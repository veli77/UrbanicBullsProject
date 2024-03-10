package stepDefinitions.API_StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepDefinitions.Hooks.response;

public class US_115_GetAllProducts_StepDefs {
    @When("User gets all products details")
    public void userGetsAllProductsDetails() {
            response =  given()
                    .when()
                    .post("https://test.urbanicfarm.com/api/public/product/getAllProducts");

        }

    @Then("User verifies status code and success response for get all products")
    public void userVerifiesStatusCodeAndSuccessResponseForGetAllProducts() {

        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("success"));
        assertEquals(true, jsonPath.get("success"));

        List<Object> myList;
        myList = jsonPath.getList("products");
        System.out.println(myList.size());
        System.out.println(myList.getFirst());
        assertFalse(myList.isEmpty());
    }
}
