<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>add Category</title>
			<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<link rel="stylesheet" type="text/css" href="/css/style.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container-fluid">
			<div>
				
				<a href="/">Main Page</a>
			</div>
			<div class="category-form">
				<h1>Add a Category</h1>
				<form:form method="POST" action="/newCategory" modelAttribute="category">
		    		<p class ="form-group">
				        <form:label path="name">Name</form:label>
				        <form:errors path="name"/>
				        <form:input  class = "form-control" path="name"/>
			   		</p>
			    	<input type="submit" value="Add Category"/> 
				</form:form>
			</div>
		</div>
	</body>
</html>