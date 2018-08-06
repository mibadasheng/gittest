package com.etc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
 
import com.etc.vo.Goods;

import com.etc.util.ConnectionFactory;
 
//��Ʒ��ҵ���߼���
public class GoodsDAO {
	
	// ������е���Ʒ��Ϣ
	public ArrayList<Goods> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Goods> list = new ArrayList<Goods>(); // ��Ʒ����
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from goodsinfo"; // SQL���
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
				list.add(item);// ��һ����Ʒ���뼯��
			}
			return list; // ���ؼ��ϡ�
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
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
	//ͨ����Ʒid��ȡ��Ʒ����

 
	// ������Ʒ��Ż����Ʒ����
	public Goods getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Goods item = new Goods();
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from goodsinfo where goodsid=?"; // SQL���
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
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
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
	//ͨ����Ʒid��ȡ��Ʒ����
	public static float selectpriceBygoodid(String goodsid)
	{
		PreparedStatement pstm= null;
		float price=0;
		try {
			
			Connection	conn = ConnectionFactory.getConn();
				String sql = "select sellprice from goodsinfo where goodsid=?"; // SQL���
				//String sql = "select  from tb_user where username=?"; // SQL���
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
		ArrayList<Goods> list = new ArrayList<Goods>(); // ��Ʒ����
		try {
			conn = ConnectionFactory.getConn();
			String sql = "select * from goodsinfo where typeid=?"; // SQL���
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
				list.add(item);// ��һ����Ʒ���뼯��
			}
			return list; // ���ؼ��ϡ�
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
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
		//得到数据库的连接
		Connection conn = ConnectionFactory.getConn();
		//定义sql
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
	      // ��SQL����еĵ�һ��ռλ����ֵ 
	      ptmt.setInt(1, cartid); 
	      // ִ�и��²��� 
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
	//��ȡ��������ǰ������Ʒ��Ϣ
	public ArrayList<Goods> getViewList(String list)
	{
		System.out.println("list:"+list);
		ArrayList<Goods> itemlist = new ArrayList<Goods>();
		int iCount=5; //ÿ�η���ǰ������¼
		if(list!=null&&list.length()>0)
		{
		    String[] arr = list.split(",");
		    System.out.println("arr.length="+arr.length);
		    //�����Ʒ��¼���ڵ���5��
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
