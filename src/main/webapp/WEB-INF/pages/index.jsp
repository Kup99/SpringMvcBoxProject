<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>boxes</title>
</head>
<body>



<c:forEach items="${boxes}" var="boxes">
    <td>${boxes.name}</td>

    <form method="get" action="/getBoxEntity/${boxes.id}">
    <p><input type="submit" value=""
              style="height: 256px; width: 256px;background-image: url(/resources/serverIndex.png);"/></p>
    </form>
</c:forEach>




<form method="get" action="/addBox">
    <p><input type="submit" value=""
              style="height: 64px; width: 64px;background-image: url(/resources/add.png);"/></p>
</form>
</body>
</html>
