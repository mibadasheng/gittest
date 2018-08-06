<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="com.etc.vo.Goods"%>
<%@ page import="com.etc.dao.GoodsDAO"%>

<!DOCTYPE html>
<html>
<head>
<title>店铺简介</title>
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
<%
if((String)session.getAttribute("username")==null){
%>
<script type="text/javascript" language="javascript">
alert("您还没有登录，请登录");
window.document.location.herf="login.jsp";
</script>
<%}
%>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- start menu -->
</head>
<body>
<!--header-->
<div class="header">
	 <div class="container">
	     <div class="main-header">
			  <div class="carting">
				 <ul><li><a href="login.jsp"> 登录</a></li></ul>
				 <ul><li><a href=" logoff.do"> 登出</a></li></ul> 
				 <ul><li><a href="userdel.do?<%=(String)session.getAttribute("username")%>"> 注销</a></li></ul>
				 </div>
			 <div class="logo">
				 <h3><a href="FIVE.jsp">FIVE FLOWERS</a></h3>
			  </div>			  
			 <div class="box_1">				 
				 <a href="cart.do?username=<%= (String)session.getAttribute("username") %>"><h3>购物车:<img src="images/cart.png" alt=""/></h3></a>
				 <p><a href="javascript:;" class="simpleCart_empty"></a></p>
			 
			 </div>	 
			 <div class="clearfix"></div>
		 </div>
				
				<!-- start header menu -->
		<ul class="megamenu skyblue">
			<li class="active grid"><a class="color1" href="FIVE.jsp">首页</a></li>
			<li class="grid"><a href="#">女装</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>分类</h4>
								<ul>
									<li><a href="dress.jsp">连衣裙</a></li>					
									<li><a href="shirt.jsp">上装</a></li>
									<li><a href="pants.jsp">下装</a></li>
									<li><a href="home.jsp">家居服</a></li>
									<li><a href="decorations.jsp">配饰</a></li>
									<li><a href="shoes.jsp">鞋</a></li>
									
								</ul>	
							</div>							
							</div>
					
						
						
			<li class="grid"><a href="about.html">关于</a></li>		
				</ul> 			 
			  <div class="clearfix"></div>			   	
	 </div>
		 <div class="caption">
		 <h1>FASHION AND CREATIVITY</h1>	 
		 <p>Sed dapibus est a lorem dictum, id dignissim lacus fermentum. Nulla ut nibh in libero maximus pretium
		 Nunc vulputate vel tellus ac elementum. Duis nec tincidunt dolor, ac dictum eros.</p>
	     </div>
</div>
<!--header//-->
<br>
<br>
<br>
<br>
<br>
        <h1><b>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;   &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;   &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  五个女大学生呕心沥血所成</b></h1>
  <br>
  <br>
  <br>
  <br>
    
                                                                       

<!--fotter-->
<div class="fotter-logo">
	 <div class="container">
	 <div class="ftr-logo"><h3><a href="FIVE.jsp">FIVE FLOWERS</a></h3></div>
	 <div class="ftr-info">
	 <p>FIVEFLOWERS版权所有；<a target="_blank" ></a></p>
	</div>	 <div class="clearfix"></div>
	 </div>
</div>

<!--fotter//-->

</body>
</html>