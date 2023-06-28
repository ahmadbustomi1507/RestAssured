package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.github.bonigarcia.wdm.WebDriverManager;

public class my_test {

    @BeforeTest
    public void set_driver() {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumDriver\\113\\chromedriver.exe");
    }

    @Test
    public void test_get_driver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.getTitle();
        driver.quit();
    }
}
