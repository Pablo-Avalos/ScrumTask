var idProyectoActual = null;
var proyectos = null;
var proyectoActual = null;


/* Obtener proyectos disponibles */
$.ajax({
	type : 'GET',
	contentType : 'application/json',
	dataType : 'json',
	url : '/proyectos',
	success : function(response) {
		proyectos = response;
		console.log(response[0]);
		idProyectoActual = response[0].id;
		var select = $("#Select-Proyectos");
		for (var i = 0; i < response.length; i++) {
			$("#Select-Proyectos").append(
					'<option value="' + response[i].id + '">'
							+ response[i].nombre + '</option>');
		}
		obtenerTablero(idProyectoActual)
		obtenerIntegrantes(idProyectoActual)
	}
});


/* Seleccionar un proyecto */
$(document).ready( function () {
	$('#Select-Proyectos').change(function() {
		actualizarProyecto(this.value); //this.value es el id del proyecto seleccionado
	});
});

function actualizarProyecto(idProyecto){
	idProyectoActual = idProyecto
	actualizarIntegrantes();
	//actualizarReuniones();
	actulizarTablero();
}

function actulizarTablero(){
	$("#tableroConTareas").empty();
	obtenerTablero(idProyectoActual);
}


function obtenerTablero(idProyecto) {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		dataType : 'json',
		url : '/tablero/' + idProyecto,
		success : function(response) {
			for (var i = 0; i < response.tareas.length; i++) {
				$("#tableroConTareas").append(
						'<li id = "dialog" class="ui-state-default"> Id : '
								+ response.tareas[i].id + '<br> Nombre : '
								+ response.tareas[i].nombre + '<br> Descripcion: '+ response.tareas[i].descripcion + '</li>');

			}
		}
	});
}

function obtenerIntegrantes(idProyecto) {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		dataType : 'json',
		url : '/integrantes/' + idProyecto,
		success : function(response) {
			for (var i = 0; i < response.length; i++) {
				$("#selectable").append(
						'<li class="ui-widget-content">' + response[i].nombre + '</li>');
			}
		}
	});
}

$(function() {
	$("#dialog").dialog();
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

$(function() {
	$("#tableroConTareas").sortable();
	$("#tableroConTareas").disableSelection();
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
				var nombre = $("#name").val();
				var descripcion = $("#descripcion").val();
				$(document).ready(crearTarea(idProyectoActual, nombre, descripcion));
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
		},
		complete : function () {
			actulizarTablero();
		}
	});
}



//Integrantes

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
		eliminarIntegranteSeleccionado();
	});
});


function eliminarIntegranteSeleccionado() {
	$.ajax({
		type : 'GET',
		contentType : 'application/json',
		dataType : 'json',
		url : '/eliminarIntegrante/' + idProyectoActual + '/' + nombreIntegranteSeleccionado,
		success : function(response) {
		},
		complete : function () {
			actualizarIntegrantes();
		}
	});
}

function actualizarIntegrantes(){
	$("#selectable").empty();
	obtenerIntegrantes(idProyectoActual);
}

// Reuniones

jQuery.browser = {};
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        jQuery.browser.version = RegExp.$1;
    }
})();


jQuery(document).ready(function() { 
    jQuery("#jqGrid").jqGrid({
    	type : 'GET',
        url:'/reuniones/' + 1,
        editurl:'/reuniones/' + 1, 
        datatype: "json",
        colNames:['ID'], //,'Tipo','Integrantes', 'Temas Tratados'],
        colModel: [
            { label: 'id',name: 'ID',width: 75,key: true,editable: true,editrules : { required: true}} //,
            //{ label: 'tipo',name: 'Tipo',width: 140,editable: true},
            //{ label: 'integrantes',name: 'Integrantes',width: 140,editable: true},
            //{ label : 'temasTratados',name: 'Temas Tratados',width: 100,editable: true}
            ],
		sortname: 'CustomID',
		sortorder : 'asc',
		caption:"Reuniones",
		loadonce: true,
		viewrecords: true,
		gridview: true,
        width: 1100,
        height: 350,
        rowNum: 10,
        //rowList: [3],
        //height: '100%'
        pager: "#jqGridPager"
    });

    $('#jqGrid').navGrid('#jqGridPager',
        // the buttons to appear on the toolbar of the grid
        { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
        // options for the Edit Dialog
        {
            editCaption: "The Edit Dialog",
            recreateForm: true,
			checkOnUpdate : true,
			checkOnSubmit : true,
            closeAfterEdit: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Add Dialog
        {
            closeAfterAdd: true,
            recreateForm: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Delete Dailog
        {
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        });
});