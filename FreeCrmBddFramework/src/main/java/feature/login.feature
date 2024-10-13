Feature: The Internet login


Background: 
Given when user is on the the internet page

@RegressionTest
Scenario: The Internet initial login

##Given when user is on the the internet page
When title of login page is The Internet
Then user enters "tomsmith" & "SuperSecretPassword"
And user clicks on login button first	
Then user lands on home page


@RegressionTest @SmokeTest
Scenario Outline: Invalid/Wrong username on login						

#Given when user is on the-internet page
When user enters wrong "<username>" or "<passward>"
And user clicks on login button second
Then user login fail with error message at the top

Examples:
	| username | passward |
	| qabhiw | SuperSecretPassword |
	| ivuvvuivi | wrongpass |

