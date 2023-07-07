@LoginPage
Feature: Login Page feature validation

	Background:
		Given User is in Login Page of Cogmento CRM

  Scenario: TC01_User login to Cogmento CRM
    When User enter user Email
    And User enter user Passowrd
    Then User click on login button
    Then Validate the title of the page is "Cogmento CRM"
