package com.etc.vo;

public class Order {
	private int orderid;
	private User user;
	private int goodid;
	private float allprice;
	private String username;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public float getAllprice() {
		return allprice;
	}
	public void setAllprice(float allprice) {
		this.allprice = allprice;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", user=" + user + ", goodid=" + goodid + ", allprice=" + allprice
				+ ", gname=" + username + ", getOrderid()=" + getOrderid() + ", getUser()=" + getUser() + ", getGoodid()="
				+ getGoodid() + ", getAllprice()=" + getAllprice() + ", getGname()=" + getUsername() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
