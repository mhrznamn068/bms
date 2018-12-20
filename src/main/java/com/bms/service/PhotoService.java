package com.bms.service;

import java.util.List;

import com.bms.model.PhotoModel;


public interface PhotoService
{

  public void addPhoto(PhotoModel p);
  
  public void editPhoto(PhotoModel p);
  
  public void deletePhoto(int id);
  
  public List<PhotoModel> listImage();
  
  public PhotoModel getPhotoById(int id);
}
