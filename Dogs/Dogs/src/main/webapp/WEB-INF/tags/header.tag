<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
    <title>Welcome to dog house</title>
</head>

<body>
<div class="container">

<nav>
<a href="dogs">All Dogs</a> |
<a href="/add">create a dog</a> |
<a href="toys/new">Give a dog a toy</a> |
<a href="/logout">Logout</a>
</nav>
<hr>
<jsp:doBody/>

</div>
</body>
