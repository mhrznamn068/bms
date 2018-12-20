<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bag List</title>
<style>
	table thead th{
		width:50px;
	}
</style>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/dashboard.css" rel="stylesheet">
<link href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
		
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
	<div class="container-fluid">
	<h3 align="center">Bag List</h3>
	<table id="bagtable" class="table" >
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Image</th>
				<th>Category</th>
				<th>Brand</th>
				<th>Description</th>
				<th>View</th>
				<th>Featured</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
			
		<tbody>
			<c:forEach items="${baglist}"  var="bag">
			<tr>			
				<td width="10%"> ${bag.bid} </td>
				<td> ${bag.bname}</td>
				<td> ${bag.bprice}</td>
				<td> <img src="${pageContext.request.contextPath}/resources/bagimages/${bag.image}" height="50px" width="80px" class="imgstatus"></td>
				<td>${bag.category.catname}</td>
				<td>${bag.brand.brandname}</td>
				<td> ${bag.bdescription}</td>
				<td> ${bag.bview}</td>
				<td> ${bag.bfeatured}</td>
				
				<td><a href="${pageContext.request.contextPath}/moderator/editbag/${bag.bid}" class="btn btn-info" >Edit</a></td>
				<td><a href="${pageContext.request.contextPath}/moderator/deletebag/${bag.bid}" class="btn btn-danger" >Delete</a> </td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>
</div></div></div></div>		

		</body>
		
		<script src="${pageContext.request.contextPath}/webjars/jquery/2.2.4/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
		<script>
			$(document).ready(function(){
				$('#bagtable').dataTable();
				console.log("datatable");
			});
		</script>
</html>