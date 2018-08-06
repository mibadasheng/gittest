package com.etc.service;

import java.util.ArrayList;
import java.util.List;

import com.etc.dao.GoodsDAO;
import com.etc.vo.Goods;

public class GoodsService {
	public ArrayList<Goods> getGoodsList() {
		//����DAOʵ��
		GoodsDAO goodsDao=new GoodsDAO();
		//ȡ������
		ArrayList<Goods> goodsList=goodsDao.getAllItems();
		//�ж��û���Ϣ�Ƿ���ȷ
		if(goodsList==null) {
			return null;
		}
		return goodsList;
		
	}
	public int register(Goods goods) throws Exception  {
		// insert数据
		return GoodsDAO.insert(goods);
	}
}
