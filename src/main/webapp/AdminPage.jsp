<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 8/25/2017
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Admin</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">E-ShoppingCart</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="AdminPage.jsp">Home</a></li>
            <li><a href="viewcustomer">View Customer</a></li>
            <li><a href="addbook">Add Product</a></li>
            <li><a href="viewbook">View Product</a></li>
            <li><a href="logoutAdmin">Logout</a></li>
            <li style="text-align: right; "><a href="#"><%out.print(session.getAttribute("adminEmail"));%></a></li>

        </ul>
    </div>
</nav>
<%session.getAttribute("adminEmail");%>
</body>
</html>
