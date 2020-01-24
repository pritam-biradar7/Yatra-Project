package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="customers")
public class CustomerPojo {

	Integer custId;
	String name;
	@Email(message="Invalid Email format")
	String email;
	String password;
	String mobileNo;
	AddressPojo addr;
	CartPojo cart;
	//List<PackagePojo> pkg;
	
	//no-argument constructor
	public CustomerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterised constructor
	public CustomerPojo(String name, String email, String password, String mobileNo, AddressPojo addr,CartPojo cart/*,List<PackagePojo> pkg*/) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.addr = addr;
		this.cart=cart;
		//this.pkg=pkg;
	}

	//auto-generation of id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Column(length=50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=30,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length=10)
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	//customer(one) to address(one) relation with cascade on ALL and fk in address
	@OneToOne(mappedBy="cust", cascade=CascadeType.ALL)
	public AddressPojo getAddr() {
		return addr;
	}

	public void setAddr(AddressPojo addr) {
		this.addr = addr;
	}
	
	/*@ManyToMany
	public List<PackagePojo> getPkg() {
		return pkg;
	}

	public void setPkg(List<PackagePojo> pkg) {
		this.pkg = pkg;
	}*/

	@OneToOne(cascade=CascadeType.PERSIST)
	public CartPojo getCart() {
		return cart;
	}

	public void setCart(CartPojo cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CustomerPojo [custId=" + custId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobileNo=" + mobileNo + ", addr=" + addr + ", cart=" + cart + "]";
	}

	
	
}
