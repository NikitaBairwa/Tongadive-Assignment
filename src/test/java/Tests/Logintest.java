
package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webpages.Loginpage;

public class Logintest {
    WebDriver driver;
    Loginpage login;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        login = new Loginpage(driver);
    }

    @Test
    public void validLoginTest() {
        login.login("student", "Password123");

        // Assert URL contains expected path
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("logged-in-successfully"), "User is not redirected after valid login.");

        // Optionally, assert the presence of success message
        String successText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(successText, "Logged In Successfully", "Success message not displayed correctly.");
    }

    @Test
    public void invalidLoginTest() {
        login.login("invalid@example.com", "wrongPassword");

        // Assert the error message is displayed
        String errorMessage = driver.findElement(By.id("error")).getText();
        Assert.assertEquals(errorMessage.trim(), "Your username is invalid!", "Error message is not correct.");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}