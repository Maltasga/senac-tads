<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>While True</title>
        <link href="Content/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Content/css/estilo.css" rel="stylesheet" type="text/css"/>  
        <link href="Content/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-login">

            <div class="text-center">
                <label>Autentique-se</label>
            </div>
            <form action="login" method="post">
                <div class="form-group">
                    <label>Usuário</label>
                    <input type="text" name="usuario" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Senha</label>
                    <input type="password" name="senha" class="form-control" />
                </div>
                <div class="text-right">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </form>
            <c:if test="${msgFalhaLogin != null}">
                <div class="alert alert-danger msgFalha">
                    <c:out value="${msgFalhaLogin}"></c:out>
                    </div>
            </c:if>
        </div>
    </body>
</html>
