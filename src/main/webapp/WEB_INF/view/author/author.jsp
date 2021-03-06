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
    <title>Author</title>
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
    <c:forEach var="author" items="${authors}" varStatus="rowCounter">
        <tr>
            <td>${author.getId()}</td>
            <td>${author.getFirstName()}</td>
            <td>${author.getLastName()}</td>
            <td>
                <button type="button" data-toggle="collapse" data-target="#demo${author.getId()}" class="btn btn-outline-info accordion-toggle">Update</button>
            </td>
            <td >
                <form action="/delete_author" style="margin-block-end: 0em;" method="post">
                    <input type="hidden" name="id" value="${author.getId()}">
                    <input type="submit" class="btn btn-outline-danger"value="Delete"/>
                </form>
            </td>
        </tr>

        <tr>
            <td colspan="6" class="hiddenRow" style="border-top: 0px solid #dee2e6;  padding: 0; margin-block-end: 0em; font-size: 0px">
                <form method="post" action="/update_author">
                <div class="accordian-body collapse" id="demo${author.getId()}">
                    <input type="hidden", name="id" value="${author.getId()}">
                    <div class="author_first_name">
                        <input type="text" name="FirstName" class="form-control " placeholder="First Name" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    </div>
                    <div class="author_last_name">
                        <input type="text" name="LastName" class="form-control" placeholder="Last Name" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    </div>
                    <input  type="submit" class="btn btn-outline-success btn-submit" value="submit"/>

                </div>
                </form>
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
                <input type="text" name="FirstName" class="form-control" placeholder="First Name"
                       aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="text" name="LastName" class="form-control" placeholder="Last Name"
                       aria-label="Recipient's username" aria-describedby="basic-addon2">
                <input type="submit" class="btn btn-primary" value="submit"/>
            </form>
        </div>
    </div>
    <div class="invalid_data" style="color: red">
        ${invalid_data}
    </div>
</div>
</body>
</html>
