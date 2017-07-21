<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="navbar navbar-default ">
    <div class="container-fluid menu">
        <div class="navbar-header">
            <a class="navbar-brand" href="home">
                <img src="Content/img/logo.png" class="logo" alt="KK CoolWear"/>
            </a>

            <ul class="nav navbar-nav navbar-left">
                <c:forEach items="${menus}" var="m">
                    <li>
                        <a href="${m.caminho}">
                            ${m.nome}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div>
            <ul class="nav navbar-nav navbar-right">
                <li class="menu-usuario">
                    <c:out value="${usuarioLogado.nome}"></c:out>
                        | 
                    <c:out value="${usuarioLogado.perfil.nome}"></c:out>
                    | 
                    <label id="logout">sair</label>
                </li>
            </ul> 
        </div>

    </div>
</div>
<script type="text/javascript">
    window.addEventListener("load", function () {
        var logout = document.querySelector("#logout");
        logout.style.cursor = "pointer";

        logout.addEventListener("click", function () {
            var form = document.createElement("form");
            form.method = "post";
            form.action = "logout";
            this.appendChild(form);
            form.submit();
        });
    });
</script>