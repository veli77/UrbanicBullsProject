package stepDefinitions.DB_StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtilities;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_201_AddANewAddress_StepDefs {

    private String AddressTitle;
    private List<Map<String, Object>> addressList;
    @When("User creates a new address")
    public void userCreatesANewAddress() {
        AddressTitle = "DataBaseTesting";
        DBUtilities.createNewAddress(1647, AddressTitle, 0);
    }

    @Then("User should be able to reach address information in the correct schema and columns in DB")
    public void userShouldBeAbleToReachAddressInformationInTheCorrectSchemaAndColumnsInDB() throws SQLException {
        addressList = DBUtilities.getList("address");
        Object actualTitle = addressList.getLast().get("title");
        System.out.println(actualTitle);
        Assert.assertEquals(AddressTitle,actualTitle);
    }


    @And("User should be able to delete the address")
    public void userShouldBeAbleToDeleteTheAddress() {
        int actualId = (int) addressList.getLast().get("id");
        System.out.println(actualId);
        DBUtilities.deleteElementFromRelatedList(actualId,"address");
    }
}
