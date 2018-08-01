package com.etc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.CartDao;
import com.etc.dao.GoodsDAO;
import com.etc.service.CartService;
import com.etc.util.ConnectionFactory;
import com.etc.vo.Goods;

public class DeleteServlet extends HttpServlet { 
	  private static final long serialVersionUID = 1L; 
	  
	  /** 
	   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse 
	   *   response) 
	   */
	  protected void doGet(HttpServletRequest request, 
	      HttpServletResponse response) throws ServletException, IOException { 
		  doPost(request,response);
		 
	  } 
	  
	  /** 
	   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse 
	   *   response) 
	   */
	  
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		//System.out.println("Œ“∞Æ—ßœ∞");
		  CartDao cart = new CartDao();
			CartService cartService=new CartService();
			
			String userName = request.getParameter("username");
			String goodid  = request.getParameter("goodid");
			System.out.println(userName);
			int userId = cart.selectByUserName(userName);
			
	   // int cartid = cart.selectByUserid(userId);
		System.out.println(goodid);
	    try {
			cart.delete(goodid,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    request.getRequestDispatcher("cart.do").forward(request, response);
	  }
	    	
	}
