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

    //Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Иван", "Иваныч", "Заневский проспект, 1", "Сокольники", "+79998887766", "12.12.2022", 2, 2, "Позвонить за час"},
                {"Брюс Ли", "Чан", "Красная площадь", "Китай-город", "89997779988", "12.01.2023", 4, 1, ""},
        };
    }
    private WebDriver driver;

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
        objCustomerDataPage.enterCustomerData(name, surname, deliveryAddress, metroStation, phoneNumber);
        // создать объект страницы с данными об аренде
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // вызвать методы, передать тестовые данные
        objRentDataPage.enterRentData(deliveryData, rentPeriodVariant, colorVariant, comment)
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
        objCustomerDataPage.enterCustomerData(name, surname, deliveryAddress, metroStation, phoneNumber);
        // создать объект страницы с данными об аренде
        RentDataPage objRentDataPage = new RentDataPage(driver);
        // вызвать методы, передать тестовые данные
        objRentDataPage.enterRentData(deliveryData, rentPeriodVariant, colorVariant, comment)
                       .confirmOrder();
        // задать ожидаемый результат
        String expectedTextFromOrderHasBeenCreatedInfo = "Заказ оформлен";
        // сравнить ожидаемый и актуальный результат
        Assert.assertEquals("Текст не совпадает", expectedTextFromOrderHasBeenCreatedInfo, objRentDataPage.getTextFromOrderHasBeenCreatedInfo());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
