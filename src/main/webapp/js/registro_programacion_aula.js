/**
 * 
 */
$(document).ready(function () {
    var contat;
    setContador(0);
    getContador()
    getPrograma();
    getPlan();
    getCurso();
    setInit();
    verProgramacion();
    registrarProgramacion_aula();
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
            url: '/IngSoftware/programaciones/reporte/plan/'+plan+'/programa/'+programa,
            dataType: "json",
            success: function (data) {
                var reporte = data
                var contador = 1;
                if (reporte == null) {
                	$('#resultadoOK2').show();
    				$('#resultadoOK2').fadeOut(2500);
                } else if(reporte == undefined){
                	$('#resultadoOK2').show();
    				$('#resultadoOK2').fadeOut(2500);
                }else if(reporte.length > 0){
                	var semboll = 0;
                	$.each(reporte, function(key, registro){
                		if(registro.idaula == 0 || registro.idaula == null || registro.idaula == undefined){
                			var name = '';
                    		if(registro.nameprofesor == null){
                    			name = 'Sin Profesor Asignado';
                    		}else{
                    			name = registro.nameprofesor + ' ' + registro.lastnameprofesor
                    		}
                    		var string1 = '<div class="form-inline" id="cuerpo' + contador + '">';
                            var string2 = '<input class="form-control" style="width:25%;font-size:8px;text-align: left;" type="text" disabled id="' + registro.idprogramacion + '" value="' + registro.namecurso + '" title="' + registro.namecurso + '"/>';
                            var string3 = '<input type="text" disabled id="profesor' + contador + '" class="form-control" style="width:25%;font-size:8px;text-align: left;" value="' + name + '" />';
                            var string4 = '<input type="text" disabled id="aula' + contador + '" class="form-control" style="width:15%;font-size:8px;text-align: left;" />';
                            var string5 = '<input type="text" disabled id="horario' + contador + '" class="form-control" style="width:15%;font-size:8px;text-align: left;" value="' + registro.dayhorario + ' ' + registro.timestarthorario.substring(0,4)+' - '+ registro.timeendhorario.substring(0,4)+ '" />';
                            var string6 = '<button value="profesor" id="selaula' + contador + '" onclick="elegirAula(' + registro.idprogramacion + ','+ registro.idhorario + ',' + contador + ')" title="buscar aula disponible" class="btn btn-default" >Aula</button>';
                            var string7 = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                            var string8 = '';
                            var string9 = '</div>';
                            var string10 = '<div id="dialog' + contador + '" title="Selec. Aula" style="display:none;font-size:8px;"></div>';
                            var stringfinal = string1 + string2 + string3 + string4 + string5 + string6 + string7 + string8 + string9 + string10;
                            $('#cuerpo').append(stringfinal);
                            $('#cuerpo').show();
                            contador = contador + 1;
                            setContador(contador);
                            semboll = 1;
                		}
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


function verProgramacion() {
    $('#ver').click(function () {
    	var stored = localStorage['config'];
        if (stored)
            myVar = JSON.parse(stored);
        $('#programaciones').empty();
        $.ajax({
            type: "GET",
            url: '/IngSoftware/programaciones/reporte/ciclo/'+myVar.cycleconfiguracion,
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
                var string9 = '<label class="form-control" style="width:80px;font-size:8px;text-align: center;"> aula </label>';
                var string10 = '</div>';
                var stringtitulos = string2 + string3 + string4 + string5 + string6 + string7 + string8 + string9 + string10;
                $("#verprogramaciones").append(stringtitulos);
                $.each(programaciones, function (key, registro) {
                	var nameprofesor = registro.nameprofesor;
                	var aula = 'Sin Aula';
                	if(nameprofesor == null || nameprofesor == ''){
                		nameprofesor = 'SIN PROFESOR ASIGNADO';
                	}else{
                		nameprofesor = nameprofesor + ' ' +  registro.lastnameprofesor;
                	}
                	if(registro.idaula != null && registro.idaula != '' && registro.idaula != undefined && registro.idaula != 0){
                		aula = registro.numberaula + ' ' + registro.pavilionaula;
                	}
                	var string2 = '<div class="form-inline">';
                    var string3 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.programcurso        + '" title="' + registro.programcurso      + '"/>';
                    var string4 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.plancurso           + '" title="' + registro.plancurso         + '"/>';
                    var string5 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.cyclecurso          + '" title="' + registro.cyclecurso        + '"/>';
                    var string6 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.groupprogramacion   + '" title="' + registro.groupprogramacion + '"/>';
                    var string7 = '<input class="form-control" style="width:255px;font-size:8px;text-align: right;" type="text" disabled value="' + registro.namecurso          + '" title="' + registro.namecurso         + '"/>';
                    var string8 = '<input class="form-control" style="width:255px;font-size:8px;text-align: right;" type="text" disabled value="' + nameprofesor                + '" title="' + nameprofesor               + '"/>';
                    var string9 = '<input class="form-control" style="width:80px;font-size:8px;text-align: right;" type="text" disabled value="' + aula                        + '" title="' + aula                       + '"/>';
                    var string10 = '</div>';
                    var stringfinal = string2 + string3 + string4 + string5 + string6 + string7 + string8 + string9 + string10;
                    $("#verprogramaciones").append(stringfinal);
                });
                $('#verprogramaciones').css('font-size','8px');
                $('#verprogramaciones').dialog({ autoOpen: false });
                $('#verprogramaciones').dialog('option', 'width', 900);
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

function elegirAula(idprogramacion, idhorario, contador){
	$('#selaula' + contador).attr("disabled", true);
    $("#dialog" + contador).empty();
    var String1 = '<div id="titulo'+contador+'"><div class="form-control">Aulas Disponibles</div></div>';
    //var String1 = '<div id="titulo'+contador+'" class="row"><div class="col-md-9" style="font-size:8px;text-align: center;"><div class="form-control">Aulas Disponibles</div></div></div>';
    $("#dialog" + contador).append(String1);
    var String2 = '<div id="conten'+contador+'"><div id="columna1'+contador+'"> </div></div>';
    $("#dialog" + contador).append(String2);
    llenarAulas(idprogramacion, idhorario, contador);//profesores con disponibilidad por preferencia de cursos
    //setTimeout(function(){ abrirPopup(contador);$('#selaula' + contador).attr("disabled", false);}, 15000);
}

function abrirPopup(contador) {
    $(function () {
        $('#dialog' + contador).dialog({ autoOpen: false });
        $('#dialog' + contador).dialog('option', 'width', 380);
        $('#dialog' + contador).dialog('option', 'height', 380);
        $('#dialog' + contador).show();
        $('#dialog' + contador).dialog('open');
    });
}

function llenarAulas(idprogramacion, idhorario, contador) {
    $.ajax({
        type: "GET",
        url: '/IngSoftware/aulas',///programacion/' + idprogramacion,
        dataType: "json",
        success: function (data) {
            var aulas = data;
            //console.log(data);
            $.each(aulas, function (key, registro) {
            	$("#columna1" + contador).append('<input class="form-control" type="text" readonly value="' + registro.numberaula + ' ' + registro.pavilionaula + '" id="' + registro.idaula + '" onclick="enviarAula(this.id, this.value,' + idprogramacion + ',' + idhorario + ',' + contador + ')" style="8px;font-size:8px;text-align: right;"/>');
            });
            abrirPopup(contador);
            $('#selaula' + contador).attr("disabled", false);
        },
        error: function (data) {
        	$('#selaula' + contador).attr("disabled", false);
        }
    });
}

function enviarAula(idaula, fullaula, idprogramacion, idhorario, contador) {
    $('#aula' + contador).attr("value", fullaula);
    $('#aula' + contador).attr("id2", idaula);
    $('#aula' + contador).attr("id3", idhorario);
}

function registrarProgramacion_aula() {
    $('#guardar').click(function () {
    	var stored = localStorage['user'];
        if (stored)
            myVar = JSON.parse(stored);
        var aux = 0;
        for (var i = 1; i < getContador(); i++) {
            //salen en pares el primero es idprogramacion y el segundo el idprofesorse debe actualizar la BD
            var dataOut = {idprogramacion: 'sn',
                idaula: 'sn',
                idhorario : 'sn',
                idusuario : myVar.idusuario};
            $('#cuerpo' + i + ' input[type="text"]').each(function (index) {
                //console.log(index + ' ' +  $(this).attr("id"));
                if (index == 0) {
                    dataOut.idprogramacion = $(this).attr("id");
                }
                if (index == 1) {
                    //dataOut.idprofesor = $(this).attr("id2");
                }
                if (index == 2) {
                    dataOut.idaula = $(this).attr("id2");
                    dataOut.idhorario = $(this).attr("id3");
                }
            });
            //console.log(dataOut);
            if (!isNaN(dataOut.idprogramacion) && !isNaN(dataOut.idaula)) {
            	guardaProgramacion_Aula(dataOut, i);
            }
        }
    });
}

function guardaProgramacion_Aula(dataOut, aux){
	console.log(dataOut);
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: '/IngSoftware/aula/programacion/horario/usuario',
        dataType: "json",
        data: JSON.stringify(dataOut),
        success: function (data) {
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
