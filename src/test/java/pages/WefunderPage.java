package pages;

import org.junit.Assert;

import static stepDefinitions.Hooks.driver;

public class WefunderPage extends CommonPage{

    public void verifyGoWefunderPage(){
        String expectedUrl = "https://wefunder.com/urbanicfarm";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
