var controller = {

	idProyectoActual : null,
	proyectos : null,
	proyectoActual : null,

	obtenerProyectos : function() {
		$
				.ajax({
					type : 'GET',
					contentType : 'application/json',
					dataType : 'json',
					url : '/proyectos',
					success : function(response) {
						if (response.length < 1) {
							// Todo
							vaciarProyecto();
							desabilitarBotonEliminarProyecto();
						} else {
							proyectos = response;
							controller.idProyectoActual = response[0].id;
							controller.proyectoActual = response[0];
							var select = $("#Select-Proyectos");
							for (var i = 0; i < response.length; i++) {
								$("#Select-Proyectos").append(
										'<option value="' + response[i].id
												+ '">' + response[i].nombre
												+ '</option>');
							}
							habilitarBotonEliminarProyecto();
							controller
									.obtenerTablero(controller.idProyectoActual);
							controller
									.obtenerIntegrantes(controller.idProyectoActual);
							controller
									.obtenerReunionesDeProyecto(controller.idProyectoActual);
						}
					}
				});
	},

	obtenerTablero : function() {
		$
				.ajax({
					type : 'GET',
					contentType : 'application/json',
					dataType : 'json',
					url : '/tablero/' + controller.idProyectoActual,
					success : function(response) {
						var divTabla = document
								.getElementById("tableroConRelease");
						var tabla = document.createElement("table");
						var tblBody = document.createElement("tbody");

						for (var i = 0; i < response.release.length; i++) {

							var fila = document.createElement("tr");
							var celdaRelease = document.createElement("td");
							var textoCeldaRelease = document
									.createTextNode("Release "
											+ response.release[i].numero);
							celdaRelease.setAttribute("id", "release" + i)
							celdaRelease.setAttribute("value", i);
							celdaRelease.appendChild(textoCeldaRelease);

							fila.appendChild(celdaRelease);

							for (var j = 0; j < response.release[i].listaSprints.length; j++) {
								var fechaInicio = response.release[i].listaSprints[j].fechaInicio;
								var fechaFin = response.release[i].listaSprints[j].fechaFin;

								var numerSpt = response.release[i].listaSprints[j].numero;
								var celdaSprint = document.createElement("td");

								var textoCeldaSprint = document
										.createTextNode("Sprint " + numerSpt);

								celdaSprint.appendChild(textoCeldaSprint);

								celdaSprint.setAttribute("id", "celdaSprint"
										+ i + j);
								celdaSprint.appendChild(document
										.createElement("br"));

								var fechaInicioSprint = document
										.createTextNode("Fecha Inicio: "
												+ fechaInicio);

								celdaSprint.appendChild(fechaInicioSprint);

								var divTareas = document.createElement("div");
								divTareas.setAttribute("value", i);
								var ullist = document.createElement("ul");
								divTareas.appendChild(ullist);
								ullist.setAttribute("id", "tareas" + j);
								ullist.setAttribute("value", j);
								ullist.setAttribute("class", "sortable")
								ullist.setAttribute("style", "height: 150px;");
								for (var h = 0; h < response.release[i].listaSprints[j].listaTareas.length; h++) {
									var tarea = response.release[i].listaSprints[j].listaTareas[h];
									var celdaTareas = document
											.createElement("li");
									var estado = controller.cambiarEstado(tarea.estado.codigo);

									celdaTareas.setAttribute("class",
											"tareaParaEliminar " + estado);
									
									celdaTareas.setAttribute("value", tarea.id);
									var nombre = document.createElement("div");
									nombre.appendChild(document
											.createTextNode(tarea.nombre))

									var tablaTarea = document.createElement("table");
									tablaTarea.setAttribute("class" , "tbt");
									
									var id = document.createElement("tr")
									var nombre = document.createElement("tr")
									var descripcion = document.createElement("tr")
									id.setAttribute("class" , "tbt");
									nombre.setAttribute("class" , "tbt");
									descripcion.setAttribute("class" , "tbt");

									nombre.appendChild(document.createTextNode("Nombre: " + tarea.nombre));
									descripcion.appendChild(document.createTextNode("Desc: " + tarea.descripcion));
									tablaTarea.appendChild(id);
									tablaTarea.appendChild(nombre);
									tablaTarea.appendChild(descripcion);

									celdaTareas.appendChild(tablaTarea);

									
									ullist.appendChild(celdaTareas);

								}
								celdaSprint.appendChild(document
										.createElement("br"));

								var fechaFinSprint = document
										.createTextNode("Fecha Fin: "
												+ fechaFin);

								celdaSprint.appendChild(fechaFinSprint);

								celdaSprint.appendChild(divTareas);
								fila.appendChild(celdaSprint);
							}

							tblBody.appendChild(fila);
							tabla.appendChild(tblBody);
							// appends <table> into <body>
							divTabla.appendChild(tabla);
						}
						tabla.setAttribute("border", "2");

						agregarBotonesAreleases(response);
						agregarBotonesAtareas();
					},
					complete : function functionName() {
						$(".sortable").sortable({
							connectWith : ".sortable"
						});
					}
				});
	},

	obtenerIntegrantes : function() {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/integrantes/' + controller.idProyectoActual,
			success : function(response) {
				for (var i = 0; i < response.length; i++) {
					if (response[i].tipo == "scrumMaster") {
						$("#selectableScrumMaster").append(
								'<li class="ui-widget-content">'
										+ response[i].nombre + '</li>');
					} else if (response[i].tipo == "productOwner") {
						$("#selectableProductOwner").append(
								'<li class="ui-widget-content">'
										+ response[i].nombre + '</li>');
					} else if (response[i].tipo == "desarrollador") {
						$("#selectableDesarrolladores").append(
								'<li class="ui-widget-content">'
										+ response[i].nombre + '</li>');
					}

					// $("#selectableScrumMaster").append(
					// '<li class="ui-widget-content">'
					// + response[i].nombre + '</li>');
					// Posibles integrantes para nueva reunión
					// $('#integranteReunion').append(
					// '<li> <input type="checkbox" name="rol" value='
					// + response[i].id + '>'
					// + response[i].nombre
					// + '</label></li>');
				}
			}
		});
	},

	crearTarea : function(nombre, descripcion) {
		var tarea = '1';
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/agregarTarea/' + controller.idProyectoActual + '/' + nombre
					+ '/' + descripcion,
			success : function(response) {
				tarea = response;
			},
			complete : function() {
				actulizarTablero();
			}
		});
	},

	eliminarIntegrante : function(nombreIntegrante) {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/eliminarIntegrante/' + controller.idProyectoActual + '/'
					+ nombreIntegrante,
			success : function(response) {
			},
			complete : function() {
				actualizarIntegrantes();
				controller.obtenerIntegrantesDeReunion();
			}
		});
	},

	agregarIntegrante : function(nombreIntegrante, tipo) {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/agregarIntegrante/' + controller.idProyectoActual + '/'
					+ nombreIntegrante + '/' + tipo,
			success : function(response) {
			},
			complete : function() {
				actualizarIntegrantes();
				controller.obtenerIntegrantesDeReunion();
			}
		});
	},
	crearRelease : function() {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/crearRelease/' + controller.idProyectoActual,
			success : function(response) {
				$("#dialog-release").text(
						"Se creo el Release " + response.numero);

			},
			complete : function() {
				actulizarTablero();
			}

		});
	},

	crearSprint : function(numeroRelease, fechaInicio, fechaFin) {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/crearSprint/' + controller.idProyectoActual + '/'
					+ numeroRelease + '/' + fechaInicio + '/' + fechaFin,
			success : function(response) {
				// $("#dialog-sprint").close();
				$("#dialog-sprintResponse").text(
						"Se creo el Sprint '" + response.numero
								+ "' en el release '" + numeroRelease + "'");

				$("#dialog-sprintResponse").dialog("open");
			},
			complete : function() {
				actulizarTablero();
			}

		});

	},

//	eliminarTarea : function(id) {
//		$.ajax({
//			type : 'GET',
//			contentType : 'application/json',
//			dataType : 'json',
//			url : '/eliminarTarea/' + controller.idProyectoActual + '/' + id,
//			success : function(response) {
//			},
//			complete : function() {
//				actulizarTablero();
//			}
//		});
//	},
	crearTarea : function(nRelease, nSprint, nombre, descripcion) {
		var tarea = '1';
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/agregarTarea/' + controller.idProyectoActual + '/'
					+ nRelease + '/' + nSprint + '/' + nombre + '/'
					+ descripcion,
			success : function(response) {
				tarea = response;
			},
			complete : function() {
				actulizarTablero();
			}
		});
	},

	eliminarTarea : function(nRelease, nSprint, id) {
		// var tarea = '1';
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/eliminarTarea/' + controller.idProyectoActual + '/'
					+ nRelease + '/' + nSprint + '/' + id,
			success : function(response) {
				alert("se elimino correctamente")
				// tarea = response;
			},
			complete : function() {
				actulizarTablero();
			}
		});
	},
	
	pasarDeEstadoTarea : function(nRelease, nSprint, id) {
		// var tarea = '1';
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/cambiarEstado/' + controller.idProyectoActual + '/'
					+ nRelease + '/' + nSprint + '/' + id + '/' + 1,
			success : function(response) {
			},
			complete : function() {
				actulizarTablero();
			}
		});
	},


	eliminarProyecto : function() {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/eliminarProyecto/' + controller.idProyectoActual,
			success : function(response) {
			},
			complete : function() {
				actualizarListaProyectos();
			}
		});
	},

	obtenerIntegrantesDeReunion : function() {
		$
				.ajax({
					type : 'GET',
					contentType : 'application/json',
					dataType : 'json',
					url : '/integrantesReunion/' + controller.idProyectoActual,
					success : function(response) {
						// controller.obtenerIntegrantes()
						$('#integranteReunion').empty();
						for (var i = 0; i < response.length; i++) {
							// $('#li'+response[i].id).remove();
							$('#integranteReunion')
									.append(
											'<li id=li'
													+ response[i].id
													+ '> <input type="checkbox" name="rol" value='
													+ response[i].id + ' id='
													+ response[i].id + '>'
													+ response[i].nombre
													+ '</label></li>');
						}
					}
				});
	},

	obtenerUsuariosDeReunion : function(idReunion) {
		$
				.ajax({
					type : 'GET',
					contentType : 'application/json',
					dataType : 'json',
					url : '/usuariosReunion/' + controller.idProyectoActual
							+ '/' + idReunion,
					success : function(response) {
						for (var i = 0; i < response.length; i++) {
							$('#li' + response[i].id).remove();
							$('#integranteReunion')
									.append(
											'<li id=li'
													+ response[i].id
													+ '> <input type="checkbox" checked="checked" name="rol" value='
													+ response[i].id + ' id='
													+ response[i].id + '>'
													+ response[i].nombre
													+ '</label></li>');
						}
					}
				})
	},

	obtenerReunionesDeProyecto : function(idProyecto) {
		controller.obtenerReuniones();
		controller.obtenerTipoDeReuniones(idProyecto);
		// controller.obtenerIntegrantesDeReunion(idProyecto);
		controller.obtenerIntegrantesDeReunion(idProyecto);
	},

	obtenerReuniones : function() {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/reuniones/' + controller.idProyectoActual,
			success : function(reuniones) {
				// jQuery("#jqGrid").clearGridData()
				for (var i = 0; i <= reuniones.length; i++) {
					jQuery("#jqGrid").addRowData(i, reuniones[i])
				}
				;
				$("#fechareunion").datepicker("setDate", new Date());
			}
		});
	},

	obtenerTipoDeReuniones : function() {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/tiposDeReunion',
			success : function(response) {
				for (var i = 0; i < response.length; i++) {
					$("#reunion-tipo").append(
							'<option>' + response[i].tipo + '</option>');
				}
			}
		});
	},
	cambiarEstado: function(idEstado){
		switch(idEstado) {
	    case 1:
	    	return "estado1";
	        break;
	    case 2:
	     	return "estado2";
	     	break;
	    case 3:
	    	return "estado3";
	        break;
	}
		
	}

};
