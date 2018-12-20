package com.bms.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.BillingDao;
import com.bms.model.Billing;

@Repository
public class BillingDaoImpl implements BillingDao {

	 @Autowired
	 private SessionFactory sessionFactory;
	  
	@Override
	public void shipit(Billing bill) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(bill);
		
	}

}
