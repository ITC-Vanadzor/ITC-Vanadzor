//package org.openqa.selenium.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LunchLogin {
    public static void main(String[] args) throws Exception {
        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();

        // Go to the Google Suggest home page
        driver.get("http://localhost:8080/lunchOrder-1/loginpage.html");

        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.id("email"));
        query.sendKeys("invalid email");
        WebElement submit  = driver.findElement(By.id("botton"));
        submit.click();


        driver.quit();
    }
}
