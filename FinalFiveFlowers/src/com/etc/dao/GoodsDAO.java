package com.etc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
 
import com.etc.vo.Goods;

import com.etc.util.ConnectionFactory;
 
//商品的业务逻辑类
public class GoodsDAO {
	
	// 获得所有的商品信息
	public ArrayList<Goods> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>(); // 商品集合
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from goodsinfo"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Goods item = new Goods();
				item.setGoodid(rs.getInt("goodsid"));
				item.setTypeid(rs.getString("typeid"));
				item.setGname(rs.getString("gname"));
				item.setSellprice(rs.getInt("sellprice"));
				item.setPhoto(rs.getString("photo"));
				item.setPhotoname(rs.getString("photoname"));
				list.add(item);// 把一个商品加入集合
			}
			return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
 
	}
	//通过商品id获取商品单价

 
	// 根据商品编号获得商品资料
	public Goods getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Goods item = new Goods();
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from goodsinfo where goodsid=?"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				item.setGoodid(rs.getInt("goodsid"));
				item.setTypeid(rs.getString("typeid"));
				item.setGname(rs.getString("gname"));
				item.setSellprice(rs.getInt("sellprice"));
				item.setPhoto(rs.getString("photo"));
				
			} 
 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
 
		}
		return item;
	}
	//通过商品id获取商品单价
	public static float selectpriceBygoodid(String goodsid)
	{
		PreparedStatement pstm= null;
		float price=0;
		try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select sellprice from goodsinfo where goodsid=?"; // SQL语句
				//String sql = "select  from tb_user where username=?"; // SQL语句
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, goodsid);
				ResultSet	rs = pstm.executeQuery();
				while (rs.next()) {
					price=rs.getInt(1);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return price;
	}
	public static ArrayList<Goods> getItemsbytypeid(String id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>(); // 商品集合
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from goodsinfo where typeid=?"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Goods item = new Goods();
				item.setGoodid(rs.getInt("goodsid"));
				item.setGname(rs.getString("gname"));
				item.setSellprice(rs.getInt("sellprice"));
				item.setPhoto(rs.getString("photo"));
				item.setPhotoname(rs.getString("photoname"));
				list.add(item);// 把一个商品加入集合
			}
			return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
 
	}
	
	public static int insert(Goods goods) throws Exception {
		PreparedStatement pstmt= null;
		int result = 0;
		//寰楀埌鏁版嵁搴撶殑杩炴帴
		Connection conn = ConnectionFactory.getConn();
		//瀹氫箟sql
		String sql = "insert into goodsinfo(gname, typeid, photo,sellprice,gmount) values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGname());
			pstmt.setString(2, goods.getTypeid());
			pstmt.setString(3, goods.getPhoto());
			pstmt.setFloat(4, goods.getSellprice());
			pstmt.setInt(5, goods.getGmount());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
/*	public void delete( int cartid) throws SQLException 
	  { 
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
	    String sql = "delete *from shoppingcart where cartid=?"; 
	    try{ 
	    	conn = ConnectionFactory.getConn();
	      ptmt = conn.prepareStatement(sql); 
	      // 对SQL语句中的第一个占位符赋值 
	      ptmt.setInt(1, cartid); 
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
*/
	/*
	//获取最近浏览的前五条商品信息
	public ArrayList<Goods> getViewList(String list)
	{
		System.out.println("list:"+list);
		ArrayList<Goods> itemlist = new ArrayList<Goods>();
		int iCount=5; //每次返回前五条记录
		if(list!=null&&list.length()>0)
		{
		    String[] arr = list.split(",");
		    System.out.println("arr.length="+arr.length);
		    //如果商品记录大于等于5条
		    if(arr.length>=5)
		    {
		       for(int i=arr.length-1;i>=arr.length-iCount;i--)
		       {
		    	  itemlist.add(getItemsById(Integer.parseInt(arr[i])));  
		       }
		    }
		    else
		    {
		    	for(int i=arr.length-1;i>=0;i--)
		    	{
		    		itemlist.add(getItemsById(Integer.parseInt(arr[i])));
		    	}
		    }
		    return itemlist;
		}
		else
		{
			return null;
		}
		
	}
	*/
}
