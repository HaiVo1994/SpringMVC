<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 22/11/2019
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer</title>
</head>
<body>
    <form method="post" action="dictionary">
        <input type="text" name="word">
        <input type="submit" value="Transfer">
    </form>
    ${dictionary}
</body>
</html>
