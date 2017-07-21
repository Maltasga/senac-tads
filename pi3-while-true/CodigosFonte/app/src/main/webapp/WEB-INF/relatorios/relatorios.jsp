<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <jsp:include page="../../WEB-INF/partilals/htmlHead.jsp"></jsp:include>
            <title>Relatórios</title>
        </head>
        <body>
        <jsp:include page="../../WEB-INF/partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <h2 class="titulo">Relatórios de Vendas</h2>        
                <form method="POST" action="rel-vendas-geral">
                    <div class="form-flex">
                        <div class="form-group">
                            <label>Filial</label>
                        <c:choose>
                            <c:when test="${filialAtiva.id != 1}">
                                <select name="filial" class="form-control">
                                    <option value="${filialAtiva.id}" selected="selected" >${filialAtiva.nome}</option>  
                                </select>
                            </c:when>
                            <c:otherwise>
                                <select name="filial" class="form-control">
                                    <option value="0">Todas as Filiais</option>
                                    <c:forEach items="${listaFiliais}" var="f">
                                        <option value="${f.id}">${f.nome}</option>
                                    </c:forEach>
                                </select>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="form-group">
                        <label>Período</label>
                        <select name="periodo" class="form-control">
                            <c:forEach items="${periodo}" var="p">
                                <option value="${p}">${p}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btns btn btn-info">Gerar</button>
                </div>
            </form>
            <div class="form-group ">
                <p><label>Período:</label> <c:out value="${periodoSelecionado}"></c:out></p>
                <p><label>Filial:</label> <c:out value="${nomeFilial}"></c:out></p>
                </div>

            <fmt:setLocale value="pt_BR" />
            <p>Total de Vendas no período: <label><fmt:formatNumber value="${totalVendas}" type="currency"></fmt:formatNumber></label></p>
                <div style="height: 200px; overflow: scroll; border-top: 1px dotted black;">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Filial</th>
                                <th>Data da venda</th>
                                <th>Vendedor</th>
                                <th>Valor total</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaVendas}" var="v">
                            <tr>
                                <td><c:out value="${v.nome}"></c:out></td>
                                <td><fmt:formatDate value="${v.dataVenda}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                                <td><c:out value="${v.vendedor}"></c:out></td>
                                    <td>
                                    <fmt:setLocale value="pt_BR" />
                                    <fmt:formatNumber value="${v.valorTotal}" type="currency"></fmt:formatNumber>
                                    </td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
