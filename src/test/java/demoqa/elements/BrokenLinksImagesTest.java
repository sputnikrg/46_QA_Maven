package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.BrokenLinksImagesPage;
import org.testng.annotations.BeforeMethod;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectBrokenLinksImages().hideAds();
    }

    @Test
    public void brokenLinksImagesTest() {
        new BrokenLinksImagesPage(app.driver)
                .checkBrokenLinksImages();
    }
}
