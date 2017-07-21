window.addEventListener("load", event => {
    let pessoas = [
        { nome: "Alan", idade: 39 },
        { nome: "Filipe", idade: 27 },
        { nome: "Natasha", idade: 31 },
        { nome: "Natalia", idade: 26 },
        { nome: "Joaquim", idade: 56 },
        { nome: "Nelson", idade: 48 },
    ];

    function imprimePessoas(lista) {
        let container = document.querySelector("#lista");
        let ul, li;

        container.innerHTML = "";
        ul = document.createElement("ul");
        lista.forEach(e => {
            if (e) {
                li = document.createElement("li");
                li.textContent = e.nome + " | " + e.idade + " anos";
                ul.appendChild(li);
            }
        }, this);

        container.appendChild(ul);
    }

    document.querySelector("input[type=button]")
        .addEventListener("click", event => {
            let busca = document.querySelector("#nome").value;
            let listaFiltradas = pessoas.map(e => {
                if (e.nome.indexOf(busca) > -1) {
                    return {
                        nome: e.nome,
                        idade: e.idade
                    };
                }
            });
            if (listaFiltradas.length) {
                imprimePessoas(listaFiltradas);
            } else { imprimePessoas(pessoas); }
        });

    imprimePessoas(pessoas);
});