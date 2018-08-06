<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.etc.vo.Cart"%>
<!DOCTYPE html>

<html>
<head>
<title>cart</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link
	href='http://fonts.googleapis.com/css?family=Raleway:400,200,600,800,700,500,300,100,900'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Arimo:400,700,700italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/component.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="New Fashions Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script src="js/jquery.min.js"></script>
<script src="js/simpleCart.min.js">
	
</script>
<script src="Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	/* function shows() {
		obj = document.getElementsByName("cart");
		check_val = [];
		for (k in obj) {
			if (obj[k].checked)
				check_val.push(obj[k].value);
		}
		alert("你选中了id为" + check_val + "的商品");
		 $.ajax(
                 {data:{"check_val":check_val},
                   type:"post",
                   url:"order.do",
                   success: function(data){
                     //alert(data);
                   },
                   
                 }
             );
	} */
	function deleteCart(username,goodid){
		
		alert("确定删除商品id为"+goodid+"的商品");
		//window.location.href="delete.do?username=123&goodid=222";
		window.location.href="delete.do?username="+username+"&goodid="+goodid;
	}
</script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<!-- start menu -->
</head>
<body>
	<%
		ArrayList<Cart> list = (ArrayList<Cart>) request.getAttribute("list");
	%>
	<!--header-->
	<div class="header">
		<div class="container">
			<div class="main-header">
				<div class="carting">
					<ul>
						<li><a href="login.jsp"> 登录</a></li>
					 <li><a href=" logoff.do"> 登出</a></li>
				 <li><a href="userdel.do?<%=(String)session.getAttribute("username")%>"> 注销</a></li>
					</ul>
				</div>
				<div class="logo">
					<h3>
						<a href="index.html">FIVE FLOWERS</a>
					</h3>
				</div>
				<div class="box_1">
					<a href="cart.html"><h3>
							购物车: <img src="images/cart.png" alt="" />
						</h3></a>
					<p>
						<a href="javascript:;" class="simpleCart_empty"></a>
					</p>

				</div>

				<div class="clearfix"></div>
			</div>

			<!-- start header menu -->
			<ul class="megamenu skyblue">
				<li class="active grid"><a class="color1" href="FIVE.do">首页</a></li>
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
										<li><a href="decorations.jsp">内衣</a></li>
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
			<p>Sed dapibus est a lorem dictum, id dignissim lacus fermentum.
				Nulla ut nibh in libero maximus pretium Nunc vulputate vel tellus ac
				elementum. Duis nec tincidunt dolor, ac dictum eros.</p>
		</div>
	</div>
	<!--header//-->
	<div class="cart">
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="index.html">首页</a></li>
				<li class="actisessionve">购物车</li>
			</ol>
			<div class="cart-top">
				<a href="dress.html"> 返回</a>
			</div>

			<div class="col-md-9 cart-items">
				<h2>我的购物车</h2>
<form id="cartForm">

				<%  float sum = 0;
					for (Cart u : list) {
						
						//System.out.println(u.getGoods().getSellprice());
						//System.out.println(u.getNum());
						//sum += (u.getGoods().getSellprice() * u.getNum());

						//System.out.println(sum);
						//System.out.println("商品ID："+u.getGoods().getGoodid());
						
				%>

				<!--  
			 <script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
			   -->


				<div class="cart-header">
					<div class=" ">
							
							<div class="" align="right">
								<input type="button" value="删除按钮" name="btnSubmit" onclick="deleteCart('<%=(String) session.getAttribute("username")%>','<%=u.getGoods().getGoodid()%>')">
							</div>
					</div>
					<div class="cart-sec">
						
						<div class="" align="right">
							<input type="checkbox" name="cart"
								value="<%=u.getGoods().getGoodid()%>" />
						</div>
						
						<div class="cart-item cyc">
							<img src="<%=u.getGoods().getPhoto()%>" />
						</div>
						<div class="cart-item-info">
							<%
								
							%>
							<h3><%=u.getGoods().getGname()%><span>商品号: 3578</span>
							</h3>
							<h4>
								<span>单价. $ <%=u.getGoods().getSellprice()%></span>
							</h4>
							<p class="qty">
								数量 ::<%=u.getNum()%></p>
								 
 									

							<!-- 	 <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small"> -->
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<%
					}
				%>
</form>

				<script>
					$(document).ready(function(c) {
						$('.close2').on('click', function(c) {
							$('.cart-header2').fadeOut('slow', function(c) {
								$('.cart-header2').remove();
							});
						});
					});
				</script>
				


			
			</div>

			<div class="col-md-3 cart-total">
				<a class="continue" href="FIVE.do">继续添加</a>
				
				
				<div class="clearfix"></div>
				<!--  <form action="cart.do?action=tijiao method="post">-->
							
				<button  type="submit" form="cartForm" formaction="order.do" formmethod="post" style="background-color:#FF8C00;width:180px;height:40px;margin-left:30px" >立即购买</button>
							
						<!--  </form>-->
			 	 
				<!--<a class="order" href="order.do?username=<%=(String) session.getAttribute("username")%>&allprice=700">提交</a>-->

				<div class="total-item">
					
					<p>
						<a href="#">登录</a> to use accounts - linked coupons
					</p>
				</div>
			</div>
		</div>
	</div>
	<!--fotter-->
	<div class="fotter-logo">
		<div class="container">
			<div class="ftr-logo">
				<h3>
					<a href="index.html">FIVE FLOWERS</a>
				</h3>
			</div>
			<div class="ftr-info">
				<p>
					Copyright &copy; 2015.Company name All rights reserved.<a
						target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--fotter//-->

</body>
</html>

