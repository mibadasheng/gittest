package com.etc.vo;

import java.math.BigDecimal;
import java.util.List;

public class Cart {
	 
	private int cartid;
	private int userid;
	private int goodsid;
	private int num;
	private Goods goods;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getUserid() {
		return userid;
	}
	@Override
	public String toString() {
		return "BigCart [cartid=" + cartid + ", userid=" + userid + ", goodsid=" + goodsid + ", num=" + num + "]";
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}