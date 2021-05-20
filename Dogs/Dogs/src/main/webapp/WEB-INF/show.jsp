<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dog Profile Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<t:header>
<hr>
<div class="container">
<p>${errorMsg}</p>
<h2>Details For <c:out value="${dog.name}"/></h2>
<p>Owner: <a href="/profile/${dog.owner.id}">${dog.owner.firstName}</a></p>
<hr>
<p>Name: ${dog.name }</p>
<p>Breed: ${dog.breed }</p>
<p>Age: ${dog.age}</p>
<hr>
<h3>Liked By:</h3>
<ol>
<c:forEach items="${dog.likers}" var="user">
<li>${user.firstName} ${user.lastName}</li>
</c:forEach>


</ol>

<hr>
<h2>Toys</h2>
<ol>
<c:forEach items="${dog.toys}" var="toy">
<li>${toy.name} (${toy.price}) - ${toy.description}</li>

</c:forEach>
</ol>

<c:choose>
<c:when test="${dog.tag != null }">
<h2>Tag Details</h2>
<p>City: ${dog.tag.city }</p>
<p>State: ${dog.tag.state }</p>
</c:when>
<c:otherwise>
<h3>Add Dog Tag</h3>
<hr>
<form:form method="POST" action="/addTag/${dog.id}" modelAttribute="tag">
		<div class="form-group">
			<form:label path="city">City</form:label>
			<form:errors path="city"/>
			<form:input path="city"/>		
		</div>
		<div class="form-group">
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>		
		</div>

<button>Add Dog Tag</button>
</form:form>
</c:otherwise>

</c:choose>
<c:if test="${dog.owner.id == userId }">
<a href="/edit/${dog.id}">Edit Dog</a>
</c:if>



</div>
</t:header>
</body>
</html>