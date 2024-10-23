package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "password")
    WebElement userPassword;
    @FindBy(id = "login")
    WebElement loginButton;



    public LoginPage enterPersonalData(String user, String password) {
       // typeScrollWithJS(userName, user,700);
        type(userName, user);
        type(userPassword, password);
        return this;
    }

    public ProfilePage clickOnLoginButton() {
        click(loginButton);
        return new ProfilePage(driver);
    }
}
