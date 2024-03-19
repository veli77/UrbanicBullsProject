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

public class US_139_CreateWeeklyOrder_stepDefs {
    RequestSpecification requestSpecification= API_Utils.preSetUp(USERCREDENTIAL.USER2);


    @When("the user can create a new weekly order at {string}")
    public void theUserCanCreateANewWeeklyOrderAt(String pathParam) {

      //  Map<String, Object> woProducts = new HashMap<>();
      //  woProducts.put("id", 74);
      //  woProducts.put("wo_productQuantity", 4);
       // woProducts.put("variant_id",28);

      // Map<String,Object> parameters= new HashMap<>();
      // parameters.put("deliveryCost",5);
      // parameters.put("subTotal",31.96);
      // parameters.put("tip",6.39);
      // parameters.put("title","Weekly Product Amaranth");
      // parameters.put("total","43.35");
      // parameters.put("type","weekly");
      // parameters.put("weeklyOrderId","");
      // parameters.put("wo_products",woProducts);

        String parameters= """
                {
                    "weeklyOrderId": "",
                    "title": "Weekly Product Amaranth",
                    "subTotal": 31.96,
                    "deliveryCost": 5,
                    "tip": 6.39,
                    "total": "43.35",
                    "type": "weekly",
                    "wo_products": [
                        {
                            "id": 74,
                            "wo_productQuantity": 4,
                            "variant_id": 28
                        }
                    ]
                }""";


        response=given()
                .spec(requestSpecification)
                .body(parameters)
                .when()
                .post(pathParam);


       response.prettyPrint();



    }

    @Then("the user should be able to create a new weekly order")
    public void theUserShouldBeAbleToCreateANewWeeklyOrder() {

        JsonPath jpath = response.jsonPath();

        String actualData = jpath.getString("descr");
        String expectedData = "Weekly Order Created...";
        Assert.assertEquals(expectedData,actualData);

    }
}
