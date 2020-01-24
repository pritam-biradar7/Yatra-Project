package com.app.dao;

import java.util.List;

import com.app.pojos.CartPojo;
import com.app.pojos.PackagePojo;

public interface ICartDao {

	int addToCart(int custId,int pkgId);
	List<PackagePojo> showCart(int cartId);
	String removeFromCart(int custId,int pkgId);
	String createCart(int custId);
}
