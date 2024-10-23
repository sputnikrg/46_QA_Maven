package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {
    public SidePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement login;

    public LoginPage selectLogin() {
        click(login);
        //clickWithJS(login, 0, 700);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")//.= (точка равно) значит что строго соответвует слову Alerts
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    //*Select Menu
    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public WidgetsPage selectSelectMenu() {
        click(selectMenu);
        //scrollToElement(selectMenu);
        return new WidgetsPage(driver);
    }

    //BrowserWindows
    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BasePage selectBrowserWindows() {
        click(browserWindows);
        return this;
    }

    //Шаг который ведет выбору кнопок
    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public BasePage selectButtons() {
        click(buttons);
        return new ButtonsPage(driver);
    }

    //Шаг который ведет выбору кнопок
    @FindBy(xpath = "//span[.='Text Box']")
    WebElement textBox;

    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }

    //*Practice Form
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }

    //*Auto Complete
    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoCompleteMenu;

    public AutoCompletePage selectAutoCompleteMenu() {
        click(autoCompleteMenu);
        return new AutoCompletePage(driver);
    }

@FindBy(xpath = "//span[.='Broken Links - Images']")
WebElement brokenLinksImages;
    public BrockenLinksImagesPage selectBrokenLinksImages() {
        return new BrockenLinksImagesPage(driver);
    }
}
