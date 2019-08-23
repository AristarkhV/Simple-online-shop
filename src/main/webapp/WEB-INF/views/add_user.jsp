<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add User</title>
</head>
<body>
<center>
    <h2>Add User</h2>
    <form:form action="/admin/users/add" method="post" modelAttribute="user">
        Email:<br>
        <form:input type="email" path="email" value="${user.email}"/>
        <br>
        Password:<br>
        <form:input type="password" path="password" value=""/>
        <br>
        <form:radiobutton path="role" value="USER"/>
        User<br>
        <form:radiobutton path="role" value="ADMIN"/>
        Admin<br>
        <br><br>
        <c:if test="${passwordsError != null}">
            ${passwordsError}
        </c:if>
        <c:if test="${validFields != null}">
            ${validFields}
        </c:if>
        <br>
        <input type="submit" value="Add user">
    </form:form>
</center>
</body>
</html>
