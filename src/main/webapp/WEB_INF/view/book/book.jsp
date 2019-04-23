<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 22.04.2019
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <jsp:include page="../head.jsp"/>
    <title>Book</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col ">id</th>
        <th scope="col">Book Name</th>
        <th scope="col">Release Date</th>
        <th scope="col">Valid</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}" varStatus="rowCounter">
        <tr>
            <td>${book.getId()}</td>
            <td>${book.getName()}</td>
            <td>${book.getReleaseDate().toString()}</td>
            <td>${book.available}</td>
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
</table></body>
<form action="/create_book" class="col1 col">
    <input type="submit" class="create_buttom btn btn-primary" value="Create Book"/>
</form>
<form action="/delete_book" class="col1 col">
    <input type="submit" class="create_buttom btn btn-danger" value="DELETE"/>
</form>
</html>
