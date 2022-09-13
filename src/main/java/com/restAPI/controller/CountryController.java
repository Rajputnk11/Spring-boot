package com.restAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restAPI.beans.Country;
import com.restAPI.services.CountryService;

@RestController
public class CountryController {
     @Autowired
	CountryService countryService=new CountryService();
    
	
    @GetMapping("/getCountries")
    public List<Country> getCountries() {
    	
    	return countryService.getAllCountries();
    }
    
    @GetMapping("/getCountries/{id}")
    public ResponseEntity<Country> getCountriesbyId(@PathVariable int id) {
    	
    	try {
    		
    		Country country= countryService.getCountrybyId(id);
    		return new ResponseEntity<Country>(country,HttpStatus.OK);
    		
    	}catch(Exception e) {
    		
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		
    	}
    	
    }
    
    @GetMapping("getCountries/countryName")
    public ResponseEntity<Country> getCountriesbyName(@RequestParam(value="name") String name) {
       try {
    		
    		Country country= countryService.getCountrybyName(name);
    		return new ResponseEntity<Country>(country,HttpStatus.OK);
    		
    	}catch(Exception e) {
    		
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		
    	}
    
    }
    
    @PostMapping("/addCountry")
    public Country addCountries(@RequestBody Country country) {
    	
    	return countryService.addCountry(country);
    	
    }
    @PutMapping("updateCountry")
    public ResponseEntity<Country> updateCountries(@PathVariable(value="id") int id, @RequestBody Country country) {
    	try {
    		Country existCountry=countryService.getCountrybyId(id);
    		existCountry.setCountryName(country.getCountryName());
    		existCountry.setCountryCapital(country.getCountryCapital());
    		
    		Country updated_country=countryService.updateCountry(existCountry);
    		
    		return new ResponseEntity<Country>(updated_country,HttpStatus.OK);
    	}catch(Exception e) {
    		return new ResponseEntity<>(HttpStatus.CONFLICT);
    	}
    	
    }
    
    @DeleteMapping("/deleteCountry/{id}")
    public AddResponse deleteCountries(@PathVariable int id) {
    	
    	return countryService.deleteCountry(id);
    }
}
