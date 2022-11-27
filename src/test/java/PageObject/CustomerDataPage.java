package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerDataPage {
    private WebDriver driver;
    // ������� ���� "���":
    private By nameField = By.xpath(".//input[@placeholder='* ���']");
    // ������� ���� "�������":
    private By surnameField = By.xpath(".//input[@placeholder='* �������']");
    // ������� ���� "�����":
    private By deliveryAddressField = By.xpath(".//input[@placeholder='* �����: ���� �������� �����']");
    // ������� ���� "�����":
    private By metroStationField = By.xpath(".//input[@placeholder='* ������� �����']");
    // ������� ����������� ������ "�����":
    private By dropdownlist = By.xpath(".//div[@class='select-search__select']");
    // ������� ���� "�������":
    private By phoneNumberField = By.xpath(".//input[@placeholder='* �������: �� ���� �������� ������']");
    // ������� ������ "����������":
    private By continueBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // ����������� ������:
    public CustomerDataPage(WebDriver driver){
        this.driver = driver;
    }

    // ����� - ������ ���:
    public CustomerDataPage enterName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    // ����� - ������ �������:
    public CustomerDataPage enterSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }
    // ����� - ������ �����:
    public CustomerDataPage enterDeliveryAddress(String deliveryAddress){
        driver.findElement(deliveryAddressField).sendKeys(deliveryAddress);
        return this;
    }
    // ����� - ������ �����:
    public CustomerDataPage enterMetroStation(String metroStation){
        driver.findElement(metroStationField).sendKeys(metroStation);
        return this;
    }
    // ����� - �������� �� ����� � ���������� ������:
    public CustomerDataPage clickDropdownlist(){
        driver.findElement(dropdownlist).click();
        return this;
    }
    // ����� - ������ �������
    public CustomerDataPage enterPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }
    // ����� - ������ �� ������ "����������":
    public CustomerDataPage clickContinueBtn(){
        driver.findElement(continueBtn).click();
        return this;
    }


}
