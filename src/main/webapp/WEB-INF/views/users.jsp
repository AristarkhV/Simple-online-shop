<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>All users</title>
</head>
<body>
<center>
    <h3>All Users</h3>
    <form action="/admin/users" method="get">
        <button><a href='<c:out value="/admin/users/add"/>'> Add user </a></button>
        <button><a href='<c:out value="/admin/products"/>'> All Products</a></button>
        <table border=1>
            <tr>
                <th> Email</th>
                <th> Password</th>
                <th> Edit</th>
                <th> Delete</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <c:if test="${user.id != null}">
                        <td>
                            <button><a href='<c:out value="/admin/users/update?id=${user.id}"/>'> Edit </a></button>
                        </td>
                        <td>
                            <button><a href='<c:out value="/admin/users/delete?id=${user.id}"/>'> Delete </a></button>
                        </td>
                    </c:if>
                    <c:if test="${user.id == null}">
                        <td>
                            <button><a href='<c:out value="/admin/users"/>'> Edit </a></button>
                        </td>
                        <td>
                            <button><a href='<c:out value="/admin/users"/>'> Delete </a></button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <button><a href="<c:url value="/sign"/>"> Log Out </a></button>
    </form>
</center>
</body>
</html>
