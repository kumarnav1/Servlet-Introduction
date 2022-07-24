<%--
  Created by IntelliJ IDEA.
  User: nk400
  Date: 24-07-2022
  Time: 03:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Success Page</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user") %>, Login Successful.</h3>
<a href="login.html">Login Page</a>
</body>
</html>