	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search List</title>
<style>
	table thead th{
		width:50px;
	}
</style>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/dashboard.css" rel="stylesheet">


</head>
<body>
	<table>
	<c:forEach items="${baglist}"  var="bag">
		<tbody>
			<tr>			
				<td> ${bag.bid} </td>
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
			</tbody>
			</c:forEach>
		</table>
	</body>
</html>