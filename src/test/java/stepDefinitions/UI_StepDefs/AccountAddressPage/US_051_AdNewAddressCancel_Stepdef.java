package stepDefinitions.UI_StepDefs.AccountAddressPage;

import io.cucumber.java.en.And;
import pages.AccountAddressPage;

public class US_051_AdNewAddressCancel_Stepdef extends AccountAddressPage {
    @And("User clicks on the button cancel")
    public void userClicksOnTheButtonCancel() {
        clickAddAddressCancelBtn();
    }

    @And("User should be able to see not new address")
    public void userShouldBeAbleToSeeNotNewAddress() {
        verifyNotNewAddress();
    }
}
