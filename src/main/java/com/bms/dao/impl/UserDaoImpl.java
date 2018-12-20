package com.bms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bms.dao.UserDao;
import com.bms.model.Users;


@Repository
public class UserDaoImpl implements UserDao
{
  
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void addUser(Users users)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.persist(users);
    
  }

  @Override
  public void updateUser(Users users)
  {
    Session session=this.sessionFactory.getCurrentSession();
    session.update(users);
  }

  @Override
  public void deleteUser(String userid)
  {
    Session session=this.sessionFactory.getCurrentSession();
    Users users=(Users)session.load(Users.class, new String(userid));
    if(null!=users){
      session.delete(users);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Users> userlist()
  {
    Session session=this.sessionFactory.getCurrentSession();
    List<Users> userlist=session.createQuery("from Users").list();
    return userlist;
  }

  @Override
  public Users getUserById(String userid)
  {
    Session session=this.sessionFactory.getCurrentSession();
    Users users=(Users)session.load(Users.class, new String(userid));
    return users;
  }

  @Override
  public Users getUserByName(String username)
  {
    Session session=this.sessionFactory.getCurrentSession();
    System.out.println("Dao Loaded");
    Users user=(Users) session.createQuery("from Users where username='"+username+"'").uniqueResult();
    System.out.println("User from Dao Impl="+user);
    return user;
  }

}
