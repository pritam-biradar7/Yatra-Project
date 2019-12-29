package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.PackagePojo;

@Repository
@Transactional
public class PackageDaoImpl implements IPackageDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<PackagePojo> getPackages(int country) {

		String jpql="select p from PackagePojo p where p.country.cId=:country";
		return sf.getCurrentSession().createQuery(jpql,PackagePojo.class)
				.setParameter("country", country).getResultList();
	}

}
