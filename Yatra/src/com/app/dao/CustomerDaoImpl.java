package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.CustomerPojo;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao{

	@Autowired
	private SessionFactory sf;

	@Override
	public List<CustomerPojo> getCustomers() {
		String jpql="select c from CustomerPojo c";
		return sf.getCurrentSession().createQuery(jpql, CustomerPojo.class)
				.getResultList();
	}

	@Override
	public CustomerPojo authenticateCustomer(String email, String password) {

		String jpql="select c from CustomerPojo c where c.email=:em and c.password=:pass";
		return sf.getCurrentSession().createQuery(jpql,CustomerPojo.class)
				.setParameter("em", email).setParameter("pass", password).getSingleResult();
	}

	@Override
	public String registerCustomer(CustomerPojo cust) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(cust);
		return "Customer Added successfully with id "+cust.getCustId();
	}
}
