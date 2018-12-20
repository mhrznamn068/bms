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
		
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<h4>${error}</h4>
							<form:form action="${pageContext.request.contextPath}/j_spring_security_check" method="POST" modelAttribute="user">
							<input name="j_username" type="text" placeholder="Username" />
							<input name="j_password" type="password" placeholder="Password" />
							<input name="remember_me_param" type="checkbox" style="width:15px; display:inline;"> Remember Me 
							<input type="submit" name="submit" value="Login" class="btn btn-default">
						</form:form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
					 <form:errors path="users.firstname"/> 
						<form:form action="${pageContext.request.contextPath}/register" method="POST">
							<input name="firstname" type="text" placeholder="First Name"/>
							<%-- <form:errors path="users.firstname"/> --%>
							<input name="lastname" type="text" placeholder="Last Name"/>
							<form:errors path="lastname" cssClass="error" />
							<input name="username" type="text" placeholder="User Name"/>
							<form:errors path="username" cssClass="error" />
							<input name="dob" type="date" />
							<form:errors path="dob" cssClass="error" />
							<input name="email" type="email" placeholder="Email Address"/>
							<form:errors path="email" cssClass="error" />
							<input name="password" type="password" placeholder="Password"/>
							<form:errors path="password" cssClass="error" />
							<input name="cpassword" type="password" placeholder="Confirm Password"/>
							<form:errors path="cpassword" cssClass="error" />
							<label>Gender:</label>
							<select name="gender" style="width:80%; margin-bottom:10px;">
							<option value="male">Male</option>
							<option value="female">Female</option> 
							</select>
							<input type="submit" name="Register" class="btn btn-default">
						</form:form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
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
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.scrollUp.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>