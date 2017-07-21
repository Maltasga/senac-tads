<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>PDV - CoolWear</title>
        <jsp:include page="../partilals/htmlHead.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="../partilals/menu.jsp"></jsp:include>
        <div class="container">
            <div class="form-cadastro">
                <div class="titulo">
                    <p>Identificar cliente</p>
                </div>
                <form method="post" action="venda" class="form-group">
                    <div class="form-group col-md-8">
                        <label>CPF</label>
                        <div class="form-inline">
                            <input type="text" name="cpf" class="form-control" required="required"/>
                            <input type="submit" value="Buscar" class="btn btn-primary" />
                            <input type="button" id="btnNovoCliente" class="btn btn-default" value="Cadastrar novo cliente" />
                        </div>
                    </div>
                </form>
                <c:if test="${msgErro != null}">
                    <div class="col-md-10 alert alert-warning">
                        <c:out value="${msgErro}"></c:out>
                    </div>
                </c:if>
            </div>
        </div>
        <script type="text/javascript">
            window.addEventListener("load",function(){
                document.querySelector("#btnNovoCliente").addEventListener("click", function(){
                    window.location = "cadastrar-cliente";
                })
            })
        </script>
    </body>
</html>
