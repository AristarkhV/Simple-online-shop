<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Your order</title>
</head>
<body>
<center>
    <h2> Order </h2>
    <form:form action="/user/order" method="POST" modelAttribute="order">
        First Name:<br>
        <form:input type="text" path="firstName" value=""/>
        <br>
        Last Name:<br>
        <form:input type="text" path="lastName" value=""/>
        <br>
        Number of phone:<br>
        <form:input type="number" path="numberOfPhone" value=""/>
        <br>
        Street Name:<br>
        <form:input type="text" path="streetName" value=""/>
        <br>
        House Number:<br>
        <form:input type="number" path="houseNumber" value=""/>
        <br>
        <c:if test="${ok != null}">
            ${ok}
        </c:if>
        <c:if test="${valid != null}">
            ${valid}
        </c:if>
        <br>
        <button type="submit"> Send</button>
        <button><a href='<spring:url value="/signout"/>'> Log Out </a></button>
    </form:form>
</center>
</body>
</html>
