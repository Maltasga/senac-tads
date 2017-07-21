<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="partilals/htmlHead.jsp"></jsp:include>
            <title>Falha</title>
        </head>
        <body>
            <div class="container">
                <div class="panel">
                    <div class="panel-title">
                        <h1>Houve uma falha inesperada!</h1>
                    </div>
                    <div class="panel-body">
                    <c:if test="${msgFalha != null}">
                        <c:out value="${msgFalha}"></c:out>
                    </c:if>
                </div>
            </div>
        </div>
        <a href="home">Voltar para página inicial</a>
    </body>
</html>
