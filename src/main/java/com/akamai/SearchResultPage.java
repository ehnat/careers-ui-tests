package com.akamai;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

class SearchResultPage extends BasePage {

    @FindBy(xpath = "//*[@id='jobs_filters_title']//following::span[@class='total_results']")
    private WebElement totalResults;

    @FindBy(xpath = "//*[@class='jlr_title']//child::a[contains(@class,'job_link')]")
    private List<WebElement> jobTitles;

    SearchResultPage(WebDriver driver) {
        super(driver);
    }

    int getTotalResults() {
        waitForVisibilityWebElement(totalResults);
        return Integer.parseInt(totalResults.getText());
    }

    int getJobPostNumber(String title) {
        waitForVisibilityWebElement(jobTitles.get(0));
        return (int) jobTitles.stream()
                .filter(jobTitle -> jobTitle.getText().contains(title))
                .count();
    }

    JobPostPage goToJobPost(String title) {
        WebElement jobPostTitle = findJobTitle(title)
                .orElseThrow(() -> new NoSuchElementException(String.format("Job post with title %s doesn't exists", title)));
        jobPostTitle.click();
        return new JobPostPage(driver);
    }

    private Optional<WebElement> findJobTitle(String title) {
        return jobTitles.stream()
                .filter(jobTitle -> jobTitle.getText().equals(title))
                .findAny();
    }
}