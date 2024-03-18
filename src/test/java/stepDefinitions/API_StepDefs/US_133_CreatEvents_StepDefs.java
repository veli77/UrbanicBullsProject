package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.When;

public class US_133_CreatEvents_StepDefs {
    @When("user gets the create an events at {string}")
    public void userGetsTheCreateAnEventsAt(String url) {
        String jsonBody="""
            {
            "address": "California, MD, Amerika Birleşik Devletleri",
                    "city": "California",
                    "isDefault": true,
                    "isSellerAddress": true,
                    "postal": "95170",
                    "state": "St. Mary's County",
                    "title": "Emily's Shop"
        }
        """;
    }
}
