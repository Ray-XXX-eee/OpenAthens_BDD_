Feature: Registration Page Feature
	@register
	@end-to-end
  Scenario: Test Registration Succes (happy path)
    Given I navigate to register page
    When I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as 'raihan@gmail.com'
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as 'interests....'
    And I give 'password' input as 'passwor3'
    And I give 'confirm password' input as 'passwor3'
    And Click register
    Then Registration should be successfull
    
	@negetive_test
	@register
  Scenario: Test Mandatory field (Email missing)
    Given I navigate to register page
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
    Given I navigate to register page
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
   Scenario: Test Mandatory field (Password missing)
    Given I navigate to register page
    When I give 'name' input as 'Raihan Kabir'
    And I give 'email' input as 'raihan@gmail.com'
    And I give 'webpage' input as 'https://raihan.com'
    And I give 'interest' input as 'my interest'
    And I give 'password' input as ''
    And I give 'confirm password' input as ''
    And Click register
    Then Should throw error message for 'password missing'
    And Should not navigate to Dashboard
    
    
