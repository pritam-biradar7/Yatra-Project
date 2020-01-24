package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.ICountryDao;
import com.app.dao.IPackageDao;
import com.app.pojos.CountryPojo;
import com.app.pojos.PackagePojo;

@Controller
@RequestMapping("/package")
public class PackageController {

	@Autowired
	private IPackageDao dao;
	
	@Autowired
	private ICountryDao cDao;
	
	@GetMapping("/selected")
	public String getSelectedPackage(HttpSession hs) {
		try {
			//int cid=Integer.parseInt(cId);
			//System.out.println(cId);
			int cId=(int) hs.getAttribute("cId");
			hs.setAttribute("Selected_Package",dao.getPackages(cId));
			return "/package/selected";
		}
		catch(RuntimeException e)
		{
			System.out.println("Error in package controller"+e);
			return "/country/list";
		
	}}
	
	@PostMapping("/selected")
	public String getCart(@RequestParam int pId,HttpSession hs){
		hs.setAttribute("pkgId", pId);
		System.out.println("PackageId: "+pId);
		return "redirect:/cart/add";
	
	}
	
	@GetMapping("/list")
	public String getAllPackages(HttpSession hs) {
		hs.setAttribute("package_list",dao.getAllPackages());
		return "/package/list";
	}
	
	@PostMapping("/list")
	public String getPackages() {
		
		return "redirect:/package/add";
	}
	
	@GetMapping("/add")
	public String addPackage() {
		
		return "/package/add";
	}
	
	@PostMapping("/add")
	public String addPackage(@RequestParam double pAmt,@RequestParam String pName,
	@RequestParam String pType,@RequestParam String pDesc,@RequestParam int cId) {
		PackagePojo pkg=new PackagePojo();
		CountryPojo country=new CountryPojo();
		country=cDao.getCountry(cId);
		System.out.println(country.getName());
		//pkg.setpId(4);
		pkg.setpAmt(pAmt);
		pkg.setpDesc(pDesc);
		pkg.setpName(pName);
		pkg.setpType(pType);
		pkg.setCountry(country);
		System.out.println(pkg.getpName());
		System.out.println(dao.insertPackage(pkg));
		return "redirect:/package/list";
	}
	
	/*@PostMapping("/add")
	public String addPackage(PackagePojo pkg,Model map,RedirectAttributes flashmap) {
		flashmap.addFlashAttribute("new_package", dao.insertPackage(pkg));
		System.out.println(pkg.getpName());
		return "redirect:/package/list";
	}*/
	
	@GetMapping("/delete")
	public String deletePackage(@RequestParam int pId) {
		dao.removePackage(pId);
		return "redirect:/package/list";
	}
	
	@GetMapping("/update")
	public String updatePackage(@RequestParam int pId,HttpSession hs) {
		PackagePojo pkg=new PackagePojo();
		pkg=dao.getPackage((pId));
		hs.setAttribute("uPackage", pkg);
		return "/package/update";
	}
	
	@PostMapping("/update")
	public String updatePackage(@RequestParam double pAmt,@RequestParam String pName,
	@RequestParam String pType,@RequestParam String pDesc,@RequestParam int cId,HttpSession hs) {
		PackagePojo pkg=(PackagePojo) hs.getAttribute("uPackage");
		CountryPojo country=new CountryPojo();
		country=cDao.getCountry(cId);
		System.out.println(pkg.getpName());
		pkg.setpAmt(pAmt);
		pkg.setpDesc(pDesc);
		pkg.setpName(pName);
		pkg.setpType(pType);
		pkg.setCountry(country);
		dao.updatePackage(pkg);
		return"redirect:/package/list";
	}
}
	

