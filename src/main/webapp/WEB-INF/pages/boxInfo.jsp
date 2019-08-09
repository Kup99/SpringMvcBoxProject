<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<p>Information about box</p>

<c:forEach items="${boxInfo}" var="boxInfo">

<h4> ${boxInfo.id}</h4>
<h4> ${boxInfo.name}</h4>
<%--<h4> ${boxInfo.type}</h4>--%>
<%--<h4> ${boxInfo.memory}</h4>--%>
<%--<h4> ${boxInfo.colour}</h4>--%>
<%--<h4> ${boxInfo.weight}</h4>--%>
<h4>Добавить информацию,нажмите +</h4>
<form method="get" action="/addBoxEntity/${boxInfo.id}">
    <p><input type="submit" value=""
              style="height: 64px; width: 64px;background-image: url(/resources/add.png);"/></p>

    </c:forEach>
</body>
</html>
