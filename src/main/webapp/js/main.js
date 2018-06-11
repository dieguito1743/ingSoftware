// JavaScript Document
$(document).ready(function() {
    timeOutSesion();
});

function timeOutSesion() {
    try {
        var url = 'login.html';
        var stored = localStorage['user'];
        if (stored) myVar = JSON.parse(stored);
        setTimeout(function() {
            localStorage.removeItem('user');
            alert('Se acabo tu sesion');
            $(location).attr('href', url);
        }, myVar.timeOut * 60000);
    } catch (e) {
        verificarSesion();
    }
}

function verificarSesion() {
    var url = "login.html";
    $(location).attr('href', url);
}