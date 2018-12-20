package com.bms.service;

import java.util.List;

import com.bms.model.Category;

public interface CategoryService {

	public void addCategory(Category cat);
	
	public void updateCategory(Category cat);
	
	public void deleteCategory(String catid);
	
	public List<Category> categorylist();
	
	public Category getCatById(String catid);
}
