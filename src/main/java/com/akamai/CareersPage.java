package com.akamai;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

class CareersPage extends BasePage {

    private String url;

    @FindBy(id = "keyword")
    private WebElement keywordInput;

    @FindBy(id = "jLocInputHldr")
    private WebElement locationElement;

    @FindBy(xpath = "//*[@id='location_facet_chzn']//child::input")
    private WebElement locationInput;

    @FindBy(id = "jSearchSubmit")
    private WebElement searchButton;

    CareersPage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
    }

    CareersPage open() {
        driver.get(url);
        return this;
    }

    SearchResultPage findJobPost(String keyword, String location) {
        keywordInput.sendKeys(keyword);
        setJobLocation(location);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    private void setJobLocation(String location) {
        Actions builder = new Actions(driver);
        Action setLocation = builder
                .click(locationElement)
                .sendKeys(locationInput, location)
                .sendKeys(locationInput, Keys.ENTER)
                .build();
        setLocation.perform();
    }
}
