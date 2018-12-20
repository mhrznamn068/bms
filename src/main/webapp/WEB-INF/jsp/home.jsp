<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | E-Shopper</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/price-range.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/responsive.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/searchitems.css" rel="stylesheet">
    </head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="shop-menu pull-right" style="background-color:inherit;" >
							<ul class="nav navbar-nav">
								<li><a href="${pageContext.request.contextPath}/account"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="${pageContext.request.contextPath}/billing"><i class="fa fa-crosshairs"></i> Checkout</a></li>
								<li><a href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								<c:choose>
								<c:when test="${empty user}">
								<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i> Login</a></li>
								</c:when>
								<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-lock"></i> Logout</a></li>
								</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
			<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li> <a href="${pageContext.request.contextPath}/home">Home</a> </li>
                  				<li> <a href="${pageContext.request.contextPath}/aboutus">About Us</a> </li>
                  				<li> <a href="${pageContext.request.contextPath}/services">Services</a> </li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
					<div id="feedback"></div>
						<div class="search_box pull-right">
							
							<input type="text" id="searchbags"  placeholder="Search"/>
							
							<%-- <button type="submit" id="bth-search"
						class="btn btn-primary btn-sm">Search</button>
							</form> --%>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<c:forEach items="${imagelist}"  var="photo" varStatus="status">
                                <li data-target="#slider-carousel" data-slide-to="${status.index}" <c:if test='${status.index == 0}'>class="active"</c:if>></li>
                                </c:forEach>
                           </ol>
						
						<div class="carousel-inner">
						<c:forEach items="${imagelist}"  var="photo" varStatus="status">
							<div class="item <c:if test='${status.first}'>active</c:if>">
								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>Buy Bags Online</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									
								</div>
								<div class="col-sm-6">
									<img src="${pageContext.request.contextPath}/resources/carousel/${photo.image}" class="girl img-responsive" alt="" />
								
								</div>
							</div>
							</c:forEach>
								
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
	<section>
		<div class="container">
			<div class="row">
				
					<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<c:forEach items="${categorylist}"  var="cat">
                   						<h4 class="panel-title"> <a href="${pageContext.request.contextPath}/category/${cat.catid}" class="list-group-item">${cat.catname}</a> </h4>
                  						
                  					</c:forEach> 
                  				</div>
                  			</div>
                 
						</div><!--/category-products-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>Brands</h2>
							<div class="brands-name">
								<c:forEach items="${brandlist}"  var="brand">
                   						<h4 class="panel-title"> <a href="${pageContext.request.contextPath}/brand/${brand.brandid}" class="list-group-item">${brand.brandname}</a> </h4>
                  						
                  					</c:forEach> 
							</div>
						</div><!--/brands_products-->
						
						<div class="price-range"><!--price-range-->
							<h2>Price Range</h2>
							<div class="well text-center">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div><!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
					
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="searchitems">
						<h2 class="title text-center">Search Items</h2>
						<div class="listofbags">
						
						</div>
					</div>
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						<c:forEach items="${baglist}" var="bag">
						<div class="col-sm-4">
						
							<div class="product-image-wrapper">
								<div class="single-products">
								<div class="productinfo text-center">
											<a href="${pageContext.request.contextPath}/product/${bag.bid}">
											<img src="${pageContext.request.contextPath}/resources/bagimages/${bag.image}" alt="" />
											</a>
											<h2>$ ${bag.bprice}</h2>
											
											<p>${bag.bname}</p>
											<a href="${pageContext.request.contextPath}/addtocart/${bag.bid}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
										
								</div>
								
							</div>
						
						</div>
						</c:forEach>	
					</div><!--features_items-->
					
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Recommended Items</h2>
						<c:forEach items="${popularitems}" var="bag">
						<div class="col-sm-4">
						
							<div class="product-image-wrapper">
								<div class="single-products">
								<div class="productinfo text-center">
											<a href="${pageContext.request.contextPath}/product/${bag.bid}">
											<img src="${pageContext.request.contextPath}/resources/bagimages/${bag.image}" alt="" />
											</a>
											<h2>$ ${bag.bprice}</h2>
											
											<p>${bag.bname}</p>
											<p>${bag.bview}</p>
											<a href="${pageContext.request.contextPath}/addtocart/${bag.bid}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
										</div>
										
								</div>
								
							</div>
						
						</div>
						</c:forEach>	
					</div><!--features_items-->

					
				</div>
			</div>
		</div>
	</section>
	
	<footer id="footer"><!--Footer-->

		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Online Help</a></li>
								<li><a href="#">Contact Us</a></li>
								<li><a href="#">Order Status</a></li>
								<li><a href="#">Change Location</a></li>
								<li><a href="#">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">T-Shirt</a></li>
								<li><a href="#">Mens</a></li>
								<li><a href="#">Womens</a></li>
								<li><a href="#">Gift Cards</a></li>
								<li><a href="#">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Terms of Use</a></li>
								<li><a href="#">Privecy Policy</a></li>
								<li><a href="#">Refund Policy</a></li>
								<li><a href="#">Billing System</a></li>
								<li><a href="#">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="#">Company Information</a></li>
								<li><a href="#">Careers</a></li>
								<li><a href="#">Store Location</a></li>
								<li><a href="#">Affillate Program</a></li>
								<li><a href="#">Copyright</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i></button>
								<p>Get the most recent updates from <br />our site and be updated your self...</p>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
	
	
  
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.2.4/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"> </script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	console.log("ready");
	
	$('.searchitems').hide();
	
    
	$( "#searchbags" ).keyup(function() {
    	
		var search=$('#searchbags').val();
		console.log(search);
       	if (search==''){
       		console.log("search is empty");
       		$('.features_items').show();
       	 	$('.searchitems').hide();
       	}
       	else{
        $.ajax({
            url: "${pageContext.request.contextPath}/getSearch",
            type: "GET",
            data: {searchName:search},
            dataType: 'json',
            
            success: function(data){
            	//alert(data);
            	console.log(data);
            	$('.features_items').hide();
            	 $('.searchitems').show();
            	 $('.listofbags').empty(); 
            	 for(i=0;i<data.length;i++){
                	 $('.searchitems .listofbags').append('<p>"'+data[i].bname+'"</p>');
                	 $('.searchitems .listofbags').append("<a href='${pageContext.request.contextPath}/product/"+data[i].bid+"'><img src='${pageContext.request.contextPath}/resources/bagimages/"+ data[i].image +"'/></a>");
                	 
                 }
               
            },
            error: function(e){
                alert(e);
                console.log(e);
                }
        });
       	}
        console.log(search);
    });
	
});
</script>

</body>
</html>