package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ICountryDao;
import com.app.dao.IPackageDao;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private ICountryDao cdao;
	
	@Autowired
	private IPackageDao pdao;
	
	@GetMapping("/list")
	public String getAllCountries(Model map,HttpSession hs) {
		hs.setAttribute("country_list",cdao.getCountries());
		
		return "/country/list";
	}
	
	@PostMapping("/list")
	public String getPackages(@RequestParam int cId,HttpSession hs) {
		try {
			//int cid=Integer.parseInt(cId);
			//System.out.println(cId);
			hs.setAttribute("cId", cId);		
			return "redirect:/package/selected";
		}
		catch(RuntimeException e)
		{
			System.out.println("Error in package controller"+e);
			return "/country/list";
		}
	}
	
	@GetMapping("/countries")
	public String getCountries(HttpSession hs) {
		hs.setAttribute("countries",cdao.getCountries());
		return "/country/countries";
	}
	
	@PostMapping("/countries")
	public String addPackage(@RequestParam int cId, HttpSession hs) {
		hs.setAttribute("cId1",cId );
		return "/package/list";
	}
	
}
