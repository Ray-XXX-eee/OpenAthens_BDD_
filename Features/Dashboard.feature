
Feature: HomePage

	@dashboard1
  Scenario: Registration completion and dashBoard page load
    Given I navigate to register page
    When I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as 'raihan@gmail.com'
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as 'interests....'
    And I give 'password' input as 'passwor3'
    And I give 'confirm password' input as 'passwor3'
    And Click register
    Then Registration should be successfull
    Then Dashboard should show 5 jobs
   
   @dashboard
   Scenario: Check DashBoard page table
    Given I navigate to Dashboard page
    Then Dashboard should show 5 jobs
    Then 'graduate job' should have '#428bca' color
    And 'graduate scheme' should have '#5bc0de' color
    And 'law training contract' should have '#f0ad4e' color
    
    
    
    
    
   
    
    