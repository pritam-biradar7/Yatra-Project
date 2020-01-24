package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.CartPojo;
import com.app.pojos.CustomerPojo;
import com.app.pojos.PackagePojo;
@Repository
@Transactional
public class CartDaoImpl implements ICartDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public int addToCart(int custId,int pkgId) {
		// TODO Auto-generated method stub
		CustomerPojo cust=sf.getCurrentSession().get(CustomerPojo.class,custId);
		System.out.println(cust);
		CartPojo cart=sf.getCurrentSession().get(CartPojo.class, cust.getCart().getcId());
		System.out.println(cart.getcId());
		PackagePojo pkg=sf.getCurrentSession().get(PackagePojo.class, pkgId);
		System.out.println(pkg.getpId());
		cart.addPackage(pkg);
		return cart.getcId();
	}
	@Override
	public List<PackagePojo> showCart(int cartId) {

		CartPojo cart=new CartPojo();
		cart=sf.getCurrentSession().get(CartPojo.class, cartId);
		
		return cart.getPkg();
	}
	@Override
	public String removeFromCart(int custId,int pkgId) {

		PackagePojo pkg=sf.getCurrentSession().get(PackagePojo.class, pkgId);
		CustomerPojo cust=sf.getCurrentSession().get(CustomerPojo.class,custId);
		CartPojo cart=sf.getCurrentSession().get(CartPojo.class, cust.getCart().getcId());
		cart.removePakage(pkg);
		return "Package removed from cart";
	}
	@Override
	public String createCart(int custId) {
		
		CustomerPojo cust=sf.getCurrentSession().get(CustomerPojo.class,custId);
		CartPojo cart=new CartPojo();
		cart.setCustomer(cust);
		sf.getCurrentSession().persist(cart);
		cust.setCart(cart);
		return "Cart created";
	}

}
