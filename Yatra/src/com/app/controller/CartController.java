package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.ICartDao;
import com.app.pojos.CustomerPojo;
import com.app.pojos.PackagePojo;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ICartDao cDao;
	
	@GetMapping("/add")
	public String addCart(HttpSession hs) {

		CustomerPojo cust=(CustomerPojo) hs.getAttribute("customerDetails");
		System.out.println("customerId: "+cust.getCustId());
		System.out.println("packageId: "+(int)hs.getAttribute("pkgId"));
		hs.setAttribute("cartId",cDao.addToCart(cust.getCustId(), (int)hs.getAttribute("pkgId")));
		return "redirect:/cart/showcart";
	}
	
	@GetMapping("/showcart")
	public String showCart(HttpSession hs) {
		//CustomerPojo cust=new CustomerPojo();
		CustomerPojo cust=(CustomerPojo)hs.getAttribute("customerDetails");
		List<PackagePojo> pkg=new ArrayList<>();
		pkg=cDao.showCart(cust.getCart().getcId());
		hs.setAttribute("cart",pkg);
		double total=0;
		for(PackagePojo p:pkg)
		{
			total=total+p.getpAmt();
		}
		hs.setAttribute("total", total);
		return "/cart/showcart";
	}
	@PostMapping("/showcart")
	public String showCart() {
		return "redirect:/address/addaddress";
	}
	
	@GetMapping("/remove")
	public String removeFromCart(@RequestParam int pId,HttpSession hs) {
		CustomerPojo cust=(CustomerPojo) hs.getAttribute("customerDetails");
		cDao.removeFromCart(cust.getCustId(), pId);
		return "redirect:/cart/showcart";
	}
}
