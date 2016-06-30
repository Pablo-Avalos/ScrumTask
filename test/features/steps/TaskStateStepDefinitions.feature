Feature: Tareas de Estado

Scenario: Creacion de Tarea con estado
	When  Le pongo el estado "NotStarted"
	Then  El estado de la tarea debe ser "NotStarted"
	
	When  Le pongo el estado "Started"
	Then  El estado de la tarea debe ser "Started" 
	
	When  Le pongo el estado "Finished"
	Then  El estado de la tarea debe ser "Finished"