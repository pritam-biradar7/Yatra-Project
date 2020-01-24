package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class CartPojo {
//cart id,package id, price,tax,
	private Integer cId;
	private List<PackagePojo> pkg=new ArrayList<>();
	private CustomerPojo customer;
	//private List<OrderPojo> order=new ArrayList<>();
	
	
	public CartPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CartPojo(List<PackagePojo> pkg, CustomerPojo customer/*, List<OrderPojo> order*/) {
		super();
		this.pkg = pkg;
		this.customer = customer;
		//this.order = order;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	
	@OneToOne(mappedBy="cart",fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	public CustomerPojo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPojo customer) {
		this.customer = customer;
	}


    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
    public List<PackagePojo> getPkg() {
		return pkg;
	}



	public void setPkg(List<PackagePojo> pkg) {
		this.pkg = pkg;
	}
	
	public void addPackage(PackagePojo pkgs) {
		pkg.add(pkgs);
		pkgs.getCart().add(this);
	}
	
	public void removePakage(PackagePojo pkgs) {
		pkg.remove(pkgs);
		pkgs.getCart().remove(this);
	}


/*	@OneToMany(mappedBy="cart", cascade=CascadeType.PERSIST)
	public List<OrderPojo> getOrder() {
		return order;
	}


	public void setOrder(List<OrderPojo> order) {
		this.order = order;
	}
	
	*/
}
