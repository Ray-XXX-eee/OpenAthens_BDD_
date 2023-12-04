
Feature: HomePage

	@homepage
  Scenario: Navigate to Registration page from Index page
    Given I navigate to home page
    When Home Page is loaded
    And I click on register button
    Then Registration page should open
    
    @end-2-end
    Scenario: Navigate to Registration page from Index page
    Given I navigate to home page
    When Home Page is loaded
    And I click on register button
    Then Registration page should open
    And I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as 'raihan@gmail.com'
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as 'interests....'
    And I give 'password' input as 'passwor3'
    And I give 'confirm password' input as 'passwor3'
    And Click register
    Then Registration should be successfull
   
    
   
    
    