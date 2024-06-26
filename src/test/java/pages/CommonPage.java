package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private AccountAddressPage accountAddressPage;
    private HomePage homePage;
    private ContactUsPage contactUsPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SellShareTradePage sellShareTradePage;
    private AccountWeeklyOrderPage accountWeeklyOrderPage;
    private LocalSellerSearchPage localSellerSearchPage;
    private AboutUsPage aboutUsPage;
    private FarmerMarketPage farmerMarketPage;
    private ExplorePage explorePage;
    private WefunderPage wefunderPage;
    private PrivacyPolicyPage privacyPolicyPage;
    private AccountHomePage accountHomePage;
    private AccountDeliveryPage accountDeliveryPage;
    private AccountHubPage accountHubPage;
    private AccountOrdersPage accountOrdersPage;
    private WelcomePage welcomePage;
    private AccountRequestedProductsPage accountRequestedProductsPage;
    private BasketPage basketPage;
    private EventsPage eventsPage;
    private MyEventsPage myEventsPage;
    private NotificationPage notificationPage;
    private AccountContactUsPage accountContactUsPage;
    private SupportDonationPage supportDonationPage;

    public SupportDonationPage getSupportDonationPage() {
        if (supportDonationPage == null) {
            supportDonationPage = new SupportDonationPage();
        }
        return supportDonationPage;
    }

    public AccountContactUsPage getAccountContactUsPage() {
        if (accountContactUsPage == null) {
            accountContactUsPage = new AccountContactUsPage();
        }
        return accountContactUsPage;
    }

    public NotificationPage getNotificationPage() {
        if (notificationPage == null){
            notificationPage = new NotificationPage();
        }
        return notificationPage;
    }

    public  MyEventsPage getMyEventsPage() {
        if (myEventsPage == null){
            myEventsPage = new MyEventsPage();
        }
        return myEventsPage;
    }

    public EventsPage getEventsPage() {
        if (eventsPage == null) {
            eventsPage = new EventsPage();
        }
        return eventsPage;
    }

    public BasketPage getBasketPage() {
        if (basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }

    public AccountRequestedProductsPage getAccountRequestedProductsPage() {
        if (accountRequestedProductsPage == null) {
            accountRequestedProductsPage = new AccountRequestedProductsPage();
        }
        return accountRequestedProductsPage;
    }
    public WelcomePage getWelcomePage() {
        if (welcomePage == null) {
            welcomePage = new WelcomePage();
        }
        return welcomePage;
    }
    public AccountOrdersPage getAccountOrdersPage() {
        if (accountOrdersPage == null) {
            accountOrdersPage = new AccountOrdersPage();
        }
        return accountOrdersPage;
    }

    public AccountHubPage getAccountHubPage() {
        if (accountHubPage == null) {
            accountHubPage = new AccountHubPage();
        }
        return accountHubPage;
    }

    public AccountDeliveryPage getAccountDeliveryPage() {
        if (accountDeliveryPage == null) {
            accountDeliveryPage = new AccountDeliveryPage();
        }
        return accountDeliveryPage;
    }

    public AccountHomePage getAccountHomePage() {
        if (accountHomePage == null) {
            accountHomePage = new AccountHomePage();
        }
        return accountHomePage;
    }

    public AccountAddressPage getAccountAddressPage() {
        if (accountAddressPage == null) {
            accountAddressPage = new AccountAddressPage();
        }
        return accountAddressPage;
    }

    public PrivacyPolicyPage getPrivacyPolicyPage() {
        if (privacyPolicyPage == null) {
            privacyPolicyPage = new PrivacyPolicyPage();
        }
        return privacyPolicyPage;
    }

    public WefunderPage getWefunderPage() {
        if (wefunderPage == null) {
            wefunderPage = new WefunderPage();
        }
        return wefunderPage;
    }


    public LocalSellerSearchPage getLocalSellerSearchPage() {

        if (localSellerSearchPage == null) {
            localSellerSearchPage = new LocalSellerSearchPage();
        }
        return localSellerSearchPage;
    }


    public FarmerMarketPage getFarmerMarketPage() {
        if (farmerMarketPage == null) {
            farmerMarketPage = new FarmerMarketPage();
        }
        return farmerMarketPage;
    }

    public ExplorePage getExplorePage() {
        if (explorePage == null) {
            explorePage = new ExplorePage();
        }
        return explorePage;
    }


    public AboutUsPage getAboutUsPage(){
        if (aboutUsPage == null) {
            aboutUsPage = new AboutUsPage();
        }
        return aboutUsPage;

    }

    public AccountWeeklyOrderPage getAccountWeeklyOrderPage() {
        if (accountWeeklyOrderPage == null) {
            accountWeeklyOrderPage = new AccountWeeklyOrderPage();
        }
        return accountWeeklyOrderPage;
    }

    public SellShareTradePage getSellShareTradePage() {
        if (sellShareTradePage == null) {
            sellShareTradePage = new SellShareTradePage();
        }

        return sellShareTradePage;
    }


    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }

        return loginPage;
    }

    public ContactUsPage getContactUsPage() {
        if (contactUsPage == null) {
            contactUsPage = new ContactUsPage();
        }
        return contactUsPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage== null) {
            registerPage = new RegisterPage();
        }

        return registerPage;
    }
}