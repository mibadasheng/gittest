package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConn() {
		Connection conn = null;
		try {
			//1.閸旂姾娴囨す鍗炲З缁拷
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
			String username ="root";
			String password="";
			//2.閼惧嘲绶辨潻鐐村复
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
