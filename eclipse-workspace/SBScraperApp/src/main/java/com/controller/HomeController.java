package com.controller;


import java.sql.SQLException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.repository.ScraperMqSQL;

import model.Credentials;
import model.User;

@Controller
public class HomeController {
	
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String goHome(){
		return "index";
	}
	@RequestMapping(path="/parts", method=RequestMethod.GET)
    public String partsScreen() {       
        return "parts";
    }
	@RequestMapping("/notify")
	public String notifyPage() {
	    return "notify"; //defect-details.html page name to open it
	}
	
	@PostMapping("/form")
    public String formPost(User user, Model model) throws SQLException {
        model.addAttribute("user", user);
        ScraperMqSQL aDb = new ScraperMqSQL();
        if((aDb.saveUser(user))) {
        	return "loggedIn";
        }
        return "notify";
    }
	
	@RequestMapping("/login")
    public String loginPost() {
       
        return "login";
    }

	@RequestMapping(value = "/loggedIn", method = RequestMethod.POST)
	public String loggedIn(Credentials credentials, ModelMap model) {
		ScraperMqSQL aDb = new ScraperMqSQL();
		 
		User existingUser;
		try {
			User aUser = new User();
			aUser.setUSer(credentials.getUserName());
			aUser.setEmail(credentials.getUserName());
			aUser.setPassWord(credentials.getPassWord());		 
			 
			existingUser = aDb.getExistingUser(aUser);
			if(existingUser != null) {
				model.addAttribute("user", existingUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "notify";

		}
		if(existingUser != null) {
			return "loggedIn";
		}
		return "notify";
		}
	
	@RequestMapping(value = "/saveUser" ) 
	public String saveUser(User aUser, ModelMap model) {
		ScraperMqSQL aDb = new ScraperMqSQL();
		boolean myBooleanVariable = false;
		try {
			aDb.saveUser(aUser);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		model.addAttribute("user", aUser);
		model.addAttribute("myBooleanVariable", myBooleanVariable);
	    return "loggedIn"; 
	}
	
}