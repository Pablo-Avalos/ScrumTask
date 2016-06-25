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

$(function() {
	$("#agregarIntegrante").button().on("click", function() {
		//abrir dialog
	});
});

$(function() {
	$("#eliminarIntegrante").button({}).on("click", function() {
		controller.eliminarIntegrante(nombreIntegranteSeleccionado);
	});
});
