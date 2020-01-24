package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AdminPojo;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public AdminPojo authenticateAdmin(String email, String password) {

		String jpql="select a from AdminPojo a where a.email=:em and a.password=:pass";
		return sf.getCurrentSession().createQuery(jpql,AdminPojo.class)
				.setParameter("em", email).setParameter("pass", password).getSingleResult();
	}

}
