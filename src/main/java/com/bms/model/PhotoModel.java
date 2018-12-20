package com.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="photo")
@Proxy(lazy=false)
public class PhotoModel
{
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  
  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  private String name;
  
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  private String image;

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}
  


}
