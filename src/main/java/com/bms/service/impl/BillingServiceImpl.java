package com.bms.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.BillingDao;
import com.bms.model.Billing;
import com.bms.service.BillingService;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillingDao billingDao;
	
	@Override
	@Transactional
	public void shipit(Billing bill) {
		this.billingDao.shipit(bill);
		
	}

}
