package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import model.ScraperObject;
import model.States;
import model.User;

@Repository("repository")
public class ScraperMqSQL {
	Connection con = null;
	String beginSql = "\"";
	String endString = "\""+ "," ;
	public void connect() {
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scrape", "admin", "startup1");
			 //System.out.print("Successfully connected to database." +"\n");
			con = DriverManager.getConnection("jdbc:mysql://aa1c01ssoupj6pn.cdv1ultbkowo.us-east-2.rds.amazonaws.com:3306/scrape", "admin", "startup1");

		}
		catch(Exception c){
			System.out.print(c);
		}
	}

	public void insertScrapedData(ScraperObject aScrapedObject) {
		
		String insertString 
		= "insert into scraped_data (guid,price,url,location,date_time,deactivated,description,state) Values ( " + 
				beginSql+aScrapedObject.getGuid().hashCode() + endString +
				beginSql+aScrapedObject.getPrice() + endString +
				beginSql+aScrapedObject.getUrl() + endString +
				beginSql+ fixDescription(aScrapedObject.getLocation().toUpperCase())+ endString +
				beginSql+aScrapedObject.getDate()+ endString+
				beginSql+aScrapedObject.getDeactivated()+ endString+
				//beginSql+aScrapedObject.getPicture()+ endString+
				beginSql+  fixDescription(aScrapedObject.getDescription()) + endString
				+beginSql  + fixDescription( getStateFor(aScrapedObject.getLocation()).toUpperCase()) +"\""+ 
				 ")";
		
		
		try {
			Statement stmt = getConnection().createStatement();
			stmt.executeUpdate(insertString); 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+insertString);
		}

	}
	

	private String getStateFor(String location) {
		States aState = new States();
		return aState.getStateFor(location);
	}

	private Connection getConnection() throws SQLException {
		if(con == null || con.isClosed()) {
			connect();
		}
		return con;
	}

	private String fixDescription(String description) { 
		String fixedDescription =  description.replaceAll("\"", "");
		if(fixedDescription.endsWith("\\")) {
			return fixedDescription =  description.substring(0, (fixedDescription.length()-1));
		}
		return fixedDescription;
	}

	public void disconnect() {
		try {
			con.close(); 
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

	public ResultSet doesUrlExist(String aUrl) throws SQLException {
		String selectString  = "select * from scraped_data where url = " + "'" +aUrl+ "'" ;
		ResultSet aResult = null;
		try {
			Statement stmt = getConnection().createStatement();
			  aResult = stmt.executeQuery(selectString);
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+selectString);
		}
		 
		return aResult  ;
	}
	
	public ResultSet doesDescExist( String aDescription, String aCity, String aTable) throws SQLException {
		String aState  = getStateFor(aCity);
		String selectString  = "select * from " + aTable +" where description = " + "\""+  (fixDescription(aDescription))+  "\""+ " and state = " + "'" +aState.toUpperCase()+ "'";
		ResultSet aResult = null;
		try {
			Statement stmt = getConnection().createStatement();
			  aResult = stmt.executeQuery(selectString);
			  while (aResult.next()) {
				 	if( !((aResult.getString("description")).isEmpty())) {
				 		 return aResult;
				 	}
				 	 
				}
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+selectString);
		}
		 
		return null ;
	}
	
	 
	public boolean doesGuidExist(String aGuid) throws SQLException {
		String selectString  = "select * from scraped_data where guid = " + "'" +aGuid+ "'" ;
		ResultSet aResult = null;
		try {
			Statement stmt = getConnection() .createStatement();
			  aResult = stmt.executeQuery(selectString);
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+selectString);
		}
		 
		return (aResult.getFetchSize() >0);
	}

	public void createFirstHistoryRecord(ScraperObject aNewScrapedObject, ResultSet existingUrl) {
		
		String insertString 
		= "insert into history (guid,scraped_data_guid,original_value,changed_value) Values ( " + 
				beginSql+generateGuid( ).hashCode() + endString +
				//beginSql+aNewScrapedObject.getGuid().hashCode() + endString +
				beginSql+(aNewScrapedObject.getPrice() + "|" + fixDescription(aNewScrapedObject.getDescription()))+ endString +
				beginSql+ "" + "\""+  
				 ")";
		try {
			Statement stmt = getConnection().createStatement();
			stmt.executeUpdate(insertString); 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+insertString);
		}
		
	}

	public UUID generateGuid( ) {
		   UUID uuid = UUID.randomUUID();
		   return uuid;
	}

	public void handleExistingHistoryRecord(ScraperObject aNewScrapedObject) throws SQLException {
		String selectString  = "select * from scraped_data sd, history h where sd.url = " + "'" +
	//aNewScrapedObject.getUrl()+ "'"
				 " and h.scraped_data_guid = sd.guid" ;
		ResultSet aResult = null;
		Statement stmt = null;
		try {
			stmt = getConnection() .createStatement();
			aResult = stmt.executeQuery(selectString);
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+selectString);
		}
		while (aResult.next()) {
			String changedValue = aResult.getString("changed_value");
			if(changedValue.isEmpty()) {
				continue;
			}
			String originalValue   = aResult.getString("original_value");
			String originalPrice = originalValue.substring(0, (originalValue.indexOf("|")));
			String originalDescription = originalValue.substring( (originalValue.indexOf("|")+1), originalValue.length());

			String changedPrice = changedValue.substring(0, (changedValue.indexOf("|")));
			String changedDescription = changedValue.substring( (changedValue.indexOf("|")+1), changedValue.length());
			String changedString = "";
			if(!(originalPrice.equalsIgnoreCase(changedPrice))) {
				changedString = "Price changed from " + originalPrice + " to " + changedPrice;
			}
			if(!(originalDescription.equalsIgnoreCase(changedDescription))) {
				if(changedString.isEmpty()) {
					changedString = "Description changed from " + originalDescription + " to " + changedDescription;
				}else {
					changedString = changedString + ", description changed from " + originalDescription + " to " + changedDescription;
				}
			}
			if(!(changedString.isEmpty())) {
				insertHistory(changedString,aNewScrapedObject,stmt);
			}
			
		}
		stmt.close();
	}

	private void insertHistory(String changedString, ScraperObject aNewScrapedObject, Statement stmt) {
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
		String insert  = "insert into history (guid,scraped_data_guid,original_value,changed_value,last_changed) values(" +
				beginSql +		generateGuid( )+ endString +
				//beginSql +	 aNewScrapedObject.getGuid()+ endString +
				beginSql +	 aNewScrapedObject.getDescription()+ endString +
				beginSql +	 changedString+ endString +
				beginSql +	time + "\"" + ")";
		try {
			stmt.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<ScraperObject> getAllNonDeactivated() {
		ResultSet aResult = null;
		String select  = "select * from scraped_data where deactivated = " +beginSql +"false" +"\"" ;
		Statement stmt;
		List<ScraperObject> returnList = new <ScraperObject> ArrayList ();
		try {
			stmt = getConnection().createStatement();
			aResult = stmt.executeQuery(select);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (aResult.next()) {
				returnList.add(buildScrapedData(aResult));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return returnList;
	}

	private ScraperObject buildScrapedData(ResultSet aResult) {
		ScraperObject scapedObject = new ScraperObject();
		try {
			//scapedObject.setSrappedData(aResult.getString("scraped_data"));
			scapedObject.setPrice(aResult.getString("price"));
			scapedObject.setUrl(aResult.getString("url"));
			scapedObject.setLocation(aResult.getString("location"));
			//scapedObject.setGuid(UUID.fromString(aResult.getString("guid")));
			//scapedObject.setDate(aResult.getString("date_time"));
			scapedObject.setDescription(aResult.getString("description"));
			scapedObject.setState(aResult.getString("state"));
			//scapedObject.setDeactivated((aResult.getString("deactivated")) =="true");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return scapedObject;
	}
	
	public boolean saveUser(User aUser) throws SQLException {
		 
		Timestamp time = new Timestamp(System.currentTimeMillis()); 		
       if(doesUserExist(aUser)){
    	   updateExistingUser(aUser);
    	   return true;
       }
		try {
			String insert  = "insert into user (username,email,password,create_time,search_words) values(" +
					beginSql +	aUser.getEmail()+ endString +
					beginSql +	aUser.getEmail()+ endString +
					beginSql +	aUser.getPassWord()+ endString +
					beginSql +	time+ endString +
					beginSql +	aUser.getSearchWord()+  "\"" + ")";
			Statement stmt = getConnection().createStatement();
			stmt.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	private void updateExistingUser(User aUser) { 
		try {
			String update  = "update user  set search_words = "
		+ beginSql +	aUser.getSearchWord()+"\"" + " where username = "  +beginSql +	aUser.getEmail()+  "\"";
				 
			Statement stmt = getConnection().createStatement();
			stmt.execute(update);
		} catch (SQLException e) {
			e.printStackTrace();
			return ;
		}
	}

	public List<ScraperObject> getAllNonDeactivatedForState(String aState) {
		ResultSet aResult = null;
		String select  = "select * from scraped_data where deactivated = " +beginSql +"false" +"\"" + " and state = "  +beginSql + aState.toUpperCase() +"\"";
		Statement stmt;
		List<ScraperObject> returnList = new <ScraperObject> ArrayList ();
		try {
			stmt = getConnection().createStatement();
			aResult = stmt.executeQuery(select);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (aResult.next()) {
				returnList.add(buildScrapedData(aResult));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return returnList;
	}

	public boolean doesUserExist(User user) throws SQLException {
		String selectString  = "";
		if(user.getPassWord() == null) {
			 selectString  = "select * from user where email = " + beginSql +user.getEmail()+ "\"" ;
		}
		else{
			selectString  = "select * from user where email = " + beginSql +user.getEmail()+ "\"" + 
					" and password = "  + beginSql +user.getPassWord() + "," + user.getPassWord()+ "\"" ;
			 
		}
		ResultSet aResult = null;
		try {
			Statement stmt = getConnection().createStatement();
			aResult = stmt.executeQuery(selectString);

		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+selectString);
		}
		while (aResult.next()) {
			return !((aResult.getString("email")).isEmpty());
		}
		return false;
	}
	
	public User getExistingUser(User user) throws SQLException {
		String selectString  =   "select * from user where email = " + beginSql +user.getEmail()+ "\"" + 
					" and password = "  + beginSql +user.getPassWord() + "," + user.getPassWord()+ "\"" ;
			  
		ResultSet aResult = null;
		try {
			Statement stmt = getConnection().createStatement();
			aResult = stmt.executeQuery(selectString);

		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+selectString);
		}
		User aUser = new User();
		while (aResult.next()) {
		 	if( !((aResult.getString("email")).isEmpty())) {
		 		aUser.setEmail(aResult.getString("email"));
		 	}
		 	if( !((aResult.getString("search_words")).isEmpty())) {
		 		aUser.setSearchWord((aResult.getString("search_words")));
		 	}
		}
		if(!(aUser.getEmail().isEmpty())) {
			return aUser;
		}
		return null;
	}
	public List<ScraperObject> getAllNonDeactivatedFor(String aCity) {
		
		String select  = "select * from scraped_data where deactivated = " +beginSql +"false" +"\"" + " and location =" +beginSql +aCity.toUpperCase() +"\"";
		ResultSet aResult = null;
		Statement stmt;
		List<ScraperObject> returnList = new <ScraperObject> ArrayList ();
		try {
			stmt = getConnection().createStatement();
			aResult = stmt.executeQuery(select);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (aResult.next()) {
				returnList.add(buildScrapedData(aResult));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return returnList;
	}
	
	public void deactivateThisUrl(String url) {
		String update  = "update scraped_data set deactivated = " +beginSql +  "true" +"\""  + " where url = " +beginSql +url +"\"" ;
		Statement stmt;
		
		try {
			stmt = getConnection().createStatement();
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			System.out.print("Error with SQL: "+update);
			e.printStackTrace();
		}
		Runtime.getRuntime().gc();
	}

	public void deleteFor(String aCity) {
		String update  = "delete from scraped_data where location = " +beginSql +aCity.toUpperCase() +"\""  ;
		Statement stmt;
		try {
			stmt = getConnection().createStatement();
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			System.out.print("Error with SQL: "+update);
			e.printStackTrace();
		}
	}
	
	public void deletePartsFor(String aCity) {
		String update  = "delete from parts_data where location = " +beginSql +aCity.toUpperCase() +"\""  ;
		Statement stmt;
		try {
			stmt = getConnection().createStatement();
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			System.out.print("Error with SQL: "+update);
			e.printStackTrace();
		}
	}

	public List<ScraperObject> geAllNonDEactivedParts() {
		String select  = "select * from parts_data where deactivated = " +beginSql +"false" +"\"" ;
		ResultSet aResult = null;
		Statement stmt;
		List<ScraperObject> returnList = new <ScraperObject> ArrayList ();
		try {
			stmt = getConnection().createStatement();
			aResult = stmt.executeQuery(select);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (aResult.next()) {
				returnList.add(buildScrapedData(aResult));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return returnList;
	}
	
  public void insertPartsdData(ScraperObject aScrapedObject) {
		
		String insertString 
		= "insert into parts_data (guid,price,url,date_time,deactivated,description,location,state) Values ( " + 
				beginSql+aScrapedObject.getGuid().hashCode() + endString +
				beginSql+aScrapedObject.getPrice() + endString +
				beginSql+aScrapedObject.getUrl() + endString +
				beginSql+aScrapedObject.getDate()+ endString+
				beginSql+aScrapedObject.getDeactivated()+ endString+
				beginSql+  fixDescription(aScrapedObject.getDescription()) + endString
				+beginSql  + fixDescription(aScrapedObject.getLocation().toUpperCase()) + endString
				+beginSql  + fixDescription( getStateFor(aScrapedObject.getLocation()).toUpperCase()) +"\""+ 
				 ")";
		
		
		try {
			Statement stmt = getConnection().createStatement();
			stmt.executeUpdate(insertString); 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.print("Error with: "+insertString);
		}

	}
}

