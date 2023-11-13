<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/12/2023
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <h2>Danh sách học sinh</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Adress</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${list_student}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.address}</td>
                <td>${student.age}</td>
                <td>
                    <a href="ServletEditStudent?id=${student.id}">Edit</a>
                    <button onclick="delete_student(${student.id})">Delete</button>
                </td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</div>
    <script>
        function delete_student(id) {
            $.get("ServletDeleteStudent?id="+id, function(data, status){
                alert("Data: " + data + "\nStatus: " + status);
                window.location.reload();
            });
        }
    </script>
</body>

</html>
