package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;

    private ContactUsPage contactUsPage;

    private Register_Page registerPage;

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

    public Register_Page getRegisterPage() {
        if (registerPage== null) {
            registerPage = new Register_Page();
        }

        return registerPage;
    }
}
