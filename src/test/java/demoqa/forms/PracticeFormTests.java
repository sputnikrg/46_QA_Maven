package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getForm().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();

    }

    @Test
    public void practiceFormTest() {
        new PracticeFormPage(app.driver)
                .enterPersonalData("Samanta", "Fox", "sam_sam@gmail.com", "1234567890")
                .selectGender("Female")
                .chooseDateAsString("21 October 1968")
                //.chooseDate("21", "October", "1968")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/work/fs/7d2c7f724360667b99d52ee9fe553846.jpg")
                .enterCurrentAddress("Portishead, Bristol, UK")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }
    //"Samanta", "Fox", "sam_sam@gmail.com", "1234567890"
    @Test
    @Parameters({"firstName", "lastName", "email", "phone"})
    public void practiceFormParametersTest(String firstName, String lastName, String email, String phone) {
        new PracticeFormPage(app.driver)
                .enterPersonalData(firstName,lastName, email, phone )
                .selectGender("Female")
                .chooseDateAsString("21 October 1968")
                //.chooseDate("21", "October", "1968")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("C:/work/fs/7d2c7f724360667b99d52ee9fe553846.jpg")
                .enterCurrentAddress("Portishead, Bristol, UK")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form")
        ;
    }
}
