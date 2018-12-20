package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.MenuDao;
import com.bms.model.MenuModel;
import com.bms.service.MenuService;



@Service
public class MenuServiceImpl implements MenuService
{

  @Autowired
  private MenuDao menuDao;
  

  @Override
  @Transactional
  public void addMenu(MenuModel m)
  {
   
    this.menuDao.addMenu(m);
    
  }

  @Override
  @Transactional
  public void editMenu(MenuModel m)
  {
  
    this.menuDao.editMenu(m);
    
  }

  @Override
  @Transactional
  public void deleteMenu(int id)
  {
    this.menuDao.deleteMenu(id);
    
  }

  @Override
  @Transactional
  public List<MenuModel> listMenu()
  {
    
    return this.menuDao.listMenu();
  }

  @Override
  @Transactional
  public MenuModel getMenuById(int id)
  {
   
    return this.menuDao.getMenuById(id);
  }

@Override
@Transactional
public MenuModel getMenuByName(String mname) {
	
	return this.menuDao.getMenuByName(mname);
}

}
