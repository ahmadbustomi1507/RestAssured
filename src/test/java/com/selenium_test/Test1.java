package com.selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

    @BeforeTest
    public void set_driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Driver\\chromedriver.exe");       
    }

    @Test
    public void test_get_driver() {
        // ChromeOptions op = new ChromeOptions();
        // op.setHeadless(false);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // WebDriverManager.firefoxdriver().setup();;
        // WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.google.com/");
        driver.getTitle();
        // driver.findElement(By.id("name_of_id")).sendKeys("do something");
        driver.quit();
    }
}
