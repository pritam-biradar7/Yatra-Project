package com.app.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orders")
public class OrderPojo {
//paymentId, cartId,amount,payment date	
//booking id,
	
	private Integer oId;
	//private CartPojo cart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date oDate;
	
	public OrderPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderPojo(/*CartPojo cart,*/ Date oDate) {
		super();
		//this.cart = cart;
		this.oDate = oDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	/*@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	public CartPojo getCart() {
		return cart;
	}

	public void setCart(CartPojo cart) {
		this.cart = cart;
	}*/

	@Temporal(TemporalType.DATE)
	@Column(name="Order_Date")
	public Date getoDate() {
		return oDate;
	}

	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	
	
}
