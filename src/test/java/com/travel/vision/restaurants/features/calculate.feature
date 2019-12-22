Feature: RoomCharge

Background:
Given Validate the browser
When Browser is triggered
Then Check if browser is started

@RoomChargeTest
Scenario: Room Charge page
Given User is on Room Charge Page
When User fills in form with bill amount '100.00', tip amount '20.00', and tax rate '5.00'
Then Room charge details are submitted
And Calculated total bill is accurately calculated at '125.00'

@RoomChargeTest
Scenario: Room Charge page
Given User is on Room Charge Page
When User fills in form and submits with Email Receipt clicked
Then Room charge details are submitted
And Email is sent to specified Email Address






