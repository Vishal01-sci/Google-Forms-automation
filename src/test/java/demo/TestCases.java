package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.beans.Transient;
import java.time.Duration;
import java.util.logging.Level;
//import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    public static ChromeDriver driver;
    


    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

    @Test
    public void testCase01() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigating to form
        Wrappers navigateToForm = new Wrappers(driver);
        navigateToForm.navigateToForms();
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Boolean status = currentURL.contains("forms");
        Assert.assertTrue(status, "Failed to navigate to forms page");

        // Entering name 
        Wrappers firstText = new Wrappers(driver);
        firstText.enterName("Crio Learner");

        // Entering reason
        Wrappers secondText = new Wrappers(driver);
        Long epoch = System.currentTimeMillis()/1000;
        String textToBeEntered = "I want to be the best QA Engineer! " + Long.toString(epoch);
        secondText.enterReason(textToBeEntered);
        

        // Selecting experience
        Wrappers selectExperience = new Wrappers(driver);
        selectExperience.experienceInAutomation();
        System.out.println("Experience 3-5 years is selected");
        

        // Selectig skills learned
        Wrappers selectSkills = new Wrappers(driver);
        selectSkills.selectSkills();
        System.out.println("Skills - Java, Selenium and TestNG is selected");
        

        // Selecting how to address you
        Wrappers sltMr = new Wrappers(driver);
        sltMr.selectMR();
        System.out.println("Mr is selected");
        

        // Selectig date
        Wrappers selectDate = new Wrappers(driver);
        selectDate.sltDate();

        // Entering time
        Wrappers enterTime = new Wrappers(driver);
        enterTime.entTime();

        // Submiting form
        Wrappers submitForm = new Wrappers(driver);
        submitForm.clickSubmit();

        // Validating success message
        Wrappers valMessage = new Wrappers(driver);
        valMessage.thanksMessage();
    }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}