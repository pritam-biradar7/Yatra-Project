package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IAddressDao;
import com.app.pojos.AddressPojo;
import com.app.pojos.CustomerPojo;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private IAddressDao dao;
	
	@GetMapping("/addaddress")
	public String addAddress() {
		return "/address/addaddress";
	}

	@PostMapping("addaddress")
	public String addAddress(@RequestParam String street,@RequestParam String city, 
			@RequestParam String state, @RequestParam String country, @RequestParam int pincode,
			HttpSession hs,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date odate) {
		CustomerPojo cust=(CustomerPojo) hs.getAttribute("customerDetails");
		AddressPojo addr=new AddressPojo();
		addr.setStreet(street);
		addr.setCity(city);
		addr.setState(state);
		addr.setCountry(country);
		addr.setPincode(pincode);
		addr.setCust(cust);
		hs.setAttribute("customerAddress", dao.addAddress(addr));
		hs.setAttribute("odate", odate);
			return "redirect:/payment/placeorder";
	}
}
