package com.bms.dao;

import java.util.List;

import com.bms.model.Brand;

public interface BrandDao {
	
	public void addBrand(Brand brand);
	
	public void updateBrand(Brand brand);
	
	public void deleteBrand(String brandid);
	
	public List<Brand> brandlist();
	
	public Brand getBrandById(String brandid);

}
