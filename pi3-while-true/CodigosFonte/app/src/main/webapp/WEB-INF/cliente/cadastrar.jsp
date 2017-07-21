<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../partilals/htmlHead.jsp"></jsp:include>
            <title>Cliente</title>
        </head>
        <body>
        <jsp:include page="../partilals/menu.jsp"></jsp:include>
            <div class="container form-cadastro">
                <div class="titulo">
                    <h2><c:out value="${tituloCliente}"></c:out></h2>   
                </div>
                <form method="POST">
                    <div class="form-dados">
                        <div class="form-flex">
                            <div class="form-group form-cliente">
                                <label>Nome</label>
                                <input type="text" name="cliente" required class="form-control" value="${clientetoedit.nome}" />
                        </div>

                        <div class="form-group form-cpf">
                            <label>CPF</label>
                            <input type="text" name="cpf" required class="form-control"  value="${clientetoedit.cpf}"/>
                        </div>
                    </div>

                    <div class="form-flex">
                        <div class="form-group form-cep">
                            <label>CEP</label>
                            <input type="text" name="cep" required class="form-control" value="${clientetoedit.endereco.cep}" />
                        </div>
                        <div class="form-group form-endereco">
                            <label>Endereço</label>
                            <input type="text" name="endereco" required class="form-control" value="${clientetoedit.endereco.logradouro}"/>
                        </div>
                        <div class="form-group form-complemento">
                            <label>Complemento</label>
                            <input type="text" name="complemento" class="form-control" value="${clientetoedit.endereco.complemento}" />
                        </div>
                    </div>
                    <div class="form-flex">
                        <div class="form-group form-bairro">
                            <label>Bairro</label>
                            <input type="text" name="bairro" required class="form-control" value="${clientetoedit.endereco.bairro}" />
                        </div>
                        <div class="form-group form-cidade">
                            <label>Cidade</label>
                            <input type="text" name="cidade" required class="form-control" value="${clientetoedit.endereco.cidade}" />
                        </div>                      
                        <div class="form-group form-uf">
                            <label>UF</label>
                            <select name="uf" required class="form-control" >                                
                                <option value=""></option>
                                <c:forEach items="${listaUf}" var="i">                                    
                                    <c:choose>
                                        <c:when test="${i == clientetoedit.endereco.uf}">
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
                    <div class="form-flex">
                        <div class="form-group form-sexo">
                            <label>Sexo</label>
                            <select name="sexo" required class="form-control" >
                               <option value=""></option>
                                <c:forEach items="${listaSexo}" var="i">                                    
                                    <c:choose>
                                        <c:when test="${i == clientetoedit.sexo}">
                                            <option value="${i}" selected="selected">${i}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i}">${i}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>     
                        </div>
                        <div class="form-group form-nascimento">
                            <label>Data de Nascimento</label>
                            <fmt:formatDate value="${clientetoedit.dataNascimento}" pattern="dd/MM/yyyy" var="dataFormatada"></fmt:formatDate>
                            <input type="text" name="nascimento" required class="form-control" value="${dataFormatada}" />
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
