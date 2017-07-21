window.addEventListener("load", function () {
    var t = 10;
    setTimeout(function () {
        fetch("getChat", {method: "post"}, function (response) {
            // todo...
        });
    }, 1000);
});