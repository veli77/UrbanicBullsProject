package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;

    private ContactUsPage contactUsPage;

    private LoginPage loginPage;

    private RegisterPage registerPage;

    private SellShareTradePage sellShareTradePage;

    private AccountPage accountPage;

    private LocalSellerSearchPage localSellerSearchPage;



    public LocalSellerSearchPage getLocalSellerSearchPage() {

        if (localSellerSearchPage == null) {
            localSellerSearchPage = new LocalSellerSearchPage();
        }
        return localSellerSearchPage;
    }

    public AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage();
        }
        return accountPage;
    }

    public SellShareTradePage getSellShareTradePage() {
        if (sellShareTradePage == null) {
            sellShareTradePage = new SellShareTradePage();
        }

        return sellShareTradePage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }

        return registerPage;
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
}
