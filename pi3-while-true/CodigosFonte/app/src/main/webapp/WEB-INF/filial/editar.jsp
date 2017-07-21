<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Cadastro de Filial</title>
        <jsp:include page="../partilals/htmlHead.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="../partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2>Manutenção de filial</h2>
                </div>
            <c:if test="${erros.isEmpty()==false}">
                <div class="alert alert-danger">
                    <h4>Erros no preenchimento do formulário</h4>
                    <ul>
                            <c:forEach items="${errosEndereco}" var="item">
                                <li>${item}</li>
                                </c:forEach>
                    </ul>
                </div>
            </c:if>
            <div style="width: 70%;">
                <form method="post" action="editar-filial" class="form-dados">
                    <input type="hidden" name="id" value="${filial.id}" />
                    <div class="form-group text-justify">
                        <label>Razão Social</label>
                        <span>${filial.nome}</span>
                        <label>CNPJ</label>
                        <span>${filial.cnpj}</span>
                        <c:if test="${filial.matriz}">
                            <label for="chkAtivoMatriz">Matriz</label>
                            <span class="glyphicon glyphicon-check"></span>
                        </c:if>

                        <label>Data de Cadastro</label>
                        <span><fmt:formatDate value="${filial.dataCadastro}" pattern="dd/MM/yyyy"></fmt:formatDate></span>
                            <div class="form-group">
                                <label>Logradouro</label>
                                <input type="text" name="logradouro" class="form-control" required="required" value="${endereco.logradouro}"/>
                            <label>CEP</label>
                            <input type="text" name="cep" class="form-control" required="required" value="${endereco.cep}"/>
                        </div>
                        <div class="form-group">
                            <label>Complemento</label>
                            <input type="text" name="complemento" class="form-control" value="${endereco.complemento}"/>
                        </div>
                        <div class="form-group">
                            <label>Bairro</label>
                            <input type="text" name="bairro" class="form-control" required="required" value="${endereco.bairro}"/>
                            <label>Cidade</label>
                            <input type="text" name="cidade" class="form-control" required="required" value="${endereco.cidade}"/>
                            <label>UF</label>
                            <select name="uf" required class="form-control" >                                
                                <option value=""></option>
                                <c:forEach items="${listaUF}" var="i">                                    
                                    <c:choose>
                                        <c:when test="${i == endereco.uf}">
                                            <option value="${i}" selected="selected">${i}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i}">${i}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select> 
                        </div>
                    </div>
                    <div class="form-group text-right">
                        <input type="submit" value="Salvar" class="btn btn-primary" />
                        <a href="index.html" class="btn btn-warning">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
