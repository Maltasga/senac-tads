<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../partilals/htmlHead.jsp"></jsp:include>
            <title>Coleção</title>
        </head>
        <body>
        <jsp:include page="../partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2><c:out value="${tituloColecao}"></c:out></h2>     
                </div>
                <form method="POST">
                    <div class="form-dados">
                        <div  class="form-group form-colecao">
                            <label>Nome da Coleção</label>
                            <input type="text" required name="colecao" class="form-control" placeholder="Nome da Coleção" value="${colecaotoedit.nome}">
                    </div>

                    <div class="form-flex">
                        <div class="form-group form-periodo">
                            <label>Periodo</label>
                            <select name="periodo" class="form-control" required >
                                <option value=""></option>
                                <c:forEach items="${listaPeriodo}" var="i">                                    
                                    <c:choose>
                                        <c:when test="${i == colecaotoedit.periodo}">
                                            <option value="${i}" selected="selected">${i}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i}">${i}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>                      
                            </select>
                        </div>
                        <div class="form-group form-ano">
                            <label>Ano</label>
                            <select name="ano" class="form-control" required >
                                <option value=""></option>
                                <c:forEach items="${listaAno}" var="i">                                    
                                    <c:choose>
                                        <c:when test="${i == colecaotoedit.ano}">
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
                    <div id="actions" class="row form-group">
                        <div class="form-botoes">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                            <a href="index.html" class="btn btn-warning">Cancelar</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!--            <footer>
        <jsp:include page="/WEB-INF/partilals/rodape.jsp"></jsp:include>
    </footer>-->
    </body>
</html>
