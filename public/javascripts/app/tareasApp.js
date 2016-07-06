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

$(function() {
 var dialogElimTarea = $("#eliminarTarea").dialog(
			{
				autoOpen : false,
				height : 300,
				width : 350,
				modal : true,
				buttons : {
					'Eliminar Tarea' : function() {
						var nRelease = $("#ne-release").val();
						var nSprint = $("#ne-sprint").val();
						var id = $("#id").val();
						console.log("neerelease" + nRelease);
						console.log("nSprint" + nSprint);
						console.log("id" + id);
						$(document).ready(
								controller.eliminarTarea(nRelease, nSprint,
										id));
						dialogElimTarea.dialog("close");
					},
					Cancelar : function() {
						dialogElimTarea.dialog("close");
					}
				},
				close : function() {
					form[0].reset();
					dialogElimTarea.dialog("close");
				}
			});

	$("#eliminar-tarea").button().on("click", function() {
		dialogElimTarea.dialog("open");
	});
});

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

$(function() {
	dialogSprint = $("#dialog-sprint").dialog({
		autoOpen : false,
		height : 300,
		width : 350,
		modal : true,
		buttons : {
			'Crear Sprint' : function() {
				var numeroRelease = $("#numRelease").val();
				$(document).ready(controller.crearSprint(numeroRelease));
				dialogSprint.dialog("close");
			},
			Cancelar : function() {
				dialogSprint.dialog("close");
			}
		}
	});

	$("#create-sprint").button().on("click", function() {
		dialogSprint.dialog("open");
	});
});

function nuevoBotonSprint(numeroRelease) {
	var boton = $('<div><button id="agregarSprint'+numeroRelease+'">Agregar Sprint</button></div>').click(function () {
		$(document).ready(controller.crearSprint(numeroRelease));
	});
	return boton
}

function nuevoBotonTarea(numeroRelease,numeroSprint) {
	var boton = $('<div><button id="agregarTarea'+numeroRelease+numeroSprint+'">Agregar tarea</button></div>').click(function () {
		alert("hola");
		abrirDialogCrearTarea(numeroRelease, numeroSprint);
	});
	return boton
}

function agregarBotonesAreleases(proyecto) {
	for (var i = 0; i < proyecto.release.length; i++) {
		var release = $("#release"+i)//document.getElementById('release'+i);
		release.append(nuevoBotonSprint(i));
		agregarBotonesAsprint(proyecto.release[i], i);
	}
}

function agregarBotonesAsprint(release, idRelease){
	for (var i = 0; i < release.listaSprints.length; i++) {
		var sprint = $("#celdaSprint"+idRelease+i)
		sprint.append(nuevoBotonTarea(idRelease, i))
	}
}
