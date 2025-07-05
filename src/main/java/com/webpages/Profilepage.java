
package com.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Profilepage {
    WebDriver driver;
    By editBtn = By.id("edit_btn");
    By inputField = By.className("input-field");
    By saveBtn = By.id("save_btn");
  

    public Profilepage(WebDriver driver) {
        this.driver = driver;
    }

    public void updateProfile(String name) {
    	driver.findElement(editBtn).click();
        driver.findElement(inputField).sendKeys(name);
        driver.findElement(saveBtn).click();
    }
}