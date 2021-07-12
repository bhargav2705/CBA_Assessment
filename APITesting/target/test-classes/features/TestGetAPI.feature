@APITesting1

Feature: To test APIs 

Scenario: TC 1_Test Get API for the assessment

Given I have the URI and other information 
Then I run the GET user request with the details
And I verify the response contains list of users


Scenario: TC 2_Test POST API for the assessment

Given I have the URI and other information 
Then I run the POST user request with the details
And I verify the response code



Scenario: TC 3_Test PUT API for the assessment

Given I have the URI and other information 
Then I run the PUT user request with the details
And I verify the response code


