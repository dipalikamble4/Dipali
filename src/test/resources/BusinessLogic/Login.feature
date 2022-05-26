Feature: Login Functionality

Background: User successfully clicked on Initial Login window
When user open "Chrome" browser with exe 
When user open url as 
When user cancle initial Login window

@SmokeTest
Scenario: Login functionality by using valid credentials
When user navigate on Login button
When user click on MyProfile
When user enter "7447786389" as username
When user enter "Piyush@13" as password
When user click on Login button
Then Application shows user profile to user
