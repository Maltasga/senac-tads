window.addEventListener("load", function () {
    var btnNovo = document.querySelector("#btnNovoUsuario");
    btnNovo.addEventListener("click", function () {
        window.location = "cadastrar-usuario";
    });

    var botoesEdicao = document.querySelectorAll(".btn-editar");
    for (var i = 0; i < botoesEdicao.length; i++) {
        var btn = botoesEdicao[i];
        btn.style.cursor = "pointer";
        btn.addEventListener("click", function () {
            var id = this.getAttribute("data-id");
            window.location = "editar-usuario?q=" + id;
        });
    }

    var botoesExclusao = document.querySelectorAll(".btn-excluir");
    for (var i = 0; i < botoesExclusao.length; i++) {
        var btn = botoesExclusao[i];
        btn.style.cursor = "pointer";
        btn.addEventListener("click", function () {
            var self = this;
            if (confirm("Deseja excluir este usuário?")) {
                var id = this.getAttribute("data-id");
                var xhr = new XMLHttpRequest();
                xhr.open("post", "excluirusuario", true);
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                        self.parentElement.parentElement.remove();
                    }
                };
                xhr.send("q=" + id);
            }
        });
    }

    function filtrarPorNome() {
        var filtro = document.querySelector("#txtNomeFiltro").value;
        var linhas = document.querySelectorAll("tbody>tr");
        for (var i = 0; i < linhas.length; i++) {
            if (!filtro) {
                linhas[i].classList.remove("hide"); 
            } else {
                var nome = linhas[i].querySelector("td:first-of-type").textContent;
                if (!nome.toLowerCase().includes(filtro.toLowerCase())) {
                    linhas[i].classList.add("hide");
                } else {
                    linhas[i].classList.remove("hide");
                }
            }
        }
    }

    document.querySelector("#btnFiltrar").addEventListener("click", filtrarPorNome);
});