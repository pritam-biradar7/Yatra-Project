package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class AdminPojo {

	Integer adminId;
	String name;
	String email;
	String password;
	String mobileNo;
	
	public AdminPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminPojo(String name, String email, String password, String mobileNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "AdminPojo [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	
}
