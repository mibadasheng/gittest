<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message = (String)request.getAttribute("message");%>
<%=(message==null)?"":message%></p>
<form action="delgood.do" method="post" >
商品名：<input type ="text" name="gname"><br>

<input type ="submit" value ="提交">
</form>
</body>
</html>