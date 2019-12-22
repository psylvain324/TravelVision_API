Feature: RoomCharge Search

Background:
Given Validate the browser
When Browser is triggered
Then Check if browser is started

@RoomChargeTest
Scenario: Room Charge search page
Given User is on Room Charge search Page
When User fills in form with bill from date '2019/12/12 21:00:01' and date to '2019/12/15 21:10:01'
Then Room charge search details are submitted
And One Room Charge record is displayed in the details grid






