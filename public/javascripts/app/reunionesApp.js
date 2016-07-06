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
var reunionActual;
var idNuevaReunion = -1;
var fechaReunion;
//carga de datos de reunión
jQuery(document).ready(function() {
	jQuery("#jqGrid").jqGrid({
		mtype : "GET",
		colNames : [ 'ID', 'Tipo','Fecha', 'Integrantes', 'Temas Tratados' ],
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
			width : 13
		},{
			label : 'Fecha',
			name : 'fecha',
			index : 'fecha',
			width : 15
		}, {
			label : 'Integrantes',
			name : 'integrantes',
			index : 'integrantes',
			width : 65
		}, {
			label : 'Temas Tratados',
			name : 'temasTratados',
			index : 'temasTratados',
			width : 75
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
		width : 1100,
		height : 400,
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
		if(celdaSeleccionada == null){
			$("#reunionVer").click();			
		}else {
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
		//title : "Detalle de reunión",
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
					$("#ver").dialog('option', 'title', 'Ver Reunión');
					$("#ver").dialog("option", "width", 300);
					$("#ver").dialog("option", "height", 400);
					$("#ver").append(
							'<p>Reunión número: ' + reunionActual.id
									+ '</p>');
					$("#ver").append(
							'<p>Tipo de reunión: ' + reunionActual.tipo
									+ '</p>');
					$("#ver").append(
							'<p>Fecha de reunión: ' + reunionActual.fecha
									+ '</p>');
					$("#ver").append(
							'Participantes: <br> <textarea readonly width="40" height="40" class="text ui-widget-content ui-corner-all">'
							+ reunionActual.integrantes.split(",") +'</textarea><br>');
					$("#ver").append(
							'Tema y Descripción: <br> <textarea readonly width="40" height="40" class="text ui-widget-content ui-corner-all">'
							+ reunionActual.temasTratados +'</textarea>');
				} else {
					$("#ver").dialog("option", "width", 310);
					$("#ver").dialog("option", "height", 210);
					$("#ver").dialog('option', 'title', 'Error: ');
					$("#ver").append(
							'<p>No se seleccionó ninguna reunión</p><br>');
				}
				dialogVerReunion.dialog('open');
			});
});

// Ventana para crear una reunión 
$(function() {
	var dialog, form, dialogCrearTema = $("#dialog-Tema").dialog(
			{
				autoOpen : false,
				//title : "Organizar Reuniones",
				height : 500,
				width : 500,
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
						var date = $("#fechareunion").datepicker('getDate'),
			            day  = date.getDate().toString(),  
			            month = (date.getMonth() + 1).toString(),              
			            year =  (date.getFullYear()).toString();
						fechaReunion = day + "-" + month + "-" + year;
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
					reiniciarGuardarDialog();
					dialogCrearTema.dialog("close");
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
		url : '/guardarReunion/' + controller.idProyectoActual + '/' + idNuevaReunion + '/' + fechaReunion + '/'
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

$(function() {
    $("#fechareunion").datepicker({
    	dateFormat: "dd-mm-yy",
    	minDate: new Date(),
    	setDate: new Date()
    });
});

function reiniciarGuardarDialog(){
	$("#nombre-tema").val("");
	$("#descripcion-tema").val("");
	checkeados = $("input:checked").each(function() {
		$('input:checkbox').removeAttr('checked');
	});
	//$("#reunion-tipo").empty();
	$("#dialog-Tema").dialog('option', 'title', 'Guardar Reunión');
	$("#fechareunion").datepicker( "setDate", new Date());
	idNuevaReunion = -1;
};






// Editar

$(function() {

	$("#reunionEditar").button({}).on("click", function() {
		if(celdaSeleccionada == null){
			$("#reunionVer").click();			
		}else {
		$("#fechareunion").datepicker( "setDate", reunionActual.fecha);
		var temasTratados = reunionActual.temasTratados.split(": ");
		$("#nombre-tema").val(temasTratados[0]);
		$("#descripcion-tema").val(temasTratados[1]);
		$("#reunion-tipo").val(reunionActual.tipo);
		$("#dialog-Tema").dialog('option', 'title', 'Editar Reunión');
		controller.obtenerUsuariosDeReunion(reunionActual.id);
		idNuevaReunion = reunionActual.id;
		$("#reunionCrear").click();
		};
	});
});
	
