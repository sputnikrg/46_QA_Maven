package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickalertWithTimer() {
        click(timerAlertButton);
        //метод который дожидается нашего алерта (WebDriverWait) и когда он появится- нажимает на него
        wait.until(ExpectedConditions.alertIsPresent())

                .accept();

        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmButton() {
        click(confirmButton);
        //clickWithJS(confirmButton, 0, 700);
        return this;
    }

    public AlertsPage selectResult(String confirm) {
        if (confirm != null && confirm.equals("OK")) {//если наш конфирм кот мы передаем равен "OK"
            driver.switchTo().alert().accept();//то мы вызываем наш драйвер
        } else if (confirm != null && confirm.equals("Cancel")) {//сли мы передаем "Cancel" то он отклоняет
            driver.switchTo().alert().dismiss();//переключаемся на алерт
        } else {
            System.out.println("error alert command");
            //и соглашаемся с помощью метода accept
        }
        return this;
    }
    @FindBy(id = "confirmResult")
    WebElement confirmResult;
    public AlertsPage verifyResult(String result) { //проверяем какой текст появляется под кнопкой
        shouldHaveText(confirmResult, result,5000);//5000 миллисекунд таймаут
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;
    public AlertsPage clickOnPromptButton() {
        click(promtButton);
        //clickWithJS(promtButton, 0, 300);
        return this;
    }


    public AlertsPage sendTextToAlert(String textToFind) {
        driver.switchTo().alert().sendKeys(textToFind);//переключаюсь на наш алерт
        driver.switchTo().alert().accept();
        return this;
    }
    @FindBy(id = "promptResult")
    WebElement promptResult;
    public AlertsPage verifyAlertText(String textToFind) {
        shouldHaveText(promptResult,textToFind,5000);
        assert promptResult.getText().contains(textToFind);
        return this;
    }
}