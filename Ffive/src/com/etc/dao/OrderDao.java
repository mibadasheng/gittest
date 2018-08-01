package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.etc.servlet.RegisterServlet;
import com.etc.util.ConnectionFactory;
import com.etc.vo.Cart;
import com.etc.vo.Order;
import com.etc.vo.User;

public class OrderDao {
	private static Logger log = Logger.getLogger(RegisterServlet.class);
	public static Order selectByusername(String username)
	{
		PreparedStatement pstm= null;
		ResultSet rs=null;
		
		Order order=null;
		
		
		try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select username,allprice from  orderinfo   where username=?"; // SQL语句
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, username);
				rs = pstm.executeQuery();
				while (rs.next()) {
					order=new Order();
					UserDao userDao = new UserDao();
					order.setUsername(rs.getString(1));
					order.setAllprice(rs.getFloat(2));
					order.setUser(userDao.selectByname(username));
					
					//cartList.add(cart);
					//cart.goods.setGoods(rs.getString(3));
					//cart.setGoodid(goodsid);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return order;
	}
	public void add(String allprice,String username) throws SQLException 
	  { 
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//大小写不能改变
		String dateStr=sdf.format(date);
	    String sql = "insert  into orderinfo(allprice,username)"+"values(?,?)";
	    try{ 
	    conn = ConnectionFactory.getConn();
	      ptmt = conn.prepareStatement(sql); 
	      // 对SQL语句中的第一个占位符赋值 
	      //ptmt.setString(1, goodid); 
	      ptmt.setString(1,allprice);
	      ptmt.setString(2, username);
	     
	      // 执行更新操作 
	      ptmt.executeUpdate(); 
	      UserDao userDao = new UserDao();
	      User user= userDao.selectByname(username);
	      log.info("[Order log]: allprice:" +allprice+" user:"+user+" date:"+dateStr);
	        
	    }finally{ 
	      if (null!=ptmt) { 
	        ptmt.close(); 
	      } 
	        
	      if (null!=conn) { 
	        conn.close(); 
	      } 
	        
	    } 
	      
	  } 
}
