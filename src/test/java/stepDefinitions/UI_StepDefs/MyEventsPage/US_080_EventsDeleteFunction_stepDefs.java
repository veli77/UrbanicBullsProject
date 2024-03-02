package stepDefinitions.UI_StepDefs.MyEventsPage;

import io.cucumber.java.en.And;
import pages.CommonPage;

public class US_080_EventsDeleteFunction_stepDefs extends CommonPage {
    @And("User selects an address")
    public void userSelectAnAddress() {

        getMyEventsPage().addAnAddress("Apple Park","One Apple Park Way, Cupertino, CA 95014, USA","95014");

    }
}
