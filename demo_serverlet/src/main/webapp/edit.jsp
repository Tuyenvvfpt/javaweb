<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/17/2023
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Cập nhật thông tin</h2>
    <form action="ServletEditStudent" method="post" >
        <div class="form-group">
            <label for="user_id">Email:</label>
            <input type="hidden" class="form-control" id="user_id" name="user_id" value="${student.id}">
        </div>
        <div class="form-group">
            <label for="name_user">Name:</label>
            <input type="text" class="form-control" id="name_user" placeholder="Enter email" name="name_user" value="${student.name}">
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" placeholder="Enter password" name="address" value="${student.address}">
        </div>
        <div class="form-group">
            <label for="age">Address:</label>
            <input type="text" class="form-control" id="age" placeholder="Enter password" name="age" value="${student.age}">
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>
