<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/register" method="POST" commandName="user">
		<c:if test="${!empty user.username}">
				<div class="form-group">
					<form:label path="userid">
							<spring:message text="Id" />
						</form:label>
					<form:input path="userid" readonly="true" size="8"
							disabled="true" /> <form:hidden path="userid" />
				</div>
				</c:if>
				
				<div class="form-group">
					<form:label path="username">Username</form:label>
					<form:input path="username" class="form-control"/>
				</div>
		
				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:password path="password" class="form-control"/>
				</div>
				
				<div class="form-group">
		 			<input type="submit" name="submit" value="Register" class="btn btn-primary btn-md center-block">
		 </div>
	</form:form>
	<a href="${pageContext.request.contextPath}/logout" class="btn btn-primary btn-md center-block">Logout </a>
	<script src="${pageContext.request.contextPath}/webjars/jquery/2.2.4/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>