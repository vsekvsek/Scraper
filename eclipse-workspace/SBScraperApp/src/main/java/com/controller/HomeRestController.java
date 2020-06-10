package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.ServiceInterface;

import model.ScraperObject;
import model.User;
@RestController
public class HomeRestController {
	@Autowired
	private ServiceInterface scraperService;
	List<ScraperObject>  allNonDectivated = null;
	List<ScraperObject>  allNonDectivatedParts = null;
	
	@Autowired
	@RequestMapping(path="/scraped", method=RequestMethod.GET)
	public List<ScraperObject> getAllNonDectivatedData(){			 
		if(allNonDectivated == null) {
			allNonDectivated = scraperService.getAllNonDeactivatedOnes();
		}		
		return allNonDectivated;
	}
	
	@Autowired
	@RequestMapping(path="/partsData", method=RequestMethod.GET)
	public List<ScraperObject> getAllNonDectivatedPartsData(){
		if(allNonDectivatedParts == null) {
			allNonDectivatedParts = scraperService.getAllNonDeactivatedParts();
		}
		
		return allNonDectivatedParts;
	}
}
