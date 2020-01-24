package com.app.dao;

import java.util.List;

import com.app.pojos.CountryPojo;

public interface ICountryDao {

	List<CountryPojo> getCountries();
	CountryPojo getCountry(int cId);
}
