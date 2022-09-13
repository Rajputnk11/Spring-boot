package com.restAPI.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restAPI.beans.Country;
import com.restAPI.controller.AddResponse;
import com.restAPI.repository.CountryReposistory;
 
@Component
@Service
public class CountryService {

	@Autowired
	CountryReposistory countryReposistory;
	
	public List<Country> getAllCountries() {
	  return countryReposistory.findAll();	 
	}
	
	public Country getCountrybyId(int id) {
	 
		return countryReposistory.findById(id).get();
	}
	
	public Country getCountrybyName(String countryName) {
	 
		List<Country> countries=countryReposistory.findAll();
		
		Country country=null;
		
		for(Country con:countries) {
			if(con.getCountryName().equalsIgnoreCase(countryName)) {
				country=con;
			}
		}
		return country;
	}
	
	public int getMaxId() {
		 
		return countryReposistory.findAll().size()+1;
	}
	 
	public Country addCountry(Country country) {
	 
		country.setId(getMaxId());
		countryReposistory.save(country);
		return country;
	}
	
	public Country updateCountry(Country country) {
		countryReposistory.save(country);
		 return country;
	}
	
	public AddResponse deleteCountry(int id) {
	 
		countryReposistory.deleteById(id);
	AddResponse res=new AddResponse();
	res.setId(id);
	res.setMsg("Country deleted : "+id);
	return res;
	}
	
	
	/*
	  static HashMap<Integer,Country> countryIdMap;
	  
	  public CountryService() {
		countryIdMap =new HashMap<Integer,Country>();
		
		Country Ind=new Country(1,"India","Delhi");
		Country Usa=new Country(2,"USA","Wshingtion");
		Country Uk=new Country(13,"UK","London");
		
		countryIdMap.put(1,Ind);
		countryIdMap.put(2,Usa);
		countryIdMap.put(3,Uk);
	}
	
	public List getAllAcountries() {
		List countries=new ArrayList(countryIdMap.values());
		return countries;
	}
	
	public Country getCountrybyId(int id) {
		
		return countryIdMap.get(id);
	}
	
	public Country getCountrybyName(String countryName) {
		Country country=null;
		
		for(int i:countryIdMap.keySet()) {
			if(countryIdMap.get(i).getCountryName().equals(countryName)) {
				country=countryIdMap.get(i);
			}
		}
		return country;
	}
	
	public static int getMaxId() {
		int max=0;
		for(int i:countryIdMap.keySet()) {
			if(max<=i) {
				max=i;
			}
		}
		return max+1;
	}
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);
		
		return country;
	}
	
	public Country updateCountry(Country country) {
		 if(country.getId()>0) {
			 countryIdMap.put(country.getId(), country);
		 }
		return country;
	}
	
	public AddResponse deleteCountry(int id) {
		    
		countryIdMap.remove(id);
		AddResponse rs=new AddResponse();
		
		rs.setMsg("Country deleted successfully");
		rs.setId(id);
		return rs;
		
		
	}
	*/
}
