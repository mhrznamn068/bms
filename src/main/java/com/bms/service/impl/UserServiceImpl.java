package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.UserDao;
import com.bms.model.Users;
import com.bms.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
  
  @Autowired
  private UserDao userDao;

  @Override
  @Transactional
  public void addUser(Users users)
  {
    this.userDao.addUser(users);
    
  }

  @Override
  @Transactional
  public void updateUser(Users users)
  {
    this.userDao.updateUser(users);
    
  }

  @Override
  @Transactional
  public void deleteUser(String userid)
  {
    this.userDao.deleteUser(userid);
    
  }

  @Override
  @Transactional
  public List<Users> userlist()
  {
    
    return this.userDao.userlist();
  }

  @Override
  @Transactional
  public Users getUserById(String userid)
  {
   
    return this.userDao.getUserById(userid);
  }

  @Override
  @Transactional
  public Users getUserByName(String username) {
	
	return this.userDao.getUserByName(username);
  }
  
  @Override
  @Transactional
  public void setStatus(String userid){
	  Users users=this.userDao.getUserById(userid);
	  users.setStatus(true);
  }

}