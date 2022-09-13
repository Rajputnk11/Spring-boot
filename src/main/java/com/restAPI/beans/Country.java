package com.restAPI.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Country_db")
public class Country {

	@Id
	@Column(name="id")
	int id;
	
	@Column(name="CountryName")
	String CountryName;
	
	@Column(name="CountryCapital")
	String CountryCapital;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	
	public Country() {
	}
	public Country(int id, String countryName, String countryCapital) {
		super();
		this.id = id;
		CountryName = countryName;
		CountryCapital = countryCapital;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getCountryCapital() {
		return CountryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		CountryCapital = countryCapital;
	}
}
