"use strict";

$(function () {
    $("#btnCarregarTodos").on("click", function () {
        $.get("http://localhost:5002/customers",
            response => {
                debugger;
                if (typeof (response) === "string")
                    response = JSON.parse(response);

                let lista = $("#lista tbody").html("");
                for (let i = 0; i < response.length; i++) {
                    const item = response[i];
                    let tdId = createTd(item.CustomerId);
                    lista.append(tdId);
                    let tdName = createTd(`${item.FirstName} ${item.LastName}`);
                    lista.append(tdName);
                    let tdCountry = createTd(item.Country);
                    lista.append(tdCountry);

                    let link = document.createElement("a");
                    link.className += "link-detalhe";
                    link.setAttribute("cutomerid", item.CustomerId);
                    link.textContent = "detalhe";
                    link.href = "#";
                    let tdDetails = createTd(link);
                    lista.append(tdDetails);
                }
            });
    });

    $(".link-detalhe").on("click", function () {
        let self = $(this);
        let customerId = self.attr("customerid");

        $.get("http://localhost:5002/customers/" + customerId, response => {
            debugger;
            if (typeof (response) === "string")
                response = JSON.parse(response);

            modal.show(response[0]);

        });
    })

    function createTd(value) {
        let td = document.createElement("td");

        if (typeof (value === "object")) {
            td.appendChild(value);
        } else if (value) {
            td.textContent = value;
        }
        return td;
    }

    let modal = {
        show(item) {
            _fill(item);
            $("#modal").show();
        },
        hide() {
            $("#modal").html("").hide();
        },
        _fill(item) {
            let self = $("#modal");
            self.append(`<h1>Customer: ${item.FirstName} ${item.LastName}</h1>`);
            self.append(`<p>Company ${item.Company}</p>`);
            self.append(`<p>${item.Address}, ${item.City}/${item.State} - ${item.Country}</p>`);
            self.append(`<p>Phone ${item.Phone} - E-mail ${item.Email}</p>`);
            var linkFechar = document.createElement("a");
            linkFechar.textContent = "Fechar";
            linkFechar.href = "javascript:void(0);";
            linkFechar.addEventListener("click", function () {
                modal.hide();
            });
            var div = document.createElement("div");
            div.style.textAlign = "center";
            div.appendChild(linkFechar);
            self.append(div);
        }
    };

    // inicializar a modal invisível
    modal.hide();
});