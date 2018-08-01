<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page import="com.etc.vo.Goods"%>
<%@ page import="com.etc.dao.GoodsDAO"%>
 
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
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
				 </div>
			 <div class="logo">
				 <h3><a href="FIVE.jsp">FIVE FLOWERS</a></h3>
			  </div>			  
			 <div class="box_1">				 
				 <a href="cart.do?username=<%= (String)session.getAttribute("username") %>"><h3>购物车: <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> )<img src="images/cart.png" alt=""/></h3></a>
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
									<li><a href="decorations.jsp">内衣</a></li>
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
<!--header-->
<div class="categoires">
	 <div class="container">
		 <a href="#"><div class="col-md-4 sections fashion-grid-a">
			 <h4>Fashion</h4>
			 <p>dignissim</p>			 					
		 </div></a>
		 <a href="#"><div class="col-md-4 sections fashion-grid-b">
			 <h4>Beauty</h4>
			 <p>fermentum</p>			 					
		 </div></a>
		 <a href="#"><div class="col-md-4 sections fashion-grid-c">
			 <h4>Creativity</h4>
			 <p>vulputate</p>				
		 </div></a>
	 </div>
</div>
<!---->

			 
<div class="product-model">	 
	 <div class="container">			
		 <div class="col-md-11 product-model-sec"  align="left">
			           <% 
                      /*  首页的货品Typeid=0 */
             ArrayList<Goods> list = (ArrayList<Goods>)request.getAttribute("list");
               
               if(list!=null&&list.size()>0)
               {
            	   //System.out.println("size:"+list.size());
	               for(int i=0;i<list.size();i++)
	               {  
	                  Goods item = list.get(i);
	                  if((item.getTypeid()).equals("0")){
	                	
	                	  
	                  
           %>   			   				  
				 <a href="single.jsp"><div class="product-grid">					  
						<div class="more-product-info"></div>			
						<div class="product-img b-link-stripe b-animate-go  thickbox">						   
							<img src="<%=item.getPhoto() %>" class="img-responsive" alt=""/>
							<div class="b-wrapper">
							<h4 class="b-animate b-from-left  b-delay03">							
							<button class="btns"><a href="single.jsp?id=<%=item.getGoodid() %>">ORDER NOW</button>
							</h4>
							</div>
						</div></a>						
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust">
								<h4><%=item.getGname() %></h4>
								<span class="item_price">$<%=item.getSellprice() %></span>
								<input type="text" class="item_quantity" value="1" />
							<!--  	<input type="button" class="item_add" value="加入购物车">-->
								<button class="item_add_items"><a href="add.do?username=<%= (String)session.getAttribute("username")%>&goodid=<%=item.getGoodid()%>">加入购物车</a></button> 
							</div>													
							<div class="clearfix"> </div>
						</div>
						</div>
									<%
                   }
	               }
              } 
          %>
					</div>			
				
					 </div>
					
			<!-- tabs-box -->
			<!-- Comman-js-files -->
			<script>
			$(document).ready(function() {
				$("#tab2").hide();
				$("#tab3").hide();
				$(".tabs-menu a").click(function(event){
					event.preventDefault();
					var tab=$(this).attr("href");
					$(".tab-grid1,.tab-grid2,.tab-grid3").not(tab).css("display","none");
					$(tab).fadeIn("slow");
				});
				$("ul.tabs-menu li a").click(function(){
					$(this).parent().addClass("active a");
					$(this).parent().siblings().removeClass("active a");
				});
			});
			</script>
			<!-- Comman-js-files -->
	 </div>
</div>
<!--fotter-->
<div class="fotter">
	 <div class="container">
	 <div class="col-md-6 contact">
		  <form>
			 
		 </form>

	 </div>
	 <div class="col-md-6 ftr-left">
		 <div class="ftr-list">
			 <ul>
				 <li><a href="#">首页</a></li>
				 <li><a href="about.jsp">关于</a></li>
				
				 
			 </ul>
		 </div>
		 
		 
	 </div>	 
	 <div class="clearfix"></div>
	 </div>
</div>
<!--fotter//-->
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