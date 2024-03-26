package stepDefinitions.DB_StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtilities;
import utilities.ReusableMethods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_200_addNewEmailAddress_stepDefs {

    private String userEmail;

    @When("User create a Email Address")
    public void userCreateAEmailAddress() throws SQLException {

        DBUtilities.createConnection();
        userEmail= ReusableMethods.randomEmail(5);
        int allow_anonymous_chat=1;
        int browser_notifications=0;
        Object delivery_type="[]";
        String first_name=ReusableMethods.createName();
        int is_verified=0;
        String password=ReusableMethods.randomPassword(6);
        String role_user="ROLE_USER";
        Object roles="["+role_user+"]";

        DBUtilities.createUser(allow_anonymous_chat,browser_notifications,is_verified,delivery_type,userEmail,first_name,password,roles);

        userEmail=ReusableMethods.randomEmail(8);
        int user_Id=(int) DBUtilities.getList("user").getLast().get("id");
        DBUtilities.updateElement("user","email",user_Id,userEmail);


        //insert into user (allow_anonymous_chat,browser_notifications,delivery_type,email,first_name,is_verified,password,roles)
        //    values(1,0,'[]','erdal4@yopmail.com','Erdal',0,
        //    'denemepassword123','["ROLE_USER"]');

        //select * from user where first_name='Erdal';
        //
        //insert into user (allow_anonymous_chat,browser_notifications,delivery_type,email,first_name,is_verified,password,roles)
        //    values(1,0,'[]','erdal4@yopmail.com','Erdal',0,
        //    'denemepassword123','["ROLE_USER"]');
        //delete from user where user.id = 2916;
    }

    @Then("User should be able to reach Email Address information in the correct schema and columns in DB")
    public void userShouldBeAbleToReachEmailAddressInformationInTheCorrectSchemaAndColumnsInDB() throws SQLException {
                List<Map<String, Object>> user = DBUtilities.getList("user");
       for (int i = 0; i < user.size(); i++) {
           System.out.println("user.get(i).get(email) = " + user.get(i).get("email"));
       }
       Object actualEmail = user.getLast().get("email");
       Assert.assertEquals(userEmail,actualEmail);
    }

    @Then("User should be able to get added Email Address")
    public void userShouldBeAbleToGetAddedEmailAddress() throws SQLException {
        String lastAddedUserEmail=DBUtilities.getUserList_pojo().getLast().getEmail();

        System.out.println("last added user email address: " + lastAddedUserEmail);

    }

    @And("User should be able to delete a user")
    public void userShouldBeAbleToDeleteAUser() throws SQLException {
        int userId=(int)DBUtilities.getList("user").getLast().get("id");
        DBUtilities.deleteElementFromRelatedList(1,"user");
    }
}
