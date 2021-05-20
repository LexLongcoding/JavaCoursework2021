<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
    <title>Thoughts</title>
</head>

<body>
    <h1>Thoughts Login Page</h1>
    <div class="row">
        <div class="col">
        <p>${loginError}</P>
            <h4>Login</h4>
            <form method="POST" action ="/login">
            <div class="form-group">
            <label>Email:</label>
            <input class="form-control" type="email" name="loginEmail">
            </div>
            <div class="form-group">
            <label>Password</label>
            <input class="form-control" type="password" name="loginPass">
        	</div>
        	<button class="btn btn-standard">Login</button>
        	</div>
        	</form>
        <div class="col">
            <h4>Register</h4>
            <form:form action="/register" method="post" modelAttribute="user">
                <div class="form-group">
                    <form:label path="firstName">First Name</form:label>
                    <form:errors path="firstName" />
                    <form:input class="form-control" path="firstName"/>
                </div>
                <div class="form-group">
                    <form:label path="lastName">Last Name</form:label>
                    <form:errors path="lastName" />
                    <form:input class="form-control" path="lastName"/>
                </div>
                <div class="form-group">
                    <form:label path="email">Email</form:label>
                    <form:errors path="email" />
                    <form:input class="form-control" path="email"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password</form:label>
                    <form:errors path="password"/>
                    <form:input type="password" class="form-control" path="password"/>
                </div>
                <div class="form-group">
                    <form:label path="confirmPassword">Confirm Password</form:label>
                    <form:errors path="confirmPassword" />
                    <form:input type="password" class="form-control" path="confirmPassword" />
                </div>
                <input class="btn btn-danger" type="submit" value="submit" />
            </form:form>
        </div>
    </div>
</body>

</html>