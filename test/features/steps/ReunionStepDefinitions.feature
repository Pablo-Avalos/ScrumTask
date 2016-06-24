Feature: Creacion de una Reunion. Agregar integrante y agregar tema 

Scenario: Creacion de una Reunion 
	Given Tengo una reunion sin nada 
	When Le seteo la id con 1 
	And Le seteo la hora de inicio con 18 18 
	And Le seteo la fecha con 23 5 2018 
	Then La id de la reunion debe ser 1 
	And La hora de inicio debe ser 18 18 
	And La fecha debe ser 23 6 2018 
	
Scenario: Agregar un integrante a la reunion 
	Given Tengo una reunion sin integrantes 
	When Le agrego un integrante a la reunion 
	Then La reunion debe tener un integrante 
	
Scenario: Agregar un tema a la reunion 
	Given Tengo una reunion sin temas 
	When Le agrego un tema a la reunion 
	Then La reunion debe tener un tema 
	
Scenario: Definir una Daily
	Given Una reunion sin tipo 
	When Creo una "Daily" 
	Then La reunion debe ser una "Daily" 
	
    Given Una reunion sin tipo 
	When Creo una "Planning" 
	Then La reunion debe ser una "Planning"
	
	Given Una reunion sin tipo 
	When Creo una "Demo" 
	Then La reunion debe ser una "Demo"
	
	Given Una reunion sin tipo 
	When Creo una "Retrospective" 
	Then La reunion debe ser una "Retrospective"  
  
