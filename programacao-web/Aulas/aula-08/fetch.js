
window.addEventListener("load", () => {
    function imprimir(texto) {
        let p = document.createElement("p");
        p.textContent = texto;
        document.querySelector("body").appendChild(p);
    }


    document.querySelector("input[type=button]")
        .addEventListener("click", event => {
            let formData = new FormData();
            formData.append("nome", "Gabriel");
            formData.append("idade", "29");
            formData.append("email", "gmalta@sistran.com.br");
            
            fetch("/pessoas.json", { method: "POST", body: formData })
                .then(response => response.json())
                .then(p => {
                    p.forEach(element => { imprimir(element.nome + " - " + element.idade); });
                });
        });
});
