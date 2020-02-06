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
 
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 
        driver.get("https://www.saucedemo.com/index.html");
 
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user"); 
 
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
 
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")).click();
  
        System.out.println("Login Successfully");
         
        driver.findElement (By.id("user-dropdown-toggle")).click();
 
        driver.findElement (By.xpath("//*[@id=\"signout-button\"]/button")).click();
 
 
        System.out.println("LogOut Successfully");
  
        driver.quit();
 
 }
 
}
