<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
	</head>
	<body>
		<div class == "container-fluid">
			<div>
				<a href="/newCategory">Add Category</a>
				<a href="/newProduct">Add Product</a>
				
				
			</div>
			
			<div class= "product-table">
				<table class="table table-dark ">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
						<tr>
							<td><a href="/product/${product.id}">${product.name}</a></td>
							<td>${product.description}</td>
							<td> $${product.price}</td>
							
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class ="category-table">
				<table class="table table-dark">
					<thead>
						<tr>
							<th>Category</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${categories}" var="cat" varStatus="loop">
						<tr>
							<td> <a href="/category/${cat.id}">${cat.name}</a>  
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>