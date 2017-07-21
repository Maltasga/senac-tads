window.addEventListener("load", event => {
    document.querySelector("#xhr")
        .addEventListener("click", event => {
            let xhr = new XMLHttpRequest();
            xhr.open("POST", "/pessoas.json", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.onreadystatechange = function () {
                if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
                    console.log("Requisição feita por XMLHttpRequest");

                }
            }
            xhr.send("nome=gabriel&idade=29");
        });

    document.querySelector("#fetch")
        .addEventListener("click", event => {
            let formData = new FormData();
            formData.append("nome", "Gabriel");
            formData.append("idade", "29");

            fetch("/pessoas.json", { method: "POST", body: formData })
                .then(response => response.json())
                .then(p => {
                    console.log("Requisição feita por Fetch API");
                });
        });
});