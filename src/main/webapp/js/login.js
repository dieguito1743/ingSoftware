// JavaScript Document
$(document).ready(function() {
    localStorage.removeItem('user');
    localStorage.removeItem('config');
    $('#sinuse').hide();
    $('#sinpass').hide();
    $('#iru').hide();
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
    if(userVal == null  || userVal == ''){
    	$('#sinuse').show();
        $("#sinuse").fadeOut(2000);
        return;
    }
    var passVal = $('#pass').val();
    if(passVal == null  || passVal == ''){
    	$('#sinpass').show();
        $("#sinpass").fadeOut(2000);
        return;
    }
    $.ajax({
        type: "GET",
        url: '/IngSoftware/usuario/user/'+userVal+'/pass/'+passVal,
        dataType: "json",
        success: function(data) {
            var usuario = data;
            localStorage['user'] = JSON.stringify(usuario);
            obtenerConfiguracion();
        },
        error: function(data) {
            alert('error getUsuario');
        }
    });
};

function olvideMiClavePorQueSoyBruto() {
    $('#forget').click(function() {
        //alert('No Puedes Recuperar tu clave jajaja :v');
    	$('#iru').show();
        $("#iru").fadeOut(2000);
        return;
    });
}

function obtenerConfiguracion(){
	//peticion para obtener las configuracion
	//si no obtiene error setea automaticamente la configuracion
    var url = "main.html";
	$.ajax({
        type: "GET",
        url: '/IngSoftware/configuraciones',
        dataType: "json",
        success: function(data) {
            var config = data;
            localStorage['config'] = JSON.stringify(config);
            $(location).attr('href', url);
        },
        error: function(data) {
        	var numberCycle = '1';
            if (parseInt(month) > 2 && parseInt(month) < 7) {
                numberCycle = '2';
            }
            if (parseInt(month) > 6 && parseInt(month) < 13) {
                numberCycle = '0';
            }
            var cycleconfiguracionVal = dt.getFullYear() + numberCycle;
            var config = {
            		idconfiguracion : null,
            		cycleconfiguracion : cycleconfiguracionVal,
            		statusconfiguracion : 0
            };
            localStorage['config'] = JSON.stringify(config);
            $(location).attr('href', url);
        }
    });
}