Feature: Academic Management

  Scenario: Associate a class to a subject
    Given there is a subject named "Matemática" with a duration of "32 h"
    And there is a class with code "A001"
    When I associate class "A001" to subject "Matemática"
    Then subject "Matematica" should have class "A001" associated

  Scenario: Enroll a student in a class
    Given there is a class with code "A001"
    And there is a student named "João" with ID 12345
    When I enroll student "João" in class "A001"
    Then student "João" should be enrolled in class "A001"

  Scenario: List enrolled students in a subject
    Given there is a subject named "História"
    And there is a class with code "B001"
    And there is a student named "Maria" enrolled in class "B001"
    When I list the enrolled students in subject "Histria"
    Then I should get a list containing student "Maria"

  Scenario: Get subject name
    Given there is a subject named "Quimica"
    When I get the subject name
    Then I should get the name "Quimica"

  Scenario: Get subject workload
    Given there is a subject named "Física" with workload "60 h"
    When I get the subject workload
    Then I should get the workload "60 h"