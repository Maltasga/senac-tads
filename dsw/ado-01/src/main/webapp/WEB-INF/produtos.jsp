<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set value="${pageContext.request.contextPath}" var="url"></c:set>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>KK Coolwear</title>        
            <link href="${url}/content/libs/twitter-bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${url}/content/libs/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="${url}/content/libs/twitter-bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="${url}/content/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div id="titulo">
                    <img id="logo-lg" src="${url}/content/imagens/logo-lg.png" alt="Logotipo e-commerce KK Coolwear" />
                    <img id="logo-sm" src="${url}/content/imagens/logo-sm.png" alt="Logotipo e-commerce KK Coolwear" />
                </div>
            </div>

            <div class="row">
                <div id="menu">
                    <ul>
                        <li>menu</li>
                        <li>menu</li>
                        <li>menu</li>  
                        <li>menu</li>
                    </ul>
                </div>
            </div>

            <c:forEach items="${produtos}" var="item">
                <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                    <div class="produto">
                        <center>
                            <img class="img-responsive" src="${url}/content/imagens/${item.imagem.nome}" alt="${item.imagem.alt}" />
                        </center>
                        <hr />
                        <p class="nome">${item.nome}</p>
                        <p class="descricao">${item.descricao}</p>
                        <p class="valor"><fmt:formatNumber value="${item.valor}" currencySymbol="R$ " type="currency"></fmt:formatNumber></p>
                            <div class="btn-comprar">
                                <button type="button" class="btn btn-info">Comprar</button>
                            </div>
                        </div>
                    </div>
            </c:forEach>         
        </div>
    </body>
</html>
