package com.app.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ICartDao;
import com.app.dao.ICustomerDao;
import com.app.pojos.CustomerPojo;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerDao dao;
	
	@Autowired
	private ICartDao cDao;
	
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
	
	@GetMapping("/register")
	public String registerCustomer() {
		return "/customer/register";
	}
	
	@PostMapping("/register")
	public String registerCustomer(@RequestParam String name,@RequestParam String email,
			@RequestParam String password,@RequestParam String mobileno) {
		CustomerPojo cust=new CustomerPojo();
		cust.setEmail(email);
		cust.setName(name);
		cust.setPassword(password);
		cust.setMobileNo(mobileno);
		//cust.setCart(new CartPojo());
		dao.registerCustomer(cust);		
		int id=cust.getCustId();
		cDao.createCart(id);
		return "redirect:/customer/login";
	}
	
}
