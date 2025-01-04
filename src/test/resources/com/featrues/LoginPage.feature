@LoginPage
Feature: Login Page Validation

	@LoginPage_TC01
  Scenario: TC01_Validate User successfully login into Cogmento CRM
    When User login to Cogmento CRM application
    Then Validate the title of the page is "Cogmento CRM"
