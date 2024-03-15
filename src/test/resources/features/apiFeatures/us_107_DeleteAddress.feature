@Vedat @API @US_107

  Feature: TE of US_107
      @userVedatToken
      Scenario: As a user, I should be able to delete an existing address.
        Given User connects to the "https://test.urbanicfarm.com/api/account/address/addAddress" and add a address
        Then User deletes added address and verifies success message
