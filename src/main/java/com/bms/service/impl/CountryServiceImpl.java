package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.CountryDao;
import com.bms.dao.StateDao;
import com.bms.model.Country;
import com.bms.model.State;
import com.bms.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private StateDao stateDao;
	
	@Override
	@Transactional
	public void addCountry(Country country) {
		
		this.countryDao.addCountry(country);
		
	}
	
	@Override
	@Transactional
	public void joinCountryState(int countryid,int stateid){
		
		Country country=this.countryDao.getCountryById(countryid);
		State state=this.stateDao.getStateById(stateid);
		country.getState().add(state);
	}

	@Override
	@Transactional
	public void updateCountry(Country country) {
		this.countryDao.updateCountry(country);
		
	}

	@Override
	@Transactional
	public void deleteCountry(int countryid) {
		this.countryDao.deleteCountry(countryid);
		
	}

	@Override
	@Transactional
	public List<Country> countrylist() {
		
		return this.countryDao.countrylist();
	}

	@Override
	@Transactional
	public Country getCountryById(int countryid) {
		
		return this.countryDao.getCountryById(countryid);
	}

}
