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
    // локатор первого вопроса в списке "Вопросы о важном":
    private By firstQuestion = By.xpath(".//div[@id='accordion__heading-0']");
    // локатор первого ответа в списке "Вопросы о важном":
    private By firstAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    // локатор шестого вопроса в списке "Вопросы о важном":
    private By sixthQuestion = By.xpath(".//div[@id='accordion__heading-5']");
    // локатор шестого ответа в списке "Вопросы о важном":
    private By sixthAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");
    // конструктор класса:
    public MainPageImportantQuestionsSection(WebDriver driver){
        this.driver = driver;
    }
    // метод - проскролить страницу до раздела "Вопросы о важном":
    public MainPageImportantQuestionsSection scrollToQuestions(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement importantQuestionsSection = driver.findElement(By.xpath(".//div[text()='Вопросы о важном']"));
        js.executeScript("arguments[0].scrollIntoView();", importantQuestionsSection);
        return this;
    }
    // метод - кликнуть по первому вопросу:
    public MainPageImportantQuestionsSection clickOnFirstQuestion(){
        driver.findElement(firstQuestion).click();
        return this;
    }
    // метод - получить текст первого ответа:
    public String getTextFromFirstAnswer(){
        String actualTextFromFirstAnswer = driver.findElement(firstAnswer).getText();
        return actualTextFromFirstAnswer;
    }
    // метод - кликнуть по шестому вопросу:
    public MainPageImportantQuestionsSection clickOnSixthQuestion(){
        driver.findElement(sixthQuestion).click();
        return this;
    }
    // метод - получить текст шестого ответа:
    public String getTextFromSixthAnswer(){
        String actualTextFromFirstAnswer = driver.findElement(sixthAnswer).getText();
        return actualTextFromFirstAnswer;
    }
    // метод - дождаться ожидаемого текста в поле Ответ (без метода иногда не срабатывает Тест для chrome)
    public MainPageImportantQuestionsSection waitForFirstAnswer(String answer) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.textToBePresentInElementLocated(firstAnswer, answer));
        return this;
    }

}
