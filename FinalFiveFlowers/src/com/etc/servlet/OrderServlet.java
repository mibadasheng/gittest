package com.etc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etc.dao.CartDao;
import com.etc.dao.GoodsDAO;
import com.etc.dao.OrderDao;
import com.etc.service.CartService;
import com.etc.service.GoodsService;
import com.etc.vo.Cart;
import com.etc.vo.Goods;
import com.etc.vo.Order;

public class OrderServlet  extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	       // request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
	    	 doPost(request,response);
	    }

	    @SuppressWarnings("static-access")
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	request.setCharacterEncoding("UTF-8");
	    	//OrderDao orderr = new OrderDao();
			//OrderService orderService=new OrderService();
	    	String action = request.getParameter("action");
	    	//if ("tijiao".equals(action)) {
				
	    	System.out.println("***");
//	    	String goodid=request.getParameter("check_val");
	    	String[] goodid=request.getParameterValues("cart");
	    	System.out.println("goodid.length:"+goodid.length);
	    	GoodsDAO item = new GoodsDAO();
	    	CartDao cart = new CartDao();
	    	ArrayList<Goods> list = new ArrayList<Goods>();
	    	float sum=0;
	    	for(String id :goodid) {
	    		Goods goods=item.getItemsById(Integer.parseInt(id));
	    		float price=item.selectpriceBygoodid(id);
	    		int num=cart.selectnumBygoddid(id);
	    		sum+=price*num;
	    		//request.setAttribute("num", num);
	    		list.add(goods);// 把一个商品加入集合
	    	System.out.println("啦啦啦"+id);
	    	}
	    	request.setAttribute("sum", sum);
	    	request.setAttribute("list", list);
	    	HttpSession session = request.getSession();
			String userName =(String) session.getAttribute("username");
			String allprice = request.getParameter("allprice");
			//String goodid=request.getParameter("goodsid");
			
				//如果用户存在
				OrderDao orderDao = new OrderDao();
				try {
					orderDao.add(sum, userName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			Order order=orderDao.selectByusername( userName);
			
				request.setAttribute("order", order);
				System.out.println(order);
				request.getRequestDispatcher("pay.jsp").forward(request, response);
				//}
			
	    }

}
