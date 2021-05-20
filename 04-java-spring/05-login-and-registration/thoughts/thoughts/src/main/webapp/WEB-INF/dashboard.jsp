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
<title>Insert title here</title>
</head>
<body>
<H1>The Dash Page</H1>
<div class="container">
<p>Hello ${user.firstName}</p>

<form:form action="/addThought" method="POST" modelAttribute="thought">
	<form:input type="hidden" value="${user.id}" path="creator"/>
	<div class="form-group">
	<form:label path="thoughtContent">Post a Thought</form:label>
	<form:errors path="thoughtContent"/>
	<form:textarea path="thoughtContent"/>
	</div>
	
	<button class="btn btn-primary">Add Thought</button>
</form:form>
<hr>
<c:forEach items="${thoughts}" var ="thought">
<c:choose>
<c:when test="${thought.likers.contains(user)}">
<a href="/unlike/${thought.id}">Unlike</a>
</c:when>
<c:otherwise>
<a href="/like/${thought.id}">Like</a>
</c:otherwise>
</c:choose>
<p>Likes: ${thought.likers.size()}</p>
<p>${thought.creator.firstName} says:</p>
<p>${thought.thoughtContent}</p>
<a href="/${thought.id}">Details</a>
<c:if test="${thought.creator.id == user.id }">
<p><a class="btn btn-danger" href="/delete/${thought.id}">Delete</a></p>
</c:if>
</c:forEach>
</div>
</body>
</html>