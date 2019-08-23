<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Basket</title>
</head>
<body>
<center>
    <h3>Basket</h3>
    <form action="/user/products/basket" method="get">
        <button><a href='<c:out value="/user/products"/>'> All Products </a></button>
        <c:if test="${basket.basketSize == null}">
            Count of products : 0 <br>
        </c:if>
        <c:if test="${basket.basketSize  != null}">
            Count of products : ${basket.basketSize} <br>
        </c:if>
        <table border=1>
            <tr>
                <th> Name</th>
                <th> Description</th>
                <th> Price</th>
            </tr>
            <c:forEach var="product" items="${basket.products}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                </tr>
            </c:forEach>
        </table>
        <button><a href='<c:out value="/user/order"/>'> Buy </a></button>
        <button><a href='<spring:url value="/signout"/>'> Log Out </a></button>
    </form>
</center>
</body>
</html>

