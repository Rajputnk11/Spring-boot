package com.restAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restAPI.beans.Country;

public interface CountryReposistory extends JpaRepository<Country,Integer> {

	
}
