<%@page contentType="text/html;charset = UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<link href="resources/css/base.css" rel="stylesheet" type="text/css">--%>
<%--<link href="resources/css/layout.css" rel="stylesheet" type="text/css">--%>
<%--<link href="resources/css/skeleton.css" rel="stylesheet" type="text/css">--%>
    <title>Servers</title>
</head>
<body>

<c:forEach items="${type}" var="type">
    <td>${type}</td>
    <form method="get" action="/show/${type}">
        <p><input type="submit" value=""
                  style="height: 256px; width: 256px;background-image: url(/resources/serverIndex.png);"/></p>
    </form>
</c:forEach>

    <form method="get" action="/add">
        <p><input type="submit" value=""
                  style="height: 64px; width: 64px;background-image: url(/resources/add.png);"/></p>
    </form>

</body>
</html>
