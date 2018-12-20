package com.bms.dao;

import java.util.List;

import com.bms.model.Country;

public interface CountryDao {

	public void addCountry(Country country);
	
	public void updateCountry(Country country);
	
	public void deleteCountry(int countryid);
	
	public List<Country> countrylist();
	
	public Country getCountryById(int countryid);
}
