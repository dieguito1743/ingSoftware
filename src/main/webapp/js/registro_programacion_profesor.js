// JavaScript Document
$(document).ready(function () {
    var contat;
    setContador(0);
    getContador()
    getPrograma();
    getPlan();
    getCurso();
    setInit();
    registrarProgramacion_profesor();
    verProgramacion();
});

function setContador(contador) {
    this.contat = contador;
}

function getContador() {
    return this.contat;
}

function getPrograma() {
    $.ajax({
        type: "GET",
        url: '/IngSoftware/cursos/programas',
        dataType: "json",
        success: function (data) {
            var programa = data;
            $("#programa").append('<option value="-1" selected>Escoja Programa</option>');
            $.each(programa, function (key, registro) {
                $("#programa").append('<option value=' + registro.programcurso + '>' + registro.programcurso + '</option>');
            });
        },
        error: function (data) {
            alert('error getPrograma');
        }
    });
}

function getPlan() {
    $("#programa").change(function () {
        var valor = $('select[id=programa]').val();
        $("#plan").empty()
        $("#cuerpo").empty()
        $.ajax({
            type: "GET",
            url: '/IngSoftware/cursos/planes/' + valor,
            dataType: "json",
            success: function (data) {
                var plan = data
                if (plan == null) {
                } else {
                    $("#plan").append('<option value="-1" selected>Escoja Plan</option>');
                    $.each(plan, function (key, registro) {
                        $("#plan").append('<option value=' + registro.plancurso + '>' + registro.plancurso + '</option>');
                    });
                }
            },
            error: function (data) {
                //alert('error getPlan');
            }
        });
    });
}

function getCurso() {
    $("#plan").change(function () {
        var plan = $('select[id=plan]').val();
        var programa = $('select[id=programa]').val();
        $("#cuerpo").empty()
        $.ajax({
            type: "GET",
            url: '/IngSoftware/cursos/programa/' + programa + '/plan/' + plan,
            dataType: "json",
            success: function (data) {
                var cursos = data
                var contador = 1;
                if (cursos == null) {
                	$('#resultadoOK2').show();
    				$('#resultadoOK2').fadeOut(2500);
                } else if(cursos == undefined){
                	$('#resultadoOK2').show();
    				$('#resultadoOK2').fadeOut(2500);
                }else if(cursos.length > 0){
                	var semboll = 0;
                    $.each(cursos, function (key, registro) {
                        $.ajax({
                            type: "GET",
                            url: '/IngSoftware/programaciones/curso/' + registro.idcurso,
                            dataType: "json",
                            success: function (data) {
                                if (data.idcurso == registro.idcurso && data.idprofesor == 0) {
                                    var string1 = '<div class="form-inline" id="cuerpo' + contador + '">';
                                    var string2 = '<input class="form-control" style="width:25%;font-size:8px;text-align: left;" type="text" disabled id="' + data.idprogramacion + '" value="' + registro.namecurso + '" title="' + registro.namecurso + '"/>';
                                    var string3 = '<input type="text" disabled id="profesor' + contador + '" class="form-control" style="width:25%;font-size:8px;text-align: left;" />';
                                    var string4 = '<button value="profesor" id="selprof' + contador + '" onclick="elegirProfesor(' + registro.idcurso + ',' + contador + ')" title="buscar profesor" class="btn btn-default" >P</button>';
                                    var string5 = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                                    var string6 = '<input class="checkbox" type="checkbox" id="fucionpc' + contador + '" disabled />';
                                    var string7 = '</div>';
                                    var string8 = '<div id="dialog' + contador + '" title="Profesores" style="display:none;font-size:8px;"></div>';
                                    var stringfinal = string1 + string2 + string3 + string4 + string5 + string6 + string7 + string8;
                                    $('#cuerpo').append(stringfinal);
                                    $('#cuerpo').show();
                                    contador = contador + 1;
                                    setContador(contador);
                                    semboll = 1;
                                }
                            },
                            error: function (data) {
                            }
                        });
                    });
                    setTimeout(function(){ if(semboll == 0){
    					$('#resultadoOK2').show();
    					$('#resultadoOK2').fadeOut(2500);
    				}}, 600);
                }
            },
            error: function (data) {
                alert('error getCurso');
            }
        });
    });
}

function setInit() {
	$('#infoprogramacion').hide();
    $('#resultadoOK').hide();
    $('#resultadoOK2').hide();
    $('#resultadoFAIL').hide();
    $("#plan").change(function () {
        var plan = $('select[id=plan]').val();
        var programa = $('select[id=programa]').val();
        if (plan == "-1") {
            $("#cuerpo").empty()
        }
    });
    $('#programa').change(function () {
        var programa = $('select[id=programa]').val();
        if (programa == "-1") {
            $('#plan').empty()
            $('#cuerpo').empty()
        }
    });
}

function elegirProfesor(idcur, contador) {
    obtenerProfesorDelCurso(idcur, contador);
}

function abrirPopup(contador) {
    $(function () {
        $('#dialog' + contador).dialog({ autoOpen: false });
        $('#dialog' + contador).dialog('option', 'width', 550);
        $('#dialog' + contador).dialog('option', 'height', 350);
        $('#dialog' + contador).show();
        $('#dialog' + contador).dialog('open');
    });
}

function obtenerProfesorDelCurso(idcurso, contador) {
	$('#selprof' + contador).attr("disabled", true);
    $("#dialog" + contador).empty();
    var String1 = '<div id="titulo'+contador+'" class="row"><div class="col-md-4" style="font-size:8px;text-align: center;">Prof. Dispon. c/ Prefe</div><div class="col-md-4" style="font-size:8px;text-align: center;">Prof. SDIsp. c/ Prefe</div><div class="col-md-4" style="font-size:8px;text-align: center;">Prof. Otros</div></div>';
    $("#dialog" + contador).append(String1);
    var String2 = '<div class="row" id="conten'+contador+'"><div class="col-md-4" id="columna1'+contador+'"> </div><div class="col-md-4" id="columna2'+contador+'"> </div><div class="col-md-4" id="columna3'+contador+'"> </div></div>';
    $("#dialog" + contador).append(String2);
    llenarPDN(idcurso, contador);
    llenarPDP(idcurso, contador);//profesores con disponibilidad por preferencia de cursos
    setTimeout(function(){ abrirPopup(contador);$('#selprof' + contador).attr("disabled", false);}, 15000);
}

function llenarPDP(idcurso, contador) {
    $.ajax({
        type: "GET",
        url: '/IngSoftware/preferencias_cursos_profesores/curso/' + idcurso,
        dataType: "json",
        success: function (data) {
            var preferencias = data;
            console.log(data);
            $.each(preferencias, function (key, registro) {
                consultarDisponibilidad(registro.idprofesor, idcurso, contador, 0);
            });
            //abrirPopup(contador);
        },
        error: function (data) {
        }
    });
}

function llenarPDN(idcurso, contador){
	$.ajax({
        type: "GET",
        url: '/IngSoftware/preferencias_cursos_profesores/no/curso/' + idcurso,
        dataType: "json",
        success: function (data) {
            var preferencias = data;
            console.log(data);
            $.each(preferencias, function (key, registro) {
                consultarDisponibilidad(registro.idprofesor, idcurso, contador, 2);
            });
            //abrirPopup(contador);
        },
        error: function (data) {
        }
    });
}

function consultarDisponibilidad(idprofesor, idcurso, contador, tipo) {
    $.ajax({
        type: "GET",
        url: '/IngSoftware/disponibilidades/profesor/' + idprofesor + '/curso/' + idcurso,
        dataType: "json",
        success: function (data) {
            var disponibilidad = data;//retorna las disponibilidades para imprimirlas junto con el profesor aun falta
            console.log(data);
            if(tipo == 2){
            	if(data.tipo == 0 ){
            		obtenerProfesor(idprofesor, idcurso, contador, 2);//obtiene datos del profesor y los pone el el popup
            	}
            }else{
            	obtenerProfesor(idprofesor, idcurso, contador, data.tipo);//obtiene datos del profesor y los pone el el popup
            }
        },
        error: function (data) {
        }
    });
}

function obtenerProfesor(idprofesor, idcurso, contador, tipo) {
	if(tipo == 0){
	    $.ajax({
	        type: "GET",
	        url: '/IngSoftware/profesores/' + idprofesor,
	        dataType: "json",
	        success: function (data) {
	            var profesor = data;
	            $("#columna1" + contador).append('<input class="" style="font-size:8px;text-align: right;" type="text" readonly value="' + profesor.nameprofesor + ' ' + profesor.lastnameprofesor + '" id="' + profesor.idprofesor + '" onclick="enviarProfesor(this.id, this.value,' + idcurso + ',' + contador + ')" style="background:rgb(207,207,207);8px;font-size:8px;text-align: right;"/>');
	        },
	        error: function (data) {
	        }
	    });
	}
	if(tipo == 1){
	    $.ajax({
	        type: "GET",
	        url: '/IngSoftware/profesores/' + idprofesor,
	        dataType: "json",
	        success: function (data) {
	            var profesor = data;
	            $("#columna2" + contador).append('<input class="" style="font-size:8px;text-align: right;" type="text" readonly value="' + profesor.nameprofesor + ' ' + profesor.lastnameprofesor + '" id="' + profesor.idprofesor + '" onclick="enviarProfesor(this.id, this.value,' + idcurso + ',' + contador + ')" style="background:rgb(207,207,207);8px;font-size:8px;text-align: right;"/>');
	        },
	        error: function (data) {
	        }
	    });
	}
	if(tipo == 2){
	    $.ajax({
	        type: "GET",
	        url: '/IngSoftware/profesores/' + idprofesor,
	        dataType: "json",
	        success: function (data) {
	            var profesor = data;
	            $("#columna3" + contador).append('<input class="" style="font-size:8px;text-align: right;" type="text" readonly value="' + profesor.nameprofesor + ' ' + profesor.lastnameprofesor + '" id="' + profesor.idprofesor + '" onclick="enviarProfesor(this.id, this.value,' + idcurso + ',' + contador + ')" style="background:rgb(207,207,207);8px;font-size:8px;text-align: right;"/>');
	        },
	        error: function (data) {
	        }
	    });
	}
}

function enviarProfesor(idprofesor, fullnameprofesor, idcurso, contador) {
    $('#profesor' + contador).attr("value", fullnameprofesor);
    $('#profesor' + contador).attr("id2", idprofesor);
}

function registrarProgramacion_profesor() {
    $('#guardar').click(function () {
    	var stored = localStorage['user'];
        if (stored)
            myVar = JSON.parse(stored);
        var aux = 0;
        for (var i = 1; i < getContador(); i++) {
            //salen en pares el primero es idprogramacion y el segundo el idprofesorse debe actualizar la BD
            var dataOut = {idprogramacion: 0,
                idprofesor: 'SinAsignar',
                idcurso: 0,
                idusuario: myVar.idusuario,
                cycleprogramacion: 0,
                groupprogramacion: 0,
                statusprogramacion: 0};
            $('#cuerpo' + i + ' input[type="text"]').each(function (index) {
                console.log(index);
                if (index == 0) {
                    dataOut.idprogramacion = $(this).attr("id");
                }
                if (index == 1) {
                    dataOut.idprofesor = $(this).attr("id2");
                }
            });
            if (!isNaN(dataOut.idprofesor)) {
            	actualizar(dataOut, i);
            }
        }
    });
}

function actualizar(dataOut, aux){
	$.ajax({
        type: "PUT",
        contentType: "application/json",
        url: '/IngSoftware/programaciones/' + dataOut.idprogramacion,
        dataType: "json",
        data: JSON.stringify(dataOut),
        success: function (data) {
        	$.ajax({
        		type: "PUT",
        		contentype: "application/json",
        		url: '/IngSoftware/disponibilidades/profesor/'+data.idprofesor+'/programacion/'+data.idprogramacion,
        		dataType: "json",
        		data: JSON.stringify(data),
        		success: function(data2){
        			console.log(data2);
        		},
        		error: function(data2){
        			console.log(data2);
        		}
        	});
            var programacion = data;
            console.log(aux);
            $('#cuerpo' + aux).remove();
            $('#resultadoOK').show();
            $("#resultadoOK").fadeOut(8000);
        },
        error: function (data) {
            $('#resultadoFAIL').show();
            $("#resultadoFAIL").fadeOut(8000);
            return;
        }
    });
}

function verProgramacion() {
    $('#ver').click(function () {
    	var stored = localStorage['config'];
        if (stored)
            myVar = JSON.parse(stored);
        $('#programaciones').empty();
        $.ajax({
            type: "GET",
            url: '/IngSoftware/programaciones/reporte/'+myVar.cycleconfiguracion,
            dataType: "json",
            success: function (data) {
                var programaciones = data;
                var String1 = '<div id="verprogramaciones" title="Programaciones" style="display:none"></div>';
                $("#programaciones").append(String1);
                var string2 = '<div class="form-inline">';
                var string3 = '<label class="form-control" style="width:60px;font-size:8px;text-align: center;"> Programa </label>';
                var string4 = '<label class="form-control" style="width:60px;font-size:8px;text-align: center;"> Plan </label>';
                var string5 = '<label class="form-control" style="width:60px;font-size:8px;text-align: center;"> ciclo </label>';
                var string6 = '<label class="form-control" style="width:60px;font-size:8px;text-align: center;"> grupo </label>';
                var string7 = '<label class="form-control" style="width:255px;font-size:8px;text-align: center;"> curso </label>';
                var string8 = '<label class="form-control" style="width:255px;font-size:8px;text-align: center;"> profesor </label>';
                var string9 = '</div>';
                var stringtitulos = string2 + string3 + string4 + string5 + string6 + string7 + string8 + string9;
                $("#verprogramaciones").append(stringtitulos);
                $.each(programaciones, function (key, registro) {
                	var nameprofesor = registro.nameprofesor;
                	if(nameprofesor == null || nameprofesor == ''){
                		nameprofesor = 'SIN PROFESOR ASIGNADO';
                	}else{
                		nameprofesor = nameprofesor + ' ' +  registro.lastnameprofesor;
                	}
                	var string2 = '<div class="form-inline">';
                    var string3 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.programcurso      + '" title="' + registro.programcurso      + '"/>';
                    var string4 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.plancurso         + '" title="' + registro.plancurso         + '"/>';
                    var string5 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.cyclecurso        + '" title="' + registro.cyclecurso        + '"/>';
                    var string6 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.groupprogramacion + '" title="' + registro.groupprogramacion + '"/>';
                    var string7 = '<input class="form-control" style="width:255px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.namecurso         + '" title="' + registro.namecurso         + '"/>';
                    var string8 = '<input class="form-control" style="width:255px;font-size:8px;text-align: right;" type="text" disabled value="' + nameprofesor               + '" title="' + nameprofesor               + '"/>';
                    var string9 = '</div>';
                    var stringfinal = string2 + string3 + string4 + string5 + string6 + string7 + string8 + string9;
                    $("#verprogramaciones").append(stringfinal);
                });
                $('#verprogramaciones').css('font-size','8px');
                $('#verprogramaciones').dialog({ autoOpen: false });
                $('#verprogramaciones').dialog('option', 'width', 800);
                $('#verprogramaciones').dialog('option', 'height', 290);
                $('#verprogramaciones').dialog('open');
            },
            error: function (data) {
            	$('#infoprogramacion').show();
                $("#infoprogramacion").fadeOut(8000);
            }
        });
    });
}
