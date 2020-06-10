package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.ScraperMqSQL;

import model.ScraperObject;

@Service("scraperService")
public class ScraperServiceImpl implements ServiceInterface{
	@Autowired
	private ScraperMqSQL repository;

	@Override
	public List<ScraperObject> getAllNonDeactivatedOnes() {
		return repository.getAllNonDeactivated();
	}

	@Override
	public List<ScraperObject> getAllNonDeactivatedOnesForState(String aState) {
		return repository.getAllNonDeactivatedForState(aState);
	}

	@Override
	public List<ScraperObject> getAllNonDeactivatedParts() {
		return repository.geAllNonDEactivedParts();
	}
}
