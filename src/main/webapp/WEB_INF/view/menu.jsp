<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<div class="naw menu" >
    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <div class="col logo">
            Library
        </div>
        <form action="/book" class="col">
            <input type="submit" class="btn btn1 btn-outline-secondary" value="Books"/>
        </form>
        <form action="/order" class="col">
            <input type="submit" class="btn btn1 btn-outline-secondary" value="Orders"/>
        </form>
        <form action="/reader" class="col">
            <input type="submit" class="btn btn1 btn-outline-secondary" value="Reader"/>
        </form>
        <form action="/author" class="col">
            <input type="submit" class="btn btn1 btn-outline-secondary" value="Author"/>
        </form>
    </nav>

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>




