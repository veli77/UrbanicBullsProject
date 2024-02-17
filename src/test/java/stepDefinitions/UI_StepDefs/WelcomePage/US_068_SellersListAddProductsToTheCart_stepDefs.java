package stepDefinitions.UI_StepDefs.WelcomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_068_SellersListAddProductsToTheCart_stepDefs extends CommonPage {

    @Given("User goes to the Welcome Page")
    public void userGoesToTheIconHomeWelcomePage() {
        getWelcomePage().ClickWelcomePage();
    }

    @Then("A list of sellers should appear under the heading Local sellers near you")
    public void aListOfSellersShouldAppearUnderTheHeadingLocalSellersNearYou() {
        getWelcomePage().ListofSellersAppears();
    }

    @Then("User is able to click on any seller in the list")
    public void userIsAbleToClickOnAnySellerInTheList() {
        ReusableMethods.waitFor(3);
        getWelcomePage().RandomSellerIsSelected();
    }
    @Then("Products should be seen listed in separate sections")
    public void productsShouldBeSeenListedInSeparateSections() {
        getWelcomePage().ProductListAppears();
    }
    @Then("Product quantity icons must be functional")
    public void productQuantityIconsMustBeFunctional() {
        getWelcomePage().QuantityIconsFunctional();
    }
    @Then("Add to Cart button must be functional")
    public void addToCartButtonMustBeFunctional() {
        getWelcomePage().AddToCartButtonFunctional();
    }
    @When("User clicks on the Add to Cart button")
    public void userClicksOnTheAddToCartButton() {
        getWelcomePage().RandomProductIsClicked();
    }

    @Then("Product added alert should appear")
    public void productAddedAlertShouldAppear() {
        getWelcomePage().ProductAddedAlert();
    }
    @And("The product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {
       getWelcomePage().isProductAddedToTheBasket();
       getWelcomePage().VerifyProductIsInTHeList();
        //Removing the Product from the Basket
       getWelcomePage().RemoveProductsFromTheBasket();
    }
}
