<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 8/25/2017
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="CustomerPage.jsp" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>View Book Bought</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <table class="table table-bordered">
            <tr>
                <thead>
                <td>Customer</td>
                <td>Book</td>
                <td>Price</td>
                <td>Author</td>

                </thead>
            </tr>
            <c:forEach var="bookbought" items="${shoppingcart}">
                <tr>

                    <td><c:out value="${bookbought.customer_name}"></c:out></td>
                    <td><c:out value="${bookbought.bookname}"></c:out></td>
                    <td><c:out value="${bookbought.bookprice}"></c:out></td>
                    <td><c:out value="${bookbought.bookauthor}"></c:out></td>


                </tr>
            </c:forEach>
        </table>
        <a href="viewBookCustomer.jsp">
            <button class="btn btn-success">Back</button>
        </a>
        <form action="" method="post">
            <button class="btn btn-success">Buy</button>
        </form>
    </div>
</div>

</body>
</html>
