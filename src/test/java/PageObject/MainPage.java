package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    // локатор кнопки "Заказать" вверху страницы:
    private By topOrderBtn = By.xpath(".//button[@class='Button_Button__ra12g']");
    // локатор кнопки "Заказать" внизу страницы:
    private By bottomOrderBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // конструктор класса:
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    // метод - кликнуть по верхней кнопке "Заказать":
    public MainPage clickOnTopOrderBtn(){
        driver.findElement(topOrderBtn).click();
        return this;
    }
    // метод - проскролить страницу до нижней кнопки "Заказать":
    public MainPage scrollToBottomOrderBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bottomOrderBtn = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
        js.executeScript("arguments[0].scrollIntoView();", bottomOrderBtn);
        return this;
    }
    // метод - кликнуть по нижней кнопке "Заказать":
    public MainPage clickOnBottomOrderBtn(){
        driver.findElement(bottomOrderBtn).click();
        return this;
    }

}

