jQuery.browser = {};
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        jQuery.browser.version = RegExp.$1;
    }
})();

var celdaSeleccionada;
var reunionActual;
jQuery(document).ready(function() {
    jQuery("#jqGrid").jqGrid({
		mtype : "GET",
        colNames:['ID','Tipo','Integrantes', 'Temas Tratados'],
        colModel: [
           {label: 'ID',name: 'id',index: 'id',width:10,sorttype: "int"},
           {label: 'Tipo',name: 'tipo',index: 'tipo',width: 15},
           {label: 'Integrantes',name: 'integrantes',index: 'integrantes', width: 60},
           {label: 'Temas Tratados',name: 'temasTratados',index: 'temasTratados',width: 60}
            ],
            onSelectRow: function(id){
            	celdaSeleccionada= id
            	reunionActual = jQuery("#jqGrid").jqGrid('getRowData',id);            	
             },    
		sortname: 'CustomID',
		sortorder : 'asc',
		caption:"Reuniones",
		loadonce: true,
		viewrecords: true,
		gridview: true,
		gridstate: true,
        width: 1100,
        height: '100%',
        rowNum: 10,
    }).navGrid("#jqGrid",{edit:false,add:false,del:false});
});
 
	$(function() {
		$("#reunionEliminar").button({}).on("click", function() {
			//javascript: return confirm('¿Estas seguro?');
			if (!confirm("¿Desea eliminar la reunión?")) {
				return false;
				}
			else {
			eliminarReunion(reunionActual.id);
			}
		});
	});
	
	function eliminarReunion () {
	  	$.ajax({
	  		type : 'GET',
	  		contentType : 'application/json',
	  		dataType : 'json',
	  		url : '/eliminarReunion/' + controller.idProyectoActual + '/' + reunionActual.id,
	  		success : function(response) {
	  		},
	  		complete : function () {
	  			actualizarReuniones();
	  		}
	  	});
	  };
	  
// Editar reunión
		function editarReunion () {
		  	$.ajax({
		  		type : 'GET',
		  		contentType : 'application/json',
		  		dataType : 'json',
		  		url : '/editarReunion/' + controller.idProyectoActual + '/' + reunionActual.id,
		  		success : function(response) {
		  		},
		  		complete : function () {
		  			actualizarReuniones();
		  		}
		  	});
		  };
	  
// dialogo ver reunión. Requiere tener el modelo.	 
	  $(function() {
			var dialog, form,

			dialogVerReunion = $("#ver").dialog({
				autoOpen : false,
				title: "Detalle de reunión",
				height : 400,
				width : 350,
				modal : true,
				buttons : {
					Aceptar : function() {
						dialogVerReunion.dialog("close");
					}
				},
				close : function() {}
			});

		  $("#reunionVer").button({}).on("click", function() {
		    $("#ver").empty();
            $("#ver").append('<p>Reunión número: '+reunionActual.id+'</p><br>');
            $("#ver").append('<p>Tipo de reunión: '+reunionActual.tipo+'</p><br>');
            $("#ver").append('<p>Participantes: '+reunionActual.integrantes+'</p><br>');
			$("#ver").append('<p>Temas: '+reunionActual.temasTratados+'</p><br>');
		    dialogVerReunion.dialog('open');
		  });
		});