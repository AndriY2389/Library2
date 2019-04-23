<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 21.04.2019
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../head.jsp"/>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col ">Id</th>
        <th scope="col">Book Id</th>
        <th scope="col">Date of Issuance</th>
        <th scope="col">Date of Return</th>
        <th scope="col">Reader Id</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="orders" items="${orders}" varStatus="rowCounter">
        <tr>
            <td>${orders.getId()}</td>
            <td>${orders.getBooks().getId()}</td>
            <td>${orders.getDateOfIssuance()}</td>
            <td>${orders.getDateOfReturn()}</td>
            <td>${orders.getReaders().getId()}</td>
            <td>
                <button type="button" class="btn btn-outline-info">Update</button>
            </td>
            <td class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                <label class="form-check-label" for="defaultCheck1"/>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<form action="/create_order" class="col1 col">
    <input type="submit" class="create_button btn btn-primary" value="Create Order"/>
</form>
<form action="/delete_order" class="col1 col">
    <input type="submit" class="create_button btn btn-danger" value="DELETE"/>
</form>
</body>
</html>