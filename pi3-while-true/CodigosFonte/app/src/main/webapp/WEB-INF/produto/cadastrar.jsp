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
                <form method="POST" action="cadastrar-produto">
                    <div class="form-dados">
                        <div class="form-flex">
                            <div class="form-group form-codigo">
                                <label>Cód.Produto</label>
                                <input type="text" required name="codigo" class="form-control" required>
                            </div>

                            <div  class="form-group form-produto">
                                <label>Nome do Produto</label>
                                <input pattern="[a-zA-Z]+" type="text" name="produto" class="form-control" required>
                            </div>

                            <div class="form-group form-descricao">
                                <label>Descrição</label>
                                <input type="text"  name="descricao" class="form-control" >
                            </div>
                        </div>
                        <div class="form-combos">
                            <div class="form-group form-comboColecao">
                                <label>Coleção</label>
                                <select name="colecao" required class="form-control" >
                                    <option value=""></option>                                 
                                <c:forEach items="${listaColecoes}" var="c">
                                    <option value="${c.id}">${c.nome}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group form-tipo">
                            <label>Tipo</label>
                            <select name="tipo" required class="form-control" >
                                <option value=""></option>
                                <c:forEach items="${listaTipos}" var="t">
                                    <option value="${t}">${t}</option>
                            </c:forEach>                      
                        </select>
                    </div>

                    <div class="form-group form-cor">
                        <label>Cor</label>
                        <select name="cor" required class="form-control" required >
                            <option value=""></option>
                            <c:forEach items="${listaCores}" var="cr">
                                <option value="${cr}">${cr}</option>
                            </c:forEach>                         
                        </select>
                    </div>
                </div>

                <div class="form-valor">
                    <div  class="form-group form-valor-item">
                        <label>Valor de Produção</label>
                        <input type="text" pattern="[0-9]+([\.,][0-9]+)?" name="valorProducao" required class="form-control">
                    </div>

                    <div  class="form-group form-valor-item">
                        <label>Valor de Venda</label>
                        <input type="text" pattern="[0-9]+([\.,][0-9]+)?" name="valorVenda" required class="form-control">
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
