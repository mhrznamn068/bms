package com.bms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {

	@Id
	@Column(name = "brandid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int brandid;

	private String brandname;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "brand_brandid")
	private List<Bag> baglist;

	public int getBrandid() {
		return brandid;
	}

	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public List<Bag> getBaglist() {
		return baglist;
	}

	public void setBaglist(List<Bag> baglist) {
		this.baglist = baglist;
	}
}
