package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.PhotoDao;
import com.bms.model.PhotoModel;



@Repository
public class PhotoDaoImpl implements PhotoDao
{
  
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void addPhoto(PhotoModel p)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.persist(p);
    
  }

  @Override
  public void editPhoto(PhotoModel p)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.update(p);
    
  }

  @Override
  public void deletePhoto(int id)
  {
    Session session=this.sessionFactory.getCurrentSession();
    PhotoModel p=(PhotoModel) session.load(PhotoModel.class, new Integer(id));
    if(null!=p){
      session.delete(p);  
    }
    
    
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<PhotoModel> listImage()
  {
    Session session=this.sessionFactory.getCurrentSession();
    List<PhotoModel> listimage=session.createQuery("from PhotoModel").list();
    return listimage;
  }

  @Override
  public PhotoModel getPhotoById(int id)
  {
    Session session=this.sessionFactory.getCurrentSession();
    PhotoModel p=(PhotoModel) session.load(PhotoModel.class, new Integer(id));
    
    return p;
  }

 
  

}
