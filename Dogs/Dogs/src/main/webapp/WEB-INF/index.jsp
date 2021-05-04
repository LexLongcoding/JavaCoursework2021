<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dog Page</title>
</head>
<body>
<div class="container">
<h1> Hey, this is my dog page </h1>
<table class="table table-dark">
<thead>
<td>ID</td>
<td>Name</td>
<td>Breed<td>
<td>Age</td>
</thead>
<tbody>
<c:forEach items="${dogs}" var="dog">
<tr>
<td>${dog.id}</td>
<td><a href="/${dog.id}/">${dog.name}</a></td>
<td>${dog.breed}</td>
<td>${dog.age}</td>
<td>
<c:choose>
<c:when test="${dog.tag != null }">
<p>Registered</p>
</c:when>
<c:otherwise>
<p>Not Yet Registered</p>
</c:otherwise>
</c:choose>

</td>
</tr>
</c:forEach>
</tbody>
 </div>
</body>
</html>