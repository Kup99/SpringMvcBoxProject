<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<p>Information about box</p>
<c:forEach items="${info}" var="info">
    <h4>Info About : ${info.name}</h4>
    <ul>
    <li>Name:${info.name}</li>
    <li>Colour:${info.colour}</li>
    <li>Type:${info.weight}</li>
    </ul>
</c:forEach>
</body>
</html>
