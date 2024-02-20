package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static stepDefinitions.Hooks.driver;

public class AccountOrdersPage extends CommonPage{

    static int orderNo;

    @FindBy(xpath = "//article[@class='row']//a")
    public List<WebElement> viewOrderDetailsButtons;

    @FindBy(xpath = "//div[@class='mr-3']//span")
    public List<WebElement> orderSummaryList;


public void verifyOrdersPage(){
    String currentUrl=driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.toLowerCase().contains("orders"));
}

public void selectOrder(){
    int ordersListSize=viewOrderDetailsButtons.size();
    Random random =new Random();
    orderNo= random.nextInt(ordersListSize);

}

public void verifyViewdetailsButton(){

    Assert.assertTrue(viewOrderDetailsButtons.get(orderNo).isEnabled());
}

public void clickViewDetailsButton(){
    viewOrderDetailsButtons.get(orderNo).click();
}

public void verifyOrderDetailsPage(){
    String currentUrl=driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("order-details"));

}

public void verifyOrderSummary(){

    List<String> expectedSummary=List.of("Items total","Shipping total","Applied promotion","Grand total");
    expectedSummary.stream().forEach(t->Assert.assertTrue(verifySummaryText(t)));
}

public boolean verifySummaryText(String text){
    return orderSummaryList.stream()
            .map(WebElement::getText)
            .anyMatch(t->t.contains(text));
}
}
