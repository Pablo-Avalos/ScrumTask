Feature: Creacion de una Reunion. Agregar integrante y agregar tema 

Scenario: Cambiar la id a una reunion 
	Given Tengo una reunion con una id 
	When Le seteo la id con 1 
	Then La id de la reunion debe ser 1 
	
	
Scenario: Agregar un integrante a la reunion 
	Given Tengo una reunion sin integrantes 
	When Le agrego al integrante "pepito" a la reunion 
	Then La reunion debe tener un integrante 
	
	
Scenario: Setear una fecha a una reunion 
	Given Tengo una reunion sin fecha 
	When Le seteo la fecha al dia 23 del mes 5 del anio 2018 
	Then La fecha de la reunion debe ser el dia 23 del mes 5 del anio 2018 
	
	
Scenario: Setear la hora de inicio de una reunion 
	Given Tengo una reunion sin hora de inicio 
	When Le seteo la hora de inicio con 18 horas y 18 minutos 
	Then La hora de inicio de la reunion debe ser a las 18 horas y 18 minutos 
	
	
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