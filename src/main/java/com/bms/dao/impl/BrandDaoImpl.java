package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.BrandDao;
import com.bms.model.Brand;

@Repository
public class BrandDaoImpl implements BrandDao {
	
	private static final Logger logger = LoggerFactory.getLogger(BrandDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addBrand(Brand brand) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(brand);
		logger.info("Brand added"+brand);
		
	}

	@Override
	public void updateBrand(Brand brand) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(brand);
		logger.info("Logger updated"+brand);
		
	}

	@Override
	public void deleteBrand(String brandid) {
		Session session=this.sessionFactory.getCurrentSession();
		Brand brand=(Brand)session.load(Brand.class, new String(brandid));
		if(brand!=null){
			session.delete(brand);
			logger.info("Brand deleted"+brand);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> brandlist() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Brand> brandlist=session.createQuery("from Brand").list();
		return brandlist;
	}

	@Override
	public Brand getBrandById(String brandid) {
		Session session=this.sessionFactory.getCurrentSession();
		Brand brand=(Brand)session.load(Brand.class, new String(brandid));
		return brand;
	}

}
