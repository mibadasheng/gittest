package com.etc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.util.ConnectionFactory;

public class DelGoodServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String gname = request.getParameter("gname");
		PreparedStatement pstmt= null;
		Connection conn = ConnectionFactory.getConn();
        System.out.println(gname);
           String sql = "delete  from goodsinfo where gname=?";
           try {   
        	//   System.out.println("2222");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           request.getRequestDispatcher("firstpage.jsp").forward(request, response);
    }
	}

