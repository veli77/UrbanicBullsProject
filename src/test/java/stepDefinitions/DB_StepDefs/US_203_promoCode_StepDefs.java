package stepDefinitions.DB_StepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.PromoCode.PPromoCode;
import utilities.DBUtilities;
import utilities.ReusableMethods;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_203_promoCode_StepDefs {

    String promoCodeName = ReusableMethods.createName();
    @When("User create Promo Code")
    public void user_create_promo_code() {

        String startDate = ReusableMethods.createDateWithTime(-1, -2);
        String endDate = ReusableMethods.createDateWithTime(50, 0);

        DBUtilities.createPromoCode(promoCodeName,startDate,endDate);
    }

    @Then("User should be able to see Promo Code information in the correct schema and columns in DB")
    public void user_should_be_able_to_see_promo_code_information_in_the_correct_schema_and_columns_in_db() throws SQLException {

//        List<Map<String, Object>> promocode = DBUtilities.getList("promo_code");
//        for (int i = 0; i < promocode.size(); i++) {
//            System.out.println("promocode.get(i).get(code) = " + promocode.get(i).get("code"));
//        }
//        Object actualCode = promocode.getLast().get("code");
//        Assert.assertEquals(promoCodeName,actualCode);

        List<PPromoCode> pPromoCodes = DBUtilities.getPromoCodeList_pojo();
        for (int i = 0; i < pPromoCodes.size(); i++) {
            System.out.println("pPromoCodes.get(i).getId() = " + pPromoCodes.get(i).getId());
        }
        String actualDiscountType = pPromoCodes.getLast().getDiscount_type();
        Assert.assertEquals("percentage",actualDiscountType);

        pPromoCodes.stream().forEach(t-> System.out.println(t.getId()+" "+t.getCode()+" "+t.getDiscount()));
    }

    @And("User update Promo Code")
    public void userUpdatePromoCode() {
        //DBUtilities.updatePromoCode(promoCodeName,13);
    }

    @And("User delete Promo Code")
    public void userDeletePromoCode() {
        DBUtilities.deletePromoCode(13);
    }
}
