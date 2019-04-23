<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 22.04.2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>READER</title>
    <jsp:include page="../head.jsp"/>

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
            <td >
                <button type="button" class="btn btn-outline-danger">Delete</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<form action="/create_reader" class="col1 col">
    <input type="submit" class="create_button btn btn-primary" value="Create Author"/>
</form>
</body>
</html>
