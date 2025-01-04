@HomePage
Feature: HomePage Validation

  Background: 
    Given User login to Cogmento CRM application

  @HomePage_TC01
  Scenario: TC01_Validate all Homepage header options are showing or not
    When User is in Homepage
    Then Validate below homepage header are showing in Homepage 
    	| Cogmento             |
      | TestCompany          |
      | Pradyumnna Satapathy |
      | Free account         |
      | SearchBox            |
      | DeleteIcon           |
      | SettingsIcon         |
      

  @HomePage_TC02
  Scenario Outline: TC02_Validate given default tiles are present on Homepage
    When User is in Homepage
    Then Validate default tiles are showing in Homepage body
      | Deals Summary            |
      | Contacts activity stream |
      | Deals                    |
      | Call Queue               |
      | Upcoming calls           |
      | Twitter                  |
      | Today                    |
