/* Obtener todos los proyectos */
$(document).ready(function () {
  controller.obtenerProyectos();
});

/* Seleccionar un proyecto */
$(document).ready( function () {
	$('#Select-Proyectos').change(function() {
		actualizarProyecto(this.value); //this.value es el id del proyecto seleccionado
	});
});

function actualizarProyecto(idProyecto){
  controller.idProyectoActual = idProyecto;
	actualizarIntegrantes();
	actualizarReuniones();
	actulizarTablero();
}

function actualizarListaProyectos(){
  vaciarProyecto();
  controller.obtenerProyectos();
}

function vaciarProyecto(){
  $("#Select-Proyectos").empty();
  $("#tableroConTareas").empty();
  $(".selectable").empty();
  $("#reunion-tipo").empty();
  jQuery("#jqGrid").clearGridData();
}

function actulizarTablero(){
//	$("#tableroConTareas").empty();

	$("#tableroConRelease").empty();
	controller.obtenerTablero();
}

function actualizarIntegrantes(){
	$(".selectable").empty();
	controller.obtenerIntegrantes();
}

function actualizarReuniones(){
	vaciarReuniones();
	controller.obtenerReunionesDeProyecto();
}

function actualizarIntegrantesDeReunion(){

}

function vaciarReuniones(){
	jQuery("#jqGrid").clearGridData();
	$("#reunion-tipo").empty();
	celdaSeleccionada=null;
	//reunionActual=null;
	$("#integranteReunion").empty();
}

function desabilitarBotonEliminarProyecto(){
  $("#eliminarProyecto").button({
    disabled : true
  })
}

function habilitarBotonEliminarProyecto(){
  $("#eliminarProyecto").button({
    disabled : false
  })
}




/* Eliminar proyecto */

$(function() {
	var dialog, form,

	dialogEliminarProyecto = $("#confirmarEliminarProyecto").dialog({
		autoOpen : false,
		height : 400,
		width : 350,
		modal : true,
		buttons : {
			'Aceptar' : function() {
				controller.eliminarProyecto();
        dialogEliminarProyecto.dialog("close");
			},
			Cancelar : function() {
				dialogEliminarProyecto.dialog("close");
			}
		},
		close : function() {}
	});

  $("#eliminarProyecto").button({}).on("click", function() {
    $("#confirmarEliminarProyecto").empty();
    $("#confirmarEliminarProyecto").append('<p>¿Desea eliminar el proyecto?</p>');
    dialogEliminarProyecto.dialog('open');
  });
});
