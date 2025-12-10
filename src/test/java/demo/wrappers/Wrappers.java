package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.Keys;
import java.util.List;
import java.util.ArrayList;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    ChromeDriver driver;
    public Wrappers(ChromeDriver driver){
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    String url = "https://forms.gle/wjPkzeSEk1CM7KgGA";

    // Navigating to form
    public void navigateToForms(){
        driver.get(this.url);
    }

    // Entering name 
    public void enterName(String name){
        WebElement nameText = driver.findElement(By.xpath("//div[@class='Xb9hP']//input[1]"));
        nameText.sendKeys(name);
    }

    // Entering reason
    public void enterReason(String text){
        WebElement reasonText = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        reasonText.sendKeys(text);
    }

    // Selecting experience
    public void experienceInAutomation(){
        WebElement radioButton = driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        radioButton.click();
        
    }

    // Selectig skills learned
    public void selectSkills(){
        WebElement selectJava = driver.findElement(By.xpath("(//div[@class='bzfPab wFGF8']//div[@role='checkbox'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectJava));
        selectJava.click();
        WebElement selectSelenium = driver.findElement(By.xpath("(//div[@class='bzfPab wFGF8']//div[@role='checkbox'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectSelenium));
        selectSelenium.click();
        WebElement selectTestNG = driver.findElement(By.xpath("(//div[@class='bzfPab wFGF8']//div[@role='checkbox'])[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(selectTestNG));
        selectTestNG.click();
        
    }

    // Selecting how to address you
    public void selectMR() throws InterruptedException{
        WebElement dropDown = driver.findElement(By.xpath("(//div[contains(@class,'MocG8c ')])[1]"));
        //dropDown.click();
        dropDown.sendKeys("Mr", Keys.ENTER);
        Thread.sleep(3000);
        // List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'OA0qNb ')]/div"));
        // for(WebElement li : list){
        //     if(li.getText().equals("Mr")){
        //         li.click();
        //         break;
        //     }
        // }
        // Thread.sleep(3000);git 
        

        // WebElement selMR = driver.findElement(By.xpath("//div[contains(@class,'MocG8c ')][2]//span"));
        // selMR.click();
    }

    // Selectig date
    public void sltDate() throws InterruptedException{
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = date.format(formatter);
        System.out.println(currentDate);
        String actualDate = date.minusDays(7).format(formatter);
        WebElement enterDate = driver.findElement(By.xpath("//input[@type = 'date']"));
        enterDate.sendKeys(actualDate);
        System.out.println(actualDate);
    }

    // Entering time
    public void entTime(){
        WebElement enterTime1 = driver.findElement(By.xpath("(//input[@type ='text' and contains(@class,'whsOnd ')])[2]"));
        enterTime1.sendKeys("07");
        WebElement enterTime2 = driver.findElement(By.xpath("(//input[@type ='text' and contains(@class,'whsOnd ')])[3]"));
        enterTime2.sendKeys("30");
    }

    // Submiting form
    public void clickSubmit(){
        WebElement clkSubmit = driver.findElement(By.xpath("(//span[contains(text(),'Submit')])"));
        clkSubmit.click();
    }

    // Validating success message
    public void thanksMessage(){
        String expectedMessage = "Thanks for your response, Automation Wizard!";
        WebElement message = driver.findElement(By.xpath("//div[@class='vHW8K']"));
        String actualMessage = message.getText();
        if(actualMessage.contains(expectedMessage)){
            System.out.println("Expected message is present");
        }else{
            System.out.println("Expected message is not present");
        }

    }



    
}
