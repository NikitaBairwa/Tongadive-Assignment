
package com.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
    WebDriver driver;

    By email = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("submit");

    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(email).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}