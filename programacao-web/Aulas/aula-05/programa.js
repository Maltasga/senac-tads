window.addEventListener("load", function () {
    var cor = document.querySelector("#cor");

    cor.addEventListener("change", function (event) {
        console.log(this.value);

    });
});