package Flipkart_Application;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(Flipkart_Listeners.class)
public class Checkout_Process_Through_Invalid_Mobile_Number
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
    public void Checkout_Process_Via_Invalid_Mobile_Number() throws InterruptedException 
    {
    	Thread.sleep(3000);
    	
    	WebElement Close = driver.findElement(By.xpath("/html/body/div[3]/div/span"));
    	softAssert.assertTrue(Close.isDisplayed(), "Close Button is not displayed");
    	Close.click();
    	
    
         
         Thread.sleep(5000);
    	
    	WebElement Search_Box = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));
    	softAssert.assertTrue(Search_Box.isDisplayed(), "Search Box is not displayed");
    	Search_Box.sendKeys("Tshirts");
        Thread.sleep(1000);
    	
    	
    	WebElement Search_Button = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/button"));
    	softAssert.assertTrue(Search_Button.isDisplayed(), "Search Box is not displayed");
    	Search_Button.click();
    	
    	Thread.sleep(2000);
    	
    	 WebElement Product = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[4]/div/div[2]/div/a/div[1]/div/div/div/img"));

         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Product);
         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);");
          
         WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait1.until(ExpectedConditions.elementToBeClickable(Product));

         softAssert.assertTrue(Product.isDisplayed(), "Product not found on the search results page");
         Product.click();
         
         Switch_To_New_Tab();
         
         WebDriverWait newTabWait = new WebDriverWait(driver, Duration.ofSeconds(30));
         newTabWait.until(ExpectedConditions.numberOfWindowsToBe(2));

         ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1100);");
         
         Thread.sleep(1000);
         
         WebElement Add_to_Cart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]"));
         softAssert.assertTrue(Add_to_Cart.isDisplayed(), "Add to Cart button is not displayed");
         Add_to_Cart.click();
         
         Thread.sleep(10000);
         
         WebElement Place_Order = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[4]/div/form/button/span"));
         softAssert.assertTrue(Place_Order.isDisplayed(), "Place Order button is not displayed");
         Place_Order.click();
         
         Thread.sleep(3000);
         
         WebElement Email = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input"));
         softAssert.assertTrue(Email.isDisplayed(), "Email Field is not displayed");
         Email.sendKeys("0123456789");
         
         WebElement Continue = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button"));
         softAssert.assertTrue(Continue.isDisplayed(), "Continue Button is not displayed");
         Continue.click();
         
         Thread.sleep(1000);
         
         WebElement Error_Message = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/span[2]/span"));
         softAssert.assertTrue(Error_Message.isDisplayed(), "Error Message is not displayed");
         
         if (Error_Message.isDisplayed()) 
         {
        	 
             System.out.println("Place Order through invalid mobile number is working fine");
             
         }
         

         
         Thread.sleep(10000);
    		
    }
     
    private void Switch_To_New_Tab() 
    {
    	
        Set<String> handles = driver.getWindowHandles();
        
        for (String handle : handles) 
        {
        	
            driver.switchTo().window(handle);
            
        }
        
    }

   
 }
