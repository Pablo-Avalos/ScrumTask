var nombreIntegranteSeleccionado = null;

$(function() {
    $( ".selectable" ).selectable({
      stop: function() {
        $( ".ui-selected", this ).each(function() {
          nombreIntegranteSeleccionado = $(this).text();
          disableEnableButton();
        });
      }
    });
});

/* Eliminar el integrante seleccionado*/
$(function() {
	$("#eliminarIntegrante").button({}).on("click", function() {
		controller.eliminarIntegrante(nombreIntegranteSeleccionado);
    nombreIntegranteSeleccionado = null;
    disableEnableButton();
	});
});


function disableEnableButton(){
  if (nombreIntegranteSeleccionado == null) {
    $("#eliminarIntegrante").button({
      disabled : true
    })
  }
  else {
    $("#eliminarIntegrante").button({
      disabled : false
    })
  }
}

$(function () {
  disableEnableButton();
})


$(function() {
  /* Permitir seleccionar un unico rol */
  $('input.rol').on('change', function() {
    $('input.rol').not(this).prop('checked', false);
  });
});

function enableDisableRol(){
  if (yaTieneScrumMaster()) {
    $('input.rol[name="scrumMaster"]').prop('disabled', true);
  }
  else {
    $('input.rol[name="scrumMaster"]').prop('disabled', false);
  }
  if (yaTieneProductOwner()) {
    $('input.rol[name="productOwner"]').prop('disabled', true);
  }
  else {
    $('input.rol[name="productOwner"]').prop('disabled', false);
  }
}

function yaTieneScrumMaster() {
  return ($("#selectableScrumMaster").children().length) > 0;
}

function yaTieneProductOwner() {
  return ($("#selectableProductOwner").children().length) > 0;
}

/* Agregar un integrante */

$(function() {
  var nombre = "";
	var dialog, form,

	dialogAgregarIntegrante = $("#dialogAgregarIntegrante").dialog({
		autoOpen : false,
		height : 400,
		width : 350,
		modal : true,
    buttons: [
        {
          text: 'Aceptar',
          click: function() {
            nombre = $("#idIntegrante").val();
            var tipo = null;
            $("input:checked").each(function() {
              tipo = $(this).val();
            });
    				$(document).ready(controller.agregarIntegrante(nombre, tipo));
            nombreIntegranteSeleccionado = null;
            checkeados = $("input:checked").each(function() {
        		$('input:checkbox').removeAttr('checked');
        	});
            disableEnableButton();
    				dialogAgregarIntegrante.dialog("close");
          },
          disabled: completoLosCampos(nombre)
        },
        {
          text: 'Cancelar',
          click: function () {
              checkeados = $("input:checked").each(function() {
            		$('input:checkbox').removeAttr('checked');
            	   }) 
            dialogAgregarIntegrante.dialog("close");
          },
        },
    ]
	});

  $('input[type="checkbox"]').not(this).prop("checked", false);

	$("#agregarIntegrante").button().on("click", function() {
    enableDisableRol();
		dialogAgregarIntegrante.dialog("open");
	});
});

function completoLosCampos(nombre) {
  return false;
}
