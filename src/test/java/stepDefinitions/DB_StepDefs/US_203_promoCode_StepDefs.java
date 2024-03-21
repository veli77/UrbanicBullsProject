package stepDefinitions.DB_StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.PPromoCode;
import utilities.DBUtilities;
import utilities.ReusableMethods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class US_203_promoCode_StepDefs {

    private String promoCodeName;
    private List<PPromoCode> promoCodeListPojo;
    private int promoCodeID;
    private String updatedPromoCodeName;

    @When("User create Promo Code")
    public void user_create_promo_code() {
        String startDate = ReusableMethods.createDateWithTime(-1, -2);
        String endDate = ReusableMethods.createDateWithTime(50, 0);
        promoCodeName = ReusableMethods.createName();
        DBUtilities.createPromoCode(promoCodeName, startDate, endDate);
    }

    @Then("User should be able to reach Promo Code information in the correct schema and columns in DB")
    public void userShouldBeAbleToReachPromoCodeInformationInTheCorrectSchemaAndColumnsInDB() throws SQLException {

//        List<Map<String, Object>> promocode = DBUtilities.getList("promo_code");
//        for (int i = 0; i < promocode.size(); i++) {
//            System.out.println("promocode.get(i).get(code) = " + promocode.get(i).get("code"));
//        }
//        Object actualCode = promocode.getLast().get("code");
//        Assert.assertEquals(promoCodeName,actualCode);

        promoCodeListPojo = DBUtilities.getPromoCodeList_pojo();
        for (int i = 0; i < promoCodeListPojo.size(); i++) {
            System.out.println("pPromoCodes.get(i).getId() = " + promoCodeListPojo.get(i).getId());
        }
        String actualDiscountType = promoCodeListPojo.getLast().getDiscount_type();
        Assert.assertEquals("percentage", actualDiscountType);

        promoCodeListPojo.stream().forEach(t -> System.out.println(t.getId() + " " + t.getCode() + " " + t.getDiscount()));
    }


    @Then("User should be able to get added Promo Code ID")
    public void userShouldBeAbleToGetAddedPromoCodeID() throws IOException, SQLException {

        promoCodeListPojo = DBUtilities.getPromoCodeList_pojo();
        promoCodeID = promoCodeListPojo.getLast().getId();

        System.out.println("promoCodeListPojo.getLast() = " + promoCodeListPojo.getLast());
        System.out.println("promoCodeID = " + promoCodeID);
    }

    @And("User update Promo Code")
    public void userUpdatePromoCode() throws SQLException {
        String columnName = "code";
        updatedPromoCodeName = "updated Promo Name";
        promoCodeListPojo = DBUtilities.getPromoCodeList_pojo();

        System.out.println(promoCodeListPojo.getLast().getId() + " ?????? " + promoCodeListPojo.getLast().getCode());

        DBUtilities.updatePromoCode(columnName, updatedPromoCodeName, promoCodeID);

        promoCodeListPojo.stream()
                .filter(t -> t.getId() == promoCodeID)
                .forEach(t -> System.out.println(t.getId() + " " + t.getCode() + " " + t.getDiscount()));
    }

    @Then("User should be able to reach updated Promo Code")
    public void userShouldBeAbleToReachUpdatedPromoCode() throws SQLException {
        promoCodeListPojo = DBUtilities.getPromoCodeList_pojo();
        System.out.println("promoCodeListPojo = " + promoCodeListPojo.getLast().getCode());
        Assert.assertTrue(promoCodeListPojo.stream()
                .anyMatch(t -> t.getDiscount()==30));

    }

    @And("User delete Promo Code")
    public void userDeletePromoCode() {
        DBUtilities.deletePromoCode(promoCodeID);
    }

    @Then("User should be able to reach deleted Promo Code")
    public void userShouldBeAbleToReachDeletedPromoCode() throws SQLException {
        promoCodeListPojo = DBUtilities.getPromoCodeList_pojo();
        Assert.assertTrue(promoCodeListPojo.stream()
                .noneMatch(t -> t.getCode().equals(updatedPromoCodeName)));
    }
}
