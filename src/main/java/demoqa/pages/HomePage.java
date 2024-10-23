package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {//создали конструктор
        super(driver);
    }
    @FindBy(css=".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePage getBookStore() {
        click(bookStore);
        scrollTo(700);
        //clickWithJS(bookStore, 0, 700 );
        return new SidePage (driver);

    }
    @FindBy(css=".top-card:nth-child(3)")
    WebElement alertsFrameWindows;
    public BasePage getAlertsFrameWindows() {
        click(alertsFrameWindows);
        //clickWithJS(alertsFrameWindows, 0,700 );
        return new SidePage(driver);
    }
    @FindBy(css=".top-card:nth-child(4)")
    WebElement widgets;

    public BasePage getWidgets() {
        click(widgets);
        //clickWithJS(widgets, 0,700 );
        return new SidePage(driver);
    }
    //Шаг который ведет к элементам
    @FindBy(css=".top-card:nth-child(1)")
    WebElement elements;

    public BasePage getElements() {
        click(elements);
        return new SidePage(driver);
    }
//*Forms
@FindBy(css=".top-card:nth-child(2)")
WebElement forms;

    public BasePage getForm() {
        click(forms);
        return new SidePage(driver);
    }
}
