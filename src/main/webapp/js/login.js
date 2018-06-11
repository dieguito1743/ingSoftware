// JavaScript Document
$(document).ready(function() {
    localStorage.removeItem('user');
    eventoBoton();
    olvideMiClavePorQueSoyBruto();
});

function eventoBoton() {
    $('#iniciar').click(function() {
        iniciarSesion();
    });
    $('#user').keypress(function(e) {
        if (e.which == 13) {
            $("#pass").focus();
        }
    });
    $('#pass').keypress(function(e) {
        if (e.which == 13) {
            iniciarSesion();
        }
    });
}

function iniciarSesion() {
    var userVal = $('#user').val();
    var passVal = $('#pass').val();
    var url = "main.html";
    $.ajax({
        type: "GET",
        url: '/IngSoftware/usuario/user/'+userVal+'/pass/'+passVal,
        dataType: "json",
        success: function(data) {
            var usuario = data;
            localStorage['user'] = JSON.stringify(usuario);
            $(location).attr('href', url);
        },
        error: function(data) {
            alert('error getUsuario');
        }
    });
};

function olvideMiClavePorQueSoyBruto() {
    $('#forget').click(function() {
        alert('No Puedes Recuperar tu clave jajaja :v');
    });
}