package com.bms.service;

import java.util.List;

import com.bms.model.MenuModel;



public interface MenuService
{

  public void addMenu(MenuModel m);
  
  public void editMenu(MenuModel m);
  
  public void deleteMenu(int id);
  
  public List<MenuModel> listMenu();
  
  public MenuModel getMenuById(int id);
  
  public MenuModel getMenuByName(String mname);
}
