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
<title>Ideas</title>
</head>
<body>

<div class="container">
<H1>Great Ideas</H1>
<h2>Welcome, ${user.name}</h2>


<table class="table table-dark">
<thead>
<td>Idea</td>
<td>Created By</td>
<td>Number Of Likes</td>
<td>Action</td>

</thead>
<tbody>
<c:forEach items="${ideas}" var ="idea">
<tr>

<td><a href="/${idea.id}/">${idea.ideaName}</a></td>
<td>${idea.creator.name}</td>
<td>${idea.likers.size() }</td>
<td>

<c:choose>
<c:when test="${idea.likers.contains(user)}">
<a href="/unlike/${idea.id}">Un-Like |</a>
</c:when>
<c:otherwise>
<a href="/like/${idea.id}">Like |</a>
</c:otherwise>
</c:choose>


<c:if test="${idea.creator.id == user.id }">
<a href="/delete/${idea.id}">Delete</a>
</c:if>
</td>
</tr>
</c:forEach>

</tbody>
</table>
<h3><a class="btn btn-primary" href="/new">Create a New Idea</a></h3>
</div>

</body>
</html>