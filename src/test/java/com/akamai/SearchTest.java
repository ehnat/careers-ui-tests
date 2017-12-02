package com.akamai;

import org.testng.annotations.Test;

import static com.akamai.configuration.Configuration.CONFIGURATION;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTestCase {

    private static final String KEYWORD = "test";
    private static final String JOB_LOCATION = "Krakow, Poland";
    private static final int RESULTS_NUMBER = 12;
    private static final String JOB_POST_TITLE = "Software Development Engineer in Test";
    private static final int JOB_POST_NUMBER = 2;
    private static final String LUNA_JOB_TITLE = "Software Development Engineer in Test - LUNA";
    private static final String LUNA_JOB_CREATION_DATE = "Oct 25, 2017";

    @Test
    public void shouldSearchJobPostByKeywordAndLocation() {

        CareersPage careersPage = new CareersPage(driver, CONFIGURATION.getValue("baseUrl")).open();

        SearchResultPage searchResultPage = careersPage.findJobPost(KEYWORD, JOB_LOCATION);

        assertThat(searchResultPage.getTotalResults()).isEqualTo(RESULTS_NUMBER);
        assertThat(searchResultPage.getJobPostNumber(JOB_POST_TITLE)).isEqualTo(JOB_POST_NUMBER);
        JobPostPage jobPostPage = searchResultPage.goToJobPost(LUNA_JOB_TITLE);
        assertThat(jobPostPage.getCreationDate()).isEqualTo(LUNA_JOB_CREATION_DATE);
    }
}


