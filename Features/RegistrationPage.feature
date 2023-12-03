Feature: Registration Page Feature

Background: Navigate to Register page
	Given I navigate to register page
	
	@register
	@end-to-end
  Scenario: Test Registration Succes (happy path)
    When I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as 'raihan@gmail.com'
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as 'interests....'
    And I give 'password' input as 'passwor3'
    And I give 'confirm password' input as 'passwor3'
    And Click register
    Then Registration should be successfull
    
  #@excel-data  
  #Scenario Outline: Test Registration Succes (happy path)
    #When User fills data from given "<Sheet>" and <Row>
    #And Click register
    #Then Registration should be successfull
    #
    #Examples: 
    #|Sheet    |Row|
    #|Register |	0 |
    #|Register |	1 |
    #|Register |	2 |
    #|Register |	3 |
    
	@negetive_test
	@register
  Scenario: Test Mandatory field (Email missing)
    When I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as ''
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as 'interests....'
    And I give 'password' input as 'passwor3'
    And I give 'confirm password' input as 'passwor3'
    And Click register
    Then Should throw error message for 'email'
    And Should not navigate to Dashboard
    
   @negetive_test
	 @register
   Scenario: Test Mandatory field (Interest missing)
    When I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as 'raihan@gmail.com'
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as ''
    And I give 'password' input as 'passwor3'
    And I give 'confirm password' input as 'passwor3'
    And Click register
    Then Should throw error message for 'interest'
    And Should not navigate to Dashboard
   
   @negetive_test
	 @register
	 @last
   Scenario: Test Mandatory field (Password missing)
    When I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as 'raihan@gmail.com'
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as 'my interest'
    And I give 'password' input as ''
    And I give 'confirm password' input as ''
    And Click register
    Then Should throw error message for 'password missing'
    And Should not navigate to Dashboard
    
    
