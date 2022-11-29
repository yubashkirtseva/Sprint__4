import pages.CustomerDataPage;
import pages.MainPage;
import pages.MainPageImportantQuestionsSection;
import pages.RentDataPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class QuestionsTests {

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

    // ������� ������� ����� �����
    @After
    public void tearDown(){
        driver.quit();
    }

}
