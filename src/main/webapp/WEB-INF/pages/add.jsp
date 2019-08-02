<%@page contentType="text/html;charset = UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="Type" class="spring.example.config.TypeValuesConfig"/>
<link href="resources/css/base.css" rel="stylesheet" type="text/css">
<link href="resources/css/layout.css" rel="stylesheet" type="text/css">
<link href="resources/css/skeleton.css" rel="stylesheet" type="text/css">

<!--[if lt IE 7 ]>
<html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]>
<html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]>
<html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en"> <!--<![endif]-->
<head>
    <!-- General Metas -->
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">    <!-- Force Latest IE rendering engine -->
    <title>Login Form</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>

    <!-- Stylesheets -->
    <link rel="stylesheet" href="../../resources/css/base.css">
    <link rel="stylesheet" href="../../resources/css/skeleton.css">
    <link rel="stylesheet" href="../../resources/css/layout.css">

</head>
<body>
<div class="container">
    <div class="form-bg">
        <form method="post" action="/add">
            <h2>Information about Server</h2>
            <p><input type="text" placeholder="Name" name="name"></p>
            <p><input type="number" placeholder="Memory" name="memory"></p>
            <p><input type="number" placeholder="ID" name="id"></p>
            <select name="type" id="type">
                <c:forEach items="${Type.values}" var="type">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </select>
            <button type="submit"></button>
        </form>
    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.js"></script>
<script>window.jQuery || document.write("<script src='../../resources/js/jquery-1.5.1.min.js'>\x3C/script>")</script>
<script src="../../resources/js/app.js"></script>
</body>
</html>