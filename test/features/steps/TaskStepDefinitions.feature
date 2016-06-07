Feature: Creacion de una Tarea, solo con el nombre y descripcion

Scenario: Creacion de una Tarea
    Given Tengo una tarea
    When Le seteo el nombre como "tareaInicial"
    Then El nombre de la  tarea debe ser "tareaInicial"