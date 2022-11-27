package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentDataPage {
    private WebDriver driver;

    // ������� ���� ���� ��������:
    private By deliveryDateField = By.xpath(".//input[@placeholder='* ����� �������� �������']");
    // ������� ���� ������� ������:
    private By rentPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    // ������� ���� �����������:
    private By commentField = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // ������� ������ "��������":
    private By orderBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // ������� ������ ������������� ������:
    private By confirmOrderBtn = By.xpath(".//button[text()='��']");
    // ������� ����� � ����������� � �������� ������:
    private By orderHasBeenCreatedInfo = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    // ����������� ������:
    public RentDataPage(WebDriver driver){
        this.driver = driver;
    }

    // ����� - ������ ���� ��������
    public RentDataPage enterDeliveryData(String deliveryData){
        driver.findElement(deliveryDateField).sendKeys(deliveryData + Keys.ENTER);
        return this;
    }
    // ����� - �������� �� ���� ������ ������ ��� ������ ����������� ������
    public RentDataPage clickRentPeriodField(){
        driver.findElement(rentPeriodField).click();
        return this;
    }
    // ����� - ������� ������ ������
    public RentDataPage clickRentPeriod(int rentPeriodVariant){
        driver.findElement(By.xpath(".//div[@class='Dropdown-option']" + "[" + rentPeriodVariant + "]")).click();
        return this;
    }
    // ����� - ������� ���� ��������
    public RentDataPage chooseColor(int colorVariant){
        driver.findElement(By.xpath(".//label[@class='Checkbox_Label__3wxSf'][" + colorVariant + "]/input")).click();
        return this;
    }
    // ����� - ������ �����������
    public RentDataPage enterComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
        return this;
    }
    // ����� - ������ ������ "��������":
    public RentDataPage order(){
        driver.findElement(orderBtn).click();
        return this;
    }
    // ����� - ������ ������ ������������� ������:
    public RentDataPage confirmOrder(){
        driver.findElement(confirmOrderBtn).click();
        return this;
    }
    // �������� ����� �� ����� � ����������� � �������� ������:
    public String getTextFromOrderHasBeenCreatedInfo(){
        String textFromOrderHasBeenCreatedInfo = driver.findElement(orderHasBeenCreatedInfo).getText();
        String actualTextFromFirstAnswer = textFromOrderHasBeenCreatedInfo.substring(0, 14);
        return actualTextFromFirstAnswer;
    }
}
