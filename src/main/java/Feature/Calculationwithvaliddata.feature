
@tag
Feature: Calulator mathematic Function with valid data
  Scenario: Calculation with valid data
    When I go to the calculator application
    And I type "2+2" in the input field
    And I click "[=]" button
    Then "4" result is displaying in the result field
    When I type "sin(pi/6)/log(sqrt(e))"
    And I click "[=]" button
    Then "2.303" result is displayed in the result field

   