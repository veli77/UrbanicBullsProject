package stepDefinitions.DB_StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.HubProduct.PProduct;
import utilities.DBUtilities;
import utilities.ReusableMethods;

import java.sql.SQLException;
import java.util.List;

public class US_202_addNewProduct_stepDefs {

    private String ProductUnicName = "SUNFLOWER3";

    private List<PProduct> productList;
    @When("User create New Product")
    public void user_create_new_product() {

        DBUtilities.creatNewProduct(ProductUnicName);

    }

    @Then("User should be able to reach New Product information in the correct schema and columns in DB")
    public void user_should_be_able_to_reach_new_product_information_in_the_correct_schema_and_columns_in_db() throws SQLException {

        productList = DBUtilities.getProductList(ProductUnicName);
        String uniqueName = productList.getLast().getUnique_name();
        Assert.assertEquals(ProductUnicName, uniqueName);
        System.out.println("ProductUnicName = " + productList.getLast().getUnique_name());
        System.out.println("productList.getLast().getId() = " + productList.getLast().getId());

    }

    @When("User delete New Product")
    public void user_delete_new_product() throws SQLException {

        productList = DBUtilities.getProductList(ProductUnicName);
        int productId = productList.getLast().getId();
        DBUtilities.deleteNewProduct(productId);
        System.out.println("productList = " + productList.getLast().getUnique_name());
    }

    @Then("User should be able to reach deleted New Product information in the correct schema and columns in DB")
    public void user_should_be_able_to_reach_deleted_new_product_information_in_the_correct_schema_and_columns_in_db() throws SQLException {

        List<PProduct> productDelete = DBUtilities.getProductList(ProductUnicName);
        ReusableMethods.waitFor(3);
        boolean verify = productDelete.stream().noneMatch(e -> e.getUnique_name().equals(ProductUnicName));

        System.out.println("productList = " + productList.getLast().getUnique_name());
        System.out.println("verify = " + verify);
        Assert.assertTrue(verify);

        

    }


}
