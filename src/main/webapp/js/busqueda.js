/**
 * 
 */
$(document).ready(function() {
    $('#sinresult').hide();
    eventoBoton();
});

function eventoBoton() {
    $('#profesor').focusin(function(e) {
    	$('#curso').attr('disabled','disabled');
    });
    $('#profesor').focusout(function(e) {
    	var contador = 0;
    	$('#buscar').click(function() {
    		contador = 1;
            buscar();
        });
    	setTimeout(function(){
    		if(contador == 0){
        		$('#curso').removeAttr('disabled');
        	}
    	}, 150);
    	
    });
    $('#curso').focusin(function(e) {
    	$('#profesor').attr('disabled','disabled');
    });
    $('#curso').focusout(function(e) {
    	var contador = 0;
    	$('#buscar').click(function() {
    		contador = 1;
            buscar();
        });
    	setTimeout(function(){
    		if(contador == 0){
        		$('#profesor').removeAttr('disabled');
        	}
    	}, 250);
    });
}

function buscar(){
	var atributo1 = $('#profesor').attr('disabled');
	var atributo2 = $('#curso').attr('disabled');
	console.log( atributo1 + '  ' + atributo2);
	if(atributo1 == 'disabled' && atributo2 == undefined){
		buscaajax($('#curso').val(),2);
	}
	if(atributo2 == 'disabled' && atributo1 == undefined){
		buscaajax($('#profesor').val(),1);
	}
	$('#profesor').removeAttr('disabled');
	$('#curso').removeAttr('disabled');
	$('#curso').val('');
	$('#profesor').val('');
}

function buscaajax(valor, tipo){
	if(tipo == 2){
		console.log('curso buscado '+valor);
		$('#curso').val('');
	}
	if(tipo == 1){
		console.log('profesor buscado '+valor);
		$('#profesor').val('');
	}
}

