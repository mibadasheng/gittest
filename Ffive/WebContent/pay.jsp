<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.etc.vo.Order" %>
     <%@ page import="com.etc.vo.User" %>
     <%@ page import="com.etc.vo.Goods" %>
       <%@ page import="com.etc.vo.Cart" %>
       <%@ page import="com.etc.dao.CartDao" %>
     <%@ page import="com.etc.dao.GoodsDAO" %>
     	 <%Order order= (Order)request.getAttribute("order"); %>
             <% List<Goods> list = (List<Goods>)request.getAttribute("list");%>
             <%CartDao cart=new CartDao(); %>
<!DOCTYPE html>
<html>
<head>
<title>Pay</title>
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
<!-- start menu -->
</head>
<body>

<!--header-->
<div class="header">
	 <div class="container">
	     <div class="main-header">
			  <div class="carting">
				 <ul><li><a href="login.html"> 登录</a></li></ul>
				 </div>
			 <div class="logo">
				 <h3><a href="index.html">FIVE FLOWERS</a></h3>
			  </div>			  
			 <div class="box_1">				 
				 <a href="cart.html"><h3>购物车: <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> )<img src="images/cart.png" alt=""/></h3></a>
				 <p><a href="javascript:;" class="simpleCart_empty"></a></p>
			 
			 </div>
			 
			 <div class="clearfix"></div>
		 </div>
				
				<!-- start header menu -->
		<ul class="megamenu skyblue">
			<li class="active grid"><a class="color1" href="index.html">首页</a></li>
			<li class="grid"><a href="#">女装</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>分类</h4>
								<ul>
									<li><a href="dress.html">连衣裙</a></li>					
									<li><a href="shirt.html">上装</a></li>
									<li><a href="pants.html">下装</a></li>
									<li><a href="homes.html">家居服</a></li>
									<li><a href="decorations.html">配饰</a></li>
									<li><a href="shoots.html">鞋</a></li>
									
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
<!--Single Page starts Here-->
<div class="product-main">
	 <div class="container">
		 <ol class="breadcrumb">
		  <li><a href="index.html">首页</a></li>
		  <li class="active">女装</li>
		 </ol>
		 <div class="ctnt-bar cntnt">
			 <div class="content-bar">
				 <div class="single-page">					 
					 <!--Include the Etalage files-->
						<link rel="stylesheet" href="css/etalage.css">
						<script src="js/jquery.etalage.min.js"></script>
					 <!-- Include the Etalage files -->
					 <script>
							jQuery(document).ready(function($){
					
								$('#etalage').etalage({
									thumb_image_width: 300,
									thumb_image_height: 400,
									source_image_width: 700,
									source_image_height: 800,
									show_hint: true,
									click_callback: function(image_anchor, instance_id){
										alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
									}
								});
								// This is for the dropdown list example:
								$('.dropdownlist').change(function(){
									etalage_show( $(this).find('option:selected').attr('class') );
								});
					
							});
						</script>
						<!--//details-product-slider-->
				
					 <div class="details-left-info">
					 <h3>订单详情</h3>
					
					<%   if(list!=null&&list.size()>0) {
            	  // System.out.println("size:"+list.size());
	               for(int i=0;i<list.size();i++)
	               {
	                  Goods item = list.get(i); %>
	                  
	  <table border="2px" cellpadding="20" cellspacing="20" width="50" height="70" rules="all">
	                  <tr>
	                  <img src="<%=item.getPhoto() %>" width="60px" height="80px">
	                  </tr>
	                  <tr>
	                  <%=item.getGname() %>
	                  </tr>
	                  <tr>
	                  <%=item.getSellprice()%>
	                  </tr>
	                  </table>
	                  
            <% }
	               }%>
							<h3>确认订单</h3>
					 	买家姓名：<input type="text" name="…" value="<%=order.getUsername()%> "></br></br> 
					 	
					 	买家电话：<input type="text" name="…" value="<%=order.getUser().getPhone()%>"></br></br> 
					
								收货地址：<input type="text" name="…" value=" "></br></br>
								商品总价	：<%=request.getAttribute("sum")%>元</br></br>
							
								 		
				    <form>
							选择支付方式：<input type="radio" name="paystyle" value="支付宝" checked="checked"/>支付宝
                                         <input type="radio" name="paystyle" value="微信" />微信
                                         <input type="radio" name="paystyle" value="银行卡" />银行卡
                                         
                    </form>                  


                            </br>
							</br>
							   <button type="button" value="确定购买 " onclick="alert('你已经成功购买了该产品')">立即购买</button> 
							
					 <div class="clearfix"></div>				 	
				 </div>
			 </div>
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