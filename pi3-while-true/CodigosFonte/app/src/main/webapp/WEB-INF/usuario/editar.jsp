<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Cadastro de Usuário</title>
        <jsp:include page="../partilals/htmlHead.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="../partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2>Manutenção de usuário</h2>
                </div>
            <c:if test="${errosValidacao.isEmpty()==false}">
                <div class="alert alert-danger">
                    <h4>Erros no preenchimento do formulário</h4>
                    <ul>
                        <c:forEach items="${errosValidacao}" var="item">
                            <li>${item}</li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>
            <div style="width: 70%;">
                <form method="post" action="editar-usuario" class="form-dados">
                    <input type="hidden" name="id" value="${usuariotoedit.id}" />
                    <div class="form-group text-justify">
                        <label>Filial</label>
                        <span>${usuariotoedit.filial.nome}</span>
                        &nbsp;|&nbsp;
                        <label>Perfil</label>
                        <span>${usuariotoedit.perfil.nome}</span>
                        &nbsp;|&nbsp;
                        <c:if test="${usuariotoedit.ativo}">
                            <span class="glyphicon glyphicon-check"></span>
                        </c:if>
                        <label for="chkAtivo">Ativo</label>
                        &nbsp;|&nbsp;
                        <label>Data de Cadastro</label>
                        <span><fmt:formatDate value="${usuariotoedit.dataCadastro}" pattern="dd/MM/yyyy"></fmt:formatDate></span>
                        </div>
                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" class="form-control" name="nome" required="required" value="${usuariotoedit.nome}"/>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" required="required" value="${usuariotoedit.email}" />
                    </div>
                    <div class="form-group">
                        <label>Login</label>
                        <input type="text" class="form-control" name="login" readonly="readonly" value="${usuariotoedit.login}"/>
                    </div>
                    <div class="form-group">
                        <label>Senha</label>
                        <input type="password" class="form-control" name="senha" required="required"/>
                    </div>
                    <div class="form-group">
                        <label>Confirme sua senha</label>
                        <input type="password" class="form-control" id="txtConfirmarSenha" required="required"/>
                    </div>
                    <div class="form-group text-right">
                        <input type="submit" value="Salvar" class="btn btn-primary" />
                        <input type="reset" value="Cancelar" class="btn btn-warning"/>
                    </div>
                </form>
            </div>
        </div>
        <script src="Content/lojaJs/form-usuario.js" type="text/javascript"></script>
    </body>
</html>