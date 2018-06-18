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
                alert('error getPlan');
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
                } else {
                    $.each(cursos, function (key, registro) {
                        $.ajax({
                            type: "GET",
                            url: '/IngSoftware/programaciones/curso/' + registro.idcurso,
                            dataType: "json",
                            success: function (data) {
                                if (data.idcurso == registro.idcurso && data.idprofesor == 44) {
                                    //Se carga al Div
                                    var string1 = '<div class="form-inline" id="cuerpo' + contador + '">';
                                    var string2 = '<input class="form-control" style="width:25%;" type="text" disabled id="' + data.idprogramacion + '" value="' + registro.namecurso + '" title="' + registro.namecurso + '"/>';
                                    var string3 = '<input type="text" disabled id="profesor' + contador + '" class="form-control" style="width:25%;" />';
                                    var string4 = '<button value="profesor" id="selprof' + contador + '" onclick="elegirProfesor(this.id,' + registro.idcurso + ',' + contador + ')" title="buscar profesor" class="btn btn-default" >P</button>';
                                    var string5 = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                                    var string6 = '<input class="checkbox" type="checkbox" id="fucionpc' + contador + '"  />';
                                    var string7 = '</div>';
                                    var string8 = '<div id="dialog' + contador + '" title="Profesores" style="display:none"></div>';
                                    var stringfinal = string1 + string2 + string3 + string4 + string5 + string6 + string7 + string8;
                                    $('#cuerpo').append(stringfinal);
                                    $('#cuerpo').show();
                                    contador = contador + 1;
                                    setContador(contador);
                                } else {
                                    //No se carga al div
                                }
                            },
                            error: function (data) {
                                //alert('error en obtener los cursos registrados');
                            }
                        });
                    });
                }
            },
            error: function (data) {
                alert('error getCurso');
            }
        });
    });
}

function setInit() {
    $('#resultadoOK').hide();
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

function elegirProfesor(idprofaux, idcur, contador) {
    obtenerProfesorDelCurso(idprofaux, idcur, contador);
    //abrirPopup(contador);
    var idcurso = {
        idcurso: idcur
    };
    localStorage['curso'] = JSON.stringify(idcurso);
    var caracteristicas = 'height=300,width=500,scrollTo,resizable=1,scrollbars=1,location=0';
}

function abrirPopup(contador) {
    $(function () {
        $('#dialog' + contador).dialog({ autoOpen: false });
        $('#dialog' + contador).dialog('option', 'width', 450);
        $('#dialog' + contador).show();
        $('#dialog' + contador).dialog('open');
    });
}

function obtenerProfesorDelCurso(idprofaux, idcurso, contador) {
    $("#dialog" + contador).empty();
    llenarPDP(idprofaux, idcurso, contador);//profesores con disponibilidad por preferencia de cursos
    //llenarPNP(idcurso);//profesores que no poseen disponibilidad pero tiene preferencia de curso
    //llenarPDN();//profesores con disponibilidad pero sin preferencia de cursos
}

function llenarPDP(idprofaux, idcurso, contador) {
    $.ajax({
        type: "GET",
        url: '/IngSoftware/preferencias_cursos_profesores/curso/' + idcurso,
        dataType: "json",
        success: function (data) {
            var preferencias = data;
            $.each(preferencias, function (key, registro) {
                consultarDisponibilidad(registro.idprofesor, idprofaux, idcurso, contador);
                //obtenerProfesor(registro.idprofesor,idprofaux,idcurso,contador);
            });
            abrirPopup(contador);
        },
        error: function (data) {
            alert('error llenarPDP - No posee disponibilidades');//no tiene preferencias
        }
    });
}

function consultarDisponibilidad(idprofesor, idprofaux, idcurso, contador) {
    console.log('dentro de consultarDisponibilidad');
    $.ajax({
        type: "GET",
        url: '/IngSoftware/disponibilidades/profesor/' + idprofesor + '/curso/' + idcurso,
        dataType: "json",
        success: function (data) {
            var disponibilidad = data;//retorna las disponibilidades para imprimirlas junto con el profesor aun falta
            obtenerProfesor(idprofesor, idprofaux, idcurso, contador);//obtiene datos del profesor y los pone el el popup
        },
        error: function (data) {
            console.log('el profesor ' + idprofesor + ' No posee disponiblidad para el curso ' + idcurso);
            alert('error consultarDisponibilidad');//no posee disponibilidad
        }
    });
}

function obtenerProfesor(idprofesor, idprofaux, idcurso, contador) {
    $.ajax({
        type: "GET",
        url: '/IngSoftware/profesores/' + idprofesor,
        dataType: "json",
        success: function (data) {
            var profesor = data;
            console.log(profesor);
            $("#dialog" + contador).append('<input type="text" readonly value="' + profesor.nameprofesor + ' ' + profesor.lastnameprofesor + '" id="' + profesor.idprofesor + '" onclick="enviarProfesor(this.id, this.value,' + idprofaux + ',' + idcurso + ',' + contador + ')" style="background:rgb(14,220,112)"/>');
        },
        error: function (data) {
            alert('error obtenerProfesor');
        }
    });
}

function enviarProfesor(idprofesor, fullnameprofesor, idprofaux, idcurso, contador) {
    console.log(idprofaux);
    $('#profesor' + contador).attr("value", fullnameprofesor);
    $('#profesor' + contador).attr("id2", idprofesor);
}

function registrarProgramacion_profesor() {
    var stored = localStorage['user'];
    if (stored)
        myVar = JSON.parse(stored);

    $('#guardar').click(function () {
        for (var i = 1; i < getContador(); i++) {
            //salen en pares el primero es idprogramacion y el segundo el idprofesorse debe actualizar la BD
            var dataOut = {idprogramacion: 0,
                idprofesor: 0,
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
                console.log(dataOut);
                $.ajax({
                    type: "PUT",
                    contentType: "application/json",
                    url: '/IngSoftware/programaciones/' + dataOut.idprogramacion,
                    dataType: "json",
                    data: JSON.stringify(dataOut),
                    success: function (data) {
                        var programacion = data;
                        console.log(programacion);
                        $('#resultadoOK').show();
                        $("#resultadoOK").fadeOut(2000);
                    },
                    error: function (data) {
                        $('#resultadoFAIL').show();
                        $("#resultadoFAIL").fadeOut(2000);
                    }
                });
            }
        }
    });
}

function verProgramacion() {
    $('#programaciones').empty();
    $('#ver').click(function () {
        $.ajax({
            type: "GET",
            url: '/IngSoftware/programaciones/reporte/20181',
            dataType: "json",
            success: function (data) {
                var programaciones = data;
                var String1 = '<div id="verprogramaciones" title="Programaciones" style="display:none"></div>';
                $("#programaciones").append(String1);
                $.each(programaciones, function (key, registro) {
                    var string2 = '<div class="form-inline">';
                    var string3 = '<input class="form-control" style="width:338px;" type="text" disabled value="' + registro.namecurso + '" title="' + registro.namecurso + '"/>';
                    var string4 = '<input type="text" disabled class="form-control" style="width:338px;" value="' + registro.nameprofesor + '" title="' + registro.nameprofesor + '"/>';
                    var string5 = '</div>';
                    var stringfinal = string2 + string3 + string4 + string5;
                    $("#verprogramaciones").append(stringfinal);
                });
                //$('#dialog').dialog('option', 'width', 677 );
                $('#verprogramaciones').dialog({ autoOpen: false });
                $('#verprogramaciones').dialog('option', 'width', 750);
                //$('#dialog').show();
                $('#verprogramaciones').dialog('open');
            },
            error: function (data) {
                alert('error verCursosProgramadors');
            }
        });
    });
}
