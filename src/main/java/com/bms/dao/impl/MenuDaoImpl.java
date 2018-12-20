package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.MenuDao;
import com.bms.model.MenuModel;


@Repository
public class MenuDaoImpl implements MenuDao
{

  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public void addMenu(MenuModel m)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.save(m);
  }

  @Override
  public void editMenu(MenuModel m)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.update(m);
  }

  @Override
  public void deleteMenu(int id)
  {
    Session session=this.sessionFactory.getCurrentSession();
    MenuModel m=(MenuModel)session.load(MenuModel.class, new Integer(id));
    if(null!=m){
      session.delete(m);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<MenuModel> listMenu()
  {
    Session session=this.sessionFactory.getCurrentSession();
    List<MenuModel> listMenu=session.createQuery("from MenuModel").list();
    return listMenu;
  }

  @Override
  public MenuModel getMenuById(int id)
  {
    Session session=this.sessionFactory.getCurrentSession();
    MenuModel m=(MenuModel) session.load(MenuModel.class, new Integer(id));
    return m;
  }

@Override
public MenuModel getMenuByName(String mname) {
	 Session session=this.sessionFactory.getCurrentSession();
	 MenuModel m=(MenuModel) session.createQuery("from MenuModel where mname='"+mname+"'");
	return m;
}



}
