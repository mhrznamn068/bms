package com.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="menu")
@Proxy(lazy=false)
public class MenuModel
{
  @Id
  @Column(name="mid")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int mid;
  
  private  String mname;
  
  @Column(length=4000)
  private String description;


  
  
  public int getMid()
  {
    return mid;
  }

  public void setMid(int mid)
  {
    this.mid = mid;
  }

  public String getMname()
  {
    return mname;
  }

  public void setMname(String mname)
  {
    this.mname = mname;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
  
  
}
