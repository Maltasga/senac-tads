function toggleFiltroCategoria(event, nomeCategoria) {
    if (event.classList.contains("ligado")) {
        event.classList.remove("ligado");
        var filmes = document.querySelectorAll(".container-filme");
        for (var i = 0; i < filmes.length; i++) {
            filmes[i].classList.remove("desligado");
            filmes[i].classList.remove("bg-" + nomeCategoria);
            filmes[i].classList.add("bg-padrao");
        }
    } else {
        _desligarFiltros();
        _toggleFilmes();
        event.classList.add("ligado");
        var filmes = document.querySelectorAll(".container-filme + ." + nomeCategoria);
        for (var i = 0; i < filmes.length; i++) {
            filmes[i].classList.remove("desligado");
            filmes[i].classList.remove("bg-padrao");
            filmes[i].classList.toggle("bg-" + nomeCategoria);
        }
    }

    function _desligarFiltros() {
        var botoes = document.querySelectorAll("span.categoria");
        for (var i = 0; i < botoes.length; i++) {
            botoes[i].classList.remove("ligado");
        }
    }

    function _toggleFilmes() {
        var filmes = document.querySelectorAll(".container-filme");
        for (var i = 0; i < filmes.length; i++) {
            filmes[i].classList.remove("bg-aventura", "bg-scifi", "bg-comedia", "bg-romance", "bg-drama");
            filmes[i].classList.add("desligado", "bg-padrao");
        }
    }
}