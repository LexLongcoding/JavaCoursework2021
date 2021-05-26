<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
	<head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<link rel="stylesheet" href="css/main.css" />
		<meta charset="ISO-8859-1">
	<title>Event Planner</title>
</head>
	<body>
		<div class="container">
			<h2>Edit <strong>${ idea.ideaName }</strong></h2>
			<form:form action="/edit/${ idea.id }" method="post" modelAttribute="idea">
				<input type="hidden" name="_method" value="put">
				<form:hidden value="${ userId }" path="creator"/>
				<div class="form-group">
					<form:label path="ideaName">Content:</form:label>
					<form:errors path="ideaName"></form:errors>
					<form:input class="form-control" path="ideaName"></form:input>
				</div>
				 
			    <button>Update</button>
			</form:form>
		<h4><a class="btn btn-danger" href="/delete/${idea.id}">Delete</a></h4>	
		</div>

			
	
	</body>
</html>