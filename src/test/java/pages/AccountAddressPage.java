package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountAddressPage extends CommonPage{

    @FindBy(css = "div#mapDiv")
    public WebElement mapScreeninAddressPage;

    @FindBy(css = "div.google-maps-link")
    public WebElement googleMapsLink;

    @FindBy(css = "div.gm-inset-map-impl")
    public WebElement googleMapsSatelliteButton;

    @FindBy(css = "button.gm-control-active")
    public List<WebElement> mapsZoomButtons;

    @FindBy(xpath = "(//div[@class='gm-style']/div[contains(@style, 'cursor')])[1]")
    public WebElement cursorOverTheMapNatureZones;
}
