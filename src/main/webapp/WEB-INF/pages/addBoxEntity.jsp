<%@page contentType="text/html;charset = UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="Type" class="spring.example.config.TypeValuesConfig"/>
<html>
<head>
Title
</head>
<body>

<form method="post" action="/addBoxEntity">
    <c:forEach items="${entity}" var="entity">

        <h2>Information about BoxEntity</h2>

        <p><input type="text" placeholder="colour" name="colour"></p>

        <p><input type="number" placeholder="id" name="id" value="${entity.id}"></p>
        <p><input type="text" placeholder="name" name="name" value="${entity.name}"></p>

        <p><input type="number" placeholder="weight" name="weight"></p>
        <p><input type="number" placeholder="memory" name="memory"></p>
        <select name="type" id="type">
            <c:forEach items="${Type.values}" var="type">
                <option value="${type}">${type}</option>
            </c:forEach>
        </select>

    </c:forEach>
    <input type="submit" value="save">
</form>
</body>
</html>