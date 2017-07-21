<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h2>Novo usuário</h2>
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
            <form method="post" action="cadastrar-usuario">
                <div class="form-dados">

                    <div class="form-flex">
                        <div class="form-group form-nome">
                            <label>Nome</label>
                            <input type="text" class="form-control" name="nome" required="required" value="${userRet.nome}" />
                        </div>
                        <div class="form-flex">
                            <div class="form-group form-email">
                                <label>Email</label>
                                <input type="email" class="form-control" name="email" required="required" value="${userRet.email}" placeholder="meuemail@kkcoolwear.com.br" />
                            </div> 
                            <div  class="form-group form-filial">
                                <label>Filial</label>
                                <select name="filial" class="form-control form-filial">
                                    <option value=""></option>
                                    <c:forEach items="${listaFilial}" var="f">
                                        <c:choose>
                                            <c:when test="${f.id == userRet.idFilial }">
                                                <option value="${f.id}" selected="selected">${f.nome}</option>                                                  
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${f.id}">${f.nome}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div  class="form-group form-filial">
                                <label>Perfil</label>
                                <select name="perfil" class="form-control form-perfil">
                                    <option value=""></option>
                                    <c:forEach items="${listaPerfil}" var="p">
                                        <c:if test="${p.id == userRet.idPerfil}">
                                            <option value="${p.id}" selected="selected">${p.nome}</option>   
                                        </c:if>
                                        <c:if test="${p.id != userRet.idPerfil}"> 
                                            <option value="${p.id}">${p.nome}</option> 
                                        </c:if>
                                    </c:forEach>
                                </select>  
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-login">
                        <label>Login</label>
                        <input type="text" class="form-control" name="login" required="required" value="${userRet.login}" />
                    </div>
                    <div class="form-flex">
                        <div class="form-group form-senha">
                            <label>Senha</label>
                            <input id="senha" type="password" class="form-control" name="senha" required="required"/>
                        </div>
                        <div class="form-group form-senha">
                            <label>Confirme sua senha</label>
                            <input type="password" name="senha" class="form-control" id="txtConfirmarSenha" required="required"/>
                        </div>
                    </div>

                </div>
                <div class="form-group text-right">
                    <input type="submit" value="Salvar" class="btn btn-primary" />
                    <input type="reset" value="Cancelar" class="btn btn-warning"/>
                </div>
            </form>
        </div>
        <script src="Content/lojaJs/form-usuario.js" type="text/javascript"></script>
    </body>
</html>