package com.controller;

 
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements; 
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repository.ScraperMqSQL;

import model.ScraperObject;
import model.States;
import thread.ThreadController;
 
@RestController
public class ScraperController extends Thread {
	int scrapeCount =0;
	String mozilla = "Mozilla/17.0";
	String https = "https://";
	String mca = ".craigslist.org/search/mca?s=";
	String mpa = ".craigslist.org/search/mpa?s=";
	HashMap<String, ScraperObject> urlMap = new HashMap<String, ScraperObject>();
	HashMap<String, ScraperObject> urlPartsMap = new HashMap<String, ScraperObject>();
	HashMap<String, ScraperObject> urlMapToDelete = new HashMap<String, ScraperObject>();
	
  @RequestMapping(value ="/scrape")
	public String start( ModelMap model) throws InterruptedException {		
		System.out.print("Started scraping... "  +"\n");
		ScraperMqSQL aMySQLDB = null;
		aMySQLDB = new ScraperMqSQL();
		aMySQLDB.connect(); 
		fetchData(aMySQLDB,model);
		return scrapeCount + " total scraped.";
	}

	private void deactivateDefunctUrls(ScraperMqSQL aMySQLDB, ScraperObject scrapedObject) {
		int cntr = 0;
		
		if(!(isURLValid(scrapedObject.getUrl())) || (userDeletedPost(scrapedObject.getUrl()))){
			aMySQLDB.deactivateThisUrl(scrapedObject.getUrl());
			System.out.print("Currently deactivating: "  + scrapedObject.getUrl()  +"\n");
		}
	
		cntr++;
	}
	
	
	private boolean userDeletedPost(String url) {
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

	public boolean isURLValid(String urlString) {
		try
		{
			URL url = new URL(urlString);
			url.toURI();
			return true;
		} catch (Exception exception)
		{
			return false;
		}
	}

	 
	private void fetchData(ScraperMqSQL aMySQLDB,ModelMap model) throws InterruptedException   { 
		States states = new States();   
		ThreadController R1 = new ThreadController( "Pacific Cities", states.getWesternCities(),aMySQLDB);
		R1.start(); 	
		Thread.sleep(40000);	      
		ThreadController R2 = new ThreadController( "Mid Western Cities", states.getMidWesternCities(),aMySQLDB);
		R2.start();
		Thread.sleep(40000);	
		ThreadController R3 = new ThreadController( "Mid Atlantic Cities", states.getMidAtlanticCities(),aMySQLDB);
		R3.start();
		Thread.sleep(40000);	
		ThreadController R4 = new ThreadController( "Eastern Cities", states.getEasternCities(),aMySQLDB);
		R4.start(); 
  
		System.out.print("Finished "   +"\n");
	}
	
	private void deleteForCity(String aCity, ScraperMqSQL aMySQLDB) {
		aMySQLDB.deleteFor(aCity);
		aMySQLDB.deletePartsFor(aCity);
	}

	private List<String> getCities() {
	   States states = new States();
	//return states.getWashington();
	 return states.getAllCities();
	}

	 
	private void scrapeFor(String aCity,ScraperMqSQL aMySQLDB) {
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
		// buildExistingHashMap( aMySQLDB, aCity);
		 
		/* 
		if(urlMapToDelete.keySet().size() >0 ){
		 	int total = urlMapToDelete.keySet().size();
			int cntr = 0;
			for(String aUrl : urlMapToDelete.keySet()) {
				System.out.print("Checking deactivated urls, on " + cntr + " of " + total  + " for city " +aCity +"\n");
			cntr++; 
			ScraperObject scrapedObject = urlMapToDelete.get(aUrl);
			 
			deactivateDefunctUrls(aMySQLDB, scrapedObject);
			}
			 
		}
 
		 urlMap.clear();
		 urlPartsMap.clear();
		 urlMapToDelete.clear();
		 
		aMySQLDB.disconnect();
	 
		System.out.print("Finished for city "+ aCity + "\n"); 
		*/
	}
 

	private void scrapeForParts(ScraperMqSQL aMySQLDB, String aCity) {

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
					//  if(urlMap.get(aUrl) == null) {
						 	saveAsScrapedObject(aUrl ,price,description, aMySQLDB,aCurrentCity, picture);
						 	
				//	  }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			 
			scrapeCount++;
		} 
	
	}

	private void outputPartsData(Document doc, String aCurrentCity,ScraperMqSQL aMySQLDB) {
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
					  //if(urlPartsMap.get(aUrl) == null) {
						 	saveAsScrapedPartsObject(aUrl ,price,description, aMySQLDB,aCurrentCity, picture);
						 	
				 	// }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			 
			scrapeCount++;
		} 
	
	}


	private void buildExistingHashMap(ScraperMqSQL aMySQLDB, String aCity) {

		List<ScraperObject> existingScrapedData = aMySQLDB.getAllNonDeactivatedFor(aCity);
		for(ScraperObject eachScrapedObj : existingScrapedData) {
			if(!(urlMap.containsKey(eachScrapedObj.getUrl()))) {
				urlMapToDelete.put(eachScrapedObj.getUrl(), (ScraperObject) eachScrapedObj);				
			}
		}
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

	private void saveAsScrapedObject(String aUrl, String price, String description, ScraperMqSQL aMySQLDB, String currentCity, String aPict) throws SQLException {
		ScraperObject aNewScrapedObject = new ScraperObject();
		Timestamp time = new Timestamp(System.currentTimeMillis()); 

		aNewScrapedObject.setPrice(price);
		aNewScrapedObject.setUrl(aUrl);
		aNewScrapedObject.setDate(time.toString());
		aNewScrapedObject.setLocation(currentCity);
		aNewScrapedObject.setGuid(aMySQLDB.generateGuid());
		aNewScrapedObject.setDescription(description);
		//aNewScrapedObject.setPicture(aPict);			
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
	//		aMySQLDB.createFirstHistoryRecord(aNewScrapedObject, existingUrl);
	//	}else {
	//		aMySQLDB.handleExistingHistoryRecord(aNewScrapedObject);
	//	}
	// 	urlMap.put(aUrl, (ScraperObject) aNewScrapedObject);
	}
 
	private void saveAsScrapedPartsObject(String aUrl, String price, String description, ScraperMqSQL aMySQLDB, String currentCity, String aPict) throws SQLException {
		ScraperObject aNewScrapedObject = new ScraperObject();
		Timestamp time = new Timestamp(System.currentTimeMillis()); 

		aNewScrapedObject.setPrice(price);
		aNewScrapedObject.setUrl(aUrl);
		aNewScrapedObject.setDate(time.toString());
		aNewScrapedObject.setLocation(currentCity);
		aNewScrapedObject.setGuid(aMySQLDB.generateGuid());
		aNewScrapedObject.setDescription(description);
		aNewScrapedObject.setLocation(currentCity);	
		aNewScrapedObject.setDeactivated(false);
		
		// ResultSet urlMap = getExistingUrl(aMySQLDB,aUrl); 
		  
		 ResultSet existingDescription = getExistingDescription(aMySQLDB,description,currentCity,"parts_data");
		 if(existingDescription == null)  					 
					  {	
			 aMySQLDB.insertPartsdData(aNewScrapedObject);
		  }
		
		//urlPartsMap.put(aUrl, (ScraperObject) aNewScrapedObject);
	}
	 

	private ResultSet getExistingDescription(ScraperMqSQL aSQLDB, String aDescription, String currentCity, String aTable) {
	 
		ResultSet dbObject = null; 
		try {
			dbObject = aSQLDB.doesDescExist(aDescription,  currentCity, aTable);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return  dbObject;
	}
	 

	private ResultSet getExistingUrl(ScraperMqSQL aSQLDB, String aUrl) {
		ResultSet dbObject = null;
		try {
			dbObject = aSQLDB.doesUrlExist(aUrl);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return  dbObject;
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

	private int getTotalCount(Document doc) {
		if( doc.select("span.totalcount").size() == 0) {
			return 0;
		}
		return Integer.parseInt(doc.select("span.totalcount").first().text());
	}

	private boolean isTagValid(String text) {		 
		return !(text.contains("restore"));
	}

	private boolean isElementValid(Element anElement) { 
		return (anElement.getElementsByTag("a") != null) && 
				(anElement.getElementsByTag("a").size() >0) && 
				!(anElement.getElementsByTag("a").first().text().isEmpty());
	}

	
}
