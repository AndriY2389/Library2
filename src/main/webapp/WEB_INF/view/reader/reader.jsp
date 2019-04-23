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
    Reader
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>FIRSTNAME</th>
            <th>LASTNAME</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="reader" items="${readers}" varStatus="rowCounter">
            <tr>
                <td>${reader.getId()}</td>
                <td>${reader.getFirstName()}</td>
                <td>${reader.getLastName()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
