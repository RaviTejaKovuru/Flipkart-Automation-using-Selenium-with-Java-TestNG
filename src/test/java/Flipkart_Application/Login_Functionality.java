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
public class Login_Functionality 
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
    public void Login_Functionality_Check() throws InterruptedException 
    {
    	Thread.sleep(10000);
    	
    	WebElement Close = driver.findElement(By.xpath("/html/body/div[3]/div/span"));
    	softAssert.assertTrue(Close.isDisplayed(), "Close Button is not displayed");
    	Close.click();
    	
    	
    	WebElement Login = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div/a/span"));
    	softAssert.assertTrue(Login.isDisplayed(), "Login link is not displayed");
    	Login.click();
    	
    	Thread.sleep(5000);
    	
    	WebElement EMail = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input"));
    	softAssert.assertTrue(EMail.isDisplayed(), "EMail link is not displayed");
    	EMail.sendKeys("7695837012");
    	
    	Thread.sleep(5000);
    	
    	WebElement Request_OTP = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button"));
    	softAssert.assertTrue(Request_OTP.isDisplayed(), "Request OTP link is not displayed");
    	Request_OTP.click();
    	
    	Thread.sleep(120000);
    	
    	WebElement My_Profile = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/div/a/span"));
    	softAssert.assertTrue(My_Profile.isDisplayed(), "My Profile link is not displayed");
    	Actions actions = new Actions(driver);
		actions.moveToElement(My_Profile).build().perform();
		
		Thread.sleep(2000);
		
		WebElement Logout = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/div/div/ul/a[9]"));
		softAssert.assertTrue(Logout.isDisplayed(), "My Profile link is not displayed");
		Logout.click();
		
		Thread.sleep(5000);
    	
        System.out.println("Login Functionality is Working Fine.");
        

    }

   
 }