package pages;

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
    public void enterName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    // ����� - ������ �������:
    public void enterSurname(String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }
    // ����� - ������ �����:
    public void enterDeliveryAddress(String deliveryAddress){
        driver.findElement(deliveryAddressField).sendKeys(deliveryAddress);
    }
    // ����� - ������ �����:
    public void enterMetroStation(String metroStation){
        driver.findElement(metroStationField).sendKeys(metroStation);
    }
    // ����� - �������� �� ����� � ���������� ������:
    public void clickDropdownlist(){
        driver.findElement(dropdownlist).click();
    }
    // ����� - ������ �������
    public void enterPhoneNumber(String phoneNumber){
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }
    // ����� - ������ �� ������ "����������":
    public void clickContinueBtn(){
        driver.findElement(continueBtn).click();
    }
    // ������������ ����� ���������� ������ � �������
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
