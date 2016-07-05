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
//						console.log(response.release);
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

							celdaRelease.appendChild(textoCeldaRelease);
							fila.appendChild(celdaRelease);

							for (var j = 0; j < response.release[i].listaSprints.length; j++) {
								var numerSpt = response.release[i].listaSprints[j].numero;
								var celdaSprint = document.createElement("td");
								celdaSprint.setAttribute("id", "celdaSprint");
//								style="overflow-y: scroll; height: 520px;"
//									celdaSprint.setAttribute("style","overflow-y: scroll; height: 100px;" );
								var textoCeldaSprint = document
										.createTextNode("Sprint " + numerSpt);

								celdaSprint.appendChild(textoCeldaSprint);

								var ullist = document.createElement("ul");
								ullist.setAttribute("id", "tableroConTareas");
								ullist.setAttribute("style","overflow-y: scroll; height: 150px;" );

								for (var h = 0; h < response.release[i].listaSprints[j].listaTareas.length; h++) {
									var tarea = response.release[i].listaSprints[j].listaTareas[h];
									// celdaSprint =
									var celdaTareas = document
											.createElement("div");

									celdaTareas.setAttribute("id", "dialog");
									celdaTareas.setAttribute("class", "column");
									celdaTareas
											.setAttribute("class", "portlet-content");

									var textoLista = document
											.createTextNode("Id: " + tarea.id
													+ "\n" + " " + "Nombre: "
													+ tarea.nombre + "\n" + ""
													+ " Descripcion: "
													+ tarea.descripcion);

									// textoLista.setAttribute("id", "dialog");
									celdaTareas.appendChild(textoLista);
									ullist.appendChild(celdaTareas);
								}
								celdaSprint.appendChild(ullist);
								fila.appendChild(celdaSprint);
							}

							tblBody.appendChild(fila);
							tabla.appendChild(tblBody);
							// appends <table> into <body>
							divTabla.appendChild(tabla);
						}
						tabla.setAttribute("border", "2");
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
					}
					else if (response[i].tipo == "productOwner") {
						$("#selectableProductOwner").append(
								'<li class="ui-widget-content">'
										+ response[i].nombre + '</li>');
					}
					else if (response[i].tipo == "desarrollador") {
						$("#selectableDesarrolladores").append(
								'<li class="ui-widget-content">'
										+ response[i].nombre + '</li>');
					}


					//$("#selectableScrumMaster").append(
					//		'<li class="ui-widget-content">'
					//				+ response[i].nombre + '</li>');
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
				//controller.obtenerIntegrantesDeReunion();
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
				//controller.obtenerIntegrantesDeReunion();
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

	crearSprint : function(numeroRelease) {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/crearSprint/' + controller.idProyectoActual + '/'
					+ numeroRelease,
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

	eliminarTarea : function(id) {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/eliminarTarea/' + controller.idProyectoActual + '/' + id,
			success : function(response) {
			},
			complete : function() {
				actulizarTablero();
			}
		});
	},
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
//		var tarea = '1';
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/eliminarTarea/' + controller.idProyectoActual + '/'
					+ nRelease + '/' + nSprint + '/' + id,
			success : function(response) {
				alert("se elimino correctamente")
//				tarea = response;
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

	obtenerIntegrantesDeReunion : function(idReunion) {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/integrantesReunion/' + controller.idProyectoActual + '/' + idReunion,
			success : function(response) {
				//controller.obtenerIntegrantes()
				//$('#integranteReunion').empty();
				for (var i = 0; i < response[1].length; i++) {
		            $('#li'+response[1][i].id).remove();
					$('#integranteReunion').append(
							'<li id=li' + response[1][i].id + '> <input type="checkbox" name="rol" value='
									+ response[1][i].id + ' id='+ response[1][i].id + '>' + response[1][i].nombre
									+ '</label></li>');
				}
			}
		});
	},
	
	obtenerUsuariosDeReunion : function(idReunion) {
		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			dataType : 'json',
			url : '/usuariosReunion/' + controller.idProyectoActual + '/' + idReunion,
			success : function(response) {
				for (var i = 0; i < response.length; i++) {
		            $('#li'+response[i].id).remove();
					$('#integranteReunion').append(
							'<li id=li' + response[i].id + '> <input type="checkbox" checked="checked" name="rol" value='
									+ response[i].id + ' id='+ response[i].id + '>' + response[i].nombre
									+ '</label></li>');
				}
			}
		})
	},
	
	

	obtenerReunionesDeProyecto : function(idProyecto) {
		controller.obtenerReuniones();
		controller.obtenerTipoDeReuniones(idProyecto);
		//controller.obtenerIntegrantesDeReunion(idProyecto);
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
				$("#fechareunion").datepicker( "setDate", new Date());
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

};
