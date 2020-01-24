package com.app.dao;

import java.util.List;

import com.app.pojos.OrderPojo;

public interface IOrderDao {

	String addOrder(OrderPojo order);
	List<OrderPojo> showOrder(int uId);
	List<OrderPojo> showAllOrders();
}
