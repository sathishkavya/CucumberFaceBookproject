Feature: Face Book Account Creation

Background: Face Book Launching Function
Given Launch the FaceBook "https://www.facebook.com/"


@NewAccount
Scenario Outline: Create a face book account
When User click on create new account
When User enter the first name "<First>"
And User enter the Surname "<SurName>"
And User enter the mobile or email address "<Mobile>"
And User enter the password "<Password>"
And User select the date "<Date>"
And User select the month "<Month>"
And User select the year "<Year>"
And User click on gender "<Gender>"
And User click the signup button
Then Validate the new account "<First>"


Examples:
|First  |SurName |Mobile    |Password|Date|Month|Year |Gender| 
|SATHISH|T       |9715565652|1234564 |20  |Feb  |1998 |Male  |
#|KAVYA  |K       |7635564567|avbt125 |16  |Oct  |2002 |Female|
#|SRIDHAR|G       |8045378924|54673@hs|21  |Jan  |1997 |Male  |
#|STEEPAN|M       |9542468534|2567@fdg|10  |Oct  |1996 |Male  |

@login
Scenario Outline: Login face book account
When  User enter the mail id "<Mail>"
When User enter the pass "<Pass>"
When User enter the Login button
Then Validate the account "<Mail>"

Examples:
|Mail                  |Pass     |
|sathish29794@gmail.com|123456789|




