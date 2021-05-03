<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Enter a dog</title>
</head>
<body>
<div class="container">
	<h1>Add New Dog</h1>
	<form:form method="POST" action="/add" modelAttribute="dog">
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>		
		</div>
		<div class="form-group">
			<form:label path="breed">Breed</form:label>
			<form:errors path="breed"/>
			<form:input path="breed"/>		
		</div>
		<div class="form-group">
			<form:label path="age">Age</form:label>
			<form:errors path="age"/>
			<form:input path="age"/>		
		</div>
	
	<button>Add Dog!</button>
	</form:form>
	<hr>
	<p>HTML Forms Way</p>
	<c:forEach items="${errors }" var="err">
	<p>${err}</p>
	</c:forEach>
	<form action="/add" method="POST">
		<div class="form-group">
			<label for="name">Name</label>
			<input type="text" name="name">
		</div>
			<div class="form-group">
			<label for="breed">Breed</label>
			<input type="text" name="breed">
		</div>
			<div class="form-group">
			<label for="age">Age</label>
			<input type="text" name="age">
		</div>
	<button>Add Pet</button>
</form>

</div>

 
</body>
</html>