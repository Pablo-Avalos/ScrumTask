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
	//actualizarReuniones();
	actulizarTablero();
}

function actulizarTablero(){
	$("#tableroConTareas").empty();
	controller.obtenerTablero();
}

function actualizarIntegrantes(){
	$("#selectable").empty();
	controller.obtenerIntegrantes();
}
