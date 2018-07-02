// JavaScript Document
$(document).ready(function() {
	getPrograma();
	getPlan();
	getCurso();
	setInit();
	registrarHorario_Curso();
	verProgramacion();
});
function getPrograma() {
	$.ajax({
		type : "GET",
		url : '/IngSoftware/cursos/programas',
		dataType : "json",
		success : function(data) {
			var programa = data;
			$("#programa").append(
					'<option value="-1" selected>Escoja Programa</option>');
			$.each(programa, function(key, registro) {
				$("#programa").append(
						'<option value=' + registro.programcurso + '>'
								+ registro.programcurso + '</option>');
			});
		},
		error : function(data) {
			alert('error getPrograma');
		}
	});
}
function getPlan() {
	$("#programa")
			.change(
					function() {
						var valor = $('select[id=programa]').val();
						$("#plan").empty()
						$("#curso").empty()
						$
								.ajax({
									type : "GET",
									url : '/IngSoftware/cursos/planes/' + valor,
									dataType : "json",
									success : function(data) {
										var plan = data
										if (plan == null) {
										} else {
											$("#plan")
													.append(
															'<option value="-1" selected>Escoja Plan</option>');
											$
													.each(
															plan,
															function(key,
																	registro) {
																$("#plan")
																		.append(
																				'<option value='
																						+ registro.plancurso
																						+ '>'
																						+ registro.plancurso
																						+ '</option>');
															});
										}
									},
									error : function(data) {
										alert('error getPlan');
									}
								});
					});
}
function getCurso() {
	$("#plan").change(function() {
		obtenerCurso();
	});
}
function obtenerCurso() {
	var plan = $('select[id=plan]').val();
	var programa = $('select[id=programa]').val();
	$("#curso").empty()
	$.ajax({
		type : "GET",
		url : '/IngSoftware/cursos/programa/' + programa + '/plan/' + plan,
		dataType : "json",
		success : function(data) {
			var cursos = data
			if (cursos == null) {
				$('#resultadoOK2').show();
				$('#resultadoOK2').fadeOut(2500);
			} else if (cursos == undefined) {
				$('#resultadoOK2').show();
				$('#resultadoOK2').fadeOut(2500);
			} else if(cursos.length > 0){
				$("#curso").append(
						'<option value="-1" selected>Escoja Curso</option>');
				var semboll = 0;
				$.each(cursos, function(key, registro) {
					$.ajax({
						type : "GET",
						url : '/IngSoftware/programaciones/curso/'
								+ registro.idcurso,
						dataType : "json",
						success : function(data) {
							if (data.idcurso == registro.idcurso) {
								// No se carga al comboBox
							} else {
								$("#curso").append(
										'<option value=' + registro.idcurso
												+ ' name = '
												+ registro.cyclecurso + '>'
												+ registro.namecurso
												+ '</option>');
								semboll = 1;
							}
						},
						error : function(data) {
						}
					});
				});
				setTimeout(function(){ if(semboll == 0){
					$('#resultadoOK2').show();
					$('#resultadoOK2').fadeOut(2500);
				}}, 600);
			}
		},
		error : function(data) {
			$('#resultadoOK2').show();
			$('#resultadoOK2').fadeOut(2500);
		}
	});
}
function setInit() {
	for (var ii = 1; ii < 4; ii++) {
		$('#horainicio' + ii).mask('99:99', {
			placeholder : "HH:MM"
		});
		$('#horafin' + ii).mask('99:99', {
			placeholder : "HH:MM"
		});
	}
	$('#horainicio1').keyup(
			function() {
				var val = $('#horainicio1').val();
				try {
					if (val.length == 1 && val > 2) {
						$('#horainicio1').val('');
					}
					if (val.length == 2 && val > 24) {
						$('#horainicio1').val('');
					}
					if (val.length == 3 && val.substring(0, 2) > 24) {
						$('#horainicio1').val('');
					}
					if (val.length == 4 && val.substring(3, 4) > 6) {
						$('#horainicio1').val('');
					}
					if (val.length == 5 && val.substring(3, 5) > 60
							|| val.substring(0, 2) > 24) {
						$('#horainicio1').val('');
					}
					if (val.length == 5 && val.substring(3, 5) < 60
							&& val.substring(0, 2) < 24) {
						$('#horafin1').focus();
					}
				} catch (e) {
					return;
				}
			});
	$('#horafin1').keyup(
			function() {
				var val = $('#horafin1').val();
				try {
					if (val.length == 1 && val > 2) {
						$('#horafin1').val('');
					}
					if (val.length == 2 && val > 24) {
						$('#horafin1').val('');
					}
					if (val.length == 3 && val.substring(0, 2) > 24) {
						$('#horafin1').val('');
					}
					if (val.length == 4 && val.substring(3, 4) > 6) {
						$('#horafin1').val('');
					}
					if (val.length == 5 && val.substring(3, 5) > 60
							|| val.substring(0, 2) > 24) {
						$('#horafin1').val('');
					}
				} catch (e) {
					return;
				}
			});
	$('#horainicio2').keyup(
			function() {
				var val = $('#horainicio2').val();
				try {
					if (val.length == 1 && val > 2) {
						$('#horainicio2').val('');
					}
					if (val.length == 2 && val > 24) {
						$('#horainicio2').val('');
					}
					if (val.length == 3 && val.substring(0, 2) > 24) {
						$('#horainicio2').val('');
					}
					if (val.length == 4 && val.substring(3, 4) > 6) {
						$('#horainicio2').val('');
					}
					if (val.length == 5 && val.substring(3, 5) > 60
							|| val.substring(0, 2) > 24) {
						$('#horainicio2').val('');
					}
					if (val.length == 5 && val.substring(3, 5) < 60
							&& val.substring(0, 2) < 24) {
						$('#horafin2').focus();
					}
				} catch (e) {
					return;
				}
			});
	$('#horafin2').keyup(
			function() {
				var val = $('#horafin2').val();
				try {
					if (val.length == 1 && val > 2) {
						$('#horafin2').val('');
					}
					if (val.length == 2 && val > 24) {
						$('#horafin2').val('');
					}
					if (val.length == 3 && val.substring(0, 2) > 24) {
						$('#horafin2').val('');
					}
					if (val.length == 4 && val.substring(3, 4) > 6) {
						$('#horafin2').val('');
					}
					if (val.length == 5 && val.substring(3, 5) > 60
							|| val.substring(0, 2) > 24) {
						$('#horafin2').val('');
					}
				} catch (e) {
					return;
				}
			});
	$('#horainicio3').keyup(
			function() {
				var val = $('#horainicio3').val();
				try {
					if (val.length == 1 && val > 2) {
						$('#horainicio3').val('');
					}
					if (val.length == 2 && val > 24) {
						$('#horainicio3').val('');
					}
					if (val.length == 3 && val.substring(0, 2) > 24) {
						$('#horainicio3').val('');
					}
					if (val.length == 4 && val.substring(3, 4) > 6) {
						$('#horainicio3').val('');
					}
					if (val.length == 5 && val.substring(3, 5) > 60
							|| val.substring(0, 2) > 24) {
						$('#horainicio3').val('');
					}
					if (val.length == 5 && val.substring(3, 5) < 60
							&& val.substring(0, 2) < 24) {
						$('#horafin3').focus();
					}
				} catch (e) {
					return;
				}
			});
	$('#horafin3').keyup(
			function() {
				var val = $('#horafin3').val();
				try {
					if (val.length == 1 && val > 2) {
						$('#horafin3').val('');
					}
					if (val.length == 2 && val > 24) {
						$('#horafin3').val('');
					}
					if (val.length == 3 && val.substring(0, 2) > 24) {
						$('#horafin3').val('');
					}
					if (val.length == 4 && val.substring(3, 4) > 6) {
						$('#horafin3').val('');
					}
					if (val.length == 5 && val.substring(3, 5) > 60
							|| val.substring(0, 2) > 24) {
						$('#horafin3').val('');
					}
				} catch (e) {
					return;
				}
			});
	$('#infoprogramacion').hide();
	$('#cuerpo1').hide();
	$('#cuerpo2').hide();
	$('#cuerpo3').hide();
	$('#resultadoOK').hide();
	$('#resultadoOK2').hide();
	$('#resultadoFAIL').hide();
	$('#resultadoFAIL2').hide();
	$('#resultadoFAIL3').hide();
	$('#resultadoFAIL4').hide();
	$('#resultadoFAIL5').hide();
	$("#plan").change(function() {
		var plan = $('select[id=plan]').val();
		var programa = $('select[id=programa]').val();
		if (plan == "-1") {
			$("#curso").empty()
		}
	});
	$("#programa").change(function() {
		var programa = $('select[id=programa]').val();
		if (programa == "-1") {
			$("#plan").empty()
			$("#curso").empty()
		}
	});
	$("#curso").change(function() {
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
	$('#guardar').click(function() {
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
	if ($('#cuerpo1').css('display') == 'block'
			&& $('#cuerpo2').css('display') == 'none'
			&& $('#cuerpo3').css('display') == 'none') {
		var dayhorarioVal = $('#dia1').val();
		var timestarthorarioVal = $('#horainicio1').val() + ':00';
		var timeendhorarioVal = $('#horafin1').val() + ':00';
		if (timestarthorarioVal.length != 8 || timeendhorarioVal.length != 8) {
			$('#resultadoFAIL3').show();
			$('#resultadoFAIL3').fadeOut(2500);
			return;
		}
		var hora11 = timestarthorarioVal.split(":"), hora12 = timeendhorarioVal
				.split(":"), t11 = new Date(), t12 = new Date();
		t11.setHours(hora11[0], hora11[1], hora11[2]);
		t12.setHours(hora12[0], hora12[1], hora12[2]);
		if ((t12 - t11) != ($('#horascurso').val() * 60 * 60 * 1000)) {
			$('#resultadoFAIL4').show();
			$('#resultadoFAIL4').fadeOut(2500);
			return;
		}
		var dataOut = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal,
			timestarthorario : timestarthorarioVal,
			timeendhorario : timeendhorarioVal,
			statushorario : 0
		};
	} else if ($('#cuerpo1').css('display') == 'block'
			&& $('#cuerpo2').css('display') == 'block'
			&& $('#cuerpo3').css('display') == 'none') {
		var dayhorarioVal = $('#dia1').val();
		var dayhorarioVal2 = $('#dia2').val();
		var timestarthorarioVal = $('#horainicio1').val() + ':00';
		var timeendhorarioVal = $('#horafin1').val() + ':00';
		var timestarthorarioVal2 = $('#horainicio2').val() + ':00';
		var timeendhorarioVal2 = $('#horafin2').val() + ':00';
		if (timestarthorarioVal.length != 8 || timeendhorarioVal.length != 8
				|| timestarthorarioVal2.length != 8
				|| timeendhorarioVal2.length != 8) {
			$('#resultadoFAIL3').show();
			$('#resultadoFAIL3').fadeOut(2500);
			return;
		}
		var hora11 = timestarthorarioVal.split(":"), hora12 = timeendhorarioVal
				.split(":"), t11 = new Date(), t12 = new Date(), hora21 = timestarthorarioVal2
				.split(":"), hora22 = timeendhorarioVal2.split(":"), t21 = new Date(), t22 = new Date();
		t11.setHours(hora11[0], hora11[1], hora11[2]);
		t12.setHours(hora12[0], hora12[1], hora12[2]);
		t21.setHours(hora21[0], hora21[1], hora21[2]);
		t22.setHours(hora22[0], hora22[1], hora22[2]);
		if (dayhorarioVal == dayhorarioVal2) {
			if (t12 - t22 > 0) {
				if (t11 - t22 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			} else if (t22 - t12 > 0) {
				if (t21 - t12 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			}
		}
		if ((t12 - t11) + (t22 - t21) != ($('#horascurso').val() * 60 * 60 * 1000)) {
			$('#resultadoFAIL4').show();
			$('#resultadoFAIL4').fadeOut(2500);
			return;
		}
		var dataOut1 = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal,
			timestarthorario : timestarthorarioVal,
			timeendhorario : timeendhorarioVal,
			statushorario : 0
		};
		var dataOut2 = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal2,
			timestarthorario : timestarthorarioVal2,
			timeendhorario : timeendhorarioVal2,
			statushorario : 0
		};
		var dataOut = [ dataOut1, dataOut2 ];
	} else if ($('#cuerpo1').css('display') == 'block'
			&& $('#cuerpo3').css('display') == 'block'
			&& $('#cuerpo2').css('display') == 'none') {
		var dayhorarioVal = $('#dia1').val();
		var dayhorarioVal2 = $('#dia3').val();
		var timestarthorarioVal = $('#horainicio1').val() + ':00';
		var timeendhorarioVal = $('#horafin1').val() + ':00';
		var timestarthorarioVal2 = $('#horainicio3').val() + ':00';
		var timeendhorarioVal2 = $('#horafin3').val() + ':00';
		if (timestarthorarioVal.length != 8 || timeendhorarioVal.length != 8
				|| timestarthorarioVal2.length != 8
				|| timeendhorarioVal2.length != 8) {
			$('#resultadoFAIL3').show();
			$('#resultadoFAIL3').fadeOut(2500);
			return;
		}
		var hora11 = timestarthorarioVal.split(":"), hora12 = timeendhorarioVal
				.split(":"), t11 = new Date(), t12 = new Date(), hora21 = timestarthorarioVal2
				.split(":"), hora22 = timeendhorarioVal2.split(":"), t21 = new Date(), t22 = new Date();
		t11.setHours(hora11[0], hora11[1], hora11[2]);
		t12.setHours(hora12[0], hora12[1], hora12[2]);
		t21.setHours(hora21[0], hora21[1], hora21[2]);
		t22.setHours(hora22[0], hora22[1], hora22[2]);
		if (dayhorarioVal == dayhorarioVal2) {
			if (t12 - t22 > 0) {
				if (t11 - t22 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			} else if (t22 - t12 > 0) {
				if (t21 - t12 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			}
		}
		if ((t12 - t11) + (t22 - t21) != ($('#horascurso').val() * 60 * 60 * 1000)) {
			$('#resultadoFAIL4').show();
			$('#resultadoFAIL4').fadeOut(2500);
			return;
		}
		var dataOut1 = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal,
			timestarthorario : timestarthorarioVal,
			timeendhorario : timeendhorarioVal,
			statushorario : 0
		};
		var dataOut2 = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal2,
			timestarthorario : timestarthorarioVal2,
			timeendhorario : timeendhorarioVal2,
			statushorario : 0
		};
		var dataOut = [ dataOut1, dataOut2 ];
	} else if ($('#cuerpo1').css('display') == 'block'
			|| $('#cuerpo2').css('display') == 'block'
			|| $('#cuerpo3').css('display') == 'block') {
		var dayhorarioVal = $('#dia1').val();
		var dayhorarioVal2 = $('#dia2').val();
		var dayhorarioVal3 = $('#dia3').val();
		var timestarthorarioVal = $('#horainicio1').val() + ':00';
		var timeendhorarioVal = $('#horafin1').val() + ':00';
		var timestarthorarioVal2 = $('#horainicio2').val() + ':00';
		var timeendhorarioVal2 = $('#horafin2').val() + ':00';
		var timestarthorarioVal3 = $('#horainicio3').val() + ':00';
		var timeendhorarioVal3 = $('#horafin3').val() + ':00';
		if (timestarthorarioVal.length != 8 || timeendhorarioVal.length != 8
				|| timestarthorarioVal2.length != 8
				|| timeendhorarioVal2.length != 8
				|| timestarthorarioVal3.length != 8
				|| timeendhorarioVal3.length != 8) {
			$('#resultadoFAIL3').show();
			$('#resultadoFAIL3').fadeOut(2500);
			return;
		}
		var hora11 = timestarthorarioVal.split(":"), hora12 = timeendhorarioVal
				.split(":"), t11 = new Date(), t12 = new Date(), hora21 = timestarthorarioVal2
				.split(":"), hora22 = timeendhorarioVal2.split(":"), t21 = new Date(), t22 = new Date(), hora31 = timestarthorarioVal3
				.split(":"), hora32 = timeendhorarioVal3.split(":"), t31 = new Date(), t32 = new Date();
		t11.setHours(hora11[0], hora11[1], hora11[2]);
		t12.setHours(hora12[0], hora12[1], hora12[2]);
		t21.setHours(hora21[0], hora21[1], hora21[2]);
		t22.setHours(hora22[0], hora22[1], hora22[2]);
		t31.setHours(hora31[0], hora31[1], hora31[2]);
		t32.setHours(hora32[0], hora32[1], hora32[2]);
		if (dayhorarioVal == dayhorarioVal2) {
			if (t12 - t22 > 0) {
				if (t11 - t22 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			} else if (t22 - t12 > 0) {
				if (t21 - t12 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			}
		}
		if (dayhorarioVal == dayhorarioVal3) {
			if (t12 - t32 > 0) {
				if (t11 - t32 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			} else if (t32 - t12 > 0) {
				if (t31 - t12 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			}
		}
		if (dayhorarioVal2 == dayhorarioVal3) {
			if (t22 - t32 > 0) {
				if (t21 - t32 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			} else if (t32 - t22 > 0) {
				if (t31 - t22 < 0) {
					$('#resultadoFAIL5').show();
					$('#resultadoFAIL5').fadeOut(2500);
					return;
				}
			}
		}
		if ((t12 - t11) + (t22 - t21) + (t32 - t31) != ($('#horascurso').val() * 60 * 60 * 1000)) {
			$('#resultadoFAIL4').show();
			$('#resultadoFAIL4').fadeOut(2500);
			return;
		}
		var dataOut1 = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal,
			timestarthorario : timestarthorarioVal,
			timeendhorario : timeendhorarioVal,
			statushorario : 0
		};
		var dataOut2 = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal2,
			timestarthorario : timestarthorarioVal2,
			timeendhorario : timeendhorarioVal2,
			statushorario : 0
		};
		var dataOut3 = {
			idhorario : 0,
			cyclehorario : cyclehorarioVal,
			dayhorario : dayhorarioVal3,
			timestarthorario : timestarthorarioVal3,
			timeendhorario : timeendhorarioVal3,
			statushorario : 0
		};
		var dataOut = [ dataOut1, dataOut2, dataOut3 ];
	} else {
		$('#resultadoFAIL2').show();
		$('#resultadoFAIL2').fadeOut(2500);
		return;
	}
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : '/IngSoftware/horarios/mult',
		dataType : "json",
		data : JSON.stringify(dataOut),
		success : function(data) {
			console.log(data);
			var horario = data;
			registrarProgramacion(horario, cyclehorarioVal);
		},
		error : function(data) {
			$('#resultadoFAIL').show();
			$('#resultadoFAIL').fadeOut(2500);
		}
	});
}

function registrarProgramacion(horario, cyclehorarioVal) {
	var stored = localStorage['user'];
	if (stored)
		myVar = JSON.parse(stored);

	var curso = $('#curso').val();
	var idcursoVal = parseInt(curso);
	var idprofesorVal = null;// sin profesor
	var idprogramacionVal = 0;
	var idusuarioVal = myVar.idusuario;
	var groupprogramacionVal = 1;
	var statusprogramacionVal = 0;
	var dataOut = {
		idprogramacion : idprogramacionVal,
		idprofesor : idprofesorVal,
		idcurso : idcursoVal,
		idusuario : idusuarioVal,
		cycleprogramacion : cyclehorarioVal,
		groupprogramacion : groupprogramacionVal,
		statusprogramacion : statusprogramacionVal
	};
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : '/IngSoftware/programaciones',
		dataType : "json",
		data : JSON.stringify(dataOut),
		success : function(data) {
			var programacion = data;
			console.log(programacion);
			$.each(horario, function(key, registro) {
				registrarProgramacion_Horario(registro.idhorario,
						programacion.idprogramacion);
			});
			$('#resultadoOK').show();
			$("#resultadoOK").fadeOut(5000);
			$('#horainicio1').val('');
			$('#horafin1').val('');
			$('#horainicio2').val('');
			$('#horafin2').val('');
			$('#horainicio3').val('');
			$('#horafin3').val('');
			$('#horascurso').val('');
			$('#cuerpo1').hide()
			$('#cuerpo2').hide()
			$('#cuerpo3').hide()
			obtenerCurso();
		},
		error : function(data) {
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
	var dataOut = {
		idhorario : idhorarioVal,
		idprogramacion : idprogramacionVal
	};
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : '/IngSoftware/programaciones_horarios',
		dataType : "json",
		data : JSON.stringify(dataOut),
		success : function(data) {
			var programacion = data;
			console.log(programacion);
		},
		error : function(data) {
			$('#resultadoFAIL').show();
			$("#resultadoFAIL").fadeOut(6000);
		}
	});
}

function verProgramacion() {
	$('#ver')
			.click(
					function() {
						var stored = localStorage['config'];
						if (stored)
							myVar = JSON.parse(stored);
						$('#programaciones').empty();
						$
								.ajax({
									type : "GET",
									url : '/IngSoftware/programaciones/reporte/'
											+ myVar.cycleconfiguracion,
									dataType : "json",
									success : function(data) {
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
										var stringtitulos = string2 + string3
												+ string4 + string5 + string6
												+ string7 + string8 + string9;
										$("#verprogramaciones").append(
												stringtitulos);
										$
												.each(
														programaciones,
														function(key, registro) {
															var nameprofesor = registro.nameprofesor;
															if (nameprofesor == null
																	|| nameprofesor == '') {
																nameprofesor = 'SIN PROFESOR ASIGNADO';
															} else {
																nameprofesor = nameprofesor
																		+ ' '
																		+ registro.lastnameprofesor;
															}
															var string2 = '<div class="form-inline">';
															var string3 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="'
																	+ registro.programcurso
																	+ '" title="'
																	+ registro.programcurso
																	+ '"/>';
															var string4 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="'
																	+ registro.plancurso
																	+ '" title="'
																	+ registro.plancurso
																	+ '"/>';
															var string5 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="'
																	+ registro.cyclecurso
																	+ '" title="'
																	+ registro.cyclecurso
																	+ '"/>';
															var string6 = '<input class="form-control" style="width:60px;font-size:8px;text-align: right;" type="text" disabled value="'
																	+ registro.groupprogramacion
																	+ '" title="'
																	+ registro.groupprogramacion
																	+ '"/>';
															var string7 = '<input class="form-control" style="width:255px;font-size:8px;text-align: right;" type="text" disabled value="'
																	+ registro.namecurso
																	+ '" title="'
																	+ registro.namecurso
																	+ '"/>';
															var string8 = '<input class="form-control" style="width:255px;font-size:8px;text-align: right;" type="text" disabled value="'
																	+ nameprofesor
																	+ '" title="'
																	+ nameprofesor
																	+ '"/>';
															var string9 = '</div>';
															var stringfinal = string2
																	+ string3
																	+ string4
																	+ string5
																	+ string6
																	+ string7
																	+ string8
																	+ string9;
															$(
																	"#verprogramaciones")
																	.append(
																			stringfinal);
														});
										$('#verprogramaciones').css(
												'font-size', '8px');
										$('#verprogramaciones').dialog({
											autoOpen : false
										});
										$('#verprogramaciones').dialog(
												'option', 'width', 800);
										$('#verprogramaciones').dialog(
												'option', 'height', 290);
										$('#verprogramaciones').dialog('open');
									},
									error : function(data) {
										$('#infoprogramacion').show();
										$("#infoprogramacion").fadeOut(5000);
										// alert('No hay registro alguno');
									}
								});
					});
}

function obtenerHoras() {
	var curso = $('#curso').val();
	var idcursoVal = parseInt(curso);
	$.ajax({
		type : "GET",
		url : '/IngSoftware/horas_cursos/' + idcursoVal,
		dataType : "json",
		success : function(data) {
			var horas_cursos = data;
			var horas_total = 0;
			$.each(horas_cursos, function(key, registro) {
				horas_total = horas_total + registro.numberhourhora_curso;
			});
			$('#horascurso').val(horas_total);
		},
		error : function(data) {
			$('#horascurso').val('0');
		}
	});
}
