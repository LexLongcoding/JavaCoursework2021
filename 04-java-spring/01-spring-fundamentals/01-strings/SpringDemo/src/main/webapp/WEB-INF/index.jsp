<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Webpage</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<form action="/addjoke" method="POST">
<p>Name: <input type="text" name="name"></p>
<p>Email: <input type="email" name="email"></p>
<p>Joke: <input type="joke" name="joke"></p>

<button>Add Joke!</button>


</form>

</body>
</html>