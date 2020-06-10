package model;

public class User {
	public String email;
	private String firstName;
	private String lastName;
	public String searchWord;
	private String passWord;
	private String user;

	public void setEmail(String anEmail) {
		this.email = anEmail;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setSearchWord(String search) {
		this.searchWord = search;
	}    
	public String getSearchWord() {
		if(searchWord == null) {
			searchWord = "";
		}
		return searchWord;
	}

	public String getUser() {
		return user;
	}
	public void setUSer(String aUser) {
		this.user = aUser;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String aPassWord) {
		this.passWord = aPassWord;
	}
	public boolean isNotManager() {
		return !(getUser().equalsIgnoreCase("stevekelly@hotmail.com"));
	}
}
    
 