<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag Form</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/dashboard.css" rel="stylesheet">
</head>
<body>

	
	<nav class="navbar navbar-inverse">
 	
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/admin">Design</a>
    </div>
    <ul class="nav navbar-nav">
  
      <li class="col-lg-push-12"><form class="form-inline">
    		<input type="email" class="form-control" size="20" placeholder="Search">
    		<button type="button" class="btn btn-primary">Search</button>
  		</form> </li>
      
    </ul>
    
    <ul class="nav navbar-nav pull-right">
    <li><a href="${pageContext.request.contextPath}/logout">Logout </a></li>
    </ul>
  
</nav>

<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 col-lg-2 sidebar navbar-inverse con">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
			<li><a href="${pageContext.request.contextPath}/admin/photolist">Image List</a></li>
      		<li><a href="${pageContext.request.contextPath}/admin/imageform">Image Form</a></li>
      		<li><a href="${pageContext.request.contextPath}/admin/menuform">Menu Form</a></li>
      		<li><a href="${pageContext.request.contextPath}/admin/menulist">Menu List</a> </li>
      		<li><a href="${pageContext.request.contextPath}/admin/category">Category Form</a> </li>
      		<li><a href="${pageContext.request.contextPath}/admin/catlist">Category List</a> </li>
      		<li><a href="${pageContext.request.contextPath}/moderator/bagform">Bag Form</a> </li>
      		<li><a href="${pageContext.request.contextPath}/moderator/baglist">Bag List</a> </li>
      		<li><a href="${pageContext.request.contextPath}/moderator/state">State Form</a> </li>
      		<li><a href="${pageContext.request.contextPath}/moderator/statelist">State List</a> </li>
      		<li><a href="${pageContext.request.contextPath}/moderator/country">Country Form</a> </li>
      		<li><a href="${pageContext.request.contextPath}/moderator/countrylist">Country List</a> </li>
          </ul>
		
		</div>
	
	<div class="lg-9 col-sm-9 main">
	<div class="row placeholders">
	<form:form action="${pageContext.request.contextPath}/moderator/addbag?${_csrf.parameterName}=${_csrf.token}" method="POST" commandName="bag" enctype="multipart/form-data">
		<c:if test="${!empty bag.bname}">
		<div class="form-group">
		<form:label path="bid"> <spring:message text="ID" /> </form:label>
		<form:input path="bid" readonly="true" size="8" disabled="true"/> <form:hidden path="bid" />
		</div>
		</c:if>
		<div class="form-group">
		<form:label path="bname">Name</form:label>
		<form:input path="bname"  class="form-control"/>
		</div>
		
		<div class="form-group">
		<form:label path="bprice">Price</form:label>
		<form:input path="bprice" class="form-control"/>
		</div>
		
		<div class="form-group">
		<label>Image</label>
		<input type="file" name="file"/>
		</div> 
		
		<div class="form-group">
			<form:label path="category">Category</form:label>
			<select name="catid"> 
			<c:forEach items="${categorylist}" var="cat">
				<option value="${cat.catid}">${cat.catname}</option>
			</c:forEach>
			</select>
		</div>
		
		<div class="form-group">
			<form:label path="category">Brand</form:label>
			<select name="brandid"> 
			<c:forEach items="${brandlist}" var="brand">
				<option value="${brand.brandid}">${brand.brandname}</option>
			</c:forEach>
			</select>
		</div>
		
		<div class="form-group">
		<form:label path="bdescription">Description</form:label>
		<textarea id="bdescription" name="bdescription" class="form-control" style="width: 650px; height: 200px"></textarea>
		</div>
		
		<div class="form-group">
		<form:label path="bview">View</form:label>
		<form:input path="bview"  class="form-control"/>
      	</div>
      	
      	<div class="form-group">
      	<form:label path="bfeatured">Featured</form:label>
      	<label class="radio-inline">
      		<input name="bfeatured" type="radio" value="1">True</label>
  		<label class="radio-inline">
      		<input name="bfeatured" type="radio" value="0">False</label>
      	</div>
      	
      	<div class="form-group">
		 <input type="submit" name="submit" value="Submit" class="btn btn-primary btn-md center-block
		 ">
		 </div>
		 
	</form:form>

</div></div></div></div>
	<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/webjars/jquery/2.2.4/jquery.min.js"></script>
</body>
</html>