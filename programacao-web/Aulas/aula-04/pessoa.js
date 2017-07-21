function Pessoa(nome, sobrenome, idade, cpf, rg) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.idade = idade;
    this.cpf = cpf;
    this.rg = rg;
    this.filhos = [];
    this.adota = function (filho) { this.filhos.push(filho); }
    this.desenhar = function () {
        var body = document.querySelector("body");
        for (var i in this) {
            if (!/function|object/i.test(typeof(this[i]))) {
                var paragrafo = document.createElement("p");
                var label = document.createElement("b")
                var texto = document.createElement("span")
                label.innerText = i;
                texto.innerText = ": " + this[i];
                paragrafo.appendChild(label);
                paragrafo.appendChild(texto);
                body.appendChild(paragrafo);
                var linha = document.createElement("hr");
            }
        }
        body.appendChild(linha);
    }

    this.desenhar();
}

var joao = new Pessoa("João", "zinho", 29, "333.000.888-99", "00.222.111-0");
var maria = new Pessoa("Maria", "zinha", 29, "333.000.888-99", "00.222.111-0");
var julia = new Pessoa("Julia", "zinha", 29, "333.000.888-99", "00.222.111-0");
var ze = new Pessoa("Zé", "zinho", 29, "333.000.888-99", "00.222.111-0");
var victor = new Pessoa("Victor", "zinho", 29, "333.000.888-99", "00.222.111-0");

joao.adota(maria);
joao.adota(julia);

julia.adota(ze);
julia.adota(victor);