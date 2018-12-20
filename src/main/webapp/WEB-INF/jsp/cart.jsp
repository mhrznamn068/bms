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
    <title>Login | E-Shopper</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/price-range.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/responsive.css" rel="stylesheet">

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
	
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
				  <li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<c:forEach  items="${baglist}"  var="bag">
					<tbody>
						<tr>
							<td class="cart_product">
								<a href=""><img src="${pageContext.request.contextPath}/resources/bagimages/${bag.image}" alt=""></a>
							</td>
							<td class="cart_description">
								<h4>${bag.bname}</h4>
								
							</td>
							<td class="cart_price">
								<p id="bagprice">${bag.bprice}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity"  autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price" ></p>
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
							</td>
						</tr>

						</tbody>
						</c:forEach>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>What would you like to do next?</h3>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Sub Total <span id="subtotal"></span></li>
							<li>Eco Tax <span id="eco">2</span></li>
							<li>Shipping Cost <span>Free</span></li>
							<li>Total <span id="gtotal"></span></li>
						</ul>
						
							<button class="btn btn-default update"  onclick="calculateTotal()">Update</button>
							
							<a class="btn btn-default check_out" href="${pageContext.request.contextPath}/billing">Check Out</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->

	<footer id="footer"><!--Footer-->
		
		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Online Help</a></li>
								<li><a href="">Contact Us</a></li>
								<li><a href="">Order Status</a></li>
								<li><a href="">Change Location</a></li>
								<li><a href="">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">T-Shirt</a></li>
								<li><a href="">Mens</a></li>
								<li><a href="">Womens</a></li>
								<li><a href="">Gift Cards</a></li>
								<li><a href="">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Terms of Use</a></li>
								<li><a href="">Privecy Policy</a></li>
								<li><a href="">Refund Policy</a></li>
								<li><a href="">Billing System</a></li>
								<li><a href="">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Company Information</a></li>
								<li><a href="">Careers</a></li>
								<li><a href="">Store Location</a></li>
								<li><a href="">Affillate Program</a></li>
								<li><a href="">Copyright</a></li>
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
	<script>
	function calculateTotal(){
		var price=new Array();
		
		 
	 <c:forEach items="${baglist}"  var="bag" varStatus="status">
         price.push("${bag.bprice}");   
     </c:forEach>
     var quantity = document.getElementsByName("quantity");
     var vals=[];
     for (var i=0, n=quantity.length;i<n;i++) {
       vals.push(quantity[i].value);
     }
  	var subtotal=0;

	var x=document.getElementsByClassName("cart_total_price");
	var total=new Array();
	for(i=0;i<price.length;i++){
		total[i]=price[i]*vals[i];
		x[i].innerHTML=total[i];
		subtotal=subtotal+total[i];
	}
	var eco=document.getElementById("eco").innerHTML;
	var gtotal=subtotal+parseInt(eco); 
	
	document.getElementById("subtotal").innerHTML=subtotal;
	
	document.getElementById("gtotal").innerHTML=gtotal;
	 
	/* document.write(total);
	var quantity=new Array();
	quantity=document.getElementById("quantity").value;
	
	var total=new Array();
	for(i=0;i<length;i++){
	total[i]=price[i]*quantity[i];
	document.getElementById("total").innerHTML=total;
	}
	 */}
	  
	</script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>