package com.etc.service;

import java.util.ArrayList;

import com.etc.dao.CartDao;
import com.etc.dao.OrderDao;
import com.etc.vo.Cart;

public class OrderService {
	public boolean selectByUserID(int id) {
		//����DAOʵ��
		OrderDao cartDao=new OrderDao();
		ArrayList<Cart> cartList=CartDao.selectByUserID(id);
		//ȡ������
		
		//�ж��û���Ϣ�Ƿ���ȷ
		if(cartList==null) {
			return false;
		}
		return true;
		
	}
}
