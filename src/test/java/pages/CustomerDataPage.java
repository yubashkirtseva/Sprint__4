package pages;

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
    public void enterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    // метод - ввести фамилию:
    public void enterSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    // метод - ввести адрес:
    public void enterDeliveryAddress(String deliveryAddress){
        driver.findElement(deliveryAddressField).sendKeys(deliveryAddress);
    }
    // метод - ввести метро:
    public void enterMetroStation(String metroStation){
        driver.findElement(metroStationField).sendKeys(metroStation);
    }
    // метод - кликнуть на метро в выпадающем списке:
    public void clickDropdownlist(){
        driver.findElement(dropdownlist).click();
    }
    // метод - ввести телефон
    public void enterPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    // метод - нажать на кнопку "Продолжить":
    public void clickContinueBtn(){
        driver.findElement(continueBtn).click();
    }
    // объединенный метод заполнения данных о клиенте
    public void enterCustomerData(String name, String surname, String deliveryAddress, String metroStation, String phoneNumber){
        enterName(name);
        enterSurname(surname);
        enterDeliveryAddress(deliveryAddress);
        enterMetroStation(metroStation);
        clickDropdownlist();
        enterPhoneNumber(phoneNumber);
        clickContinueBtn();
    }


}
