package com.etc.service;

import java.util.ArrayList;
import java.util.List;

import com.etc.dao.CartDao;
import com.etc.dao.GoodsDAO;
//import com.etc.vo.BigCart;
import com.etc.vo.Cart;
import com.etc.vo.Goods;

public class CartService {
	public boolean selectByUserID(int id) {
		//创建DAO实例
		CartDao cartDao=new CartDao();
		ArrayList<Cart> cartList=CartDao.selectByUserID(id);
		//取得数据
		
		//判断用户信息是否正确
		if(cartList==null) {
			return false;
		}
		return true;
		
	}
	/*public int register(Cart cart) throws Exception  {
		// insert鏁版嵁
		//return CartDao.insert(cart);
		return CartDao.selectByUserID(userId)
	}*/

}
