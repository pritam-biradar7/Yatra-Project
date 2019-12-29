package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="package")
public class PackagePojo {

	Integer pId;
	double pAmt;
	String pName;
	String pType;
	String pDesc;
	CountryPojo country;
	List<HotelPojo> hotel=new ArrayList<>();
	
	//default constructor
	public PackagePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterised constructor w/o pId
	public PackagePojo(Integer pId, double pAmt, String pName, String pType, String pDesc, CountryPojo country,
			List<HotelPojo> hotel) {
		super();
		this.pId = pId;
		this.pAmt = pAmt;
		this.pName = pName;
		this.pType = pType;
		this.pDesc = pDesc;
		this.country = country;
		this.hotel = hotel;
	}

	//auto-generation of pId
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public Integer getpId() {
			return pId;
		}

	
	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public double getpAmt() {
		return pAmt;
	}

	public void setpAmt(double pAmt) {
		this.pAmt = pAmt;
	}
	
	@Column(name="Pkg_name",length=50)
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Column(name="Pkg_Type",length=50)
	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	@Column(name="Pkg_Desc")
	public String getpDesc() {
		return pDesc;
	}

	
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	//pkg-country relation (many(pkgs) have one(country))
	  @ManyToOne
	  public CountryPojo getCountry() {
		  return country;
		  }
	  
	  public void setCountry(CountryPojo country) {
		  this.country = country;
		  }

	  
	//pkg to hotel relation (one(pkg) has many(hotels))

	  @OneToMany(mappedBy="pkg",cascade=CascadeType.ALL)
	  public List<HotelPojo> getHotel() {
		return hotel;
	}

	public void setHotel(List<HotelPojo> hotel) {
		this.hotel = hotel;
	}
	 


	
}
