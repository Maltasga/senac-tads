<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <jsp:include page="../../WEB-INF/partilals/htmlHead.jsp"></jsp:include>
            <title>Estoque</title>
        </head>
        <body>
        <jsp:include page="../../WEB-INF/partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2>Estoque</h2>   
                </div>
                <form method="POST" action="estoque">
                    <input type="hidden" name="id" value="${id}" />
                <div class="form-dados">
                    <div class="form-flex">
                        <div  class="form-group form-codigo">
                            <p><label>Cód.Produto: </label> <c:out value="${produto.codigo}"></c:out></div>
                        </div>
                        <div class="form-group form-produto">
                            <p><label>Nome do Produto: </label> <c:out value="${produto.nome}"></c:out></p>
                        </div>
                    </div>
                    <div class="form-flex">
                        <div  class="form-group form-filial">
                            <label>Filial</label>
                            <select name="filial" class="form-control form-filial">
                                <option value=""></option>
                            <c:forEach items="${listaFilial}" var="f">
                                <c:choose>
                                    <c:when test="${f.id == filialEstoque}">
                                        <option value="${f.id}" selected="selected">${f.nome}</option>                                                  
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${f.id}">${f.nome}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group form-quantidade">
                        <label>Quantidade</label>
                        <input type="number" step="1" name="quantidade" required class="form-control" />
                    </div>
                    <div  class="form-group form-tamanho">
                        <label>Tamanho</label>
                        <select name="tamanho" class="form-control form-filial">
                            <option value=""></option>
                            <c:forEach items="${tamanhos}" var="t">
                                <option value="${t}">${t}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div id="actions" class="form-group">
                    <div class="form-botoes">
                        <button type="submit" class="btn btn-primary">Enviar</button>
                        <button class="btn btn-warning">Voltar</button>
                    </div>
                </div>
            </form>
        </div>
        <jsp:include page="/WEB-INF/partilals/scripts.jsp"></jsp:include>
        <script src="Content/lojaJs/estoque.js" type="text/javascript"></script>
    </body>
</html>
