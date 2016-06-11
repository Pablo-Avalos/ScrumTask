Feature: Tareas de tablero

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