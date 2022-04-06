Feature: Test Whendo
  @PRUEBAS_WHENDO
  Scenario: Create task
    Given abro el aplicativo Whendo
    And presiono la opcion para agregar tarea
    And presiono mas opciones para tarea
    And Agrego los siguientes datos a la tarea
      | title          | notes                      | due_date      | time | repeat | remember          |
      | Realizar tarea | Organizar y realizar tarea | 06 April 2022 | 3:10 | Daily  | 15 minutes before |
    When guardo la tarea
    Then valido los siguientes datos
      | title          | notes                      |
      | Realizar tarea | Organizar y realizar tarea |