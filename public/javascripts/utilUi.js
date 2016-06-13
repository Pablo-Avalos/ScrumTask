$(document).ready(function() {
	$("#sortable1, #sortable2").sortable({
		connectWith : ".connectedSortable"
	}).disableSelection();
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

$(document)
		.ready(
				function() {
					$(".column").sortable({
						connectWith : ".column",
						handle : ".portlet-header",
						cancel : ".portlet-toggle",
						placeholder : "portlet-placeholder ui-corner-all"
					});

					$(".portlet")
							.addClass(
									"ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
							.find(".portlet-header")
							.addClass("ui-widget-header ui-corner-all")
							.prepend(
									"<span class='ui-icon ui-icon-minusthick portlet-toggle'></span>");

					$(".portlet-toggle")
							.click(
									function() {
										var icon = $(this);
										icon
												.toggleClass("ui-icon-minusthick ui-icon-plusthick");
										icon.closest(".portlet").find(
												".portlet-content").toggle();
									});
				});


$("btnAgregarTarj").click(function() {
	agregarTarjeta();
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

$(document).ready(function() {
    $( "#Select-Proyectos" ).selectable();
});


$(function() {
    $( "#tabs" ).tabs();
  });