package com.akamai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

    WebDriver driver;
    private WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    void waitForWebElementVisibility(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}