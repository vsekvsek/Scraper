package model;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
 
public class ScraperObject {

	//private long id;
	//private String name;

  
	public boolean deactivatedBoolean;
	public UUID guid;
	private String url;
	private String price;
	private String description;
	private String location;
	private String state;
	private String date;
	public void setUrl(String aUrl) {	
		url =aUrl;	}
	public String getUrl() {
		return url;
		}


	public void setPrice(String aPrice) {
		price = aPrice;
	}
	public String getPrice() {
		return price;
	}
	public void setDescription(String aDescription) {
		description = aDescription;
	}
	public String getDescription() {
		return description;
	}
	
	public String getLocation() { 
		return location;
	}
	public void setLocation(String aLocation) {
		location = aLocation;
	}
	public String getState() { 
		return state;
	}
	public void setState(String aState) {
		state = aState;
	}
	public void setDate(String aDate) {
		date = aDate;
	}
	public String  getDate() {
		return date;
	}
	public void setGuid(UUID aGuid) {
		guid = aGuid;
	}
	public UUID getGuid() {
		return guid;
	}
	public boolean getDeactivated() {
		return deactivatedBoolean;
	}
	public void setDeactivated(boolean aBoolean) {
		deactivatedBoolean = aBoolean;
	}
}

