<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Products and Categories</title>
</head>
<body>
	<div class="container">
		<nav>
			<h3><a href="/">Products</a> | <a href="/categories">Categories</a></h3>
		</nav>
		<hr>
		<div class="cat-prod">
				<h1>${category.name}</h1>
				<ol>
					<c:forEach items="${category.products}" var="prod" varStatus="loop">
						<li>${prod.name}</li>
					</c:forEach>
				</ol>
			</div>
		<hr>
		<h2>Add Product to ${category.name}</h2>
		
			<form action="/category/add" method="POST">
					<input type="hidden" name="category_id" value=${category.id}>
					<select class="form-control" name="product_id">
		        <c:forEach items="${ notInProducts }" var="nonProd">
		        	<option value=${ nonProd.id }>${ nonProd.name }</option>
		        </c:forEach>
		        </select>
		    </div>
		    <button class="btn btn-primary">Add</button>
			
	
		
		
	</div>
		
		
