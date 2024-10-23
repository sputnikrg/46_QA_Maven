package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //! User: Malvin174
    //! Pass: 12345Qwer!

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getBookStore().hideAds();
        new SidePage(app.driver).selectLogin();

    }

    //@Test(invocationCount = 1)
    @Test()
    public void loginPositiveTest() {
        new LoginPage(app.driver)
                .enterPersonalData("Malvin174","12345Qwer!")
                .clickOnLoginButton()
                .verifyUserName("Malvin174");

    }
}