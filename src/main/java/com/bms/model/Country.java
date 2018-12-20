package com.bms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="country")
@Proxy(lazy=false)
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int countryid;
	
	private String countryname;



	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}


	@OneToMany
	@JoinTable(name="country_state",
	joinColumns={@JoinColumn(name="countryid")},
	inverseJoinColumns={@JoinColumn(name="stateid")})
	private List<State> state;



	public List<State> getState() {
		return state;
	}

	public void setState(List<State> state) {
		this.state = state;
	}

}
