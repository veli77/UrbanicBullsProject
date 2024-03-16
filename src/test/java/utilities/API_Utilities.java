package utilities;

import enums.USERCREDENTIAL;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.*;

public class API_Utilities {
    public static RequestSpecification spec;
    public static String headerToken;

    public static void restFullBookerSetUp(){
        spec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                addHeader("authorization", getHeaderToken(USERCREDENTIAL.USER3)).
                //setBaseUri("https://test.urbanicfarm.com").
                setRelaxedHTTPSValidation().
                build();

    }

    public static String getHeaderToken(USERCREDENTIAL usercredential) {
        response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\": \"" + usercredential.getUsername() + "\",\"password\": \"" + usercredential.getPassword() + "\"}")
                .when()
                .post("https://test.urbanicfarm.com/api/public/login");

        JsonPath jsonPath = response.jsonPath();
        headerToken = jsonPath.getString("token");
        headerToken="Bearer "+headerToken;

        return headerToken;
    }
}
