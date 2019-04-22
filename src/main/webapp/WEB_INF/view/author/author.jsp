<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 22.04.2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../head.jsp"/>
    <title>Author</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>FIRSTNAME</th>
        <th>LASTNAME</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="author" items="${authors}" varStatus="rowCounter">
        <tr>
            <td>${author.getId()}</td>
            <td>${author.getFirstName()}</td>
            <td>${author.getLastName()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
