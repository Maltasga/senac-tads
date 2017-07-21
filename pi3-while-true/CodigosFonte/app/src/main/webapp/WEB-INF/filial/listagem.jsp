<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <jsp:include page="../../WEB-INF/partilals/htmlHead.jsp"></jsp:include>
            <title>Lista de Filiais</title>
        </head>
        <body>
        <jsp:include page="../../WEB-INF/partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2>
                        Filiais Cadastradas
                    </h2>
                </div>
                <div class="form-group-sm form-inline">
                    <label>Filtrar por</label>
                    <input id="txtNomeFiltro" class="form-control" type="text" placeholder="Razão Social" />
                    <input id="btnFiltrar" type="button" class="btn btn-default" value="Filtrar" />
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Razão Social</th>
                            <th>CNPJ</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listaFiliais}" var="f">
                        <tr>
                            <td><c:out value="${f.nome}"></c:out></td>
                            <td><c:out value="${f.cnpj}"></c:out></td>
                            <td><c:out value="${f.ativo}"></c:out></td>
                                <td>
                                    <span class="btn-editar glyphicon glyphicon-pencil" data-id="<c:out value="${f.id}"></c:out>" title="editar"></span>
                                    &nbsp;
                                    <span class="btn-excluir glyphicon glyphicon-remove" data-id="<c:out value="${f.id}"></c:out>" title="excluir"></span>
                                </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
                <input type="button" id="btnNovaFilial" value="Nova Filial" class="btn btn-primary" />
            </div>
        </div>    
        <jsp:include page="/WEB-INF/partilals/scripts.jsp"></jsp:include>
        <script src="Content/lojaJs/listagem-filial.js" type="text/javascript"></script>
    </body>
</html>
