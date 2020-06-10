package model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ScraperObject {

	//private long id;
	//private String name;


	//private boolean active;
	@Id
	@GeneratedValue
	@Column(name="url")
	private String url;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private String price;
	@Column(name="location")
	public String location;
	@Column(name="state")
	public String state;
	@Column(name="date")
	public String date;
	@Column(name="deactivatedBoolean")
	public boolean deactivatedBoolean;
	public UUID guid;
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

