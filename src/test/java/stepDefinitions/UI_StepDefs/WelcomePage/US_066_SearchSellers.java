package stepDefinitions.UI_StepDefs.WelcomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import java.util.List;


public class US_066_SearchSellers extends CommonPage {

    @Then("User is able to search product by name")
    public void userIsAbleToSearchProductByName() {
        getWelcomePage().searchAndVerifyProductInResults();
    }

    @Then("User is able to search product by distance")
    public void userIsAbleToSearchProductByDistance(DataTable dataTable) {
        // getWelcomePage().selectProductByDistance(dataTable);
        // getWelcomePage().SelectDistanceOptions();
        getWelcomePage().searchProductByDistance(dataTable);
        getWelcomePage().SearchByDistanceOptions.getFirst().click();
    }

    @Then("User is able to search product by categories")
    public void userIsAbleToSearchProductByCategories() {
        //getWelcomePage().searchAndVerifyProductByCategories();
        getWelcomePage().searchAndVerifyProductByCategories2();
    }

    @Then("User is able to search for only organic products")
    public void userIsAbleToSearchForOnlyOrganicProducts() {
        getWelcomePage().SearchForOnlyOrganicProducts();
    }

    @Then("User is able to filter search by price level")
    public void userIsAbleToFilterSearchByPriceLevel(List<Integer> prices) {
        getWelcomePage().FilterByPriceLevel(prices);
        //  getWelcomePage().FilterSearchByRandomPriceLevel();
    }

    @Then("User is able to filter the search by delivery type")
    public void userIsAbleToFilterTheSearchByDeliveryType() {
        getWelcomePage().SearchByDeliveryType();
    }

    @Then("User is able to filter the search by unit type")
    public void userIsAbleToFilterTheSearchByUnitType() {
        getWelcomePage().SearchByUnitType();
    }
}
