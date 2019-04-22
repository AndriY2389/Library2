<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 22.04.2019
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../head.jsp"/>
    <title>Book</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<table class="table table-hover col_table">
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
    <%--<c:forEach var="book" items="${books}" varStatus="rowCounter">--%>
        <%--<tr>--%>
            <%--<td>${book.getId()}</td>--%>
            <%--<td>${book.getName()}</td>--%>
            <%--<td>${book.getReleaseDate().toString()}</td>--%>
            <%--<td>${book.isAvailable()}</td>--%>
            <%--<td>--%>
                <%--<button type="button" class="btn btn-danger">Update</button>--%>
            <%--</td>--%>
            <%--<td class="form-check">--%>
                <%--<input class="form-check-input" type="checkbox" value="" id="defaultCheck1">--%>
                <%--<label class="form-check-label" for="defaultCheck1">--%>
                    <%--Delete--%>
                <%--</label>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
        <tr>
            <td>1</td>
            <td>sdgsdgsdg</td>
            <td>sdsdfsdfsdfsdfsdf</td>
            <td>dffgdfgddfgdffgdfg</td>
            <td>
                <button type="button button_update" class="btn btn2 btn-danger">Update</button>
            </td>
            <td class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                <label class="form-check-label" for="defaultCheck1"/>
            </td>
        </tr>
    </tbody>
</table></body>
</html>
