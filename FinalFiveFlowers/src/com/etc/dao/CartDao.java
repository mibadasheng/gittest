package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.etc.servlet.GoodsDao;
import com.etc.util.ConnectionFactory;
import com.etc.vo.Cart;
import com.etc.vo.Goods;

public class CartDao {
	
	public static int selectByUserName(String userName)
	{
		PreparedStatement pstm= null;
		int id = 0;
		try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select userid  from tb_user where username=?"; // SQL语句
				//String sql = "select  from tb_user where username=?"; // SQL语句
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, userName);
				ResultSet	rs = pstm.executeQuery();
				while (rs.next()) {
					id=rs.getInt(1);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return id;
	}
	public static int selectnumBygoddid(String goodsid)
	{
		PreparedStatement pstm= null;
		int num=0;
		try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select num  from shoppingcart where goodsid=?"; // SQL语句
				//String sql = "select  from tb_user where username=?"; // SQL语句
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, goodsid);
				ResultSet	rs = pstm.executeQuery();
				while (rs.next()) {
					num=rs.getInt(1);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return num;
	}
	
	
	public static ArrayList<Cart> selectByUserID(int id)
	{
	//	PreparedStatement pstm= null;
		//ResultSet	rs=null;
		return selectByGoodsID(id);
	/*	try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select  from shoppingcart where userid=?"; // SQL语句
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				rs = pstm.executeQuery();
				while (rs.next()) {
					cart=new Cart();
					cartList.add(selectByGoodsID(id));
					
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}*/
//		return cartList;
	}
	/*public static int selectByUserid(int userid)
	{
		PreparedStatement pstm= null;
		ResultSet	rs=null;
		int cartid=0;
		
		 ArrayList<Goods> goodsList=new  ArrayList<Goods>();
		try {
			
			Connection	conn = ConnectionFactory.getConn();
			String sql = "select cartid  from shoppingcart where userid=?"; // SQL语句
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userid);
				rs = pstm.executeQuery();
			while (rs.next()) {
				cartid=rs.getInt(1);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	return cartid;
	}*/
/*	public static Cart selectByGoodsID(int goodsid)
	{
		PreparedStatement pstm= null;
		ResultSet	rs=null;
		//Goods goods=null;
		Cart cart=null;
		
		// ArrayList<Goods> goodsList=new  ArrayList<Goods>();
		try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select gname,sellprice,photo  from  goodsinfo   where goodsid=?"; // SQL语句
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, goodsid);
				rs = pstm.executeQuery();
				while (rs.next()) {
					goods=new Goods();
					
					goods.setGname(rs.getString(1));
					goods.setSellprice(rs.getInt(2));
					goods.setPhoto(rs.getString(3));
					goods.setGoodid(goodsid);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return goods;
	}*/
	
	public static ArrayList<Cart> selectByGoodsID(int userid)
	{
		PreparedStatement pstm= null;
		ResultSet	rs=null;
		//Goods goods=null;
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		Cart cart=null;
		
		// ArrayList<Goods> goodsList=new  ArrayList<Goods>();
		try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select num,goodsid  from  shoppingcart   where userid=?"; // SQL语句
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, userid);
				rs = pstm.executeQuery();
				while (rs.next()) {
					cart=new Cart();
					GoodsDAO goodsDao = new GoodsDAO();
					cart.setNum(rs.getInt(1));
					cart.setGoodsid(rs.getInt(2));
					cart.setGoods(goodsDao.getItemsById(cart.getGoodsid()));
					cartList.add(cart);
					//cart.goods.setGoods(rs.getString(3));
					//cart.setGoodid(goodsid);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return cartList;
	}
/*	public static int selectNum(int userid,String goodid)
	{
		PreparedStatement pstm= null;
		ResultSet	rs=null;
		int num=0;
		
		 ArrayList<Cart> cartList=new  ArrayList<Cart>();
		try {
			
			Connection	conn = ConnectionFactory.getConn();
			String sql = "select num  from shoppingcart where userid=?and goodsid=?"; // SQL语句
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userid);
			 pstm.setString(2, goodid); 
				rs = pstm.executeQuery();
			while (rs.next()) {
				num=rs.getInt(1);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	return num;
	}*/
	
	public void delete( String goodid,int userid) throws SQLException 
	  { 
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
	    String sql = "delete from shoppingcart where goodsid=?and userid=?"; 
	    try{ 
	    	conn = ConnectionFactory.getConn();
	      ptmt = conn.prepareStatement(sql); 
	      // 对SQL语句中的第一个占位符赋值 
	      ptmt.setString(1, goodid); 
	      ptmt.setInt(2, userid);
	      // 执行更新操作 
	      ptmt.executeUpdate(); 
	        
	    }finally{ 
	      if (null!=ptmt) { 
	        ptmt.close(); 
	      } 
	        
	      if (null!=conn) { 
	        conn.close(); 
	      } 
	        
	    } 
	      
	  } 

	public void add( String goodid,int userid,int num) throws SQLException 
	  { 
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
	    String sql = "insert  into shoppingcart(goodsid,userid,num)"+"values(?,?,?)";
	    try{ 
	    conn = ConnectionFactory.getConn();
	      ptmt = conn.prepareStatement(sql); 
	      // 对SQL语句中的第一个占位符赋值 
	      ptmt.setString(1, goodid); 
	      ptmt.setInt(2, userid);
	      ptmt.setInt(3, num);
	     
	      // 执行更新操作 
	      ptmt.executeUpdate(); 
	        
	    }finally{ 
	      if (null!=ptmt) { 
	        ptmt.close(); 
	      } 
	        
	      if (null!=conn) { 
	        conn.close(); 
	      } 
	        
	    } 
	      
	  } 

	public void update( String goodid,int userid,int num) throws SQLException 
	  { 
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
	    String sql = "update shoppingcart set num=? where goodsid=? and userid=?";
	    try{ 
	    conn = ConnectionFactory.getConn();
	      ptmt = conn.prepareStatement(sql); 
	      // 对SQL语句中的第一个占位符赋值 
	      ptmt.setInt(1, num);
	      ptmt.setString(2, goodid); 
	      ptmt.setInt(3, userid);
	      // 执行更新操作 
	      ptmt.executeUpdate(); 
	        
	    }finally{ 
	      if (null!=ptmt) { 
	        ptmt.close(); 
	      } 
	        
	      if (null!=conn) { 
	        conn.close(); 
	      } 
	        
	    } 
	      
	  } 

	/*public static ArrayList<Cart> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}