<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理</title>
</head>
<body>
<p style="color:red">
<%String message = (String)request.getAttribute("message");%>
<%=(message==null)?"":message%></p>
<form action="admin.do" method="post" enctype="multipart/form-data">
商品名：<input type ="text" name="gname"><br>
商品类型号：<input type="text" name="typeid"><br>
图片：<input type="file" name="photo"><br>
<input type ="submit" value ="提交">
</form>
</body>
</html>