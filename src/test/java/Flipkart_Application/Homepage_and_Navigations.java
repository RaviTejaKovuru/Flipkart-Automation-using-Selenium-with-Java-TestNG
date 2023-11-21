package Flipkart_Application;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


@Listeners(Flipkart_Listeners.class)
public class Homepage_and_Navigations
{

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;

    @BeforeTest
    public void setup() 
    {
    	
        
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        
    }
    
    @AfterTest
    public void tearDown() 
    {
    	
        if (driver != null) 
        {
        	
            driver.quit();
            
        }
        
        softAssert.assertAll();
    }    

   
    @Test
    public void Homepage_and_Navigations_Check() throws InterruptedException 
    {
    	Thread.sleep(10000);
    	
    	WebElement Close = driver.findElement(By.xpath("/html/body/div[3]/div/span"));
    	softAssert.assertTrue(Close.isDisplayed(), "Close Button is not displayed");
    	Close.click();
    	
    	Thread.sleep(3000);
    	
    	WebElement Fashion = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]/div/div/span/span[1]"));
    	softAssert.assertTrue(Fashion.isDisplayed(), "Fashion link is not displayed");
    	Actions actions = new Actions(driver);
    	actions.moveToElement(Fashion).build().perform();
    	
    	Thread.sleep(2000);
    	
    	WebElement Mens_Ethinic_Sets = driver.findElement(By.linkText("Men's Ethnic Sets"));
    	Mens_Ethinic_Sets.click();
    	
    	Thread.sleep(15000);
    	
    	
        System.out.println("Homepage and Navigations is Working Fine.");
        

    }
    
 }
