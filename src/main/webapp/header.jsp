<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="author" content="Русяев Максим" />
    <meta charset="UTF-8">
    <title>The Witcher</title>
    <link href="${pageContext.request.contextPath}/resources/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/my.js"></script>
    <script>
        function restart() {
            $.ajax({
                url: '/restart',
                type: 'POST',
                contentType: 'application/json;charset=UTF-8',
                async: false,
                success: function() {
                    window.location.href = "/";
                }
            });
        }
    </script>
    <link href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">

</head>
<body>
<div class="wrapper">
    <header id="header">
        <h1>The Witcher</h1>
    </header>