<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>add product</title>
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
				<a href=""></a>
				<a href="/">Main Page</a>
			</div>
			<div class="product-form">
				<h1>Add Product</h1>
				<form:form method="POST" action="/newProduct" modelAttribute="product">
		    		<p class ="form-group">
				        <form:label path="name">Name</form:label>
				        <form:errors path="name"/>
				        <form:input  class = "form-control" path="name"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="description" id="description">Description</form:label>
				        <form:errors path="description"/>
				        <form:input class ="form-control" path="description"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="price" id="price">Price</form:label>
				        <form:errors path="price"/>
				        <form:input type="number" step="0.01" class = "form-control" path="price"/>
			   		</p>
			    	<input type="submit" value="Add Product"/> 
				</form:form>
			</div>
		</div>
	</body>
</html>