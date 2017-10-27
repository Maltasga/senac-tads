var produtos = [];

function atualizaValorMinimo() {
    var inputvalorMinino = $("#valorMinimo");
    var txtValorMinimo = $("#txtvalorMinimo");
    txtValorMinimo.html(inputvalorMinino.val());
}

function atualizaValorMaximo() {
    var inputvalorMaximo = $("#valorMaximo");
    var txtValorMaximo = $("#txtvalorMaximo");
    txtValorMaximo.html(inputvalorMaximo.val());
}

function listarProdutos(arr) {
    var divLista = $("#listaProdutos").empty();

    if (!arr.length) {
        divLista.html("<div class='alert alert-warning'>Nenhum produto atende o critério do filtro informado</div>");
        return;
    }
    var ulProdutos = $('<ul class="list-unstyled"></ul>');
    arr.forEach(p => {
        var painel = `<div class="col-xs-12 col-sm-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">${p.nome}</h3>
                            </div>
                            <div class="panel-body">
                                <p>R$${p.preco.toFixed(2)}</p>
                                <p><a href="#${p.id}" class="btn btn-info">Detalhes</a></p>
                            </div>
                        </div>
                    </div>`;
        divLista.append(painel)
    });
}

function filtrarProdutos() {
    var min = parseFloat($("#valorMinimo").val());
    var max = parseFloat($("#valorMaximo").val());
    return produtos.filter(item => item.preco <= max && item.preco >= min);
}

$(function () {
    atualizaValorMinimo();
    atualizaValorMaximo();

    $("#valorMinimo").on("input", () => {
        atualizaValorMinimo();
        var p = filtrarProdutos();
        listarProdutos(p);
    });
    $("#valorMaximo").on("input", () => {
        atualizaValorMaximo();
        var p = filtrarProdutos();
        listarProdutos(p);
    });

    produtos = obterProdutos();

    listarProdutos(filtrarProdutos());
});



function obterProdutos() {
    //Desabilitado por problemas com requisições com cross-origin
    // $.get("produtos.json", response => {
    //     listarProdutos(response);
    // });

    return [{
            "id": 1,
            "nome": "Produto 1",
            "preco": 100.00
        },
        {
            "id": 2,
            "nome": "Produto 2",
            "preco": 200.00
        },
        {
            "id": 3,
            "nome": "Produto 3",
            "preco": 300.00
        },
        {
            "id": 4,
            "nome": "Produto 4",
            "preco": 400.00
        },
        {
            "id": 5,
            "nome": "Produto 5",
            "preco": 500.00
        },
        {
            "id": 6,
            "nome": "Produto 6",
            "preco": 600.00
        },
        {
            "id": 7,
            "nome": "Produto 7",
            "preco": 700.00
        },
        {
            "id": 8,
            "nome": "Produto 8",
            "preco": 800.00
        },
        {
            "id": 9,
            "nome": "Produto 9",
            "preco": 900.00
        },
        {
            "id": 10,
            "nome": "Produto 10",
            "preco": 1000.00
        },
        {
            "id": 11,
            "nome": "Produto 11",
            "preco": 2000.00
        },
        {
            "id": 12,
            "nome": "Produto 12",
            "preco": 3000.00
        },
        {
            "id": 13,
            "nome": "Produto 13",
            "preco": 4000.00
        },
        {
            "id": 14,
            "nome": "Produto 14",
            "preco": 5000.00
        },
        {
            "id": 15,
            "nome": "Produto 15",
            "preco": 6000.00
        },
        {
            "id": 16,
            "nome": "Produto 16",
            "preco": 7000.00
        },
        {
            "id": 17,
            "nome": "Produto 17",
            "preco": 8000.00
        },
        {
            "id": 18,
            "nome": "Produto 18",
            "preco": 9000.00
        },
        {
            "id": 19,
            "nome": "Produto 19",
            "preco": 1000.00
        },
        {
            "id": 20,
            "nome": "Produto 20",
            "preco": 1100.00
        },
        {
            "id": 21,
            "nome": "Produto 21",
            "preco": 1200.00
        },
        {
            "id": 22,
            "nome": "Produto 22",
            "preco": 1300.00
        },
        {
            "id": 23,
            "nome": "Produto 23",
            "preco": 1400.00
        },
        {
            "id": 24,
            "nome": "Produto 24",
            "preco": 1500.00
        }
    ]
}