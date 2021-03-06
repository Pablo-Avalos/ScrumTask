$(function() {
	$("#dialog").dialog({
		resizable : false,
		height : 140,
		modal : true,
		buttons : {
			"Delete all items" : function() {
				$(this).dialog("close");
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
	});
});

$(document).ready(function() {
	$("#tarjeta-tarea").dialog({
		resizable : false,
		title : 'test',
		height : 140,
		modal : true,
		buttons : {
			"Delete all items" : function() {
				$(this).dialog("close");
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
	});
});

$(function() {
	$("#sortable").sortable();
	$("#sortable").disableSelection();
});

function agregarTarjeta() {
	var newDiv = $(document.createElement('div'));
	newDiv.html('tarjeta agregada');
	console.log('estoy aca');
	newDiv.dialog({
		dialogClass : 'portlet'
	});
	document.getElementById("id1").appendChild(newDiv);
}

$(function() {
	$("#tabs").tabs();
});

$(function() {
	var dialog, form,

	// From
	// http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
	emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/, name = $("#name"), email = $("#email"), allFields = $(
			[]).add(name).add(email), tips = $(".validateTips");

	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}

	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			updateTips("Length of " + n + " must be between " + min + " and "
					+ max + ".");
			return false;
		} else {
			return true;
		}
	}

	function checkRegexp(o, regexp, n) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}
	dialog = $("#dialog-form").dialog({
		autoOpen : false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			'Crear Tarea' : function() {
				var nombre = $("#name").val();
				var descripcion = $("#descripcion").val();
				$(document).ready(controller.crearTarea(nombre, descripcion));
				dialog.dialog("close");
			},
			Cancelar : function() {
				dialog.dialog("close");
			}
		},
		close : function() {
			form[0].reset();
			allFields.removeClass("ui-state-error");
		}
	});

	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addUser();
	});

	$("#create-user").button().on("click", function() {
		dialog.dialog("open");
	});
});
/* Eliminar tareas */
jQuery(document).ready(function($) {
	$("#namelist").sortable({
		connectWith : '#deleteArea'
	});
	$("#deleteArea").droppable({
		accept : '#tableroConTareas > li',
		hoverClass : 'dropAreaHover',
		drop : function(event, ui) {
			eliminarTarea(ui.draggable, ui.helper);
		},
		activeClass : 'dropAreaHover'
	});
	function eliminarTarea($draggable, $helper) {
		var dialog, form,

		confirmarEliminarTarea = $("#confirmarEliminarTarea").dialog({
			autoOpen : false,
			height : 220,
			width : 400,
			modal : true,
			buttons : {
				Aceptar : function() {
					$helper.effect('transfer', {
						to : '#deleteArea',
						className : 'ui-effects-transfer'
					}, 500);
					$draggable.remove();
					var idTarea = $draggable.attr('value');
					controller.eliminarTarea(idTarea);
					confirmarEliminarTarea.dialog("close");
				},
				Cancelar : function() {
					confirmarEliminarTarea.dialog("close");
				}
			},
			close : function() {
			}
		});
		confirmarEliminarTarea.dialog("open");
	}
});

$(document).ready(function() {
	$("#confirmarEliminarTarea").dialog({
		autoOpen : false
	})
});

$(document).ready(function() {
	$("#dialog-sprint").dialog({
		autoOpen : false
	})
});
$(document).ready(function() {
	$("#eliminarTareaDialog").dialog({
		autoOpen : false
	})
});

$(function() {
	$("#tableroConTareas").sortable();
	$("#tableroConTareas").disableSelection();
});

function agregarTarjeta() {
	var newDiv = $(document.createElement('div'));
	newDiv.html('tarjeta agregada');
	console.log('estoy aca');
	newDiv.dialog({
		dialogClass : 'portlet'
	});
	document.getElementById("id1").appendChild(newDiv);
}

$(function() {
	$("#tabs").tabs();
});

function abrirDialogCrearTarea(idRelease, idSprint) {
	dialog = $("#dialog-form").dialog(
			{
				autoOpen : false,
				height : 300,
				width : 350,
				modal : true,
				buttons : {
					'Crear Tarea' : function() {
						var nombre = $("#name").val();
						var descripcion = $("#descripcion").val();
						$(document).ready(
								controller.crearTarea(idRelease, idSprint,
										nombre, descripcion));
						dialog.dialog("close");
					},
					Cancelar : function() {
						dialog.dialog("close");
					}
				},
				close : function() {
					form[0].reset();
					dialog.dialog("close");
				}
			});

	form = dialog.find("form").on("submit", function(event) {
		event.preventDefault();
		addUser();
	});
	dialog.dialog("open");
}

function abrirDialogEliminarTarea(idRelease, idSprint, idTarea) {
 var dialogElimTarea = $("#eliminarTareaDialog").dialog(
			{
				autoOpen : false,
				height : 300,
				width : 350,
				modal : true,
				buttons : {
					'Eliminar Tarea' : function() {
						var nRelease = idRelease;
						var nSprint = idSprint;
						var id = idTarea;
						$(document).ready(controller.eliminarTarea(nRelease, nSprint, id));
						dialogElimTarea.dialog("close");
					},
					Cancelar : function() {
						dialogElimTarea.dialog("close");
					}
				}
			});
			dialogElimTarea.dialog("open");
}


function abrirDialogCambiarEstado(idRelease, idSprint, idTarea) {
	 var dialogElimTarea = $("#eliminarTareaDialog").dialog(
				{
					autoOpen : false,
					height : 300,
					width : 350,
					modal : true,
					buttons : {
						'Eliminar Tarea' : function() {
							var nRelease = idRelease;
							var nSprint = idSprint;
							var id = idTarea;
							$(document).ready(controller.eliminarTarea(nRelease, nSprint, id));
							dialogElimTarea.dialog("close");
						},
						Cancelar : function() {
							dialogElimTarea.dialog("close");
						}
					}
				});
				dialogElimTarea.dialog("open");
	}



$(function() {
	dialogSrintResponse = $("#dialog-sprintResponse").dialog({
		autoOpen : false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			Cerrar : function() {
				dialogSrintResponse.dialog("close");
			}
		}
	});

});

$(function() {
	dialogRelease = $("#dialog-release").dialog({
		autoOpen : false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			Cerrar : function() {
				dialogRelease.dialog("close");
			}
		}
	});

	$("#create-release").button().on("click", function() {
		controller.crearRelease();
		dialogRelease.dialog("open");

	});
});
function abrirDialogSprint(numeroRelease) {
	var fechaInicio;
	var fechaFin;

	dialogSprint = $("#dialog-sprint").dialog(
			{
				autoOpen : false,
				height : 300,
				width : 350,
				modal : true,
				buttons : {
					'Crear Sprint' : function() {
						fechaInicio = $("#sp-fechaInicio").val();
						fechaFin = $("#sp-fechaFin").val();
						console.log("fechas" + fechaInicio + " " + fechaFin)
						$(document).ready(
								controller.crearSprint(numeroRelease,
										fechaInicio, fechaFin));
						dialogSprint.dialog("close");
					},
					Cancelar : function() {
						dialogSprint.dialog("close");
					}
				}
			});
		dialogSprint.dialog("open");
		fechaFin = '';
		fechaInicio= '';

}

function nuevoBotonSprint(numeroRelease) {
	var boton = $(
			'<div><button id="agregarSprint' + numeroRelease
					+ '">Agregar Sprint</button></div>').click(function() {
		abrirDialogSprint(numeroRelease);

	});

	// $(document).ready(controller.crearSprint(numeroRelease ));

	return boton
}

function nuevoBotonTarea(numeroRelease, numeroSprint) {
	var boton = $(
			'<button id="agregarTarea' + numeroRelease + numeroSprint
					+ '">Agregar tarea</button>').click(function() {
		abrirDialogCrearTarea(numeroRelease, numeroSprint);
	});
	return boton
}

function agregarBotonesAreleases(proyecto) {
	for (var i = 0; i < proyecto.release.length; i++) {
		var release = $("#release" + i)// document.getElementById('release'+i);
		release.append(nuevoBotonSprint(i));
		agregarBotonesAsprint(proyecto.release[i], i);
	}
}

function agregarBotonesAsprint(release, idRelease) {
	for (var i = 0; i < release.listaSprints.length; i++) {
		var sprint = $("#celdaSprint" + idRelease + i)
		sprint.append(nuevoBotonTarea(idRelease, i))
	}
}

function agregarTarea(sprint, tarea) {
	for (var i = 0; i < sprint.listaTareas.length; i++) {
		sprint.listaTareas[i]
	}
}

function agregarBotonesAtareas() {
	$(".tareaParaEliminar").each(function() {
		var idRelease = $(this).closest('div').attr('value');
		var idSprint = $(this).closest('ul').attr('value');
		var idTarea = $(this).attr('value');
		var botonEliminar = $('<button id="eliminarTarea">x</button>').click(function () {
			abrirDialogEliminarTarea(idRelease, idSprint, idTarea);
		});
		var botonCambiarEstad = $('<button id="cambiarEstado">Estado</button>').click(function () {
		 
			controller.pasarDeEstadoTarea(idRelease,idSprint,idTarea);
		});
		$(this).append(botonEliminar);
		$(this).append(botonCambiarEstad);
	});
}


$(function() {
    $( "#sp-fechaInicio").datepicker({ dateFormat: 'dd-mm-yy' });
    $( "#sp-fechaFin").datepicker({ dateFormat: 'dd-mm-yy' });
  });
