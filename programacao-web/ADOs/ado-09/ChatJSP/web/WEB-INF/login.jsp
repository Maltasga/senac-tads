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
            <h1>Bem vindo ao Chat JSP</h1>
            <div class="formulario">
                <form method="post" action="login">
                    <div class="label">
                        <label>Apelido</label>
                    </div>
                    <input class="campo" name="usuario" type="text" required="required" />
                    <input class="btn-submit" type="submit" value="Entrar" />
                </form>
            </div>
        </div>
    </body>
</html>
