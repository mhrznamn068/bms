<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title> Pay Bill</title>
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
    	<link href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css" rel="stylesheet">
    	<link href="${pageContext.request.contextPath}/resources/css/price-range.css" rel="stylesheet">
    	<link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/responsive.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/pay.css" rel="stylesheet">
	</head>
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
								<li><a href="#"><i class="fa fa-user"></i> Account</a></li>
								<li><a href="${pageContext.request.contextPath}/billing"><i class="fa fa-crosshairs"></i> Checkout</a></li>
								<li><a href="${pageContext.request.contextPath}/cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>
								<li><a href="${pageContext.request.contextPath}/login"><i class="fa fa-lock"></i> Login</a></li>
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
								 <c:forEach items="${menulist}"  var="menu">
                    				<li>
                        				<a href="#">${menu.mname}</a>
                    				</li>
                  				</c:forEach>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
		
	<div class="container-fluid">
			<div class="message">
				<h3>${msg}</h3>
			</div>
			<div class="next">
				<button type="button" class="btn-warning">Next</button>
			</div>
	</div>
	</body>
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.scrollUp.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/price-range.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</html>