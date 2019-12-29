package com.app.dao;

import java.util.List;

import com.app.pojos.CountryPojo;
import com.app.pojos.PackagePojo;

public interface IPackageDao {

	List<PackagePojo> getPackages(int country);
}
