Feature: Application Login

#Scenario: Home page default login
#Given Initialize the browser with chrome
#And navigate to the "http://www.qaclickacademy.com/" site
#And Click on the Login link in the hom epage to land on secure sign in page
#When User enters "sachithwcc@gmail.com" and "newsachith2019" and logs in
#Then Verify that user is succesfully logged in

Scenario Outline: Home page default login
Given Initialize the browser with chrome
And navigate to the "http://www.qaclickacademy.com/" site
And Click on the Login link in the hom epage to land on secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is succesfully logged in
And Close the browsers

Examples:
|username|password|
|sachithwcc@gmail.com|newsachith2019|
|test@gmail.com|12345|
