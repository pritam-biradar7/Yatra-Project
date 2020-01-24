package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IOrderDao;
import com.app.pojos.CartPojo;
import com.app.pojos.OrderPojo;

@Controller
@RequestMapping("/payment")
public class OrderController {

	@Autowired
	private IOrderDao dao;
	
	@GetMapping("/placeorder")
	public String placeOrder(HttpSession hs) {
		/*CartPojo cart=(CartPojo) hs.getAttribute("cart");
		OrderPojo order=new OrderPojo();
		//order.setCart(cart);
		order.setoDate((Date)hs.getAttribute("odate"));
		dao.addOrder(order);*/
		return "/payment/placeorder";
	}
}
