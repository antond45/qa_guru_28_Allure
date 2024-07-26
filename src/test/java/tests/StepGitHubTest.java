package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class StepGitHubTest {
    private static final String REPO = "selenide/selenide";
    private static final Integer ISSUE = 2780;

    @Test
    public void gitHubIssueStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsGitHub stepsGitHub = new StepsGitHub();

        stepsGitHub.openGitHub();
        stepsGitHub.searchForRepository(REPO);
        stepsGitHub.clickRepoLink(REPO);
        stepsGitHub.openIssuesTab();
        stepsGitHub.checkingForIssueWithNumber(ISSUE);
    }
}
