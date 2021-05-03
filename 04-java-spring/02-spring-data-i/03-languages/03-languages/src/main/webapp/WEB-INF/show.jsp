<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css" />
<title>Languages App</title>
</head>
<body>
	<div class="container">
		<h1>Details for Language * ${language.name} *</h1>
	
		
		
		<p>Creator: ${language.creator}</p>
		<p>Current Version: ${language.currentVersion}</p
		<input type="hidden" name="_method" value="edit">
		<a input class="btn btn-primary" type ="submit" href="/${language.id}/edit" >Edit Language</a>
		<form id="delete-form" action="/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		<a input class="btn btn-danger" type ="submit"  href="/${language.id}/delete">Delete</a>
		</form>
	</div>
</body>
</html>