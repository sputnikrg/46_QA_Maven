package demoqa.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;

    protected void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();//развернуть драйвер на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // неявное
        //wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // явное
        driver.get("https://demoqa.com/");
    }

    protected void stop() {
        if (driver != null) {
            driver.quit(); // Остановка драйвера после всех тестов
        }
    }
}
