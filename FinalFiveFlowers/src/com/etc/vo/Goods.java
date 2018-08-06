package com.etc.vo;

public class Goods {
	private int goodid;
	private String typeid;
	private String gname;
	private float sellprice;
	private float storeprice;
	private String photo;
	private int gmount;
	private int state;
	private String photoname;
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public int getGoodid() {
		return goodid;
	}
	public void setGoodid(int goodid) {
		this.goodid = goodid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getSellprice() {
		return sellprice;
	}
	public void setSellprice(float sellprice) {
		this.sellprice = sellprice;
	}
	public float getStoreprice() {
		return storeprice;
	}
	public void setStoreprice(float storeprice) {
		this.storeprice = storeprice;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getGmount() {
		return gmount;
	}
	public void setGmount(int gmount) {
		this.gmount = gmount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Product [goodid=" + goodid + ", typeid=" + typeid + ", gname=" + gname + ", sellprice=" + sellprice
				+ ", storeprice=" + storeprice + ", photo=" + photo + ", gmount=" + gmount + ", state=" + state + "]";
	}
	
}
