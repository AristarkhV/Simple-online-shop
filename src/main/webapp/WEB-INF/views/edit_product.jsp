<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<center>
    <h2>Edit Product</h2>
    <form action="/admin/products/update?id=${product.id}" method="post">
        Name:<br>
        <form:input type="text" path="name" value="${product.name}"/>
        <br>
        Description:<br>
        <form:input type="text" path="description" value="${product.description}"/>
        <br>
        Price:<br>
        <form:input type="number" step="0.01" path="price" value="${product.price}"/>
        <br>
        <c:if test="${validValues != null}">
            ${validValues}
        </c:if>
        <br>
        <button type="submit">Edit product</button>
    </form>
</center>
</body>
</html>
