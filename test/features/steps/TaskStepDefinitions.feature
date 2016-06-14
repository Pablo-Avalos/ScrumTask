Feature: Creacion de una Tarea, solo con el nombre y descripcion

Scenario: Creacion de una Tarea
    Given Tengo una tarea
    When Le seteo el nombre como "tareaInicial"
    Then El nombre de la  tarea debe ser "tareaInicial"
    
Scenario: Obtener una tarea ya existente
	Giver Tengo una tarea con id 115
	When Se quiere obtener la tarea con id 155
	Then Se obtiene la tarea con id 155
    
Scenario: Eliminar una tarea ya existente
	Given Tengo una tarea
	When Elimino la tarea con id 157
	Then La tarea con id 157 ya no debe estar mas en el tablero
	
Scenario: Definir autor de una tarea
	Given Una tarea sin autor 
	When Pongo el autor "autor" a una tarea
	Then El autor de la tarea debe ser "autor"
	
Scenario: Cambiar el autor de una tarea
	Given Una tarea con autor "primerautor"
	When Cambio el autor por "autordos"
	Then El autor de la tarea tiene que ser "autordos"	

Scenario: Poner la descripcion de una tarea
	Given Una tarea sin descripcion 
	When Pongo la descripcion "tareasecundaria"
	Then La descripcion de la tarea tiene que ser "tareasecundaria"
		
Scenario: Cambiar la descripcion de una tarea
	Given Una tarea con descripcion "tareaprincipal"
	When Cambio la descripcion por "tareasecundaria"
	Then La descripcion de la tarea debe ser "tareasecundaria"