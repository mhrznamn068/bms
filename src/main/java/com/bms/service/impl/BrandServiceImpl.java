package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.BrandDao;
import com.bms.model.Brand;
import com.bms.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{

	
	@Autowired
	private BrandDao brandDao;
	
	
	@Override
	@Transactional
	public void addBrand(Brand brand) {
		this.brandDao.addBrand(brand);
		
	}

	@Override
	@Transactional
	public void updateBrand(Brand brand) {
		this.brandDao.updateBrand(brand);
	}

	@Override
	@Transactional
	public void deleteBrand(String brandid) {
		Brand brand=this.brandDao.getBrandById(brandid);
		brand.getBaglist().clear();
		this.brandDao.deleteBrand(brandid);
	}

	@Override
	@Transactional
	public List<Brand> brandlist() {
		return this.brandDao.brandlist();
	}

	@Override
	@Transactional
	public Brand getBrandById(String brandid) {
		return this.brandDao.getBrandById(brandid);
	}

}
