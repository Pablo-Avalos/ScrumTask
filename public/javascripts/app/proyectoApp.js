var nuevoProyectoNombre;

	// Ventana para crear una proyecto
	$(function() {
		var dialog, form,

		dialogCrearID = $("#agregarProyectoDialog").dialog(
				{
					autoOpen : false,
					title : "Crear Proyecto",
					height : 400,
					width : 350,
					modal : true,
					buttons : {
						'Guardar' : function() {
								nuevoProyectoNombre = $("#nombreProyecto").val();
								agregarProyecto();
								dialogCrearID.dialog("close");
						},
						Cancelar : function() {
							reiniciarDialogCrearID();
							dialogCrearID.dialog("close");
						}
					},
					close : function() {
					}
				});
		$("#agregarProyecto").button({}).on("click", function() {
			dialogCrearID.dialog('open');
		});
	});

	// agregar el proyecto en application y actualizar la ui
	function agregarProyecto() {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/agregarProyecto/' + nuevoProyectoNombre,
			success : function(response) {
			},
			complete : function() {
			reiniciarGuardarDialog();
	                actualizarListaProyectos();
			}
		});
	}
	// Limpiar la ventana de guardar

	function reiniciarDialogCrearID(){
		$("#id-Proyecto").val("");
		$("#nombre-Proyecto").val("");
	}
