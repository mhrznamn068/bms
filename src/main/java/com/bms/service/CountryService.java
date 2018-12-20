package com.bms.service;

import java.util.List;

import com.bms.model.Country;

public interface CountryService {

	public void addCountry(Country country);
	
	public void updateCountry(Country country);
	
	public void deleteCountry(int countryid);
	
	public List<Country> countrylist();
	
	public Country getCountryById(int countryid);
	
	public void joinCountryState(int countryid,int stateid);
}
