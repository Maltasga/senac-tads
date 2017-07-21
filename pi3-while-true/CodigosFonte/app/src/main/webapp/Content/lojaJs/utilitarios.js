function xhrRequest(url, method, callback, data) {
    var xhr = new XMLHttpRequest();
    xhr.open(method, url, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            if (typeof callback === "function")
                callback(xhr.responseText);
        }
    }
    if (data) {
        xhr.send(data);
    } else {
        xhr.send();
    }
}