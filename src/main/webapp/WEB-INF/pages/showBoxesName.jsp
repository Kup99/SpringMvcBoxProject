<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>name</title>
</head>
<body>
<c:forEach items="${info}" var="info">
    <h4>${info.name}</h4>
    <form action="/showName/${info.id}" method="get">
        <p><input type="submit" value=""
                  style="height: 64px; width: 53px;background-image: url(/resources/server-alt.png);"/></p>
    </form>
</c:forEach>
</body>
</html>
