Feature: The Internet login

Scenario: The Internet initial login

Given when user is on the the internet page
When title of login page is The Internet
Then user enters username & password
And user clicks on login button
Then user lands on home page