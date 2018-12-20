package com.bms.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.PhotoDao;
import com.bms.model.PhotoModel;
import com.bms.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService
{
  @Autowired
  private PhotoDao photodao;

  @Override
  @Transactional
  public void addPhoto(PhotoModel p)
  {
    this.photodao.addPhoto(p);
    
  }

  @Override
  @Transactional
  public void editPhoto(PhotoModel p)
  {
    this.photodao.editPhoto(p);
    
  }

  @Override
  @Transactional
  public void deletePhoto(int id)
  {
    this.photodao.deletePhoto(id);
    
  }

  @Override
  @Transactional
  public List<PhotoModel> listImage()
  {
  
    return this.photodao.listImage();
  }

  @Override
  @Transactional
  public PhotoModel getPhotoById(int id)
  {
    
    return this.photodao.getPhotoById(id);
  }

}
