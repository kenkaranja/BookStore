<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 8/25/2017
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="CustomerPage.jsp" %>
<html>
<head>
    <title>View Books To Buy</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="jumbtron">
        <form method="post" action="shopping">
            <c:forEach var="product" items="${customerproducts}">
                <div class="panel">
                    <c:out value="${product.book_name}"></c:out>
                    <c:out value="${product.book_author}"></c:out>
                    <c:out value="${product.book_price}"></c:out>
                    <input type="checkbox" name="checkbook" value="${product.book_name}">
                </div>

            </c:forEach>

            <button class="btn btn-success">Add To Cart</button>
        </form>
    </div>

</div>

</body>
</html>
