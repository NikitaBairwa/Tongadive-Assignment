
package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.webpages.Loginpage;
import com.webpages.Profilepage;


public class Profiletest {
    WebDriver driver;
    Loginpage login;
    Profilepage profile;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
       
        profile = new Profilepage(driver);
       
    }

    @Test
    public void updateProfileTest() {
        profile.updateProfile("New Name");
        String confirmationMessage = driver.findElement(By.id("confirmation")).getText();
        Assert.assertEquals(confirmationMessage.trim(), "Row 1 was saved", "Confirmation message is not correct.");
    
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}