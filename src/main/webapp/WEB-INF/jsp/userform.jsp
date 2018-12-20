<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title> User Form </title>
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
          	<li><a href="${pageContext.request.contextPath}/admin/userform">User Form</a> </li>
          	<li><a href="${pageContext.request.contextPath}/admin/userlist">User List</a> </li>
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
	<form:form action="${pageContext.request.contextPath}/admin/adduser" method="post" commandName="user">
		
		 <c:if test="${!empty user.username}">
				<div class="form-group">
					<form:label path="userid">
							<spring:message text="ID" />
						</form:label>
					<form:input path="userid" readonly="true" size="8"
							disabled="true" /> <form:hidden path="userid" />
				</div>
			</c:if> 
			
		
		<div class="form-group">
			<form:label path="firstname">Firstname</form:label>
			 <form:input  class="form-control"  path="firstname"/>
		</div>
		
		<div class="form-group">
			<form:label path="lastname">Lastname</form:label>
			 <form:input  class="form-control"  path="lastname"/>
		</div>
		
		<div class="form-group">
			<form:label path="dob">DOB</form:label>
			 <input name="dob" type="date" class="form-control" />
		</div>
		
		<div class="form-group">
			<form:label path="gender">Gender</form:label>
			<form:select path="gender">
				<option value="male">Male</option>
				<option value="female">Female</option> 
			</form:select>
		</div>
		
		<div class="form-group">
			<form:label path="email">Email</form:label>
			 <form:input  class="form-control"  path="email"/>
		</div>
		
		<div class="form-group">
			<form:label path="username">Username</form:label>
			 <form:input  class="form-control"  path="username"/>
		</div>
		
		<div class="form-group">
			<form:label path="password">Password</form:label>
			 <form:password  class="form-control"  path="password"/>
		</div>
		
		<div class="form-group">
			<form:label path="cpassword">Confirm Password</form:label>
			 <form:password  class="form-control"  path="cpassword"/>
		</div>
		
		<div class="form-group">
			<form:label path="role">ROLE</form:label>
			<form:select path="role">
				<option value="ROLE_ADMIN">ADMIN</option>
				<option value="ROLE_MODERATOR">MODERATOR</option>
				<option value="ROLE_USER">USER</option> 
			</form:select>
		</div>
		
		<div class="form-group">
			<form:label path="status">Status</form:label>
			<form:select path="status">
				<option value="0">INACTIVE</option>
				<option value="1">ACTIVE</option> 
			</form:select>
		</div>

			
		 <div class="form-group">
		 <input type="submit" name="submit" value="Submit" class="btn btn-primary btn-md center-block
		 ">
		 </div>
		 
	</form:form>
</div></div></div></div>	</div>
		<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/webjars/jquery/2.2.4/jquery.min.js"></script>
		
</body>