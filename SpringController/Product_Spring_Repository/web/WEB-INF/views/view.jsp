<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 25/11/2019
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product details</title>
</head>
<body>
<h1>Product details</h1>
<a href="/products">Back to product list</a>
<table>
    <tr>
        <td>Code: </td>
        <td>${product.getCode()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.getPrice()}</td>
    </tr>
</table>
</body>
</html>
