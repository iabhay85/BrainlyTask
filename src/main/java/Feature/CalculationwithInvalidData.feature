Feature: Calulator mathematic Function with invalid data
  Scenario: Calulation with invalid data
    When I go to the calculator application
    And I type "5/0" in the input field
    And I click "[=]" button
    Then "Can't divide by 0" red validation message appears in the result field
    When I type "9^99999"
    And I click "[=]" button
    Then "Value too large" red validation message appears in the result field