Feature: Creacion de un proyecto, solo con el nombre seteado

Scenario: Creacion de un proyecto
    Given Tengo un proyecto inicializado
    When  Le seteo el nombre "proyectoInicial"
    Then El nombre del proyecto debe ser "proyectoInicial"
    
Scenario: Projecto con un tablero disponible
	Given Tengo un proyecto incializado   
	When  Seteo el tablero con id 17
	Then  El tablero que esta en el proyecto tiene que tener id 17

Scenario: Agregar un nuevo colaborador al proyecto
    Given Un proyecto sin colaboradores y un colaborador 
    When  Agrego al colaborador "pepe"
    Then  El proyecto debe tener como primer colaborador a "pepe" y la cantidad de colaboradores debe ser 1
	