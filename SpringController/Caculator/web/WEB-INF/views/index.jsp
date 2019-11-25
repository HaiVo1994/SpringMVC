<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 25/11/2019
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <form method="post" id="calculator" action="result">
        <input type="number" name="firstNumber">
        <input type="number" name="secondNumber">
        <input type="text" name="action" id="action" hidden>
        <br>
        <button id="add">Addition(+)</button>
        <button id="sub">Subtraction(-)</button>
        <button id="multi">Multiplication(x)</button>
        <button id="divine">Division(/)</button>
    </form>

    <p><span>Result = </span> ${result}</p>
    <script>
        function setAction(action) {
            document.getElementById("action").value = action;
            document.getElementById("calculator").submit();
        }

        document.getElementById("add").onclick = function () {
            setAction("add");
        };
        document.getElementById("sub").onclick = function () {
            setAction("sub");
        };
        document.getElementById("multi").onclick = function () {
            setAction("multi");
        };
        document.getElementById("divine").onclick = function () {
            setAction("divine");
        };
    </script>
</body>
</html>
