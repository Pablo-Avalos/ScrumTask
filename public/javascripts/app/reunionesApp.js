jQuery.browser = {};
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        jQuery.browser.version = RegExp.$1;
    }
})();

//$(document).ready(function() {
//	$.ajax({
//		type : 'GET',
//		contentType : 'application/json',
//		dataType : 'json',
//		url : '/reuniones/1',
//		success : function(reuniones) {
//			for(var i=0;i<=reuniones.length;i++){
//			    jQuery("#jqGrid").addRowData(i, reuniones[i])
//		    };
//		}
//	});
//});


var reunionSeleccionada;	 
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
            	var ret = jQuery("#jqGrid").jqGrid('getRowData',id);
            	reunionSeleccionada = ret.id;            	
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
			eliminarReunion(reunionSeleccionada);
			}
		});
	});
	
	function eliminarReunion (reunionSeleccionada) {
	  	$.ajax({
	  		type : 'GET',
	  		contentType : 'application/json',
	  		dataType : 'json',
	  		url : '/eliminarReunion/' + controller.idProyectoActual + '/' + reunionSeleccionada,
	  		success : function(response) {
	  		},
	  		complete : function () {
	  			actualizarReuniones();
	  		}
	  	});
	  };