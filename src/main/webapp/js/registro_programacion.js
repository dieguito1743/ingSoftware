// JavaScript Document
$(document).ready(function () {
    getPrograma();
    getPlan();
    getCurso();
    setInit();
    registrarHorario_Curso();
    verProgramacion();
});
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
        $("#curso").empty()
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
                alert('error getPlan');
            }
        });
    });
}
function getCurso() {
    $("#plan").change(function () {
        obtenerCurso();
    });
}
function obtenerCurso() {
    var plan = $('select[id=plan]').val();
    var programa = $('select[id=programa]').val();
    $("#curso").empty()
    $.ajax({
        type: "GET",
        url: '/IngSoftware/cursos/programa/' + programa + '/plan/' + plan,
        dataType: "json",
        success: function (data) {
            var cursos = data
            if (cursos == null) {
            } else {
                $("#curso").append('<option value="-1" selected>Escoja Curso</option>');
                $.each(cursos, function (key, registro) {
                    $.ajax({
                        type: "GET",
                        url: '/IngSoftware/programaciones/curso/' + registro.idcurso,
                        dataType: "json",
                        success: function (data) {
                            if (data.idcurso == registro.idcurso) {
                                //No se carga al comboBox
                            } else {
                                $("#curso").append('<option value=' + registro.idcurso + ' name = ' + registro.cyclecurso + '>' + registro.namecurso + '</option>');
                            }
                        },
                        error: function (data) {
                            alert('error en Comparar Curso registrado');
                        }
                    });
                });
            }
        },
        error: function (data) {
            alert('error getCurso');
        }
    });
}
function setInit() {
	for(var ii = 1; ii< 4; ii++){
		$('#horainicio'+ii).mask('99:99', {placeholder:"HH:MM"});
		$('#horafin'+ii).mask('99:99', {placeholder:"HH:MM"});
	}
	$('#horainicio1').keyup(function(){
		var val = $('#horainicio1').val();
		try{
			if(val.length == 1 && val > 2){
				$('#horainicio1').val('');
			}
			if(val.length == 2 && val > 24){
				$('#horainicio1').val('');
			}
			if(val.length == 3 && val.substring(0,2) > 24){
				$('#horainicio1').val('');
			}
			if(val.length == 4 && val.substring(3,4) > 6){
				$('#horainicio1').val('');
			}
			if(val.length == 5 && val.substring(3,5) > 60 || val.substring(0,2) > 24){
				$('#horainicio1').val('');
			}
			if(val.length == 5 && val.substring(3,5) < 60 && val.substring(0,2) < 24){
				$('#horafin1').focus();
			}
		}catch(e){
			return;
		}
    });
	$('#horafin1').keyup(function(){
		var val = $('#horafin1').val();
		try{
			if(val.length == 1 && val > 2){
				$('#horafin1').val('');
			}
			if(val.length == 2 && val > 24){
				$('#horafin1').val('');
			}
			if(val.length == 3 && val.substring(0,2) > 24){
				$('#horafin1').val('');
			}
			if(val.length == 4 && val.substring(3,4) > 6){
				$('#horafin1').val('');
			}
			if(val.length == 5 && val.substring(3,5) > 60 || val.substring(0,2) > 24){
				$('#horafin1').val('');
			}
		}catch(e){
			return;
		}
    });
	$('#horainicio2').keyup(function(){
		var val = $('#horainicio2').val();
		try{
			if(val.length == 1 && val > 2){
				$('#horainicio2').val('');
			}
			if(val.length == 2 && val > 24){
				$('#horainicio2').val('');
			}
			if(val.length == 3 && val.substring(0,2) > 24){
				$('#horainicio2').val('');
			}
			if(val.length == 4 && val.substring(3,4) > 6){
				$('#horainicio2').val('');
			}
			if(val.length == 5 && val.substring(3,5) > 60 || val.substring(0,2) > 24){
				$('#horainicio2').val('');
			}
			if(val.length == 5 && val.substring(3,5) < 60 && val.substring(0,2) < 24){
				$('#horafin2').focus();
			}
		}catch(e){
			return;
		}
    });
	$('#horafin2').keyup(function(){
		var val = $('#horafin2').val();
		try{
			if(val.length == 1 && val > 2){
				$('#horafin2').val('');
			}
			if(val.length == 2 && val > 24){
				$('#horafin2').val('');
			}
			if(val.length == 3 && val.substring(0,2) > 24){
				$('#horafin2').val('');
			}
			if(val.length == 4 && val.substring(3,4) > 6){
				$('#horafin2').val('');
			}
			if(val.length == 5 && val.substring(3,5) > 60 || val.substring(0,2) > 24){
				$('#horafin2').val('');
			}
		}catch(e){
			return;
		}
    });
	$('#horainicio3').keyup(function(){
		var val = $('#horainicio3').val();
		try{
			if(val.length == 1 && val > 2){
				$('#horainicio3').val('');
			}
			if(val.length == 2 && val > 24){
				$('#horainicio3').val('');
			}
			if(val.length == 3 && val.substring(0,2) > 24){
				$('#horainicio3').val('');
			}
			if(val.length == 4 && val.substring(3,4) > 6){
				$('#horainicio3').val('');
			}
			if(val.length == 5 && val.substring(3,5) > 60 || val.substring(0,2) > 24){
				$('#horainicio3').val('');
			}
			if(val.length == 5 && val.substring(3,5) < 60 && val.substring(0,2) < 24){
				$('#horafin3').focus();
			}
		}catch(e){
			return;
		}
    });
	$('#horafin3').keyup(function(){
		var val = $('#horafin3').val();
		try{
			if(val.length == 1 && val > 2){
				$('#horafin3').val('');
			}
			if(val.length == 2 && val > 24){
				$('#horafin3').val('');
			}
			if(val.length == 3 && val.substring(0,2) > 24){
				$('#horafin3').val('');
			}
			if(val.length == 4 && val.substring(3,4) > 6){
				$('#horafin3').val('');
			}
			if(val.length == 5 && val.substring(3,5) > 60 || val.substring(0,2) > 24){
				$('#horafin3').val('');
			}
		}catch(e){
			return;
		}
    });
	$('#infoprogramacion').hide();
    $('#cuerpo1').hide();
    $('#cuerpo2').hide();
    $('#cuerpo3').hide();
    $('#resultadoOK').hide();
    $('#resultadoFAIL').hide();
    $("#plan").change(function () {
        var plan = $('select[id=plan]').val();
        var programa = $('select[id=programa]').val();
        if (plan == "-1") {
            $("#curso").empty()
        }
    });
    $("#programa").change(function () {
        var programa = $('select[id=programa]').val();
        if (programa == "-1") {
            $("#plan").empty()
            $("#curso").empty()
        }
    });
    $("#curso").change(function () {
        var programa = $('select[id=programa]').val();
        if (programa == "-1") {
            $('#cuerpo1').hide();
            $('#cuerpo2').hide();
            $('#cuerpo3').hide();
        } else {
            $('#cuerpo1').show();
        }
        obtenerHoras();
    });
}
function registrarHorario_Curso() {
    $('#guardar').click(function () {
        registrarHorario();
    });
}

function registrarHorario() {
	var stored = localStorage['config'];
    if (stored)
        myVar = JSON.parse(stored);
    var dt = new Date();
    var month = dt.getMonth() + 1;
    var cyclehorarioVal = myVar.cycleconfiguracion;
    var dayhorarioVal = $('#dia1').val();
    var timestarthorarioVal = $('#horainicio1').val()+':00';
    var timeendhorarioVal = $('#horafin1').val()+':00';
    var dataOut = {idhorario: 0,
        cyclehorario: cyclehorarioVal,
        dayhorario: dayhorarioVal,
        timestarthorario: timestarthorarioVal,
        timeendhorario: timeendhorarioVal,
        statushorario: 0};
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: '/IngSoftware/horarios',
        dataType: "json",
        data: JSON.stringify(dataOut),
        success: function (data) {
            console.log(data);
            var horario = data;
            registrarProgramacion(horario, cyclehorarioVal);
        },
        error: function (data) {
            $('#resultadoFAIL').show();
            $("#resultadoFAIL").fadeOut(6000);
        }
    });
}

function registrarProgramacion(horario, cyclehorarioVal) {
    var stored = localStorage['user'];
    if (stored)
        myVar = JSON.parse(stored);

    var curso = $('#curso').val();
    var idcursoVal = parseInt(curso);
    var idprofesorVal = null;//sin profesor
    var idprogramacionVal = 0;
    var idusuarioVal = myVar.idusuario;
    var groupprogramacionVal = 1;
    var statusprogramacionVal = 0;
    var dataOut = {idprogramacion: idprogramacionVal,
        idprofesor: idprofesorVal,
        idcurso: idcursoVal,
        idusuario: idusuarioVal,
        cycleprogramacion: cyclehorarioVal,
        groupprogramacion: groupprogramacionVal,
        statusprogramacion: statusprogramacionVal};
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: '/IngSoftware/programaciones',
        dataType: "json",
        data: JSON.stringify(dataOut),
        success: function (data) {
            var programacion = data;
            console.log(programacion);
            registrarProgramacion_Horario(horario.idhorario, programacion.idprogramacion);
        },
        error: function (data) {
            $('#resultadoFAIL').show();
            $("#resultadoFAIL").fadeOut(6000);
        }
    });
}

function agregar_restarUno(id) {
    if (id.substring(0, 7) == 'agregar') {
        if (parseInt(id.substring(7)) < 3) {
            $('#cuerpo' + (parseInt(id.substring(7)) + 1)).show();
        }
    }
    if (id.substring(0, 6) == 'restar') {
        if (parseInt(id.substring(6)) > 1) {
            $('#cuerpo' + id.substring(6)).hide();
        }
    }
}

function registrarProgramacion_Horario(idhorarioVal, idprogramacionVal) {
    var dataOut = {idhorario: idhorarioVal,
        idprogramacion: idprogramacionVal};
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: '/IngSoftware/programaciones_horarios',
        dataType: "json",
        data: JSON.stringify(dataOut),
        success: function (data) {
            var programacion = data;
            console.log(programacion);
            $('#resultadoOK').show();
            $("#resultadoOK").fadeOut(5000);
            $('#horainicio1').val('');
            $('#horafin1').val('');
            obtenerCurso();

        },
        error: function (data) {
            $('#resultadoFAIL').show();
            $("#resultadoFAIL").fadeOut(6000);
        }
    });
}

function verProgramacion() {
	var stored = localStorage['config'];
    if (stored)
        myVar = JSON.parse(stored);
    $('#programaciones').empty();
    $('#ver').click(function () {
        $.ajax({
            type: "GET",
            url: '/IngSoftware/programaciones/reporte/'+myVar.cycleconfiguracion,
            dataType: "json",
            success: function (data) {
                var programaciones = data;
                var String1 = '<div id="verprogramaciones" title="Programaciones" style="display:none"></div>';
                $("#programaciones").append(String1);
                $.each(programaciones, function (key, registro) {
                	var nameprofesor = registro.nameprofesor;
                	if(nameprofesor == null || nameprofesor == ''){
                		nameprofesor = 'SIN PROFESOR ASIGNADO';
                	}
                    var string2 = '<div class="form-inline">';
                    var string3 = '<input class="form-control" style="width:338px;" type="text" disabled value="' + registro.namecurso + '" title="' + registro.namecurso + '"/>';
                    var string4 = '<input type="text" disabled class="form-control" style="width:338px;" value="' + nameprofesor + '" title="' + nameprofesor + '"/>';
                    var string5 = '</div>';
                    var stringfinal = string2 + string3 + string4 + string5;
                    $("#verprogramaciones").append(stringfinal);
                });
                $('#verprogramaciones').dialog({autoOpen: false});
                $('#verprogramaciones').dialog('option', 'width', 750);
                $('#verprogramaciones').dialog('open');
            },
            error: function (data) {
            	$('#infoprogramacion').show();
                $("#infoprogramacion").fadeOut(5000);
            	//alert('No hay registro alguno');
            }
        });
    });
}

function obtenerHoras() {
	var curso = $('#curso').val();
    var idcursoVal = parseInt(curso);
	$.ajax({
        type: "GET",
        url: '/IngSoftware/horas_cursos/'+idcursoVal,
        dataType: "json",
        success: function (data) {
            var horas_cursos = data;
            var horas_total = 0;
            $.each(horas_cursos, function (key, registro) {
                horas_total = horas_total+registro.numberhourhora_curso;
            });
            $('#horascurso').val(horas_total);
        },
        error: function (data) {
        	$('#horascurso').val('0');
        }
    });
}
