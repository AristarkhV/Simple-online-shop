<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit User</title>
</head>
<body>
<center>
    <h2>Edit User</h2>
<form action="/admin/users/update?id=${id}" method="post">
        Email:<br>
        <input type="email" name="email" value="${user.email}"/>
        <br>
        Password:<br>
        <input type="text" name="password" value=""/>
        <br>
        <input type="radio" value="ROLE_USER"/> User<br>
        <input type="radio" value="ROLE_ADMIN"/> Admin<br>
        <br>
        <c:if test="${validValues != null}">
            ${validValues}
        </c:if>
        <br>
        <button type="submit">Edit user</button>
    </form>
</center>
</body>
</html>
