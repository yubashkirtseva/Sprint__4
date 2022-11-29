package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageImportantQuestionsSection {
    private WebDriver driver;
    // ������� ������� ������� � ������ "������� � ������":
    private By firstQuestion = By.xpath(".//div[@id='accordion__heading-0']");
    // ������� ������� ������ � ������ "������� � ������":
    private By firstAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    // ������� ������� ������� � ������ "������� � ������":
    private By sixthQuestion = By.xpath(".//div[@id='accordion__heading-5']");
    // ������� ������� ������ � ������ "������� � ������":
    private By sixthAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");
    // ����������� ������:
    public MainPageImportantQuestionsSection(WebDriver driver){
        this.driver = driver;
    }
    // ����� - ����������� �������� �� ������� "������� � ������":
    public MainPageImportantQuestionsSection scrollToQuestions(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement importantQuestionsSection = driver.findElement(By.xpath(".//div[text()='������� � ������']"));
        js.executeScript("arguments[0].scrollIntoView();", importantQuestionsSection);
        return this;
    }
    // ����� - �������� �� ������� �������:
    public MainPageImportantQuestionsSection clickOnFirstQuestion(){
        driver.findElement(firstQuestion).click();
        return this;
    }
    // ����� - �������� ����� ������� ������:
    public String getTextFromFirstAnswer(){
        String actualTextFromFirstAnswer = driver.findElement(firstAnswer).getText();
        return actualTextFromFirstAnswer;
    }
    // ����� - �������� �� ������� �������:
    public MainPageImportantQuestionsSection clickOnSixthQuestion(){
        driver.findElement(sixthQuestion).click();
        return this;
    }
    // ����� - �������� ����� ������� ������:
    public String getTextFromSixthAnswer(){
        String actualTextFromFirstAnswer = driver.findElement(sixthAnswer).getText();
        return actualTextFromFirstAnswer;
    }
    // ����� - ��������� ���������� ������ � ���� ����� (��� ������ ������ �� ����������� ���� ��� chrome)
    public MainPageImportantQuestionsSection waitForFirstAnswer(String answer) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(firstAnswer, answer));
        return this;
    }

}
