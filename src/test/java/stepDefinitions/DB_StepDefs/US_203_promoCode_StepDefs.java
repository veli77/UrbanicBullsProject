package stepDefinitions.DB_StepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.PromoCode.PPromoCode;
import utilities.DBUtilities;
import utilities.ReusableMethods;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class US_203_promoCode_StepDefs {

    String promoCodeName = ReusableMethods.createName();
    String promoCodeID;
    String path = System.getProperty("user.dir") + "/src/test/resources/dummy.txt";
    @When("User create Promo Code")
    public void user_create_promo_code() {

        String startDate = ReusableMethods.createDateWithTime(-1, -2);
        String endDate = ReusableMethods.createDateWithTime(50, 0);

        DBUtilities.createPromoCode(promoCodeName,startDate,endDate);
    }

    @Then("User should be able to reach Promo Code information in the correct schema and columns in DB")
    public void userShouldBeAbleToReachPromoCodeInformationInTheCorrectSchemaAndColumnsInDB() throws SQLException {

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


    @Then("User should be able to get added Promo Code ID")
    public void userShouldBeAbleToGetAddedPromoCodeID() throws IOException, SQLException {

        List<PPromoCode> promoCodeListPojo = DBUtilities.getPromoCodeList_pojo();
        String promoCodeID = String.valueOf(promoCodeListPojo.getLast().getId());


        //dosyadaki datayı günceller
        FileWriter file = new FileWriter(path);
        file.write(promoCodeID);
        file.close();
    }

    @And("User update Promo Code")
    public void userUpdatePromoCode() throws IOException {

        //güncel datayı okur
        FileReader reader = new FileReader(path);
        BufferedReader file2 = new BufferedReader(reader);
        promoCodeID = file2.readLine();
        file2.close();

        String columnName = "code";
        String columnValue = "updatedPromoCode";


        DBUtilities.updatePromoCode(columnName,columnValue, Integer.parseInt(promoCodeID));
    }

    @And("User delete Promo Code")
    public void userDeletePromoCode() throws IOException {

        //güncel datayı okur
        FileReader reader = new FileReader(path);
        BufferedReader file2 = new BufferedReader(reader);
        promoCodeID = file2.readLine();
        file2.close();

        DBUtilities.deletePromoCode(Integer.parseInt(promoCodeID));
    }

}
