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
            <td >
                <button type="button" class="btn btn-outline-danger">Delete</button>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<div>
    <a class="create_button btn btn-primary" data-toggle="collapse" href="#menu"
       role="button" aria-expanded="false" aria-controls="menu">Create Order</a>
    <div class="collapse multi-collapse" id="menu">
        <div class="card card-body">
            <form action="/" class="col"><!--sasha add action on submit here -->
                <input type="text" class="form-control" placeholder="Book Id" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="text" class="form-control" placeholder="Date of Issuance" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="text" class="form-control" placeholder="Date of Return" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="text" class="form-control" placeholder="Reader Id" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="submit" class="btn btn-primary" value="submit"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>