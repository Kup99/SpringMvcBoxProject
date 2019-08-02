<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${info}" var="info">
    <h4>Info About : ${info.name}</h4>
    <ul>
        <li>ID:${info.id}</li>
        <li>Name:${info.name}</li>
        <li>Memory:${info.memory}</li>
        <li>Type:${info.type}</li>
    </ul>

    <form action="/delete/${info.id}" method="get">
       <p><input type="submit" value=""
           style="height: 64px; width: 64px;background-image: url(/resources/remove.png);"/></p>
    </form>

    <form action="/edit/${info.id}" method="get">
        <p><input type="submit" value=""
                  style="height: 64px; width: 64px;background-image: url(/resources/edit.png);"/></p>
    </form>
</c:forEach>
</body>
</html>
