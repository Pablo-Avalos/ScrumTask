var controller = {

  idProyectoActual: null,
  proyectos: null,
  proyectoActual: null,

  obtenerProyectos: function () {
    $.ajax({
    	type : 'GET',
    	contentType : 'application/json',
    	dataType : 'json',
    	url : '/proyectos',
    	success : function(response) {
    		proyectos = response;
    		controller.idProyectoActual = response[0].id;
    		var select = $("#Select-Proyectos");
    		for (var i = 0; i < response.length; i++) {
    			$("#Select-Proyectos").append(
    					'<option value="' + response[i].id + '">'
    							+ response[i].nombre + '</option>');
    		}
    		controller.obtenerTablero(controller.idProyectoActual);
    		controller.obtenerIntegrantes(controller.idProyectoActual);
    	}
    });
  },

  obtenerTablero: function() {
    $.ajax({
      type : 'GET',
      contentType : 'application/json',
      dataType : 'json',
      url : '/tablero/' + controller.idProyectoActual,
      success : function(response) {
        for (var i = 0; i < response.tareas.length; i++) {
          $("#tableroConTareas").append(
              '<li id = "dialog" class="ui-state-default" value="'+ response.tareas[i].id +'"> Id : '
                  + response.tareas[i].id + '<br> Nombre : '
                  + response.tareas[i].nombre + '<br> Descripcion: '+ response.tareas[i].descripcion + '</li>');
        }
      }
    });
  },

  obtenerIntegrantes: function() {
    $.ajax({
  		type : 'GET',
  		contentType : 'application/json',
  		dataType : 'json',
  		url : '/integrantes/' + controller.idProyectoActual,
  		success : function(response) {
  			for (var i = 0; i < response.length; i++) {
  				$("#selectable").append(
  						'<li class="ui-widget-content">' + response[i].nombre + '</li>');
  			}
  		}
  	});
  },

  crearTarea: function (nombre, descripcion) {
  	var tarea = '1';
  	$.ajax({
  		type : 'GET',
  		contentType : 'application/json',
  		dataType : 'json',
  		url : '/agregarTarea/' + controller.idProyectoActual + '/' + nombre + '/' + descripcion,
  		success : function(response) {
  			tarea = response;
  		},
  		complete : function () {
  			actulizarTablero();
  		}
  	});
  },

  eliminarIntegrante: function(nombreIntegrante) {
  	$.ajax({
  		type : 'GET',
  		contentType : 'application/json',
  		dataType : 'json',
  		url : '/eliminarIntegrante/' + controller.idProyectoActual + '/' + nombreIntegrante,
  		success : function(response) {
  		},
  		complete : function () {
  			actualizarIntegrantes();
  		}
  	});
  },

  agregarIntegrante: function(nombreIntegrante) {
    $.ajax({
  		type : 'GET',
  		contentType : 'application/json',
  		dataType : 'json',
  		url : '/agregarIntegrante/' + controller.idProyectoActual + '/' + nombreIntegrante,
  		success : function(response) {
  		},
  		complete : function () {
  			actualizarIntegrantes();
  		}
  	});
  },
   eliminarTarea: function(id) {
    $.ajax({
      type : 'GET',
      contentType : 'application/json',
      dataType : 'json',
      url : '/eliminarTarea/' + controller.idProyectoActual + '/' + id,
      success : function(response) {
      },
      complete : function () {
        actulizarTablero();
      }
    });
  }
};
