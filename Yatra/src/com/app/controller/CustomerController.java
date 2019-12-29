package com.app.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ICustomerDao;
import com.app.pojos.CustomerPojo;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerDao dao;
	
	@GetMapping("/list")
	public String getAllCust(Model map) {
		System.out.println("in controller");
		map.addAttribute("Cust_list",dao.getCustomers());
		return "/customer/list";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return"/customer/login";
	}
	
	@PostMapping("/login")
	public String validteCustomer(@RequestParam String em,@RequestParam String password,HttpSession hs)
	{
		try {
		CustomerPojo c=dao.authenticateCustomer(em, password);
		hs.setAttribute("customerDetails", c);
		return "redirect:/country/list";
	}
	catch(RuntimeException e) {
		System.out.println("Error in login controller "+e);
		return "/customer/login";
	}
  }
}
