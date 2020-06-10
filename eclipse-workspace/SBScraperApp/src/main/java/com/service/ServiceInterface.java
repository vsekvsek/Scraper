package com.service;

import java.util.List;

import model.ScraperObject;

public interface ServiceInterface {

	List<ScraperObject> getAllNonDeactivatedOnes();

	List<ScraperObject> getAllNonDeactivatedOnesForState(String string);

	List<ScraperObject> getAllNonDeactivatedParts();

}
