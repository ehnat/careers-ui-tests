package com.akamai;

import com.akamai.configuration.OperatingSystem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTestCase {

    WebDriver driver;

    @BeforeMethod
    public void openChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", OperatingSystem.valueOf(System.getProperty("operatingSystem"))
                .getChromeDriverPath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
