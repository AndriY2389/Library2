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
        <th scope="col ">Id</th>
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
            <td>
                <form action="/delete_book" method="post">
                    <input type="hidden" name="id" value="${book.getId()}">
                    <input type="submit" class="btn btn-outline-danger"value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<div>
    <a class="create_button btn btn-primary" data-toggle="collapse" href="#menu"
       role="button" aria-expanded="false" aria-controls="menu">Create Book</a>
    <div class="collapse multi-collapse" id="menu">
        <div class="card card-body">
            <form action="/" class="col"><!--sasha add action on submit here -->
                <input type="text" class="form-control" placeholder="Name" aria-label="Recipient's username"
                       aria-describedby="basic-addon2">
                <select class="custom-select" id="inputGroupSelect02">
                    <option selected>Choose Author</option>
                    <c:forEach var="author" items="${authors}" varStatus="rowCounter">
                        <option value="${author.getId()}">${author.getFirstName()} ${author.getLastName()}</option>
                    </c:forEach>
                    <!--add redirect to create author -->
                </select>
                <input type="text" class="form-control" placeholder="Release Date" aria-label="Recipient's username"
                       aria-describedby="basic-addon2">
                <input type="text" class="form-control" placeholder="Available" aria-label="Recipient's username"
                       aria-describedby="basic-addon2">
                <input type="submit" class="btn btn-primary" value="submit"/>
            </form>
        </div>
    </div>
</div>
</html>
