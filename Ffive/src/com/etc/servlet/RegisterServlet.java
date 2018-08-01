package com.etc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.alibaba.fastjson.JSON;
import com.etc.dao.UserDao;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.etc.service.UserService;
import com.etc.util.ConnectionFactory;
import com.etc.vo.User;

public class RegisterServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(RegisterServlet.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if ("register".equals(action)) {
			doRegister(request, response);
		} else if ("checkUser".equals(action)) {
			doCheckUser(request, response);
		}
	}
		
	
	/*
	 * 娉ㄩ敓缁撳閿熸枻鎷�
	 */
	private void doRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Connection conn = ConnectionFactory.getConn();
			UserService userService = new UserService();
			if(conn!=null) {
				String username=request.getParameter("username");
				username = new String(username.getBytes("ISO-8859-1"),"UTF-8");

		        String password=request.getParameter("password");
		        String email=request.getParameter("email");
		        String phone=request.getParameter("phone");
		        String userstate=request.getParameter("userstate");
		        String sql="insert into tb_user(username,password,email,phone,userstate)"+"values(?,?,?,?,?)";
		        //閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰暤顑紮鎷烽敓鏂ゆ嫹閿熺禋om.mysql.jdbc,涓�閿熸枻鎷烽敓鏂ゆ嫹java.sql,娌￠敓鍙唻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹java.sql閿熸枻鎷烽敓鏂ゆ嫹閿熺殕浼欐嫹閿熻鍖℃嫹閿燂拷
		       PreparedStatement ps;
			    try {
			    ps = conn.prepareStatement(sql);
		        ps.setString(1, username);
		        ps.setString(2, password);
		        ps.setString(3, email);
		        ps.setString(4, phone);
		        ps.setString(5, userstate);
		        ps.executeUpdate();
			    request.getRequestDispatcher("login.jsp").forward(request, response); 
				} 
			    catch (SQLException e) {
				//TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.error("error log:用户注册成功！");
				log.warn("warn log:用户注册成功！");
				log.info("info log:用户注册成功！");
				log.debug("debug log:用户注册成功！");
        	}
        	else{
        		response.sendError(500,"鏈嶅姟鍣ㄨ繛鎺ラ敊璇�");;}
	}
	private void doCheckUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		UserService userService = new UserService();
		boolean isExist = userService.UserExist(username);
		String message = "";
		if(isExist) {
			message = "鐢ㄦ埛鍚嶅凡瀛樺湪";
		}else {
			message = "鐢ㄦ埛鍚嶅彲鐢�";
		}
		//杞敓鏂ゆ嫹閿熸枻鎷稪SON閿熸枻鎷峰紡
		String jsonStr = JSON.toJSONString(message);
		System.out.println("message:"+message);
		System.out.println("jsonStr:"+jsonStr);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		//resoponse閿熸枻鎷峰簲閿熸枻鎷烽敓锟�
		PrintWriter out = response.getWriter();
		out.write(jsonStr);
		out.flush();
		out.close();
	}
	
}
