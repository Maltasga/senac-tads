
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Login</title>
    </head>
    <body>
        <h1>
            <c:choose>
                <c:when test="${agora.hours>19}">Boa noite</c:when>
                <c:when test="${agora.hours>15}">Boa tarde</c:when>
                <c:when test="${agora.hours>8}">Bom dia</c:when>
                <c:otherwise>zzz...</c:otherwise>
            </c:choose>
        </h1>
    </body>
</html>
