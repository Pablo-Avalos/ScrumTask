Feature: Tareas de tablero

Scenario: Tablero sin tarea
    Given Un tablero sin tarea
    When  Creo un tablero con id 1 sin tarea
    Then  La cantidad de tareas en el tablero debe ser 0
    
Scenario: Tablero con una tarea 
    Given Un tablero con una tarea con id 1
    When  Creo un tablero con id 1
    Then  La cantidad de tareas del tablero debe ser 1


Scenario: Asociar la nueva tarea con el tablero
    Given Un tablero inicializado y una tarea inicializada
    When  Agrego la tarea con nombre "nuevaTarea"
    Then  La primer tarea del tablero debe ser "nuevaTarea"
    
Scenario: Asociar dos nuevas tareas con el tablero
    Given Un tablero inicializado y dos tarea inicializadas
    When  Agrego la tarea con nombre "primerTarea" y agrego la tarea con nombre "segundaTarea" 
    Then  La primer tarea del tablero debe ser "primerTarea" y la segunda "segundaTarea"

Scenario: Agregar un release al tablero
    Given Un tablero sin release
    When  Agrego un release con nombre "release"
    Then  El nombre del primer release del tablero debe ser "release"
    
Scenario: Agregar un release al tablero con release
    Given Un tablero con release
    When  Agrego un nuevo release
    Then  La cantidad de release debe ser 2