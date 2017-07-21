<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat JSP</title>
        <link href="Content/estilo.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <h1>Chat JSP</h1>
            <div class="chat">
                <c:forEach items="${conversa}" var="conv">
                    <div class="linha-mensagem">
                        (<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${conv.data}"></fmt:formatDate>) <b>${conv.usuario.nome}</b>: ${conv.conteudo}
                    </div>
                </c:forEach>
            </div>
            <div class="formulario">
                <form method="post" action="bate-papo">
                    <div class="label">
                        <label>Mensagem</label>
                    </div>
                    <input type="text" class="campo" name="mensagem" required="required" />
                    <input type="submit" class="btn-submit" value="Enviar" />
                </form>
            </div>
        </div>
        <script src="Content/programa.js" type="text/javascript"></script>
    </body>
</html>
