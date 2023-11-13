<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/19/2023
  Time: 7:41 PM
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
  <h2>Add Sub Category</h2>

  <form action="ServletAddSubCategory" method="post" >

    <div class="form-group">
      <label for="name_user">Sub Category Name:</label>
      <input type="text" class="form-control" id="name_user" placeholder="Enter email" name="sub_category" value="${student.name}">
    </div>

    <div class="form-group">
      <label for="category">Category:</label>
      <select class="form-control" name="category" id="category" class="selectpicker">
        <c:forEach var="cate" items="${list_cate}">
          <option value="${cate.id}">${cate.name}</option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>

</div>
</body>
</html>
