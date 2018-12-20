package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.CountryDao;
import com.bms.model.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCountry(Country country) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(country);
	}

	@Override
	public void updateCountry(Country country) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(country);
	}

	@Override
	public void deleteCountry(int countryid) {
		Session session=this.sessionFactory.getCurrentSession();
		Country country=(Country)session.load(Country.class, new Integer(countryid));
		if(country !=null){
			session.delete(country);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> countrylist() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Country> countrylist=session.createQuery("from Country").list();
		return countrylist;
	}

	@Override
	public Country getCountryById(int countryid) {
		Session session=this.sessionFactory.getCurrentSession();
		Country country=(Country)session.load(Country.class, new Integer(countryid));
		return country;
	}

}
