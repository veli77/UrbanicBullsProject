package stepDefinitions.UI_StepDefs.HomePage;


import io.cucumber.java.en.When;
import pages.CommonPage;


public class US_007_ContactUsBtnNavBar_stepDefs extends CommonPage {


    // NavBar daki butonlara isimlerini göndererek tıklamak mümkün oluyor
    @When("User click to {string} btn at the navbar")
    public void userClickToBtnAtTheNavbar(String buttonName) {
        getHomePage().clickMainButton(buttonName);


    }

}
