package thread;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp; 
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.repository.ScraperMqSQL;

import model.ScraperObject;

public class ThreadController implements Runnable{
	int scrapeCount =0;
	 private Thread t;
	 private String threadName;
	 List<String>  cities;
	 ScraperMqSQL aMySQLDB = null;  
	 String mozilla = "Mozilla/17.0";
	 String https = "https://";
	 String mca = ".craigslist.org/search/mca?s=";
	 String mpa = ".craigslist.org/search/mpa?s=";
	 String logInfo = "";
	 	 
	 public void start () { 
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }  
	   public ThreadController(String string, List<String> aCities, ScraperMqSQL aSQLDB) {
		   threadName = string;
		   cities = aCities;
		   aMySQLDB = aSQLDB;
	}

	    
	 
	@SuppressWarnings("deprecation")
	public void run() { 
		 
		   try {
			   int count = 0;
			   int size = cities.size();
			    
			   for(String aCity : cities) {
				   count++;
				   //String   msg = " Thread " +  threadName + " for city "+ aCity +" is currently on "  + count + " for " +size+ "\n";
				   setLogInfo(aCity,count,size);
				   System.out.print(getLogInfo()); 
				   //Logger.getLogger (ThreadController.class.getName()).log(Level.INFO, getLogInfo());
				   scrapeForCity(aCity,aMySQLDB); 
			   }
		   }
		   finally {
			   Logger.getLogger (ThreadController.class.getName()).log(Level.INFO, " Finished Thread " +  threadName +  "\n");
			   System.out.print(" Finished Thread " +  threadName +  "\n");  
		   } 
	   }
	   
	   private String getLogInfo() {
		return logInfo;
	}
	private void setLogInfo(String aCity, int count, int size) {
		   logInfo = " Thread " +  threadName + " for city "+ aCity +" is currently on "  + count + " for " +size+ "\n";
	}
	private synchronized void scrapeForCity(String aCity, ScraperMqSQL aMySQLDB2) {
		   	deleteForCity(aCity,aMySQLDB);
			scrapeFor(aCity,aMySQLDB);
			scrapeForParts( aMySQLDB, aCity);
			   
	}
	   
	   private synchronized  void deleteForCity(String aCity, ScraperMqSQL aMySQLDB) {
			aMySQLDB.deleteFor(aCity);
			aMySQLDB.deletePartsFor(aCity);
		}
	   
	   
		private synchronized  void scrapeFor(String aCity,ScraperMqSQL aMySQLDB) {
			try { 
				System.setProperty("http.proxyHost", "192.168.5.1");
				System.setProperty("http.proxyPort", "1080");
				Document doc = Jsoup.connect(https + aCity +".craigslist.org/d/motorcycles-scooters/search/mca").userAgent(mozilla).get(); 
				BigDecimal totalCount = new BigDecimal(getTotalCount(doc)); 
				BigDecimal[] totalPages = totalCount.divideAndRemainder(new BigDecimal(120));
				int currentPageCount = 0;  
				int i = 1;
				BigDecimal total = totalPages[0];
				BigDecimal remainder = totalPages[1];			
					 			
				while (i <= total.intValue()) {
					Document iterativeDoc = Jsoup.connect( https + aCity +mca+currentPageCount).userAgent(mozilla).get();  
					outputData(iterativeDoc,aCity,aMySQLDB);	
					currentPageCount = currentPageCount +120;
					i++;
				}
				if(remainder.intValue() > 0) {
					Document iterativeDoc = Jsoup.connect( https + aCity +mca+(currentPageCount )).userAgent(mozilla).get();  
					outputData(iterativeDoc,aCity,aMySQLDB);	
				}
			} catch (IOException e) { 
				e.printStackTrace(  );
			} 
		}
		
		private int getTotalCount(Document doc) {
			if( doc.select("span.totalcount").size() == 0) {
				return 0;
			}
			return Integer.parseInt(doc.select("span.totalcount").first().text());
		}
		
		private void outputData(Document doc, String aCurrentCity,ScraperMqSQL aMySQLDB) {
			Elements elementList = doc.select("ul.rows");
			Elements rows = elementList.select("li");			 
			if(rows.isEmpty()) {
				
				return;
			}    
			
			for(Element anElement : rows) { 
				if(isElementValid(anElement)) {
					String aUrl ="";
					String price ="";
					String description =""; 
					for(Element eachATag : anElement.getElementsByTag("a")) {

						if(isTagValid(eachATag.text())) { 
							aUrl = getHttps(eachATag.parentNode().childNodes());  
							if(price.isEmpty()) {
								price = eachATag.text();
							}else {
								description = eachATag.text();
								}
							if(description.isEmpty()) {
								description= aUrl;	
							}
						
						}
					} 
					 try {
						//  if(urlMap.get(aUrl) == null) {
							 	saveAsScrapedObject(aUrl ,price,description, aMySQLDB,aCurrentCity);
							 	
					//	  }
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				 
				scrapeCount++;
			} 
		
		}
	 
		private boolean isTagValid(String text) {		 
			return !(text.contains("restore"));
		}

		private boolean isElementValid(Element anElement) { 
			return (anElement.getElementsByTag("a") != null) && 
					(anElement.getElementsByTag("a").size() >0) && 
					!(anElement.getElementsByTag("a").first().text().isEmpty());
		}
		private String getHttps(List<Node> childNodes) {
			if(childNodes.isEmpty()) {
				return "";
			}
			for(Node each : childNodes){
				if(each.outerHtml().contains("https")){
					return each.attributes().asList().get(0).getValue();
				}
			}
			return "";
		}
		
		private String getPicture(List<Node> childNodes) {
			if(childNodes.isEmpty()) {
				return "";
			}
			for(Node each : childNodes){
				if(each.outerHtml().contains("https")){
					return each.attributes().asList().get(1).getValue();
				}
			}
			return "";
		}
		
		private synchronized void saveAsScrapedObject(String aUrl, String price, String description, ScraperMqSQL aMySQLDB, String currentCity) throws SQLException {
			ScraperObject aNewScrapedObject = new ScraperObject();
			Timestamp time = new Timestamp(System.currentTimeMillis()); 
			if(userDeletedPost(aUrl)) {
				return;
			}
			aNewScrapedObject.setPrice(price);
			aNewScrapedObject.setUrl(aUrl);
			aNewScrapedObject.setDate(time.toString());
			aNewScrapedObject.setLocation(currentCity);
			aNewScrapedObject.setGuid(aMySQLDB.generateGuid());
			aNewScrapedObject.setDescription(description); 
			aNewScrapedObject.setDeactivated(false);
			
			ResultSet existingUrl = getExistingUrl(aMySQLDB,aUrl);
			ResultSet existingDescription = getExistingDescription(aMySQLDB,description,currentCity,"scraped_data");
			if
			((existingUrl != null) 
					&& (!(existingUrl.first()))
					&& ((existingDescription == null) )
					) {						
				aMySQLDB.insertScrapedData(aNewScrapedObject);
			}
		 
		}
		
		private synchronized ResultSet getExistingDescription(ScraperMqSQL aSQLDB, String aDescription, String currentCity, String aTable) {
			 
			ResultSet dbObject = null; 
			try {
				dbObject = aSQLDB.doesDescExist(aDescription,  currentCity, aTable);
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			
			return  dbObject;
		}
		 

		private synchronized ResultSet getExistingUrl(ScraperMqSQL aSQLDB, String aUrl) {
			ResultSet dbObject = null;
			try {
				dbObject = aSQLDB.doesUrlExist(aUrl);
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			
			return  dbObject;
		}
		private synchronized void outputPartsData(Document doc, String aCurrentCity,ScraperMqSQL aMySQLDB) {
			Elements elementList = doc.select("ul.rows");
			Elements rows = elementList.select("li");			 
			if(rows.isEmpty()) {			
				return;
			}    

			for(Element anElement : rows) { 
				if(isElementValid(anElement)) {
					String aUrl ="";
					String price ="";
					String description ="";
					String picture = "";
					for(Element eachATag : anElement.getElementsByTag("a")) {

						if(isTagValid(eachATag.text())) { 
							aUrl = getHttps(eachATag.parentNode().childNodes()); 
							picture = getPicture(eachATag.parentNode().childNodes());
							if(price.isEmpty()) {
								price = eachATag.text();
							}else {
								description = eachATag.text();
							}
							if(description.isEmpty()) {
								description= aUrl;	
							}

						}
					} 
					try { 
						saveAsScrapedPartsObject(aUrl ,price,description, aMySQLDB,aCurrentCity, picture);

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				scrapeCount++;
			} 

		}
		
		private synchronized  void scrapeForParts(ScraperMqSQL aMySQLDB, String aCity) {

			try { 
				System.setProperty("http.proxyHost", "192.168.5.1");
				System.setProperty("http.proxyPort", "1080");
				Document doc = Jsoup.connect(https + aCity +".craigslist.org/d/motorcycle-parts-accessories/search/mpa").userAgent(mozilla).get(); 
				BigDecimal totalCount = new BigDecimal(getTotalCount(doc)); 
				BigDecimal[] totalPages = totalCount.divideAndRemainder(new BigDecimal(120));
				int currentPageCount = 0;  
				int i = 1;
				BigDecimal total = totalPages[0];
				BigDecimal remainder = totalPages[1];			
					 			
				while (i <= total.intValue()) {
					Document iterativeDoc = Jsoup.connect( https + aCity +mpa+currentPageCount).userAgent(mozilla).get();  
					outputPartsData(iterativeDoc,aCity,aMySQLDB);	
					currentPageCount = currentPageCount +120;
					i++;
				}
				if(remainder.intValue() > 0) {
					Document iterativeDoc = Jsoup.connect( https + aCity +mpa+(currentPageCount )).userAgent(mozilla).get();  
					outputPartsData(iterativeDoc,aCity,aMySQLDB);	
				}
			} catch (IOException e) { 
				e.printStackTrace(  );
			}
			
		}
		
		private synchronized void saveAsScrapedPartsObject(String aUrl, String price, String description, ScraperMqSQL aMySQLDB, String currentCity, String aPict) throws SQLException {
			ScraperObject aNewScrapedObject = new ScraperObject();
			Timestamp time = new Timestamp(System.currentTimeMillis()); 
			if(userDeletedPost(aUrl)) {
				return;
			}
			aNewScrapedObject.setPrice(price);
			aNewScrapedObject.setUrl(aUrl);
			aNewScrapedObject.setDate(time.toString());
			aNewScrapedObject.setLocation(currentCity);
			aNewScrapedObject.setGuid(aMySQLDB.generateGuid());
			aNewScrapedObject.setDescription(description);
			aNewScrapedObject.setLocation(currentCity);	
			aNewScrapedObject.setDeactivated(false); 
			 ResultSet existingDescription = getExistingDescription(aMySQLDB,description,currentCity,"parts_data");
			 if(existingDescription == null)  					 
						  {	
				 aMySQLDB.insertPartsdData(aNewScrapedObject);
			  }
			 
		}
		
		private synchronized boolean userDeletedPost(String url) {
			System.setProperty("http.proxyHost", "192.168.5.1");
			System.setProperty("http.proxyPort", "1080");
			try {
				Document doc = Jsoup.connect(url).userAgent(mozilla).get();
				
					if(
						(!(doc.getElementsContainingText("This posting has been deleted by its author").isEmpty())) ||
						(!(doc.getElementsContainingText("This posting has expired.").isEmpty())) ||
						(!(doc.getElementsContainingText("deleted").isEmpty()))
						) {
						return true;
					}			
				
			} catch (IOException e) {
				e.printStackTrace();
				return true;
			} 
			
			return false;
		}
}
