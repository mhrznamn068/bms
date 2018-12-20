package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.BagDao;
import com.bms.dao.BrandDao;
import com.bms.dao.CategoryDao;
import com.bms.model.Bag;
import com.bms.model.Brand;
import com.bms.model.Category;
import com.bms.service.BagService;


@Service
public class BagServiceImpl implements BagService
{
  
  @Autowired
  private BagDao bagDao;
  
  @Autowired
  private CategoryDao categoryDao;
  
  @Autowired
  private BrandDao brandDao;

  @Override
  @Transactional
  public void addBag(Bag bag,String catid,String brandid)
  {
	Category category=this.categoryDao.getCatById(catid);
	Brand brand=this.brandDao.getBrandById(brandid);
	bag.setBrand(brand);
	bag.setCategory(category);
    this.bagDao.addBag(bag);
    
  }

  @Override
  @Transactional
  public void updateBag(Bag bag,String catid,String brandid)
  {
	Category category=this.categoryDao.getCatById(catid);
	Brand brand=this.brandDao.getBrandById(brandid);
	bag.setBrand(brand);
	bag.setCategory(category);
    this.bagDao.updateBag(bag);
    
  }

  @Override
  @Transactional
  public void deleteBag(String bid)
  {
	this.bagDao.deleteBag(bid);
   
  }

  @Override
  @Transactional
  public List<Bag> baglist()
  {
    
    return this.bagDao.baglist();
  }

  @Override
  @Transactional
  public Bag getBagById(String bid)
  {
   
    return this.bagDao.getBagById(bid);
  }

@Override
@Transactional
public Bag getBagByBagName(String bname) {
	return this.bagDao.getBagByBagName(bname);
}

@Override
@Transactional
public List<Bag> searchBag(String searchName) {
	return this.bagDao.searchBag(searchName);
}

@Override
@Transactional
public List<Bag> getBagByCategory(String category_cid) {
	
	return this.bagDao.getBagByCategory(category_cid);
}

@Override
@Transactional
public void increaseview(String bid) {
	Bag bag=this.bagDao.getBagById(bid);
	System.out.println(bag.getBname());
	bag.setBview(bag.getBview()+1);
	System.out.println(bag.getBview());
	
	
}

@Override
@Transactional
public List<Bag> getBagByBrand(String brand_brandid,int page) {
	return this.bagDao.getBagByBrand(brand_brandid,page);
}

@Override
@Transactional
public List<Bag> getPopularBags() {
	
	return this.bagDao.getPopularBags();
}

@Override
@Transactional
public List<Bag> isFeatured() {
	
	return this.bagDao.isFeatured();
}

@Override
@Transactional
public List<Bag> getBagByCatWithPag(String category_cid, int page) {
	
	return this.bagDao.getBagByCatWithPag(category_cid, page);
}

@Override
@Transactional
public List<Bag> getBagByBrandNoPag(String brand_brandid) {
	
	return this.bagDao.getBagByBrandNoPag(brand_brandid);
}


}
