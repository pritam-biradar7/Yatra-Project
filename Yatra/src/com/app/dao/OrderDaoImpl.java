package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.OrderPojo;

@Transactional
@Repository
public class OrderDaoImpl implements IOrderDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public String addOrder(OrderPojo order) {
		sf.getCurrentSession().persist(order);
		return "Order Placed";
	}

	@Override
	public List<OrderPojo> showOrder(int cId) {
		String jpql="select o from OrderPojo o where o.cart.cId=:cId";
		return sf.getCurrentSession().createQuery(jpql,OrderPojo.class)
				.setParameter("cId", cId).getResultList();
	}

	@Override
	public List<OrderPojo> showAllOrders() {
		String jpql="select o from OrderPojo o";
		return sf.getCurrentSession().createQuery(jpql,OrderPojo.class).getResultList();
	}

}
