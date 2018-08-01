<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/component.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" 
		/>		
<script src="js/jquery.min.js"></script>
<script src="js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
 <script type="text/javascript">
        function login(form){
            if(form.username.value == ""){
                alert("用户不能为空！");
                return false;
            }
            if(form.password.value == ""){
                alert("密码不能为空！");
                return false;
            }
        }
    </script>
<!-- start menu -->
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
				 <a href="cart.html"><h3>购物车: <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> 件)<img src="images/cart.png" alt=""/></h3></a>
				 <p><a href="javascript:;" class="simpleCart_empty">空购物车</a></p>
			 
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
<div class="login">
	 <div class="container">
			<ol class="breadcrumb">
		  <li><a href="index.html">主页</a></li>
		  <li class="active">登录</li>
		 </ol>
		 <h2>登录</h2>
		 <div class="col-md-6 log">			 
				 <p>我已是FIVEFLOWERS的用户.</p>
				 <p>请输入您的用户名和密码登录</p>
				 <%String message = (String)request.getAttribute("message");%><%=(message==null)?"":message%></p>
				 <form action="login.do" method="post">
					 <h5>用户名:</h5>	
					 <input type="text" value="" name="username">
					 <h5>密码:</h5>
					 <input type="password" value="" name="password">					
					 <input type ="submit" value ="登录">
					  <a href="#">忘记密码?</a>
				 </form>				 
		 </div>
		  <div class="col-md-6 login-right">
			  	<h3>我想成为FIVEFLOWERS的用户</h3>
				<p>如果您还不是FIVEFLOWERS的用户，请在此注册.</p>
				<a class="acount-btn" href="register.jsp">创建新用户</a>
		 </div>
		 <div class="clearfix"></div>		 
		 
	 </div>
</div>
<!--fotter-->
<div class="fotter-logo">
	 <div class="container">
	 <div class="ftr-logo"><h3><a href="index.html">FIVE FLOWERS</a></h3></div>
	 <div class="ftr-info">
	 <p>FIVEFLOWERS版权所有；<a target="_blank" ></a></p>
	</div>	 <div class="clearfix"></div>
	 </div>
</div>

<!--fotter//-->	
</body>
</html>