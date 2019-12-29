package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hotel")
public class HotelPojo {

	Integer hId;
	String hName;
	String contact;
	Integer rating;
	AddressPojo addr;
	PackagePojo pkg;

	//no-parameter constructor
	public HotelPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterised constructor w/o hId
	public HotelPojo(String hName, String contact, Integer rating, AddressPojo addr,PackagePojo pkg) {
		super();
		this.hName = hName;
		this.contact = contact;
		this.rating = rating;
		this.addr = addr;
		this.pkg = pkg;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer gethId() {
		return hId;
	}

	public void sethId(Integer hId) {
		this.hId = hId;
	}

	@Column(name="hotel_name",length=30)
	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	@Column(length=10)
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	//hotel(one) to address(one) relation with cascade on ALL and fk in address
	@OneToOne(mappedBy="hotel",cascade=CascadeType.ALL)
	public AddressPojo getAddr() {
		return addr;
	}

	public void setAddr(AddressPojo addr) {
		this.addr = addr;
	}

	//hotel(many) to pkg(one) relation
	 @ManyToOne 
	 public PackagePojo getPkg() { 
		 return pkg; 
	}
	 
	 public void setPkg(PackagePojo pkg) { 
		 this.pkg = pkg; 
	}
	
}
