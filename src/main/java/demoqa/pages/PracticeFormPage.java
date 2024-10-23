package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    //firstname
    //lastname
    //useremail
    //userNumber
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String name, String surName, String email, String number) {
        type(firstName, name);
        type(lastName, surName);
        type(userEmail, email);
        type(userNumber, number);
        return this;
    }

    //label[contains(text(),'Other')]
    public PracticeFormPage selectGender(String gender) {
        try {
            String xpathGender = "//label[contains(text(),'" + gender + "')]";
            WebElement genderLocator = driver.findElement(By.xpath(xpathGender));
            click(genderLocator);
        } catch (NoSuchElementException e) {
            System.out.println("Gender element not found: [" + gender + "]");
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error selecting gender: [" + gender + "]");
            throw new RuntimeException(e);

        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthSelect;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearSelect;

    //Чтобы в выпадающем списке месяца и года пользователь мог выбрать
    public PracticeFormPage chooseDate(String day, String month, String year) {
        click(dateOfBirthInput);
        new Select(monthSelect).selectByVisibleText(month);
        new Select(yearSelect).selectByVisibleText(year);
//div[@class='react-datepicker__week']//div[.='4']
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage enterSubject(String[] subjects) {
        for (String subject : subjects) {
            if (subject != null) {
                type(subjectsInput, subject);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    //label[.='Reading')]
    public PracticeFormPage chooseHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            try {
                driver.findElement(By.xpath("//label[.='" + hobby + "']")).click();
            } catch (Exception e) {//try catch или можно еще использовать if
                System.out.println("Error on selecting hobbies: [" + hobby + "]");
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadPicture(String imgPath) {
        {
            uploadPicture.sendKeys(imgPath);
        }
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterCurrentAddress(String address) {
        {
            type(currentAddress, address);
            return this;
        }
    }

    @FindBy(id = "state")
    WebElement stateConrainer;//контейнером называют какой.то элемент который внутри включает множество элементов
    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage enterState(String state) {
        click(stateConrainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

//    @FindBy(id = "dateOfBirthInput")
//    WebElement dateOfBirtStringInput;
//    @FindBy(css = ".react-datepicker__month-select")
//    WebElement monthSelectString;
//    @FindBy(css = ".react-datepicker__year-select")
//    WebElement yearSelectString;
//
//    public PracticeFormPage chooseDateAsString(String dateFromString) {
//        // Разделяем строку даты на части: день, месяц и год
//        String[] dateParts = dateFromString.split(" ");// Ожидаем, что дата приходит в формате "DD MMM YYYY", например, "04 May 2000"
//        // Извлекаем день, месяц и год из массива строк
//        String day = dateParts[0];// это "04"
//        String month = dateParts[1];// это "May"
//        String year = dateParts[2];// это "2000"
//        // Обрезаем ведущий ноль у дня, чтобы избежать проблем с локаторами
//        if (day.startsWith("0")) {
//            day = day.substring(1);  // Преобразуем "04" в "4", если день начинается с нуля
//        }
//        click(dateOfBirtStringInput);
//        new Select(monthSelectString).selectByVisibleText(month);
//        new Select(yearSelectString).selectByVisibleText(year);
//        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
//        return this;

    public PracticeFormPage chooseDateAsString(String date) {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        if (os.contains("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");//если наша операционная система мака, то выполняем COMMAND, а если винда- то CONTROL
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return  this;
    }


    //Есть елемент по которому мы кликаем "city"
    //Далее тот с которым взаимодействуем "react-select-4-input"
    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage enterCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;

    }

    @FindBy(id = "submit")
    WebElement submitButton;

    public PracticeFormPage submitForm() {
        click(submitButton);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement registrationModal;

    public PracticeFormPage verifySuccessRegistration(String text) {
        shouldHaveText(registrationModal, text, 5000);
        scrollWithPageDown(1);
        return this;
    }
}


