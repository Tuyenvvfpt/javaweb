<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/19/2023
  Time: 7:07 PM
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
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>

<%--            display Cate--%>
        <c:forEach var="cate" items="${lst_category}">
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${cate.name} <span class="caret"></span></a>
                <ul class="dropdown-menu">
<%--                    display subCate--%>
                <c:forEach var="sub_cate" items="${cate.subCategoryList}">
                    <li><a href="ServletProductBySub?id=${sub_cate.id}">${sub_cate.name}</a></li>
                </c:forEach>
                </ul>
            </li>
        </c:forEach>
        </ul>

    </div>
</nav>
<div class="container-fluid">
   
    
    <div class="row">
        <c:forEach var="product" items="${list_product}">
            <div class=" col-lg-4" >
                <div>
                    <img style="width: 300px ;height: 300px" src="image/${product.name_file}">

                </div>
                <div>
                    <p>${product.name}</p>
                    <p>${product.price}</p>
                </div>
            </div>
        </c:forEach>



</div>


</body>
</html>
