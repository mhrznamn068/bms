package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.CategoryDao;
import com.bms.model.Category;
import com.bms.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	/*@Autowired
	private BagDao bagDao;*/
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	@Transactional
	public void addCategory(Category cat) {
		this.categoryDao.addCategory(cat);
		
	}

	@Override
	@Transactional
	public void updateCategory(Category cat) {
		
		this.categoryDao.updateCategory(cat);
		/*List<Bag> baglist=this.bagDao.getBagByCategory(catid);
		for(Bag bag:baglist){
			System.out.println("category"+cat);
			bag.setCategory(cat);
		}
		cat.getBaglist().addAll(baglist);
		*/
	}

	@Override
	@Transactional
	public void deleteCategory(String catid) {
		//List<Bag> baglist=this.bagDao.getBagByCategory(catid);
		Category cat=this.categoryDao.getCatById(catid);
		System.out.println(cat.getBaglist());
		cat.getBaglist().clear();
		System.out.println(cat.getBaglist());
		this.categoryDao.deleteCategory(catid);
		
	}

	@Override
	@Transactional
	public List<Category> categorylist() {
		
		return this.categoryDao.categorylist();
	}

	@Override
	@Transactional
	public Category getCatById(String catid) {
		
		return this.categoryDao.getCatById(catid);
	}

}
