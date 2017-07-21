function adicionaData(data) {
    var ul = document.querySelector("ul");

    var btnRemover = document.createElement("button");
    btnRemover.textContent = "X";
    btnRemover.addEventListener("click", function () {
        var datasemformatacao = data.replace(/\//g, "");
        removeData(datasemformatacao);
    });

    var li = document.createElement("li");
    li.textContent = data;
    li.value = data;
    li.appendChild(btnRemover);

    if (colorirRepetido(data))
        li.classList.add("red");

    ul.appendChild(li);
}

function colorirRepetido(data) {
    var repetido = false;
    var itens = document.querySelectorAll("li");
    for (var i = 0; i < itens.length; i++) {
        var element = itens[i];
        if (element.textContent == data + "X") {
            element.classList.add("red");
            repetido = true;
        }
    }
    return repetido;
}

function removeData(data) {
    var ul = document.querySelector("ul");
    var li = document.querySelector("li[data='" + data + "']");
    li.remove();
}

function validar(data) {
    if (! /\d{2}\/\d{2}\/\d{4}/g.test(data))
        return false;

    var data = data.split("/").map(function (e) {
        return parseInt(e);
    });

    var dia = data[0];
    var mes = data[1];
    var ano = data[2];

    if ((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (ano < 1900))
        return false;

    return true;
}

function limparCampo() {
    var campo = document.querySelector("#txtData");
    campo.value = "";
    campo.classList.remove("invalido");
}

window.addEventListener("load", function () {
    document.querySelector("#btn").addEventListener("click", function () {
        var campo = document.querySelector("#txtData");
        if (validar(campo.value)) {
            adicionaData(campo.value);
            limparCampo();
        } else {
            campo.classList.add("invalido");
            alert("Data no formato inválido!");
        }
    });
});