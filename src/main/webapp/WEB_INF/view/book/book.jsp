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
        <th scope="col">Author</th>
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
            <td>${book.getAuthor().getFirstName()}  ${book.getAuthor().getLastName()}</td>
            <td>
                <button type="button" data-toggle="collapse" data-target="#demo${book.getId()}" class="btn btn-outline-info accordion-toggle">Update</button>
            </td>
            <td>
                <form action="/delete_book" style="margin-block-end: 0em;" method="post">
                    <input type="hidden" name="id" value="${book.getId()}">
                    <input type="submit" class="btn btn-outline-danger"value="Delete"/>
                </form>
            </td>
        </tr>
        <tr>
            <td colspan="6" class="hiddenRow" style="border-top: 0px solid #dee2e6;  padding: 0; margin-block-end: 0em; font-size: 0px">
                <form method="post" action="/update_book">
                    <div class="accordian-body collapse row" id="demo${book.getId()}">
                        <input type="hidden", name="id" value="${book.getId()}">
                        <div class="book_buttons">
                            <input type="text" name="name" class="form-control " placeholder="Name of book" aria-label="Recipient's username" aria-describedby="basic-addon2">
                        </div>
                        <div class="book_buttons">
                            <input type="date" required name="releaseDate" class="form-control" placeholder="ReleaseDate" aria-label="Recipient's username" aria-describedby="basic-addon2">
                        </div>
                        <div class="book_buttons">
                            <select required name="author" class="custom-select">
                                <option selected value="0">Author</option>
                                <c:forEach var="author" items="${authors}" varStatus="rowCounter">
                                    <option value="${author.getId()}">${author.getFirstName()} ${author.getLastName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input  type="submit" class="btn btn-outline-success btn-submit-book" value="submit"/>
                    </div>
                </form>
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
            <form action="/create_book" method="post" class="col">
                <input type="text" name="name" class="form-control" placeholder="name" aria-label="Recipient's username"
                       aria-describedby="basic-addon2">
                <select name="author" class="custom-select" id="inputGroupSelect02">
                    <option selected value="0">Input some</option>
                    <c:forEach var="author" items="${authors}" varStatus="rowCounter">
                        <option value="${author.getId()}">${author.getFirstName()} ${author.getLastName()}</option>
                    </c:forEach>
                </select>
                <input name="releaseDate" type="date" value="1900-01-01" class="form-control" placeholder="releaseDate" aria-label="Recipient's username"
                       aria-describedby="basic-addon2">
                <input type="submit" class="btn btn-primary" value="submit"/>
            </form>
        </div>
    </div>
    <div class="invalid_data" style="color: red">
        ${invalid_data}
    </div>
</div>
</html>
