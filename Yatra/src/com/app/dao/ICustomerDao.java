package com.app.dao;

import java.util.List;

import com.app.pojos.CustomerPojo;

public interface ICustomerDao {

	List<CustomerPojo> getCustomers();
	CustomerPojo authenticateCustomer(String email,String password);
}
