Feature:Crear una tarea y que pase de estado

Scenario: Creacion de una Tarea Started y la paso a  Finished
    Given Tengo una tarea
    When Le seteo el estado Finished
    Then El estado de la  tarea debe ser Finished 
    
 Scenario: Creacion de una Tarea y la paso a  estado Started
    Given Tengo una tarea
    When Le seteo el estado Started
    Then El estado de la  tarea debe ser Started
      
  Scenario: Creacion de una Tarea en estado NotStarted
    Given Tengo una tarea
    When Le seteo el estado NotStarted
    Then El estado de la  tarea debe ser NotStarted 