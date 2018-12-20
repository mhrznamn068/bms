package com.bms.service;

import java.util.List;

import com.bms.model.Bag;

public interface BagService
{

  public void addBag(Bag bag,String catid,String brandid);
  
  public void updateBag(Bag bag,String catid,String brandid);
  
  public void deleteBag(String bid);
  
  public List<Bag> baglist();
  
  public Bag getBagById(String bid);
  
  public Bag getBagByBagName(String bname);
  
  public List<Bag> searchBag(String searchName);
  
  public List<Bag> getBagByCategory(String category_cid);
  
  public List<Bag> getBagByCatWithPag(String category_cid,int page);
  
  public List<Bag> getBagByBrand(String brand_brandid,int page);
  
  public List<Bag> getBagByBrandNoPag(String brand_brandid);
  public void increaseview(String bid);
  
  public List<Bag> getPopularBags();
  
  public List<Bag> isFeatured();
}
