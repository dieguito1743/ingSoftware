// JavaScript Document
$(document).ready(function() {
	for(var i = 1; i < 9; i++){
		$('#00'+i).hide();
	}
    timeOutSesion();
    activarButtonNav();
    butonTimeOut();
    setInterval(butonTimeOut, 1500);
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

function activarButtonNav(){
	$('#buttonNav').click(function(){
		for(var i = 1; i < 9; i++){
			$('#00'+i).show();
		}
		
	});
}

function butonTimeOut(){
	try {
    	var display = $('#buttonNav').css('display');
    	if(display != 'block'){
    		for(var i = 1; i < 9; i++){
    			$('#00'+i).hide();
    		}
    	}else{
    		for(var i = 1; i < 9; i++){
    			$('#00'+i).show();
    		}
    	}
	} catch (e) {
    }
}