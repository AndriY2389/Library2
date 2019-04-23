<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 22.04.2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <jsp:include page="../head.jsp"/>
    <title>Author</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col ">Id</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="readers" items="${readers}" varStatus="rowCounter">
        <tr>
            <td>${readers.getId()}</td>
            <td>${readers.getFirstName()}</td>
            <td>${readers.getLastName()}</td>
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

<form action="/create_reader" class="col1 col">
    <input type="submit" class="create_buttom btn btn-primary" value="Create Author"/>
</form>
<form action="/delete_reader" class="col1 col">
    <input type="submit" class="create_buttom btn btn-danger" value="DELETE"/>
</form>
</body>
</html>
