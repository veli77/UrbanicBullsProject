package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.API_Utils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.API_Utils.response;


public class US_116_AddAndDeleteProduct_stepDefs {
    RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER5);

    @When("user can add a product at {string}")
    public void userCanAddAProductAt(String pathParam) {


        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("hubUniqueName", "VEGETABLES_AND_FRUITS_HUB");
        parameters.put("price", 0.05);
        parameters.put("productUniqueName", "VEGETABLES_AND_FRUITS_ANANAS_NOIRE");
        parameters.put("sellerDescription", "");
        parameters.put("tradeDescription", "");
        parameters.put("stock", 1);
        parameters.put("unit", "UNIT_LIBRE");
        parameters.put("isOrganic", false);
        parameters.put("isTrade", false);
        parameters.put("packQuantity", "NaN");
        response = given()
                .spec(requestSpecification)
                .body(parameters)
                .when()
                .post(pathParam)
                ;
        response.prettyPrint();

    }

    @Then("the user should be able to add a product")
    public void theUserShouldBeAbleToAddAProduct() {

        JsonPath jpath = response.jsonPath();

        String actualData = jpath.getString("descr");
        String expectedData = "You already have this product";
        Assert.assertEquals(expectedData,actualData);


    }

    @Then("the user should be able to delete the product {string}")
    public void theUserShouldBeAbleToDeleteTheProduct(String pathParam) {



        Map<String, String> body = new HashMap<>();
        body.put("hubUniqueName","VEGETABLES_AND_FRUITS_HUB");
        body.put("productUniqueName","VEGETABLES_AND_FRUITS_ANANAS_NOIRE");

        response=  given()
                .spec(requestSpecification)
                .body(body)
                .when()
                .post(pathParam)
                ;
        response.prettyPrint();

        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(200,actualStatusCode);


    }
}
