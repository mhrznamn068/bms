package com.bms.service;

import java.util.List;

import com.bms.model.Brand;

public interface BrandService {
	
	public void addBrand(Brand brand);
	
	public void updateBrand(Brand brand);
	
	public void deleteBrand(String brandid);
	
	public List<Brand> brandlist();
	
	public Brand getBrandById(String brandid);

}
