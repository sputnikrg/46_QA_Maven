package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.WidgetsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SelectTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectSelectMenu().hideAds();
    }

    @Test
    public void oldStyleSelectMenuTest() {
        new WidgetsPage(app.driver)
                .selectOldStyle("Indigo");
    }


    @Test
    public void multiSelectTest() {
        String[] colorsSelect = {"Green", "Blue"};
        new WidgetsPage(app.driver)
                .multiSelect(colorsSelect)
                .verifyColorSelected(colorsSelect);
    }

    @Test
    public  void standardMultiSelectByIndexTest(){
        new WidgetsPage(app.driver)
                .standardMultiSelectByIndex(2)
               .verifyByIndex(2);
    }

    @Test
    public void standardMultiSelectByCarsTest(){
        String[] cars = {"Volvo", "Opel","Saab" };
        new WidgetsPage(app.driver)
                .standardMultiSelectByCars(cars)
                .verifyMultiSelectByCars(cars);
    }
}
