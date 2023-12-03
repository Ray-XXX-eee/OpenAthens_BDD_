
Feature: HomePage

  Scenario: Navigate to Registration page from Index page
    Given I navigate to home page
    When Home Page is loaded
    And I click on register button
    Then Registration page should open
    
   
    
    