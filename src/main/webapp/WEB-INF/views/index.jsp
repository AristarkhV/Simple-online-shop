<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Sign In</title>
</head>
<body>
<center>
    <h2>Sign In</h2>
    <form action="<spring:url value="/signin"/>" method="post">
    Email:<br>
    <input type="email" name="email" value=""/>
    <br>
    Password:<br>
    <input type="password" name="password" value=""/>
    <br>
    <c:if test="${errorMessage != null}">
        ${errorMessage}
    </c:if>
    <c:if test="${unknown != null}">
        ${unknown}
    </c:if>
    <br>
    <input type="submit" value="Sign In"/>
</form>
</center>
</body>
</html>
