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
    1-ый сценарий
    Используется браузер Google Chrome
    Шаги
    1. перейти на сайт https://qa-scooter.praktikum-services.ru/
    2. перейти к разделу Вопросы о важном
    3. кликнуть на первый вопрос
    4. проверить, что текст в выпадающем списке соответствует ожидаемому
    */

    @Test
    public void checkTextFromImportantQuestionsSectionFirstAnswerChrome() {
        //настройка браузера
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создать объект главной страницы раздела с вопросами
        MainPageImportantQuestionsSection objMainPage = new MainPageImportantQuestionsSection(driver);
        // вызвать методы
        objMainPage.scrollToQuestions()
                .clickOnFirstQuestion()
                .waitForFirstAnswer("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        // задать ожидаемый результат
        String expectedTextFromFirstAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        // сравнить ожидаемый и актуальный результат
        Assert.assertEquals("Текст не совпадает", expectedTextFromFirstAnswer, objMainPage.getTextFromFirstAnswer());
    }

    /*
    2-ой сценарий
    Используется браузер Mozilla Firefox
    Шаги
    1. перейти на сайт https://qa-scooter.praktikum-services.ru/
    2. перейти к разделу Вопросы о важном
    3. кликнуть на шестой вопрос
    4. проверить, что текст в выпадающем списке соответствует ожидаемому
    */

    @Test
    public void checkTextFromImportantQuestionsSectionSixthAnswerFirefox() {
        //настройка браузера
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создать объект главной страницы раздела с вопросами
        MainPageImportantQuestionsSection objMainPage = new MainPageImportantQuestionsSection(driver);
        // вызвать методы
        objMainPage.scrollToQuestions()
                .clickOnSixthQuestion();
        // задать ожидаемый результат
        String expectedTextFromSixthAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        // сравнить ожидаемый и актуальный результат
        Assert.assertEquals("Текст не совпадает", expectedTextFromSixthAnswer, objMainPage.getTextFromSixthAnswer());
    }

    // закрыть браузер после теста
    @After
    public void tearDown(){
        driver.quit();
    }

}
