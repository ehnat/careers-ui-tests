package com.akamai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class JobPostPage extends BasePage {

    @FindBy(xpath = "//*[@class='job_post_date']/span[@class='field_value']")
    private WebElement creationDate;

    JobPostPage(WebDriver driver) {
        super(driver);
        waitForWebElementVisibility(creationDate);
    }

    String getCreationDate() {
        return creationDate.getText();
    }
}
