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
    <jsp:include page="head.jsp"/>
    <title>Author</title>
<body>
<jsp:include page="menu.jsp"/>
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
    <c:forEach var="authors" items="${authors}" varStatus="rowCounter">
        <tr>
            <td>${authors.getId()}</td>
            <td>${authors.getFirstName()}</td>
            <td>${authors.getLastName()}</td>
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
   role="button" aria-expanded="false" aria-controls="menu">Create Author</a>
    <div class="collapse multi-collapse" id="menu">
        <div class="card card-body">
            <form action="/create_author" method="post" class="col"><!--sasha add action on submit here -->
                <input type="text" name="FirstName" class="form-control" placeholder="First Name" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="text" name="LastName" class="form-control" placeholder="Last Name" aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="submit" class="btn btn-primary" value="submit"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
