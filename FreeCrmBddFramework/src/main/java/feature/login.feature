Feature: The Internet login

Scenario: The Internet initial login

Given when user is on the the internet page
When title of login page is The Internet
Then user enters username & password
And user clicks on login button 1st
Then user lands on home page

Scenario: Invalid/Wrong credentials on login

Given when user is on the-internet page
When user enters wrong username or password
And user clicks on login button 2nd
Then user login fail with error message at the top

