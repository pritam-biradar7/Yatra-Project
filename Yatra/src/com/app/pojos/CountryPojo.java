package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class CountryPojo {

	Integer cId;
	String name;
	String continent;
	List<PackagePojo> pkg=new ArrayList<>();
	
	//no-argument constructor
	public CountryPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterised constructor
	public CountryPojo(String name, String continent, List<PackagePojo> pkg) {
		super();
		this.name = name;
		this.continent = continent;
		this.pkg = pkg;
	}

	//auto-generation of id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_Id")
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	@Column(length=40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=20)
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	//country(one) to pkg(many) relation with cascade on ALL and fk in pkg(many side)
	@OneToMany(mappedBy="country",cascade=CascadeType.ALL)
	public List<PackagePojo> getPkg() {
		return pkg;
	}

	public void setPkg(List<PackagePojo> pkg) {
		this.pkg = pkg;
	}
	
	
	
}
