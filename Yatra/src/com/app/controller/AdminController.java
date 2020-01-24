package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IAdminDao;
import com.app.pojos.AdminPojo;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminDao dao;
	
	@GetMapping("/login")
	public String authenticateAdmin() {
		return "/admin/login";
	}
	
	@PostMapping("/login")
	public String authenticateAdmin(@RequestParam String email,@RequestParam String password,HttpSession hs,Model map) {
		String mesg=new String();
		try {
			AdminPojo a=dao.authenticateAdmin(email, password);
			hs.setAttribute("adminDetails", a);
			return "redirect:/package/list";
		}
		catch(RuntimeException e) {
			mesg="Please Enter Valid Credentials";
			map.addAttribute("mesg", mesg);
			System.out.println("Error in login controller "+e);
			return "/admin/login";
	}
}
}