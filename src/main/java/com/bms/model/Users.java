package com.bms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
@Proxy(lazy=false)
public class Users
{

  @Id
  @Column(name="userid")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int userid;
  
  @Size(min=4, max=20,message = "Please Enter Between 4 to 20 characters")
  @NotEmpty(message = "Please enter your firstname.")
  private String firstname;
  
  @Size(min=4, max=20,message = "Please Enter Between 4 to 20 characters")
  @NotEmpty(message = "Please enter your lastname.")
  private String lastname;
  
  
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private Date dob;
  
  
  private String gender;

  @Email
  @NotEmpty(message = "Please Enter Your Email Address")
  private String email;
  
  private String username;
  
  private String password;
  
  private String cpassword;
  
  private String role;
  
  private boolean status;
  



public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }



  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getRole()
  {
    return role;
  }

  public void setRole(String role)
  {
    this.role = role;
  }

  public boolean isStatus()
  {
    return status;
  }

  public void setStatus(boolean status)
  {
    this.status = status;
  }

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getCpassword() {
	return cpassword;
}

public void setCpassword(String cpassword) {
	this.cpassword = cpassword;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
  
  

}
