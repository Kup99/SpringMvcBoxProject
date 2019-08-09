<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="Type" class="spring.example.config.TypeValuesConfig"/>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<c:forEach items="${info}" var="info">
    <ul>
        <li>ID:${info.id}</li>
        <li>Name:${info.name}</li>
        <li>Memory:${info.memory}</li>
        <li>Type:${info.type}</li>
    </ul>

    <form name="server" action="/edit" method="post">
        <input title="ID" type="hidden" name="id" value="${info.id}">
        <p>Name</p>
        <input title="Name" type="text" name="name" value="${info.name}">
        <p>Memory</p>
        <input title="Memory" type="number" name="memory" value="${info.memory}">

        <select name="type" id="type">
            <c:forEach items="${Type.values}" var="type">
            <option value="${type}">${type}</option>
        </c:forEach>
        </select>

        <input type="submit" value="OK">
    </form>

</c:forEach>
</body>
</html>
