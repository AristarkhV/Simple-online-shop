<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Confirm Order</title>
</head>
<body>
<center>
    <h2> Confirm order </h2>
    <form action="/user/order/confirm" method="POST">
        Code from Email:<br>
        <input type="text" name="code" value=""/> <br>
        <br>
        <c:if test="${wrongCode != null}">
            ${wrongCode}
        </c:if>
        <c:if test="${ok != null}">
            ${ok}
        </c:if>
        <br>
        <button type="submit"> Send</button>
        <button><a href='<spring:url value="/signout"/>'> Log Out </a></button>
    </form>
</center>
</body>
</html>