Feature: Free CRM login

Scenario: Free CRM initial login

Given when user is on the free crm page
When title of login page is 'free crm'
Then user enters username & password
And user clicks on login button
Then user lands on home page
 