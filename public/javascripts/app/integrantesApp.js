var nombreIntegranteSeleccionado = null;

$(function() {
    $( "#selectable" ).selectable({
      stop: function() {
        $( ".ui-selected", this ).each(function() {
          nombreIntegranteSeleccionado = $(this).text();
        });
      }
    });
});

/* Eliminar el integrante seleccionado*/
$(function() {
	$("#eliminarIntegrante").button({}).on("click", function() {
		controller.eliminarIntegrante(nombreIntegranteSeleccionado);
	});
});

/* Agregar un integrante */

$(function() {
	var dialog, form,

	dialogAgregarIntegrante = $("#dialogAgregarIntegrante").dialog({
		autoOpen : false,
		height : 400,
		width : 350,
		modal : true,
		buttons : {
			'Agregar' : function() {
				var nombre = $("#idIntegrante").val();
				$(document).ready(controller.agregarIntegrante(nombre));
				dialogAgregarIntegrante.dialog("close");
			},
			Cancelar : function() {
				dialogAgregarIntegrante.dialog("close");
			}
		},
		close : function() {

		}
	});

  $('input[type="checkbox"]').not(this).prop("checked", false);

	$("#agregarIntegrante").button().on("click", function() {
		dialogAgregarIntegrante.dialog("open");
	});
});
