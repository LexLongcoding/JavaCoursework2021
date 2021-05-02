<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="BIG5">
		<title>Insert title here</title>
	</head>
	<body>
	
		<h1><c:out value="${book.getTitle()}"/></h1>
		<p>Description: <c:out value="${book.getDescription()}"/></p>
		<p>Language: <c:out value="${book.getLanguage()}"/></p>
		<p>Number of pages: <c:out value="${book.getNumberOfPage()}"/></p>
		
		<form method = "POST" action = "/search">
			<input type = "text" name = "index">
			<button>Try Index</button>
		</form>
		
		<a href="/books/${book.getId()}/edit">Edit Book</a>
		<form action="/books/${book.getId()}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	
	</body>
</html>