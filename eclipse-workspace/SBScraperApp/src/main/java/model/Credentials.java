package model;



import org.springframework.stereotype.Component;

@Component
public class Credentials {

	private String userName = "";
	private String passWord = "";
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String aUserName) {
		this.userName = aUserName;
	}
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String aPassword) {
		this.passWord = aPassword;
	}
}
