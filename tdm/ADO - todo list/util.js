function stringToDate(str) {
    return new Date(str.split("/").reverse())
}

function getDataStr(data) {
    var dia = "",
        mes = "",
        ano = 0;
    dia = (function (d) {
        if (d < 9) return "0" + d;
        return "" + d;
    })(data.getDate());
    mes = (function (m) {
        m += 1;
        if (m < 9) return "0" + m;
        return "" + m;
    })(data.getMonth());
    ano = data.getFullYear();
    return dia + "/" + mes + "/" + ano;
}