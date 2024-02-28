package stepDefinitions.API_Stepsdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class US_001_Logindeneme_stepDefs {
    Response response=given()
            .contentType(ContentType.JSON)
            .body(("{\"email\":) "))
            .when()
            .post("https://test.urbanicfarm.com/api/public/login");


    @Given("user connect to the {string}")
    public void userConnectToThe(String arg0) {
    }
    @Then("user verifies status code {int}")
    public void user_verifies_status_code(Integer expectedStatusCode) {
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        Assert.assertEquals(200,response.getStatusCode());
    }


}
