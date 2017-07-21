<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <jsp:include page="../../WEB-INF/partilals/htmlHead.jsp"></jsp:include>
            <title>Lista de Usuários</title>
        </head>
        <body>
        <jsp:include page="../../WEB-INF/partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2>
                        Usuários cadastrados
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
                            <th>Perfil</th>
                            <th>Status</th>
                            <th>Data de Cadastro</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listaUsuarios}" var="u">
                        <tr>
                            <td><c:out value="${u.nome}"></c:out></td>
                            <td><c:out value="${u.perfil.nome}"></c:out></td>
                                <td>
                                <c:if test="${u.ativo}">
                                    Ativo
                                </c:if>
                                <c:if test="${!u.ativo}">
                                    Inativo
                                </c:if>
                            </td>
                            <td>
                                <fmt:formatDate value="${u.dataCadastro}" pattern="dd/MM/yyyy"></fmt:formatDate>
                                </td>
                                <td>
                                    <span class="btn-editar glyphicon glyphicon-pencil" data-id="<c:out value="${u.id}"></c:out>" title="editar"></span>
                                    &nbsp;
                                    <span class="btn-excluir glyphicon glyphicon-remove" data-id="<c:out value="${u.id}"></c:out>" title="excluir"></span>
                                </td>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-right">
                <input type="button" id="btnNovoUsuario" value="novo usuário" class="btn btn-primary" />
            </div>
        </div>  
        <jsp:include page="../../WEB-INF/partilals/scripts.jsp"></jsp:include>
        <script src="Content/lojaJs/listagem-usuario.js" type="text/javascript"></script>
    </body>
</html>