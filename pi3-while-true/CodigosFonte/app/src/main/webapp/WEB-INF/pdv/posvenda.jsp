<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>PDV - CoolWear</title>
        <jsp:include page="../partilals/htmlHead.jsp"></jsp:include>
        </head>
        <body>
            <div class="container">
                <div class="form-cadastro">
                    <h2>${msgFimVenda}</h2>
            </div>
        </div>
        <script type="text/javascript">
            window.addEventListener("load", function () {
                setTimeout(function () {
                    window.location = "venda";
                }, 2000);
            });
        </script>
    </body>
</html>