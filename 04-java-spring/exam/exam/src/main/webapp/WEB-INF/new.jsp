<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
<meta charset="ISO-8859-1">
<title>Create new Idea</title>
</head>
<body>
<div class="container">
<h2>Hello ${user.name}</h2>
<h3>Create a new idea</h3>

<form:form action="/addIdea" method="POST" modelAttribute="idea">
	<form:input type="hidden" value="${user.id}" path="creator"/>
	<div class="form-group">
	<form:label path="ideaName">Enter Your Idea</form:label>
	<form:errors path="ideaName"/>
	<form:textarea path="ideaName"/>
	</div>
	
	
	<button class="btn btn-primary">Create</button>
</form:form>
</div>
</body>
</html>