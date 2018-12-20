package com.bms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category")
@Proxy(lazy=false)
public class Category {

	@Id
	@Column(name="catid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int catid;


	
	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	private String catname;
	
	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="category_catid")
	private List<Bag> baglist;


	public List<Bag> getBaglist() {
		return baglist;
	}

	public void setBaglist(List<Bag> baglist) {
		this.baglist = baglist;
	}

}
