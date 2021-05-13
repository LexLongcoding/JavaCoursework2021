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
		<h2>${ product.name }</h2>
		<p>${ product.description }</p>
		<hr>
		<div class="product-category">
				<h1>${prod.name}</h1>
				<ol>
					<c:forEach items="${product.categories}" var="cat" varStatus="loop">
						<li>${cat.name}</li>
					</c:forEach>
				</ol>
			</div>
		<hr>
		
		<h2>Add Category to ${product.name}</h2>
		
			<form action="/product/add" method="POST">
					<input type="hidden" name="product_id" value=${product.id}>
					<select class="form-control" name="category_id">
		        <c:forEach items="${ notInCategories }" var="nonCat">
		        	<option value=${ nonCat.id }>${ nonCat.name }</option>
		        </c:forEach>
		        </select>
		    </div>
		    <button class="btn btn-primary">Add</button>
			
	
		
		
	</div>

