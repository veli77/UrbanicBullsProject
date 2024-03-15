package stepDefinitions.API_StepDefs;

import enums.USERCREDENTIAL;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import utilities.API_Utils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class US_117_UpdateProduct_StepDefs {
    RequestSpecification requestSpecification = API_Utils.preSetUp(USERCREDENTIAL.USER3);
    String hubUniqueName = "HERBS_AND_FLOWERS_HUB";
    String productUniqueName = "HERBS_AND_FLOWERS_DILL";
    String url = "https://test.urbanicfarm.com/api/account/hub/product/";
    @When("User adds a product at a certain hub")
    public void userAddsAProductAtaCertainHub() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hubUniqueName", hubUniqueName);
        map.put("price", 2);
        map.put("productUniqueName", productUniqueName);
        map.put("sellerDescription", "");
        map.put("tradeDescription", "");
        map.put("stock", 20);
        map.put("unit", "POUND");
        map.put("isOrganic", false);
        map.put("isTrade", false);
        map.put("packQuantity", "NaN");

        given()
                .spec(requestSpecification)
                .body(map)
                .when()
                .post(url + "add")
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("descr", equalTo("Product added."));
    }

    @Then("User updates the product at a certain hub")
    public void userUpdatesTheProductAtaCertainHub() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hubUniqueName", hubUniqueName);
        map.put("price", 1);
        map.put("productUniqueName", productUniqueName);
        map.put("sellerDescription", "");
        map.put("tradeDescription", "");
        map.put("stock", 2);
        map.put("unit", "POUND");
        map.put("isOrganic", true);
        map.put("isTrade", true);
        map.put("packQuantity", "NaN");

        given()
                .spec(requestSpecification)
                .body(map)
        .when()
                .post(url + "update")
        .then()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }

    @Then("User deletes the product at a certain hub")
    public void userDeletesTheProductAtaCertainHub() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("hubUniqueName", hubUniqueName);
        map.put("productUniqueName", productUniqueName);

        given()
                .spec(requestSpecification)
                .body(map)
        .when()
                .post(url + "delete")
        .then()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true));
    }
}
