<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add product</title>
</head>
<body>
<center>
    <h2>Add Product</h2>
    <form:form action="/admin/products/add" method="POST" modelAttribute="product">
        Name:<br>
        <form:input type="text" path="name" value=""/>
        <br>
        Description:<br>
        <form:input type="text" path="description" value=""/>
        <br>
        Price:<br>
        <form:input path="price" type="number" step="0.01"/> <br>
        <br>
        <c:if test="${validFields != null}">
            ${validFields}
        </c:if>
        <br>
        <input type="submit" value="Add product">
    </form:form>
</center>
</body>
</html>
