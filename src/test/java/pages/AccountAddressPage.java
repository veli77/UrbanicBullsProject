package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountAddressPage extends CommonPage{

    @FindBy(css = "div#mapDiv")
    public WebElement mapScreeninAddressPage;

    @FindBy(css = "div.google-maps-link")
    public WebElement googleMapsLink;

    @FindBy(css = "div.gm-inset-map-impl")
    public WebElement googleMapsSatelliteButton;
}
