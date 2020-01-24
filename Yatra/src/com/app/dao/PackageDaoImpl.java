package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.CountryPojo;
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

	@Override
	public List<PackagePojo> getAllPackages() {

		String jpql="select p from PackagePojo p";
		return sf.getCurrentSession().createQuery(jpql,PackagePojo.class).getResultList();
	}

	@Override
	public String insertPackage(PackagePojo pkg) {
		sf.getCurrentSession().persist(pkg);
		return "Package inserted successfully!";
	}

	@Override
	public String removePackage(int pId) {

		PackagePojo pkg=sf.getCurrentSession().get(PackagePojo.class, pId);
		if(pkg!=null) {
			sf.getCurrentSession().delete(pkg);
			return "Package deleted with id: "+pkg.getpId();
		}
		return "Package not deleted...something went wrong";
	}

	@Override
	public String updatePackage(PackagePojo pkg) {
		sf.getCurrentSession().saveOrUpdate(pkg);
		return "Package updated successfully with id: "+pkg.getpId();
	}
	
	
	@Override
	public PackagePojo getPackage(int pId) {
		String jpql="select p from PackagePojo p where p.pId=:pId";
		return sf.getCurrentSession().createQuery(jpql,PackagePojo.class).setParameter("pId", pId)
				.getSingleResult();
	}

	

}
