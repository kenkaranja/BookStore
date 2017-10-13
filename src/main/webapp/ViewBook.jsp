<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 8/25/2017
  Time: 8:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="AdminPage.jsp" %>
<html>
<head>
    <title>View Book</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<div class="container">
    <div class="jumbotron">
        <table class="table table-bordered">
            <tr>
                <thead>
                <td>Name</td>
                <td>Author</td>
                <td>Price</td>
                </thead>
            </tr>
            <c:forEach var="product" items="${products}">
            <tr>

                <td><c:out value="${product.book_name}"></c:out></td>
                <td><c:out value="${product.book_author}"></c:out></td>
                <td><c:out value="${product.book_price}"></c:out></td>

            </tr>
            </c:forEach>
    </div>
</div>
</table>
</body>
</html>
