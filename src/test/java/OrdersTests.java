import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CustomerDataPage;
import pages.MainPage;
import pages.RentDataPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class OrdersTests {
    private final String name;
    private final String surname;
    private final String deliveryAddress;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryData;
    private final int rentPeriodVariant;
    private final int colorVariant;
    private final String comment;

    public OrdersTests(String name, String surname, String deliveryAddress, String metroStation, String phoneNumber, String deliveryData, int rentPeriodVariant, int colorVariant, String comment){
        this.name = name;
        this.surname = surname ;
        this.deliveryAddress = deliveryAddress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryData = deliveryData;
        this.rentPeriodVariant = rentPeriodVariant;
        this.colorVariant = colorVariant;
        this.comment = comment;
    }

    //�������� ������
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"����", "������", "��������� ��������, 1", "����������", "+79998887766", "12.12.2022", 2, 2, "��������� �� ���"},
                {"���� ��", "���", "������� �������", "�����-�����", "89997779988", "12.01.2023", 4, 1, ""},
        };
    }
    private WebDriver driver;

        /*
    3-�� ��������
    ������������ ������� Google Chrome
    ����
    1. ������� �� ���� https://qa-scooter.praktikum-services.ru/
    2. �������� ������ "��������" ������ ��������
    3. ��������� ����������� ���� � �������� ���������� � �������, ���������� �� ������
    4. �������� ������ "��������"
    5. ���������, ��� ����� � �������������� ��������� �� �������� ������ ������������� ����������
    */

    @Test
    public void checkOrderingPositiveProcessChrome() {
        //��������� ��������
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // ������� �� �������� ��������� ����������
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // ������� ������ ������� ��������
        MainPage objMainPage = new MainPage(driver);
        // ������� ������
        objMainPage.clickOnTopOrderBtn();
        // ������� ������ �������� � ������� �������
        CustomerDataPage objCustomerDataPage = new CustomerDataPage(driver);
        // ������� ������, �������� �������� ������
        objCustomerDataPage.enterCustomerData(name, surname, deliveryAddress, metroStation, phoneNumber);
        // ������� ������ �������� � ������� �� ������
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // ������� ������, �������� �������� ������
        objRentDataPage.enterRentData(deliveryData, rentPeriodVariant, colorVariant, comment)
                       .confirmOrder();
        // ������ ��������� ���������
        String expectedTextFromOrderHasBeenCreatedInfo = "����� ��������";
        // �������� ��������� � ���������� ���������
        Assert.assertEquals("����� �� ���������", expectedTextFromOrderHasBeenCreatedInfo, objRentDataPage.getTextFromOrderHasBeenCreatedInfo());
    }

    /*
    4-�� ��������
    ������������ ������� Mozilla Firefox
    ����
    1. ������� �� ���� https://qa-scooter.praktikum-services.ru/
    2. �������� ������ "��������" ����� ��������
    3. ��������� ����������� ���� � �������� ���������� � �������, ���������� �� ������
    4. �������� ������ "��������"
    5. ���������, ��� ����� � �������������� ��������� �� �������� ������ ������������� ����������
    */

    @Test
    public void checkOrderingPositiveProcessFireFox() {
        //��������� ��������
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // ������� �� �������� ��������� ����������
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // ������� ������ ������� ��������
        MainPage objMainPage = new MainPage(driver);
        // ������� ������
        objMainPage.scrollToBottomOrderBtn()
                .clickOnBottomOrderBtn();
        // ������� ������ �������� � ������� �������
        CustomerDataPage objCustomerDataPage = new CustomerDataPage(driver);
        // ������� ������, �������� �������� ������
        objCustomerDataPage.enterCustomerData(name, surname, deliveryAddress, metroStation, phoneNumber);
        // ������� ������ �������� � ������� �� ������
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // ������� ������, �������� �������� ������
        objRentDataPage.enterRentData(deliveryData, rentPeriodVariant, colorVariant, comment)
                       .confirmOrder();
        // ������ ��������� ���������
        String expectedTextFromOrderHasBeenCreatedInfo = "����� ��������";
        // �������� ��������� � ���������� ���������
        Assert.assertEquals("����� �� ���������", expectedTextFromOrderHasBeenCreatedInfo, objRentDataPage.getTextFromOrderHasBeenCreatedInfo());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
