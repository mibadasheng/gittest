package com.etc.service;

import java.util.ArrayList;

import com.etc.dao.CartDao;
import com.etc.dao.OrderDao;
import com.etc.vo.Cart;

public class OrderService {
	public boolean selectByUserID(int id) {
		//创建DAO实例
		OrderDao cartDao=new OrderDao();
		ArrayList<Cart> cartList=CartDao.selectByUserID(id);
		//取得数据
		
		//判断用户信息是否正确
		if(cartList==null) {
			return false;
		}
		return true;
		
	}
}
