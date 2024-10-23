package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public WidgetsPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        shouldHaveText(oldSelectMenu, color, 5000);


        return this;
    }


    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    @FindBy(css = "html")//кликаем в пустое поле, чтобы выйти из выподающего списка
    WebElement space;

    //Multiselect Menu
    public WidgetsPage multiSelect(String[] colors) {
        for (String color : colors) {//проходим по каждому элементу массива стрингов цветов)
            if (color != null) {
                inputSelect.sendKeys(color);
                inputSelect.sendKeys(Keys.ENTER);
            }
            inputSelect.sendKeys(Keys.ESCAPE);//тобы выйти из выбора цветов-нажимаем на кнопку esc

        }
        return this;
    }

    @FindBy(className = "css-12jo7m5")
    List<WebElement> selectedColorsElements;//в этом массиве хранятся все цвета котороые мы можем выбрать

    public boolean areColorsSelected(String[] colors) {
        List<String> selectedText = new ArrayList<>();// этот массив мы сохраняем все значения, которые найдем в списке webElementов
        for (WebElement element : selectedColorsElements) {
            selectedText.add(element.getText());//для каждого текущенго эл нашего массива мы будем проходится циклом и сохраняем его в selectedText каждую строку отдельно
        }
        for (String color : colors) {//проверяем значения. Будем циклом проходится по массиву цветов. Каждая строка является стрингом калао в массиве калорс. Цикл if вернет нам false если один из цветов не совпадает с цветом из массива. А если хоть один из элементов содержит совпадение, вернет true
            if (!selectedText.contains(color)) {
                return false;
            }
        }
        return true;
    }

    public WidgetsPage verifyColorSelected(String[] colorsSelect) {
        assertTrue(new WidgetsPage(driver).areColorsSelected(colorsSelect));
        return this;
    }

    @FindBy(id = "cars")
    WebElement carsSelect;

    public boolean areOneCarSelected(String cars) {
        return new Select(carsSelect).getFirstSelectedOption().getText().equals(cars);
    }

    @FindBy(xpath = "//select[@id='cars']")
    WebElement selectOneCar;

    public WidgetsPage selectedOneCar(String car) {
        Select select = new Select(selectOneCar);
        select.selectByVisibleText(car);
        shouldHaveText(selectOneCar, car, 5000);
        return this;
    }

    public WidgetsPage verifyIsOneCarSelected(String carsSelect) {
        assertTrue(new WidgetsPage(driver).areOneCarSelected(carsSelect));
        return this;
    }

    @FindBy(id = "cars")
    WebElement selectedCars;

    public boolean areCarsSelected(String[] cars) {
        List<String> selectedMultiCarsText = new ArrayList<>();//  // Создаем список, в который будем сохранять текст всех выбранных элементов (автомобилей)
        Select select = new Select(selectedCars);// Инициализируем объект Select, используя WebElement selectedCars, который представляет выпадающий список
        List<WebElement> selectedOption = select.getOptions();
        // Получаем все опции (элементы) выпадающего списка, а не только выбранные элементы
        for (WebElement option : selectedOption) { // Цикл для прохождения по всем опциям (элементам) выпадающего списка
            selectedMultiCarsText.add(option.getText()); // Добавляем текст каждой опции в список selectedMultiCarsText

        }

        // Теперь проверяем, что каждый автомобиль из массива cars присутствует в списке выбранных автомобилей
        for (String car : cars) {
            if (!selectedMultiCarsText.contains(car)) {   // Если хотя бы одного автомобиля нет в списке выбранных, возвращаем false
                return false;
            }
        }
        return true; // Если все автомобили найдены среди выбранных, возвращаем true
    }

    public WidgetsPage multiCarSelect(String[] cars) {
        for (String car : cars) {
            if (car != null) {
                inputSelect.sendKeys(car);
                inputSelect.sendKeys(Keys.ENTER);
            }
            inputSelect.sendKeys(Keys.ESCAPE);
        }
        return this;
    }

    public WidgetsPage verifyCarsSelected(String[] cars) {
        assertTrue(new WidgetsPage(driver).areCarsSelected(cars));
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage standardMultiSelectByIndex(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {//завернули в иф так как selectByIndex работает тоько если есть несколько вариантов
            select.selectByIndex(index);
        }
        List<WebElement> options = select.getOptions();//извлекаем опции для работы с этим элементом. Опции множество, поэтому лист. Получаем через индекс текст и печатаем его
        String selectedText = options.get(index).getText();
        System.out.println(selectedText);
        return this;
    }

    //System.out.println(select.getOptions().get(index).getText());это более короткая запись строк выше
    //return this;
    public WidgetsPage verifyByIndex(int index) {
        Select select = new Select(cars);
        List<WebElement> options = select.getOptions();//options хранит методы для всех элементов в списке
        List<WebElement> selectedOptions = select.getOptions();//selectedOptions переменная кот хранит методы только для выбранного элемента
        String selectedText = options.get(index).getText();//текст выбранного элемента
        boolean textFound = false;
        for (WebElement option : selectedOptions) {
            if (option.getText().equals(selectedText)) {///когда текст выбранного элемента соотв искомому нами текста
                textFound = true;
                break;
            }
        }
        System.out.println(selectedText);
        Assert.assertTrue(textFound);
        return this;
    }

    public WidgetsPage standardMultiSelectByCars(String[] car) {
        Select select = new Select(cars);
        if(select.isMultiple()){
            for(String element: car) {
                select.selectByVisibleText(element);
            }
        }
      return this;
    }

    public WidgetsPage verifyMultiSelectByCars(String[] expectedCars) {//expectedCars массив стрингов который мы ожидаем
        Select select = new Select(cars);
        List<WebElement> selectedOptions = select.getOptions();//selectedOptions переменная кот хранит методы только для выбранного элемента
        List<String> selectedText = new ArrayList<>();;//в этом списке хранится тескст выбранных нами автомобилей. Хранит список выбранных предидущим шагом в тесте ( standardMultiSelectByCars)авто в данный момент
      for(WebElement option: selectedOptions) {//двигаемся по тем эл кот были выбраны и двигаясь извлекаем элементы и сохраняем в наш массив
          selectedText.add(option.getText());
      }
      List<String> expectedText = Arrays.asList(expectedCars);//работаем с тем что передаем в наш метод (String[] expectedCars).Автомобили которые мы передаем для сравнения {"Volvo", "Opel","Saab"};
        assert new HashSet<>(selectedText).containsAll(expectedText);//Hash Set так как нам уже не нужен индекс и он автоматически удаляет дубликаты и имеет метод .containsAll
        return this;
    }
}

