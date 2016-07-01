// solución de problemas con navegador
jQuery.browser = {};
(function() {
	jQuery.browser.msie = false;
	jQuery.browser.version = 0;
	if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
		jQuery.browser.msie = true;
		jQuery.browser.version = RegExp.$1;
	}
})();

var celdaSeleccionada;
var nuevaReunionTemaNombre;
var nuevaReunionTemaDescripcion;
var nuevaReunionTipo;
var checkeados = [];

//carga de datos de reunión
jQuery(document).ready(function() {
	jQuery("#jqGrid").jqGrid({
		mtype : "GET",
		colNames : [ 'ID', 'Tipo', 'Integrantes', 'Temas Tratados' ],
		colModel : [ {
			label : 'ID',
			name : 'id',
			index : 'id',
			width : 10,
			sorttype : "int"
		}, {
			label : 'Tipo',
			name : 'tipo',
			index : 'tipo',
			width : 15
		}, {
			label : 'Integrantes',
			name : 'integrantes',
			index : 'integrantes',
			width : 60
		}, {
			label : 'Temas Tratados',
			name : 'temasTratados',
			index : 'temasTratados',
			width : 60
		} ],
		onSelectRow : function(id) {
			celdaSeleccionada = id
			reunionActual = jQuery("#jqGrid").jqGrid('getRowData', id);
		},
		sortname : 'CustomID',
		sortorder : 'asc',
		caption : "Reuniones",
		loadonce : true,
		viewrecords : true,
		gridview : true,
		gridstate : true,
		width : 1050,
		height : '100%',
		rowNum : 10,
	}).navGrid("#jqGrid", {
		edit : false,
		add : false,
		del : false
	});
});

// Ventana ver reunión
$(function() {
	$("#reunionEliminar").button({}).on("click", function() {
		// javascript: return confirm('¿Estas seguro?');
		if (reunionActual == null) {
			alert("Debe seleccionar una reunión antes de continuar");
		} else {
			if (!confirm("¿Desea eliminar la reunión?")) {
				return false;
			} else {
				eliminarReunion();
			}
		}
	});
});

// Eliminar reunión
function eliminarReunion() {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		dataType : 'json',
		url : '/eliminarReunion/' + controller.idProyectoActual + '/'
				+ reunionActual.id,
		success : function(response) {
		},
		complete : function() {
			actualizarReuniones();
		}
	});
};

// dialogo ver reunión
$(function() {
	var dialog, form,

	dialogVerReunion = $("#ver").dialog({
		autoOpen : false,
		title : "Detalle de reunión",
		height : 400,
		width : 350,
		modal : true,
		buttons : {
			Aceptar : function() {
				dialogVerReunion.dialog("close");
			}
		},
		close : function() {
		}
	});

	// Ventana para ver una reunión
	$("#reunionVer").button({}).on(
			"click",
			function() {
				$("#ver").empty();
				if (celdaSeleccionada != null) {
					$("#ver").append(
							'<p>Reunión número: ' + reunionActual.id
									+ '</p><br>');
					$("#ver").append(
							'<p>Tipo de reunión: ' + reunionActual.tipo
									+ '</p><br>');
					$("#ver").append(
							'<p>Participantes: ' + reunionActual.integrantes
									+ '</p><br>');
					$("#ver").append(
							'<p>Temas: ' + reunionActual.temasTratados
									+ '</p><br>');
				} else {
					$("#ver").append(
							'<p>No se selecciono ninguna reunion</p><br>');
				}
				dialogVerReunion.dialog('open');
			});
});

// Ventana para crear una reunión 
$(function() {
	var dialog, form, dialogCrearTema = $("#dialog-Tema").dialog(
			{
				autoOpen : false,
				title : "Crear Reunión",
				height : 400,
				width : 350,
				modal : true,
				buttons : {
					'Guardar' : function() {
						nuevaReunionTemaNombre = $("#nombre-tema").val();
						nuevaReunionTemaDescripcion = $("#descripcion-tema")
								.val();
						nuevaReunionTipo = $("#reunion-tipo").val();
						checkeados = $("input:checked").each(function() {
							checkeados = checkeados + 1
						});
						if (nuevaReunionTemaNombre == ""
								|| nuevaReunionTemaDescripcion == ""
								|| checkeados.length == 0) {
							alert("Para continuar, complete los datos");
						} else {
							integrantes="";
							$("input:checked").each(
									function() {
										checkeados[checkeados.length] = $(this).val();
										integrantes = integrantes + $(this).val().toString() + ",";
									});
							agregarReunion();
							dialogCrearTema.dialog("close");
						}
					},
					Cancelar : function() {
						reiniciarGuardarDialog();
						dialogCrearTema.dialog("close");
					}
				},
				close : function() {
				}
			});
	$("#reunionCrear").button({}).on("click", function() {
		dialogCrearTema.dialog('open');
	});
});

// agregar la reunión en application y actualizar la ui
function agregarReunion() {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		dataType : 'json',
		url : '/guardarReunion/' + controller.idProyectoActual + '/'
				+ nuevaReunionTipo + '/'
				+ nuevaReunionTemaNombre + '/' + nuevaReunionTemaDescripcion + '/' + integrantes,
		success : function(response) {
		},
		complete : function() {
		reiniciarGuardarDialog();
        actualizarReuniones();
		}
	});
}
// Limpiar la ventana de guardar

function reiniciarGuardarDialog(){
	$("#nombre-tema").val("");
	$("#descripcion-tema").val("");
	checkeados = $("input:checked").each(function() {
		$('input:checkbox').removeAttr('checked');
	});
}

// Carga el selector de tipos de reunion
$(document).ready(
		function() {
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				dataType : 'json',
				url : '/tiposDeReunion',
				success : function(response) {
					for (var i = 0; i < response.length; i++) {
						$("#reunion-tipo").append(
								'<option>' + response[i].tipo + '</option>');
					}
				}
			});
		});

// carga los integrantes del proyecto para agregarlos a la reunion
$(document).ready(
		function() {
			$
					.ajax({
						type : 'GET',
						contentType : 'application/json',
						dataType : 'json',
						url : '/integrantes/1',
						success : function(response) {
							for (var i = 0; i < response.length; i++) {
								$('#integranteReunion').append(
										'<li> <input type="checkbox" name="rol" value='
												+ response[i].id + '>'
												+ response[i].nombre
												+ '</label></li>');
							}
						}
					});
		});


// Editar
$(function() {
	$("#reunionEditar").button({}).on("click", function() {
		alert("Hacer cuanto antes");
	});
});