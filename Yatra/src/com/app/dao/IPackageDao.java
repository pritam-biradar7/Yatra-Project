package com.app.dao;

import java.util.List;

import com.app.pojos.CountryPojo;
import com.app.pojos.PackagePojo;

public interface IPackageDao {

	List<PackagePojo> getPackages(int country);
	List<PackagePojo> getAllPackages();
	String insertPackage(PackagePojo pkg);
	String removePackage(int pId);
	String updatePackage(PackagePojo pkg);
	PackagePojo getPackage(int pId);
}
