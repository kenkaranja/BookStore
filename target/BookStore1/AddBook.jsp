<%--
  Created by IntelliJ IDEA.
  User: ken
  Date: 8/24/2017
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Register-Book</title>
</head>
<body>
<div class="container">
    <div class="row col-md-8">
        <form method="post" action="addbook">
            <b>Add Product</b>
            <br>
            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control" name="name">
            </div>
            <div class="form-group">
                <label>Author:</label>
                <input type="text" class="form-control" name="author">
            </div>
            <div class="form-group">
                <label>Price:</label>
                <input type="number" class="form-control" name="price">
            </div>
            <button type="submit" class="btn btn-default">Save Book</button>
        </form>
    </div>

</div>
</body>
</html>
