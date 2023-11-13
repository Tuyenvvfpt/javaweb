<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/24/2023
  Time: 6:40 PM
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
  <h2>Thêm mới sản phầm</h2>
  <form class="form-horizontal" action="ServletProduct" enctype="multipart/form-data" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="name_product">Tên sản phầm:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="name_product" placeholder="Enter email" name="name_product">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="price">Giá:</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="price" placeholder="Enter password" name="price">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="image">Giá:</label>
      <div class="col-sm-10">
        <input type="file" class="form-control" id="image"  name="image">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="category">Category:</label>
      <select class="form-control col-sm-10 " name="sub_category" id="category" class="selectpicker">
        <c:forEach var="cate" items="${sub_category}">
          <option value="${cate.id}">${cate.name}</option>
        </c:forEach>

      </select>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>
