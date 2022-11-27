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

    /*
    3-ий сценарий
    Используется браузер Google Chrome
    Шаги
    1. перейти на сайт https://qa-scooter.praktikum-services.ru/
    2. кликнуть кнопку "Заказать" вверху страницы
    3. заполнить необходимые поля в разделах информация о клиенте, информация об аренде
    4. кликнуть кнопку "Заказать"
    5. проверить, что текст в информационном сообщении об успешном заказе соответствует ожидаемому
    */

    @Test
    public void checkOrderingPositiveProcessChrome() {
        //настройка браузера
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создать объект главной страницы
        MainPage objMainPage = new MainPage(driver);
        // вызвать методы
        objMainPage.clickOnTopOrderBtn();
        // создать объект страницы с данными клиента
        CustomerDataPage objCustomerDataPage = new CustomerDataPage(driver);
        // вызвать методы, передать тестовые данные
        objCustomerDataPage.enterName("Иван")
                .enterSurname("Иваныч")
                .enterDeliveryAddress("Заневский проспект, 1")
                .enterMetroStation("Сокольники")
                .clickDropdownlist()
                .enterPhoneNumber("+79998887766")
                .clickContinueBtn();
        // создать объект страницы с данными об аренде
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // вызвать методы, передать тестовые данные
        objRentDataPage.enterDeliveryData("12.12.2022")
                .clickRentPeriodField()
                .clickRentPeriod(2)
                .chooseColor(2)
                .enterComment("Позвонить за час")
                .order()
                .confirmOrder();
        // задать ожидаемый результат
        String expectedTextFromOrderHasBeenCreatedInfo = "Заказ оформлен";
        // сравнить ожидаемый и актуальный результат
        Assert.assertEquals("Текст не совпадает", expectedTextFromOrderHasBeenCreatedInfo, objRentDataPage.getTextFromOrderHasBeenCreatedInfo());
    }

    /*
    4-ый сценарий
    Используется браузер Mozilla Firefox
    Шаги
    1. перейти на сайт https://qa-scooter.praktikum-services.ru/
    2. кликнуть кнопку "Заказать" внизу страницы
    3. заполнить необходимые поля в разделах информация о клиенте, информация об аренде
    4. кликнуть кнопку "Заказать"
    5. проверить, что текст в информационном сообщении об успешном заказе соответствует ожидаемому
    */

    @Test
    public void checkOrderingPositiveProcessFireFox() {
        //настройка браузера
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создать объект главной страницы
        MainPage objMainPage = new MainPage(driver);
        // вызвать методы
        objMainPage.scrollToBottomOrderBtn()
                .clickOnBottomOrderBtn();
        // создать объект страницы с данными клиента
        CustomerDataPage objCustomerDataPage = new CustomerDataPage(driver);
        // вызвать методы, передать тестовые данные
        objCustomerDataPage.enterName("Брюс Ли")
                .enterSurname("Чан")
                .enterDeliveryAddress("Красная площадь")
                .enterMetroStation("Китай-город")
                .clickDropdownlist()
                .enterPhoneNumber("89997779988")
                .clickContinueBtn();
        // создать объект страницы с данными об аренде
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // вызвать методы, передать тестовые данные
        objRentDataPage.enterDeliveryData("12.01.2023")
                .clickRentPeriodField()
                .clickRentPeriod(4)
                .chooseColor(1)
                .order()
                .confirmOrder();
        // задать ожидаемый результат
        String expectedTextFromOrderHasBeenCreatedInfo = "Заказ оформлен";
        // сравнить ожидаемый и актуальный результат
        Assert.assertEquals("Текст не совпадает", expectedTextFromOrderHasBeenCreatedInfo, objRentDataPage.getTextFromOrderHasBeenCreatedInfo());

    }

    // закрыть браузер после теста
    @After
    public void tearDown(){
        driver.quit();
    }

}
