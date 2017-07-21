function main() {
    let xhr = new XMLHttpRequest();
    xhr.open("get", "pessoas.json");
    xhr.addEventListener("load", event => {
        let response = JSON.parse(event.target.responseText);
        response.forEach(function (element) {
            imprimir(element.nome + " - " + element.idade);
        }, this);
    });
    xhr.send();
}

function imprimir(texto) {
    let p = document.createElement("p");
    p.textContent = texto;
    document.querySelector("body").appendChild(p);
}

window.addEventListener("load", main);
