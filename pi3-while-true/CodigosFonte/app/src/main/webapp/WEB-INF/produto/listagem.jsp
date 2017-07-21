<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <jsp:include page="../../WEB-INF/partilals/htmlHead.jsp"></jsp:include>
            <title>Lista de Produtos</title>
        </head>
        <body>
        <jsp:include page="../../WEB-INF/partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2>
                        Produtos Cadastrados
                    </h2>
                </div>
                <div class="form-group-sm form-inline">
                    <label>Filtrar por</label>
                    <input id="txtNomeFiltro" class="form-control" type="text" placeholder="Nome do Produto" />
                    <input id="btnFiltrar" type="button" class="btn btn-default" value="Filtrar" />
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nome</th>
                            <th>Tipo</th>
                            <th>Cor</th>
                            <th>Valor de Venda</th>
                        </tr>                   
                    </thead>
                    <tbody>
                    <c:forEach items="${listaProdutos}" var="p">
                        <tr>
                            <td><c:out value="${p.codigo}"></c:out></td>
                            <td><c:out value="${p.nome}"></c:out></td>
                            <td><c:out value="${p.tipo}"></c:out></td>
                            <td><c:out value="${p.cor}"></c:out></td>
                            <td><c:out value="${p.valorVenda}"></c:out></td>
                                <td>
                                    <span class="btn-estoque glyphicon glyphicon-list-alt" data-id="<c:out value="${p.id}"></c:out>" title="estoque"></span>
                                    &nbsp;
                                    <span class="btn-editar glyphicon glyphicon-pencil" data-id="<c:out value="${p.id}"></c:out>" title="editar"></span>
                                    &nbsp;
                                    <span class="btn-excluir glyphicon glyphicon-remove" data-id="<c:out value="${p.id}"></c:out>" title="excluir"></span>
                                </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
                <input type="button" id="btnNovoProduto" value="Novo Produto" class="btn btn-primary" />
            </div>
        </div>
        <jsp:include page="/WEB-INF/partilals/scripts.jsp"></jsp:include>
        <script src="Content/lojaJs/listagem-produto.js" type="text/javascript"></script>
    </body>
</html>
