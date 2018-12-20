package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.CategoryDao;
import com.bms.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCategory(Category cat) {
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(cat);
	}

	@Override
	public void updateCategory(Category cat) {
		Session session=this.sessionFactory.getCurrentSession();
		session.update(cat);
	}

	@Override
	public void deleteCategory(String catid) {
		Session session=this.sessionFactory.getCurrentSession();
		Category cat=(Category)session.load(Category.class, new String(catid));
		if(cat !=null){
			session.delete(cat);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> categorylist() {
		Session session=this.sessionFactory.getCurrentSession();
		List<Category> categorylist=session.createQuery("from Category").list();
		return categorylist;
	}

	@Override
	public Category getCatById(String catid) {
		Session session=this.sessionFactory.getCurrentSession();
		Category cat=(Category)session.load(Category.class,new String(catid));
		return cat;
	}

}
