package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.CountryPojo;

@Repository
@Transactional
public class CountryDaoImpl implements ICountryDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<CountryPojo> getCountries() {

		String jpql="select c from CountryPojo c";
		return sf.getCurrentSession().createQuery(jpql,CountryPojo.class)
				.getResultList();
	}

}
