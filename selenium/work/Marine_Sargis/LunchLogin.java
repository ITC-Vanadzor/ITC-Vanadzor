//package org.openqa.selenium.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LunchLogin {
static    private WebElement isChecked;

    public static void main(String[] args) throws Exception {
        // The Firefox driver supports javascript 
        WebDriver driver = new FirefoxDriver();

        // Go to the Google Suggest home page
        driver.get("http://localhost:8080/lunch-1/loginpage.html");

        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.id("email"));
        query.sendKeys("marine@itc.com");
        WebElement query1 = driver.findElement(By.id("pswd"));
        query1.sendKeys("marine");
        WebElement submit  = driver.findElement(By.id("botton"));
        isChecked = driver.findElement(By.cssSelector("input[type='checkbox']"));
        //  driver.quit();
        isChecked.click();
        submit.click();
    WebElement query2= driver.findElement(By.id("count"));
    query2.sendKeys("10");
    }

}
