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
		//����DAOʵ��
		CartDao cartDao=new CartDao();
		ArrayList<Cart> cartList=CartDao.selectByUserID(id);
		//ȡ������
		
		//�ж��û���Ϣ�Ƿ���ȷ
		if(cartList==null) {
			return false;
		}
		return true;
		
	}
	/*public int register(Cart cart) throws Exception  {
		// insert数据
		//return CartDao.insert(cart);
		return CartDao.selectByUserID(userId)
	}*/

}
