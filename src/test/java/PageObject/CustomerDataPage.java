package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDataPage {
    private WebDriver driver;
    // локатор поля "Имя":
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // локатор поля "Фамилия":
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор поля "Адрес":
    private By deliveryAddressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор поля "Метро":
    private By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    // локатор выпадающего списка "Метро":
    private By dropdownlist = By.xpath(".//div[@class='select-search__select']");
    // локатор поля "Телефон":
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор кнопки "Продолжить":
    private By continueBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // конструктор класса:
    public CustomerDataPage(WebDriver driver){
        this.driver = driver;
    }

    // метод - ввести имя:
    public CustomerDataPage enterName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    // метод - ввести фамилию:
    public CustomerDataPage enterSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }
    // метод - ввести адрес:
    public CustomerDataPage enterDeliveryAddress(String deliveryAddress){
        driver.findElement(deliveryAddressField).sendKeys(deliveryAddress);
        return this;
    }
    // метод - ввести метро:
    public CustomerDataPage enterMetroStation(String metroStation){
        driver.findElement(metroStationField).sendKeys(metroStation);
        return this;
    }
    // метод - кликнуть на метро в выпадающем списке:
    public CustomerDataPage clickDropdownlist(){
        driver.findElement(dropdownlist).click();
        return this;
    }
    // метод - ввести телефон
    public CustomerDataPage enterPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }
    // метод - нажать на кнопку "Продолжить":
    public CustomerDataPage clickContinueBtn(){
        driver.findElement(continueBtn).click();
        return this;
    }


}
