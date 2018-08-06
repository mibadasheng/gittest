<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.etc.vo.Goods" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理成功</title>
</head>
<body>
<p style="color:red">
<%String message = (String)request.getAttribute("message");
Goods goods = (Goods)request.getAttribute("goodsinfo");
String url =(String)request.getAttribute("url");
%>
<%=(message==null)?"":message%></p>
商品名：<%=goods.getGname() %>
商品类型号：<%=goods.getTypeid() %><br>
商品图片：<img src="<%=request.getAttribute("url")%>"><br>
<img src="images/cart.png">
<a href="admin.jsp">继续管理商品</a><br>
<a href="FIVE.do">首页</a><br>
</body>

</html>