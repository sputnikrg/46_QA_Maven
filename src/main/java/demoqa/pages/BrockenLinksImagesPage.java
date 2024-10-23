package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrockenLinksImagesPage extends BasePage {
    public BrockenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> allimages;

    public BrockenLinksImagesPage checkBrockenLinksImages() {
        System.out.println(allimages.size());//смотрим сколько элементов в массиве (5)
        for (WebElement image : allimages) {
            String imageURL = image.getAttribute("src");//imageURL содержит внутри себя атрибут каждой отдельной картинки
            if (imageURL != null) {
                verifyLink(imageURL);
            }
            boolean isDisplayed = (Boolean) js.executeScript("return arguments[0].naturalWidth > 0", image);
            System.out.println("Image: [" + imageURL + (isDisplayed ? " is displayed! " : "] is NOT displayed"));
        }

        return this;
    }
}

//тест который проверяет на то есть ли наши картинки, кот отображаются на сайте. И имею ли они в себе атрибут, //который ведет нас куда то (src)
//мы распечатали массив сколько атрибутов имейдж было найдено на нашей странице. В уикле выполняется два услови: мы получаем