package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class SeleniumTest {
 private static WebDriver driver = null;
 public static void main(String[] args) {
 // Create a new instance of the Firefox driver
 
        driver = new FirefoxDriver();
 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        driver.get("https://www.saucedemo.com/index.html");
 
        // Find the element that's ID attribute is 'account'(My Account) 
 
        //driver.findElement(By.xpath(".//*[@id='account']/a")).click();
 
        // Find the element that's ID attribute is 'log' (Username)
 
        // Enter Username on the element found by above desc.
 
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user"); 
 
        // Find the element that's ID attribute is 'pwd' (Password)
 
        // Enter Password on the element found by the above desc.
 
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
 
        // Now submit the form. WebDriver will find the form for us from the element 
 
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("Login Successfully");
 
        // Find the element that's ID attribute is 'account_logout' (Log Out)
        
        driver.findElement (By.id("user-dropdown-toggle")).click();
 
        driver.findElement (By.xpath("//*[@id=\"signout-button\"]/button")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("LogOut Successfully");
 
        // Close the driver
 
        driver.quit();
 
 }
 
}
