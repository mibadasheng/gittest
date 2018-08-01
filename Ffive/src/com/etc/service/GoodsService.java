package com.etc.service;

import java.util.ArrayList;
import java.util.List;

import com.etc.dao.GoodsDAO;
import com.etc.vo.Goods;

public class GoodsService {
	public ArrayList<Goods> getGoodsList() {
		//创建DAO实例
		GoodsDAO goodsDao=new GoodsDAO();
		//取得数据
		ArrayList<Goods> goodsList=goodsDao.getAllItems();
		//判断用户信息是否正确
		if(goodsList==null) {
			return null;
		}
		return goodsList;
		
	}
	public int register(Goods goods) throws Exception  {
		// insert鏁版嵁
		return GoodsDAO.insert(goods);
	}
}
