package pages;


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
    public void enterDeliveryData(String deliveryData){
        driver.findElement(deliveryDateField).sendKeys(deliveryData + Keys.ENTER);
    }
    // ����� - �������� �� ���� ������ ������ ��� ������ ����������� ������
    public void clickRentPeriodField(){
        driver.findElement(rentPeriodField).click();
    }
    // ����� - ������� ������ ������
    public void clickRentPeriod(int rentPeriodVariant){
        driver.findElement(By.xpath(".//div[@class='Dropdown-option']" + "[" + rentPeriodVariant + "]")).click();
    }
    // ����� - ������� ���� ��������
    public void chooseColor(int colorVariant){
        driver.findElement(By.xpath(".//label[@class='Checkbox_Label__3wxSf'][" + colorVariant + "]/input")).click();
    }
    // ����� - ������ �����������
    public void enterComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    // ����� - ������ ������ "��������":
    public void order(){
        driver.findElement(orderBtn).click();
    }
    // ������������ ����� ���������� ������ �� ������
    public RentDataPage enterRentData(String deliveryData, int rentPeriodVariant, int colorVariant, String comment){
        enterDeliveryData(deliveryData);
        clickRentPeriodField();
        clickRentPeriod(rentPeriodVariant);
        chooseColor(colorVariant);
        enterComment(comment);
        order();
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
