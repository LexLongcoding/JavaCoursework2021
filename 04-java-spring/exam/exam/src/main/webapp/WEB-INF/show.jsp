<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<link rel="stylesheet" href="/css/main.css" />
		<meta charset="ISO-8859-1">
	<title>Ideas</title>
</head>
	<body>
		<div class="container">
			<h1>${ idea.ideaName }</h1>
			<div class="idea-details">
				<h4><strong>Created By:</strong> ${ idea.creator.name }</h4>
				
				
			</div>
			
			
			</div>
			<div class="container">

<hr>
<div class = "container">
<h3><a class="btn btn-primary" href="/ideas/${ idea.id }/edit">Edit this Idea</a></h3>
</div>
<h3>This idea has been liked by</h3>
<table class="table table-dark">
<thead>
<td>Name</td>
</thead>
<tbody>
<c:forEach items="${idea.likers}" var="likers">
<tr>
<td>
${likers.name}

</c:forEach>

</td>
</tr>
</tbody>
</div>


</body>
</html>
	

