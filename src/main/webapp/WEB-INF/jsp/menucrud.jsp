<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title> Menu Form </title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/dashboard.css" rel="stylesheet">
	
<script src="${pageContext.request.contextPath}/webjars/jquery/2.2.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- <script src="//cloud.tinymce.com/stable/tinymce.min.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/tinymce/tinymce.min.js"></script>
        <script>
            $(document).ready(function() {
                tinymce.init({
                    selector: "textarea",
                    theme: "modern",
                    paste_data_images: true,
                    plugins: [
                        "advlist autolink lists link image charmap print preview hr anchor pagebreak",
                        "searchreplace wordcount visualblocks visualchars code fullscreen",
                        "insertdatetime media nonbreaking save table contextmenu directionality",
                        "emoticons template paste textcolor colorpicker textpattern"
                    ],
                    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
                    toolbar2: "print preview media | forecolor backcolor emoticons",
                    image_advtab: true,
                    file_picker_callback: function(callback, value, meta) {
                        if (meta.filetype == 'image') {
                            $('#upload').trigger('click');
                            $('#upload').on('change', function(event) {
                              var formData = new FormData();
                                formData.append('rr', $('#upload')[0].files[0]);
                                console.log("form data " + formData);

                            $.ajax({
                                url: "${pageContext.request.contextPath}/admin/tinyUpload?${_csrf.parameterName}=${_csrf.token}", //controller path
                                data: formData, //value from form
                                type: "POST", //method type
                                   processData: false,
                                    contentType: false,
                                success: function(response) {   //function called if success
                                    var path=response;
//                                         var file = this.files[0];
//                                        var reader = new FileReader();
//                                        reader.onload = function(e) {

                                            callback(path, {
                                                alt: ''
                                            });
                                       // };
                                       // reader.readAsDataURL(file);

                                },
                                error: function(e) {            //error message
                                    alert('Error: ' + e);
                                }
                            });
                            return false;
                        });                         
                            
//                            
                        }
                    },
                    templates: [{
                            title: 'Test template 1',
                            content: 'Test 1'
                        }, {
                            title: 'Test template 2',
                            content: 'Test 2'
                        }]
                });
            });
        </script>
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

	<div class="container-fluid">
	<form:form action="${pageContext.request.contextPath}/admin/addmenu?${_csrf.parameterName}=${_csrf.token}" commandName="menu" method="post">
		
		<c:if test="${!empty menu.mname}">
				<div class="form-group">
					<form:label path="mid">
							<spring:message text="ID" />
						</form:label>
					<form:input path="mid" readonly="true" size="8"
							disabled="true" /> <form:hidden path="mid" />
				</div>
			</c:if>

		<div class="form-group">
			<form:label path="mname">Name</form:label>
			 <form:input  class="form-control"  path="mname" id="mname"/>
		</div>
			<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		<div class="form-group">
			<!-- <textarea id="description" name="description" style="width: 650px; height: 400px"></textarea> -->
			<textarea name="description" id="" style="width: 650px; height: 400px"></textarea>
      		<input name="image" type="file" style="display:none" id="upload" class="hidden" onchange="">
		</div>
			
		 <div class="form-group">
		 	<input type="submit" name="submit" value="Submit" class="btn btn-primary btn-md center-block">
		 </div>
	</form:form>
</div></div></div></div>	</div>

	
	
</body>