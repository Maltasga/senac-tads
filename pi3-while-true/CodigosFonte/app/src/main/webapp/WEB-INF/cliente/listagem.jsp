<%-- 
    Document   : listagem
    Created on : 13/05/2017, 20:11:48
    Author     : 'Gabi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <jsp:include page="../../WEB-INF/partilals/htmlHead.jsp"></jsp:include>
            <title>Lista de Clientes</title>
        </head>
        <body>
        <jsp:include page="../../WEB-INF/partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2>
                        Clientes cadastrados
                    </h2>
                </div>
                <div class="form-group-sm form-inline">
                    <label>Filtrar por</label>
                    <input id="txtNomeFiltro" class="form-control" type="text" placeholder="Nome" />
                    <input id="btnFiltrar" type="button" class="btn btn-default" value="Filtrar" />
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>CPF</th>
                            <th>Sexo</th>
                            <th>Data de Nascimento</th>
                            <th>Data de Cadastro</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listaClientes}" var="c">
                        <tr>
                            <td><c:out value="${c.nome}"></c:out></td>
                            <td><c:out value="${c.cpf}"></c:out></td>
                            <td><c:out value="${c.sexo}"></c:out></td>
                                <td>
                                <fmt:formatDate value="${c.dataNascimento}" pattern="dd/MM/yyyy"></fmt:formatDate>
                                </td>
                                <td>
                                <fmt:formatDate value="${c.dataCadastro}" pattern="dd/MM/yyyy"></fmt:formatDate>
                                </td>
                                <td>
                                    <span class="btn-editar glyphicon glyphicon-pencil" data-id="<c:out value="${c.id}"></c:out>" title="editar"></span>
                                    &nbsp;
                                    <span class="btn-excluir glyphicon glyphicon-remove" data-id="<c:out value="${c.id}"></c:out>" title="excluir"></span>
                                </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
                <input type="button" id="btnNovoCliente" value="Novo Cliente" class="btn btn-primary" />
            </div>
        </div>  
        <jsp:include page="../../WEB-INF/partilals/scripts.jsp"></jsp:include>
            <!--        <script src="Content/lojaJs/listagem-usuario.js" type="text/javascript"></script>-->
        <jsp:include page="../../WEB-INF/partilals/scripts.jsp"></jsp:include>
        <script src="Content/lojaJs/listagem-cliente.js" type="text/javascript"></script>
    </body>
</html>