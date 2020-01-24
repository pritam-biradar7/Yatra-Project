package com.app.dao;

//import java.util.List;

import com.app.pojos.AdminPojo;
//import com.app.pojos.CustomerPojo;

public interface IAdminDao {

	AdminPojo authenticateAdmin(String email,String password);
	
}
