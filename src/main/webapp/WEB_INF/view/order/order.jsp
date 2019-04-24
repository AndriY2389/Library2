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
        <th scope="col">Book</th>
        <th scope="col">Date of Issuance</th>
        <th scope="col">Date of Return</th>
        <th scope="col">Reader</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orders}" varStatus="rowCounter">
        <tr>
            <td>${order.getId()}</td>
            <td>${order.getBooks().getName()}</td>
            <td>${order.getDateOfIssuance()}</td>
            <td>${order.getDateOfReturn()}</td>
            <td>${order.getReaders().getFirstName()} ${order.getReaders().getLastName()}</td>
            <td>
                <button type="button" data-toggle="collapse" data-target="#demoOrder${author.getId()}"
                        class="btn btn-outline-info accordion-toggle">Update
                </button>
            </td>
            <td>
                <form action="/delete_order" style="margin-block-end: 0em;" method="post">
                    <input type="hidden" name="id" value="${order.getId()}">
                    <input type="submit" class="btn btn-outline-danger" value="Delete"/>
                </form>
            </td>
        </tr>

        <tr>
            <td colspan="7" class="hiddenRow"
                style="border-top: 0px solid #dee2e6;  padding: 0; margin-block-end: 0em; font-size: 0px">
                <form method="post" action="/update_author">
                    <div class="accordian-body collapse row"  id="demoOrder${book.getId()}">
                        <div class="order_update" style="display: inline-block;">
                            <select required name="book" class="custom-select" id="inputBookSelect">
                                <option selected value="0">Choose Book</option>
                                <c:forEach var="book" items="${books}" varStatus="rowCounter">
                                    <option value="${book.getId()}">${book.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="order_update_data " style="display: inline-block" >
                            <input name="dateOfIssuance" type="date" value="1900-01-01" class="form-control" placeholder="releaseDate" aria-label="Recipient's username"
                                   aria-describedby="basic-addon2"/>
                        </div>
                        <div class="order_update_data" style="display: inline-block" >
                            <input name="dateOfReturn" type="date" value="1900-01-01" class="form-control" placeholder="releaseDate" aria-label="Recipient's username"
                                   aria-describedby="basic-addon2"/>
                        </div>
                        <div class="order_update" style="display: inline-block;" >
                            <select required name="reader" class="custom-select" id="inputReaderSelect">
                                <option selected value="0">Choose Reader</option>
                                <c:forEach var="reader" items="${readers}" varStatus="rowCounter">
                                    <option value="${reader.getId()}">${reader.getFirstName()} ${reader.getLastName()}</option>
                                </c:forEach>
                                <!--add redirect to create author -->
                            </select>
                        </div>

                        <input type="submit" class="btn btn-outline-success btn-submit-order" value="submit"/>

                    </div>
                </form>
        </tr>
    </c:forEach>

    </tbody>
</table>

<div>
    <a class="create_button btn btn-primary" data-toggle="collapse" href="#menu"
       role="button" aria-expanded="false" aria-controls="menu">Create Order</a>
    <div class="collapse multi-collapse" id="menu">
        <div class="card card-body">
            <form action="/create_order" class="col"><!--sasha add action on submit here -->

                <select required name="book" class="custom-select" id="inputBookSelect">
                    <option selected value="0">Choose Book</option>
                    <c:forEach var="book" items="${books}" varStatus="rowCounter">
                        <option value="${book.getId()}">${book.getName()}</option>
                    </c:forEach>
                </select>

                <input name="dateOfIssuance" type="date" value="1900-01-01" class="form-control" placeholder="releaseDate" aria-label="Recipient's username"
                       aria-describedby="basic-addon2"/>

                <input name="dateOfReturn" type="date" value="1900-01-01" class="form-control" placeholder="releaseDate" aria-label="Recipient's username"
                       aria-describedby="basic-addon2"/>

                <select required name="reader" class="custom-select" id="inputReaderSelect">
                    <option selected value="0">Choose Reader</option>
                    <c:forEach var="reader" items="${readers}" varStatus="rowCounter">
                        <option value="${reader.getId()}">${reader.getFirstName()} ${reader.getLastName()}</option>
                    </c:forEach>
                </select>

                <%--<input type="text" class="form-control" placeholder="Book" aria-label="Recipient's username"--%>
                       <%--aria-describedby="basic-addon2">--%>
                <%--<input type="text" class="form-control" placeholder="Date of Issuance" aria-label="Recipient's username"--%>
                       <%--aria-describedby="basic-addon2">--%>
                <%--<input type="text" class="form-control" placeholder="Date of Return" aria-label="Recipient's username"--%>
                       <%--aria-describedby="basic-addon2">--%>
                <%--<input type="text" class="form-control" placeholder="Reader" aria-label="Recipient's username"--%>
                       <%--aria-describedby="basic-addon2">--%>
                <input type="submit" class="btn btn-primary" value="submit"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>