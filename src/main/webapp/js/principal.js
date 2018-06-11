// JavaScript Document
$(document).ready(function() {
    cargarDatosUsuario();
});

function cargarDatosUsuario() {
    var stored = localStorage['user'];
    if (stored) myVar = JSON.parse(stored);
    $('#user').attr("value", myVar.usertype);
    $('#name').attr("value", myVar.username);
    $('#departamento').attr("value", myVar.userdependency);
}