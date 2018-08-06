package com.etc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.etc.util.ConnectionFactory;
import com.etc.vo.User;

public class UserDao {

	public User selectByNameAndPwd(String username, String password) {
		User user = null;
		PreparedStatement pstmt= null;
		
		Connection conn = ConnectionFactory.getConn();
		//瀹氫箟sql
		String sql = "select  username,password,email,phone,userstate,age,sex,address from tb_user where username =? and password=?";
		try {
			//鐢熸垚棰勭紪璇慡tatement璇彞瀵硅薄
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			//鎵ц鏌ヨ
			ResultSet rs = pstmt.executeQuery();
			//鍙栧緱鏌ヨ缁撴灉
			if (rs.next()) {
				user = new User();//鎶婃煡璇㈢粨鏋滆祴缁欒繑鍥炵殑User
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setUserstate(rs.getString(5));
				user.setAge(rs.getInt(6));
				user.setSex(rs.getString(7));
				user.setAddress(rs.getString(8));
			}
			 //pstmt.close();
	         //conn.close(); //关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
    }
	public User selectByname(String username) {
		User user = null;
		PreparedStatement pstmt= null;
		//寰楀埌鏁版嵁搴撶殑杩炴帴
		Connection conn = ConnectionFactory.getConn();
		//瀹氫箟sql
		String sql = "select  username,password,email,phone,userstate,age,sex,address from tb_user where username =?";
		try {
			//鐢熸垚棰勭紪璇慡tatement璇彞瀵硅薄
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
		///pstmt.setString(2, password);
			//鎵ц鏌ヨ
			ResultSet rs = pstmt.executeQuery();
			//鍙栧緱鏌ヨ缁撴灉
			if (rs.next()) {
				user = new User();//鎶婃煡璇㈢粨鏋滆祴缁欒繑鍥炵殑User
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setUserstate(rs.getString(5));
				user.setAge(rs.getInt(6));
				user.setSex(rs.getString(7));
				user.setAddress(rs.getString(8));
			}
			 //pstmt.close();
	         //conn.close(); //关闭连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
    }
	//验证注册用户名是否已存在
	public User selectByName(String username) {
		User user = null;
		PreparedStatement pstmt= null;
		//得到数据库的连接
		Connection conn = ConnectionFactory.getConn();
		//定义sql
		String sql = "select username, password, email, phone,userstate,age,sex,address from tb_user where username =? ";
		try {
			//生成预编译Statement语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			//执行查询
			ResultSet rs = pstmt.executeQuery();
			//取得查询结果
			while (rs.next()) {
				user = new User();//把查询结果赋给返回的User
				user.setUsername(rs.getString(1));
				user.setPhone(rs.getString(4));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(2));
				user.setUserstate(rs.getString(5));
				user.setAge(rs.getInt(6));
				user.setSex(rs.getString(7));
				user.setAddress(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	   /*
		 * 注册
		 */
		public int insert(User user) {
			PreparedStatement pstmt= null;
			int result = 0;
			//得到数据库的连接
			Connection conn = ConnectionFactory.getConn();
			//定义sql
			 String sql="insert into tb_user(username,password,email,phone,userstate,age,sex,address)"+"values(?,?,?,?,?,?,?,?)";
             //这里会有两类，一类是com.mysql.jdbc,一类是java.sql,没有本质区别，java.sql兼容性会更强。
			 try {
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setString(1, user.getUsername());
             ps.setString(2, user.getPassword());
             ps.setString(3, user.getEmail());
             ps.setString(4, user.getPhone());
             ps.setString(5, user.getUserstate());
             ps.setInt(6, user.getAge());
             
             ps.setString(7, user.getSex());
             ps.setString(8, user.getAddress());
            
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
}
