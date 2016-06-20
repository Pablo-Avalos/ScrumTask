var idProyectoActual = null;
var proyectos = null;

$.ajax({
	type : 'GET',
	contentType : 'application/json',
	dataType : 'json',
	url : '/proyectos',
	success : function(response) {
		proyectos = response;
		console.log(response[0]);
		idProjectoActual = response[0].id;
		var select = $("#Select-Proyectos");
		for (var i = 0; i < response.length; i++) {
			$("#Select-Proyectos").append(
					'<option value="' + response[i].id + '">'
							+ response[i].nombre + '</option>');
		}
	}
});

function obtenerTablero(idProyecto) {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		dataType : 'json',
		url : '/tablero/' + idProyecto,
		success : function(response) {
			for (var i = 0; i < response.tareas.length; i++) {
				$("#sortable").append(
						'<li id = "dialog" class="ui-state-default"> Id : '
								+ response.tareas[i].id + '<br> Nombre : '
								+ response.tareas[i].nombre + '<br> Descripcion: '+ response.tareas[i].descripcion + '</li>');

			}
		}
	});
}
$(function() {
	$("#dialog").dialog();
});
$(document).ready(obtenerTablero(1));

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
				var idProyecto = $("#idProyecto").val();
				var nombre = $("#name").val();
				var descripcion = $("#descripcion").val();
				$(document).ready(crearTarea(idProyecto, nombre, descripcion));
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

function crearTarea(idProyecto, nombre, descripcion) {
	var tarea = '1';
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		dataType : 'json',
		url : '/agregarTarea/' + idProyecto + '/' + nombre + '/' + descripcion,
		success : function(response) {
			tarea = response;
		}

	});
	$("#sortable").empty();
	obtenerTablero(1);
}
