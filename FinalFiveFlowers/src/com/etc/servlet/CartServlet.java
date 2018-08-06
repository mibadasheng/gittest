package com.etc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.dao.CartDao;
import com.etc.dao.GoodsDAO;
import com.etc.service.CartService;
import com.etc.service.GoodsService;
import com.etc.vo.Cart;
import com.etc.vo.Goods;

public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
    	 doPost(request,response);
    }
    @SuppressWarnings("static-access")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
         System.out.println("666");
    	CartDao cart = new CartDao();
	CartService cartService=new CartService();
		
		String userName = request.getParameter("username");
		System.out.println(userName);
		int userId = cart.selectByUserName(userName);
		
		if(cartService.selectByUserID(userId)) {
			//如果用户存在
			CartDao  cartDao= new CartDao();
			ArrayList<Cart> cartList=cartDao.selectByGoodsID(userId);
			//GoodsDAO goodsDao = new GoodsDAO();
			/*for(Cart cart:goodsList) {
				cart.setGoods(goodsDao.getItemsById(cart.getGoodsid()));
			}
			 */
			request.setAttribute("list", cartList);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}else {
			response.sendRedirect("home.do");  //重定向
		}
    }
}