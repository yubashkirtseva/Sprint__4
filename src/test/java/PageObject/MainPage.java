package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    // ������� ������ "��������" ������ ��������:
    private By topOrderBtn = By.xpath(".//button[@class='Button_Button__ra12g']");
    // ������� ������ "��������" ����� ��������:
    private By bottomOrderBtn = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // ����������� ������:
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    // ����� - �������� �� ������� ������ "��������":
    public MainPage clickOnTopOrderBtn(){
        driver.findElement(topOrderBtn).click();
        return this;
    }
    // ����� - ����������� �������� �� ������ ������ "��������":
    public MainPage scrollToBottomOrderBtn(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bottomOrderBtn = driver.findElement(By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
        js.executeScript("arguments[0].scrollIntoView();", bottomOrderBtn);
        return this;
    }
    // ����� - �������� �� ������ ������ "��������":
    public MainPage clickOnBottomOrderBtn(){
        driver.findElement(bottomOrderBtn).click();
        return this;
    }

}

