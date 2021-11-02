$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CalculationwithInvalidData.feature");
formatter.feature({
  "line": 1,
  "name": "Calulator mathematic Function with invalid data",
  "description": "",
  "id": "calulator-mathematic-function-with-invalid-data",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Calulation with invalid data",
  "description": "",
  "id": "calulator-mathematic-function-with-invalid-data;calulation-with-invalid-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I go to the calculator application",
  "keyword": "When "
});
formatter.step({
  "line": 4,
  "name": "I type \"5/0\" in the input field",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "I click \"[\u003d]\" button",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "\"Can\u0027t divide by 0\" red validation message appears in the result field",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I type \"9^99999\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I click \"[\u003d]\" button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "\"Value too large\" red validation message appears in the result field",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_go_to_the_calculator_application()"
});
formatter.result({
  "duration": 9386587553,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5/0",
      "offset": 8
    }
  ],
  "location": "StepDefinition.i_type_in_the_input_field(String)"
});
formatter.result({
  "duration": 3983637561,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "[\u003d]",
      "offset": 9
    }
  ],
  "location": "StepDefinition.i_click_button(String)"
});
formatter.result({
  "duration": 780052516,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Can\u0027t divide by 0",
      "offset": 1
    }
  ],
  "location": "StepDefinition.red_validation_message_appears_in_the_result_field(String)"
});
formatter.result({
  "duration": 2205690326,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "9^99999",
      "offset": 8
    }
  ],
  "location": "StepDefinition.i_type(String)"
});
formatter.result({
  "duration": 4711930834,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "[\u003d]",
      "offset": 9
    }
  ],
  "location": "StepDefinition.i_click_button(String)"
});
formatter.result({
  "duration": 745550582,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Value too large",
      "offset": 1
    }
  ],
  "location": "StepDefinition.red_validation_message_appears_in_the_result_field(String)"
});
formatter.result({
  "duration": 2235776703,
  "error_message": "java.lang.AssertionError: [Expected result: Value too large actual result: Timeout. Undefined?] expected [true] but found [false]\n\tat org.testng.Assert.fail(Assert.java:96)\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:568)\n\tat stepDefinitions.StepDefinition.red_validation_message_appears_in_the_result_field(StepDefinition.java:85)\n\tat ✽.Then \"Value too large\" red validation message appears in the result field(CalculationwithInvalidData.feature:9)\n",
  "status": "failed"
});
formatter.after({
  "duration": 412141009,
  "status": "passed"
});
formatter.after({
  "duration": 357784925,
  "status": "passed"
});
formatter.uri("Calculationwithvaliddata.feature");
formatter.feature({
  "line": 3,
  "name": "Calulator mathematic Function with valid data",
  "description": "",
  "id": "calulator-mathematic-function-with-valid-data",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Calculation with valid data",
  "description": "",
  "id": "calulator-mathematic-function-with-valid-data;calculation-with-valid-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I go to the calculator application",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I type \"2+2\" in the input field",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click \"[\u003d]\" button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "\"4\" result is displaying in the result field",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I type \"sin(pi/6)/log(sqrt(e))\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I click \"[\u003d]\" button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "\"2.303\" result is displayed in the result field",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.i_go_to_the_calculator_application()"
});
formatter.result({
  "duration": 7090983708,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2+2",
      "offset": 8
    }
  ],
  "location": "StepDefinition.i_type_in_the_input_field(String)"
});
formatter.result({
  "duration": 3445384261,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "[\u003d]",
      "offset": 9
    }
  ],
  "location": "StepDefinition.i_click_button(String)"
});
formatter.result({
  "duration": 693292816,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 1
    }
  ],
  "location": "StepDefinition.result_is_displaying_in_the_result_field(String)"
});
formatter.result({
  "duration": 320540319,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sin(pi/6)/log(sqrt(e))",
      "offset": 8
    }
  ],
  "location": "StepDefinition.i_type(String)"
});
formatter.result({
  "duration": 9383554323,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "[\u003d]",
      "offset": 9
    }
  ],
  "location": "StepDefinition.i_click_button(String)"
});
formatter.result({
  "duration": 742322417,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2.303",
      "offset": 1
    }
  ],
  "location": "StepDefinition.result_is_displayed_in_the_result_field(String)"
});
formatter.result({
  "duration": 371101683,
  "error_message": "java.lang.AssertionError: [Expected result: 2.303 actual result: 0.042083866] expected [true] but found [false]\n\tat org.testng.Assert.fail(Assert.java:96)\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\n\tat org.testng.Assert.assertEquals(Assert.java:118)\n\tat org.testng.Assert.assertEquals(Assert.java:568)\n\tat stepDefinitions.StepDefinition.result_is_displayed_in_the_result_field(StepDefinition.java:78)\n\tat ✽.Then \"2.303\" result is displayed in the result field(Calculationwithvaliddata.feature:11)\n",
  "status": "failed"
});
formatter.after({
  "duration": 395798922,
  "status": "passed"
});
formatter.after({
  "duration": 357180034,
  "status": "passed"
});
});