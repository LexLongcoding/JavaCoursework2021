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
<link rel="stylesheet" href="css/main.css" />
<title>Languages App</title>
</head>
	<body>
		<div class="container-fluid">
			<h1>All Languages</h1>
			<a href="/new">Add a language...</a>
			<table class=" table table-dark table-striped table-bordered col-md-8 offset-md-2 table-hover ">
			    <thead>
			        <tr>
			            <th>Language</th> 
			            <th>Creator</th>
			            <th>Current Version</th>
			            <th>action</th>
			        </tr>
			    </thead>
			    <tbody>
			        	<c:forEach items="${languages}" var="language" varStatus="loop">
						<tr>    
						    <td><a href="/${language.id}"><c:out value="${language.name}"/></a> </td>
						    <td><c:out value="${language.creator}"/></td>
						    <td><c:out value="${language.currentVersion}"/></td>
						    <td> <a href="/${language.id}/edit">Edit</a>   <a href="/${language.id}/delete">Delete</a>
						    
						    		
						    		</form>
						    </td>
						</tr>
						</c:forEach>
			    </tbody>
			</table>
			
			
		</div>
	</body>	
</html>