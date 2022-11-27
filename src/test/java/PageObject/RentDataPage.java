package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentDataPage {
    private WebDriver driver;

    // локатор поля даты доставки:
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор поля периода аренды:
    private By rentPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    // локатор поля комментария:
    private By commentField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // локатор кнопки "Заказать":
    private By orderBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор кнопки подтверждения заказа:
    private By confirmOrderBtn = By.xpath(".//button[text()='Да']");
    // локатор блока с информацией о создании заказа:
    private By orderHasBeenCreatedInfo = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    // конструктор класса:
    public RentDataPage(WebDriver driver){
        this.driver = driver;
    }

    // метод - ввести дату доставки
    public RentDataPage enterDeliveryData(String deliveryData){
        driver.findElement(deliveryDateField).sendKeys(deliveryData + Keys.ENTER);
        return this;
    }
    // метод - кликнуть на поле период аренды для вызова выпадающего списка
    public RentDataPage clickRentPeriodField(){
        driver.findElement(rentPeriodField).click();
        return this;
    }
    // метод - выбрать период аренды
    public RentDataPage clickRentPeriod(int rentPeriodVariant){
        driver.findElement(By.xpath(".//div[@class='Dropdown-option']" + "[" + rentPeriodVariant + "]")).click();
        return this;
    }
    // метод - выбрать цвет самоката
    public RentDataPage chooseColor(int colorVariant){
        driver.findElement(By.xpath(".//label[@class='Checkbox_Label__3wxSf'][" + colorVariant + "]/input")).click();
        return this;
    }
    // метод - ввести комментарий
    public RentDataPage enterComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }
    // метод - нажать кнопку "Заказать":
    public RentDataPage order(){
        driver.findElement(orderBtn).click();
        return this;
    }
    // метод - нажать кнопку подтверждения заказа:
    public RentDataPage confirmOrder(){
        driver.findElement(confirmOrderBtn).click();
        return this;
    }
    // получить текст из блока с информацией о создании заказа:
    public String getTextFromOrderHasBeenCreatedInfo(){
        String textFromOrderHasBeenCreatedInfo = driver.findElement(orderHasBeenCreatedInfo).getText();
        String actualTextFromFirstAnswer = textFromOrderHasBeenCreatedInfo.substring(0, 14);
        return actualTextFromFirstAnswer;
    }
}
