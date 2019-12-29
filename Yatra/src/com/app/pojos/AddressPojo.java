package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name ="address")
public class AddressPojo {

	Integer addrId;
	String street;
	String city;
	String state;
	String country;
	Integer pincode;
	CustomerPojo cust;
	HotelPojo hotel;

	// no-argument constructor
	public AddressPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	// parameterised constructor with fk hotel and cust
	public AddressPojo(String street, String city, String state, String country, Integer pincode,
			CustomerPojo cust,HotelPojo hotel) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.cust = cust;
		this.hotel=hotel;
	}

	// auto-generation of aId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	@Column(length = 20)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(length = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(length = 20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(length = 20)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	// address(one) to customer(one) relation
	@OneToOne
	public CustomerPojo getCust() {
		return cust;
	}

	public void setCust(CustomerPojo cust) {
		this.cust = cust;
	}

	
	  //address(one) to hotel(one) relation
	  
	  @OneToOne 
	  public HotelPojo getHotel() { 
		  return hotel; 
		  }
	  
	 public void setHotel(HotelPojo hotel) { 
		 this.hotel = hotel; 
		 }

	@Override
	public String toString() {
		return "AddressPojo [addrId=" + addrId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + "]";
	}
}
