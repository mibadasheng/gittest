<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/component.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8"> 
<meta name="keywords" content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />	
<script src="js/jquery-1.11.3.js"> </script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript">

function checkUser(){
	$.ajax({
		type:"post",
		url:"register.do?action=checkUser",
		data:{"username":$("#username").val()}, 
		success:function(data) {
			alert("success返回："+data);
			$("#message").text(data);
		}
	});
}
</script>
</head>
<body>
<!--header-->
<div class="header2 text-center">
	 <div class="container">
		 <div class="main-header">
			  <div class="carting">
				 <ul><li><a href="login.html">登录</a></li></ul>
				 </div>
			 <div class="logo">
				 <h3><a href="index.html">FIVE FLOWERS</a></h3>
			  </div>			  
			 <div class="box_1">				 
				 <a href="cart.html"><h3>购物车:<img src="images/cart.png" alt=""/></h3></a>
				 
			 
			 </div>
			 
			 <div class="clearfix"></div>
		 </div>
				<!-- start header menu -->
		 <ul class="megamenu skyblue">
			<li><a href="index.html">主页</a></li>							
			 <li><a href="#">女装</a>
				  <div class="megapanel">
				  	<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>分类</h4>
								<ul>
									<li><a href="products.html">连衣裙</a></li>					
									<li><a href="products.html">上装</a></li>
									<li><a href="products.html">下装</a></li>
									<li><a href="products.html">家居服</a></li>
									<li><a href="products.html">内衣</a></li>
									<li><a href="products.html">鞋</a></li>
								</ul>	
							</div>
						</div>
				</li>				
			
				<li class="grid"><a href="about.html">关于我们</a></li>			
	
				
				</ul> 
			 </div>
			  <div class="clearfix"></div> 
	 </div>
</div>
<!--header//-->
<div class="registration-form">
	 <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="FIVE.jsp">主页</a></li>
		  <li class="active">注册</li>
		 </ol>
		 <h2>注册</h2>
		 <div class="col-md-6 reg-form">
			 <div class="reg">
				 <p>欢迎，请填写您的注册信息</p>
				 <p>如果您已经是FIVEFLOWERS的成员<a href="login.jsp">点击这里</a></p>
<p style="color:red">
<%String message = (String)request.getAttribute("message");%>
<%=(message==null)?"":message%></p>
    <form action ="register.do?action=register" method="post">
					 
					 <big>用户名:</big>	    
					 <input id="username" type="text" value="" name="username" onblur="checkUser()" >
					 <big>密码:</big>
					 <input type="password" value="" name="password">
					 <big>性别:</big>
					 <input type="text" value="" name="sex">
					 <big>年龄:</big>
					 <input type="text" value="" name="age">	
					 <big>邮箱:</big>
					 <input type="text" value="" name="email">
					 <big>电话:</big>
					 <input type="text" value="" name="phone">
					 <big>地址:</big>
					 <input type="text" value="" name="address">				
					 <input type ="submit" value ="注册">
					 <p class="click">点击这里，表示您已经同意 <a href="login.jsp">用户需知</a> 协议</p>
	</form>
			 </div>
		 </div>
		
			 
	 </div>
</div>
<!--fotter-->

<div class="fotter-logo">
	 <div class="container">
	 <div class="ftr-logo"><h3><a href="index.html">FIVE FLOWERS</a></h3></div>
	 <div class="ftr-info">
	 <p>FIVEFLOWERS版权所有;<a target="_blank" ></a></p>
	</div>
	 <div class="clearfix"></div>
	 </div>
</div>
<!--fotter//-->	

</body>
</html>
		