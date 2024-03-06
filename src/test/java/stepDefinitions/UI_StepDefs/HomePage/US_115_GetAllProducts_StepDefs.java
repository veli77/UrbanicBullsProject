package stepDefinitions.UI_StepDefs.HomePage;

import com.aventstack.extentreports.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static stepDefinitions.Hooks.response;
import static stepDefinitions.Hooks.token;

public class US_115_GetAllProducts_StepDefs {
    @When("User gets all products details")
    public void userGetsAllProductsDetails() {
            response =  given()
                    .when()
                    .post("https://urbanicfarm.com/api/public/product/getAllProducts");

        }

    @Then("User verifies status code and success response for get all products")
    public void userVerifiesStatusCodeAndSuccessResponseForGetAllProducts() {

        int actualStatusCode = response.getStatusCode();
        assertEquals(200, actualStatusCode);

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getString("success"));
        assertEquals(true, jsonPath.get("success"));

        List<Object> myList = new ArrayList<>();
        myList = jsonPath.getList("products");
        System.out.println(myList.size());
        System.out.println(myList.getFirst());
        assertFalse(myList.isEmpty());
    }
}
