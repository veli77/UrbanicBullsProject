@UI @Login
Feature: US_057

  Scenario: US_057 Delivery Type - Buyer picks up on the vine

 Given User clicks on Delivery Page button
 Then The Buyer picks up on the vine checkbox should be clickable
 When User clicks on the Buyer picks up on the vine checkbox
 Then Your available hours menu functional and visible
 When User chooses same hours
 Then Start and end time cannot be same at the Buyer picks up on the vine field alert appears
 When User chooses start time late than end time
 Then Start time cannot be greater than end time at the Buyer picks up on the vine field alert appears
 When User selects suitable hours
 Then Your delivery settings have been successfully updated alert appears
