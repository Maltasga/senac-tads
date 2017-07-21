window.addEventListener("load", () => {
    let campos = {
        user: document.querySelector("#username"),
        status: document.querySelector("#status"),
        imagem: document.querySelector("#avatar")
    };

    document.querySelector("#btnLogar")
            .addEventListener("click", () => {
                let postData = "username=" + campos.user.value +
                        "&status=" + campos.status.options[campos.status.selectedIndex].value +
                        "&image=" + campos.imagem.value;

//                let jsonData = {
//                    "username": campos.user.value,
//                    "status": campos.status.options[campos.status.selectedIndex].value,
//                    "image": campos.imagem.value
//                };

                let xhr = new XMLHttpRequest();
                xhr.open("post", "Autenticar", true);
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//                xhr.setRequestHeader("Content-type", "application/json");

                xhr.onreadystatechange = function () {
                    if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                        let response = JSON.parse(xhr.responseText);
                        console.log(response);
                    }
                }

                xhr.send(postData);
            });
});