import PageObject.CustomerDataPage;
import PageObject.MainPage;
import PageObject.MainPageImportantQuestionsSection;
import PageObject.RentDataPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class MainTests {

    private WebDriver driver;

    /*
    1-�� ��������
    ������������ ������� Google Chrome
    ����
    1. ������� �� ���� https://qa-scooter.praktikum-services.ru/
    2. ������� � ������� ������� � ������
    3. �������� �� ������ ������
    4. ���������, ��� ����� � ���������� ������ ������������� ����������
    */

    @Test
    public void checkTextFromImportantQuestionsSectionFirstAnswerChrome() {
        //��������� ��������
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ������� �� �������� ��������� ����������
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // ������� ������ ������� �������� ������� � ���������
        MainPageImportantQuestionsSection objMainPage = new MainPageImportantQuestionsSection(driver);
        // ������� ������
        objMainPage.scrollToQuestions()
                .clickOnFirstQuestion()
                .waitForFirstAnswer("����� � 400 ������. ������ ������� � ��������� ��� ������.");
        // ������ ��������� ���������
        String expectedTextFromFirstAnswer = "����� � 400 ������. ������ ������� � ��������� ��� ������.";
        // �������� ��������� � ���������� ���������
        Assert.assertEquals("����� �� ���������", expectedTextFromFirstAnswer, objMainPage.getTextFromFirstAnswer());
    }

    /*
    2-�� ��������
    ������������ ������� Mozilla Firefox
    ����
    1. ������� �� ���� https://qa-scooter.praktikum-services.ru/
    2. ������� � ������� ������� � ������
    3. �������� �� ������ ������
    4. ���������, ��� ����� � ���������� ������ ������������� ����������
    */

    @Test
    public void checkTextFromImportantQuestionsSectionSixthAnswerFirefox() {
        //��������� ��������
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ������� �� �������� ��������� ����������
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // ������� ������ ������� �������� ������� � ���������
        MainPageImportantQuestionsSection objMainPage = new MainPageImportantQuestionsSection(driver);
        // ������� ������
        objMainPage.scrollToQuestions()
                .clickOnSixthQuestion();
        // ������ ��������� ���������
        String expectedTextFromSixthAnswer = "������� ��������� � ��� � ������ ��������. ����� ������� �� ������ ����� � ���� ���� ������ �������� ��� ��������� � �� ���. ������� �� �����������.";
        // �������� ��������� � ���������� ���������
        Assert.assertEquals("����� �� ���������", expectedTextFromSixthAnswer, objMainPage.getTextFromSixthAnswer());
    }

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
        objCustomerDataPage.enterName("����")
                .enterSurname("������")
                .enterDeliveryAddress("��������� ��������, 1")
                .enterMetroStation("����������")
                .clickDropdownlist()
                .enterPhoneNumber("+79998887766")
                .clickContinueBtn();
        // ������� ������ �������� � ������� �� ������
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // ������� ������, �������� �������� ������
        objRentDataPage.enterDeliveryData("12.12.2022")
                .clickRentPeriodField()
                .clickRentPeriod(2)
                .chooseColor(2)
                .enterComment("��������� �� ���")
                .order()
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
        objCustomerDataPage.enterName("���� ��")
                .enterSurname("���")
                .enterDeliveryAddress("������� �������")
                .enterMetroStation("�����-�����")
                .clickDropdownlist()
                .enterPhoneNumber("89997779988")
                .clickContinueBtn();
        // ������� ������ �������� � ������� �� ������
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // ������� ������, �������� �������� ������
        objRentDataPage.enterDeliveryData("12.01.2023")
                .clickRentPeriodField()
                .clickRentPeriod(4)
                .chooseColor(1)
                .order()
                .confirmOrder();
        // ������ ��������� ���������
        String expectedTextFromOrderHasBeenCreatedInfo = "����� ��������";
        // �������� ��������� � ���������� ���������
        Assert.assertEquals("����� �� ���������", expectedTextFromOrderHasBeenCreatedInfo, objRentDataPage.getTextFromOrderHasBeenCreatedInfo());

    }

    // ������� ������� ����� �����
    @After
    public void tearDown(){
        driver.quit();
    }

}
