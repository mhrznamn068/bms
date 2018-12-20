package com.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bag")
public class Bag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid")
	private int bid;

	private String bname;

	private double bprice;

	private String image;

	@Column(length = 4000)
	private String bdescription;

	private long bview;

	private boolean bfeatured;

	// @JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_catid")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_brandid")
	private Brand brand;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/*
	 * @JsonIgnore
	 * 
	 * @JsonProperty(value = "category_catid")
	 */
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public double getBprice() {
		return bprice;
	}

	public void setBprice(double bprice) {
		this.bprice = bprice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBdescription() {
		return bdescription;
	}

	public void setBdescription(String bdescription) {
		this.bdescription = bdescription;
	}

	public long getBview() {
		return bview;
	}

	public void setBview(long bview) {
		this.bview = bview;
	}

	public boolean isBfeatured() {
		return bfeatured;
	}

	public void setBfeatured(boolean bfeatured) {
		this.bfeatured = bfeatured;
	}

}
