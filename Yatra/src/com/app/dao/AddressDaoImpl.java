package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AddressPojo;

@Repository
@Transactional
public class AddressDaoImpl implements IAddressDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public String addAddress(AddressPojo addr) {
		sf.getCurrentSession().persist(addr);
		return "Address added successfully";
	}

}
