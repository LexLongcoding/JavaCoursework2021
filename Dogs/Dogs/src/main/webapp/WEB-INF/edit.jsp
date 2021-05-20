<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>edit pet</title>
</head>
<body>
<t:header>
<div class="container">
	<h1>Add New Dog</h1>
	<form:form method="POST" action="/edit/${dog.id}" modelAttribute="dog">
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
	
	<button>Edit Dog!</button>
	</form:form>
	

</div>
</t:header>
</body>
</html>