<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Produto</title>
        <jsp:include page="../partilals/htmlHead.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="../partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2><c:out value="${tituloProduto}"></c:out></h2>   
                </div>
                <form method="POST" action="editar-produto" class="form-dados">
                    <input type="hidden" name="id" value="${produtoid.id}" />
                    <div class="form-dados">
                        <div class="form-flex">
                            <div class="form-group form-codigo">
                                <label>Cód.Produto</label>
                                <input type="text" name="codigo" class="form-control" value="${produtotoedit.codigo}" readonly>
                        </div>

                        <div  class="form-group form-produto">
                            <label>Nome do Produto</label>
                            <input pattern="[a-zA-Z]+" type="text" name="produto" class="form-control" value="${produtotoedit.nome}" required>
                        </div>

                        <div class="form-group form-descricao">
                            <label>Descrição</label>
                            <input type="text"  name="descricao" class="form-control" value="${produtotoedit.descricao}" >
                        </div>
                    </div>
                    <div class="form-combos">
                        <div class="form-group form-comboColecao">
                            <label>Coleção</label>
                            <select name="colecao" disabled  class="form-control" >
                                <c:forEach items="${listaColecoes}" var="c">
                                    <c:choose>
                                        <c:when test="${c.id == produtotoedit.colecao.id}">
                                            <option value="${c.id}">${c.nome}</option>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>                                
                            </select>
                        </div>

                        <div class="form-group form-tipo">
                            <label>Tipo</label>
                            <select name="tipo" disabled class="form-control" >
                                <option value="${produtotoedit.tipo}">${produtotoedit.tipo}</option>                   
                            </select>
                        </div>

                        <div class="form-group form-cor">
                            <label>Cor</label>
                            <select name="cor" disabled class="form-control" required >
                                <option value="${produtotoedit.cor}}">${produtotoedit.cor}</option>                      
                            </select>
                        </div>
                    </div>

                    <div class="form-valor">
                        <div  class="form-group form-valor-item">
                            <label>Valor de Produção</label>
                            <input type="text" pattern="[0-9]+([\.,][0-9]+)?" name="valorProducao" required class="form-control" value="${produtotoedit.valorProducao}">
                        </div>

                        <div  class="form-group form-valor-item">
                            <label>Valor de Venda</label>
                            <input type="text" pattern="[0-9]+([\.,][0-9]+)?" name="valorVenda" required class="form-control" value="${produtotoedit.valorVenda}">
                        </div>
                    </div>
                </div>
                <div id="actions" class="form-group">
                    <div class="form-botoes">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                        <a href="index.html" class="btn btn-warning">Cancelar</a>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
