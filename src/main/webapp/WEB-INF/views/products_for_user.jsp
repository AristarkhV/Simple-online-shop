<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>All products</title>
</head>
<body>
<center>
    <h3>All Products</h3>
    <form action="/user/products" method="get">
        <button><a href="/user/products/basket"> Basket </a></button>
        <table border=1>
            <tr>
                <th> Name</th>
                <th> Description</th>
                <th> Price</th>
                <th> Buy</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <c:if test="${product.id != null}">
                        <td>
                            <button><a href='<c:out value="/user/products/basket/add?id=${product.id}"/>'> Add
                            </a></button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <button><a href='<spring:url value="/signout"/>'> Log Out </a></button>
    </form>
</center>
</body>
</html>
