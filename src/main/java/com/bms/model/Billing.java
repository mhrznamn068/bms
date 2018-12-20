package com.bms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing {

	@Id
	@Column(name = "billid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billid;

	private String address;

	private String country;

	private String streetno;

	private String state;

	private long pzcode;

	@Column(length = 3000)
	private String information;

	@ManyToOne
	@JoinColumn(name = "bill_user")
	private Users user;

	@OneToMany
	@JoinColumn(name = "bill_bag")
	private List<Bag> baglist;

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billid) {
		this.billid = billid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetno() {
		return streetno;
	}

	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPzcode() {
		return pzcode;
	}

	public void setPzcode(long pzcode) {
		this.pzcode = pzcode;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Bag> getBaglist() {
		return baglist;
	}

	public void setBaglist(List<Bag> baglist) {
		this.baglist = baglist;
	}

}