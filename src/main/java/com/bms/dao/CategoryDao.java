package com.bms.dao;

import java.util.List;

import com.bms.model.Category;

public interface CategoryDao {

	public void addCategory(Category cat);
	
	public void updateCategory(Category cat);
	
	public void deleteCategory(String catid);
	
	public List<Category> categorylist();
	
	public Category getCatById(String catid);
	
	
}
