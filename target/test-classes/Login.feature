Feature: Login Functionality 

	In order to do internet banking
	As a valid Para Bank customer
	I want to login successfully

# Scenario Example
@Login
Scenario: Login Successful

Given I am in the login page of the Para Bank Application
When I enter valid credentials
	|"Waleed"|Waleed@2028|
Then I should be taken to the Overview page
