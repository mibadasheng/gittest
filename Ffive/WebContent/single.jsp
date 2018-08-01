<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.etc.dao.GoodsDAO"%>
<%@ page import="com.etc.vo.Goods"%>
<!DOCTYPE html>
<html>
<head>
<title>single</title>
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
			<li class="grid"><a href="about.jsp">关于</a></li>		
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
		  <li><a href="FIVE.jsp">首页</a></li>
		  <li><a href="dress.jsp">连衣裙</a></li>
		  <li class="active">商品详情页</li>
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
					
								$('#etalage').etalage({//放大镜插件
									thumb_image_width: 300,//缩略图的宽度
									thumb_image_height: 400,//缩略图的高度
									source_image_width: 700,//大图的宽度
									source_image_height: 800,//大图的高度
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
				<%
					GoodsDAO dao = new GoodsDAO();
					Goods item=dao.getItemsById(Integer.parseInt(request.getParameter("id")));
					if (item != null) {
				%>
						<!--//details-product-slider-->
					 <div class="details-left-slider">
						  <ul id="etalage">
							 <li>
								<a href="optionallink.html">
								<img class="etalage_thumb_image" src="<%=item.getPhoto()%>"/>
								<img class="etalage_source_image" src="<%=item.getPhoto()%>"/>
								</a>
							 </li>
							
							 <div class="clearfix"></div>
						 </ul>
					 </div>
					 <div class="details-left-info">
							<h3><%=item.getGname() %></h3>
								<h4>FIVE FLOWERS </h4>							
							<p>$ <%=item.getSellprice() %></p>
							<p class="qty">数量：</p><input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
							<div class="btn_form">
								<a href="cart.jsp">加入购物车</a>
							
								<a href="pay.jsp">立即支付</a>
							</div>
							<div class="flower-type">
							<p>尺码：： <select name="mobel" >
                            <option>S 165/84A</option>
                            <option>M 170/88A</option>
                            <option>L 175/96A</option>
                             </select>
                            <br/></p>
							<p>品牌::FIVE FLOWERS</a></p>
							</div>
							<h5>/ABOUT  /</h5>
							<p class="desc">原创设计，只做最好的。</p>
					 </div>
					 <div class="clearfix"></div>				 	
				 </div>
			 </div>
		 </div>	
		 <%
					}
				%>
				
		 <h3 align="center">/INFORMATION /</h3>
		 </br>
	<table border="2px" cellpadding="5px" cellspacing="5px" bgcolor="white" align="center" width="760px">
		<tr>     
      <th >尺码</th>
        <th >衣长</th>
          <th >胸围</th>
            <th >袖长</th>
              <th >肩宽</th>
                <th >腰围</th>
        </tr>
      
             <tr>     
      <td >S</td>
        <td >110</td>
          <td >86</td>
            <td >17.5</td>
              <td >37</td>
                <td >66</td>
          </tr>
                <tr>     
      <td >M</td>
        <td >112</td>
          <td >90</td>
            <td >18</td>
              <td >38</td>
                <td >70</td>
          </tr>
                  <tr>     
      <td >L</td>
        <td >114</td>
          <td >94</td>
            <td >18.5</td>
              <td >39</td>
              <td >74</td>
          </tr>
          </table>
          
          <table border="0px" cellpadding="0px" cellspacing="0px" bgcolor="white" align="center" width="560px" height="1000px" rules="none">
          <tr><td><img src="<%=item.getPhoto()%>" alt=" " height="1000px" weight="500px" align=" right" /></td></tr></table>
       
         
          </br>
          
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