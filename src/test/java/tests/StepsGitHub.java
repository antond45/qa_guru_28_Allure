package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepsGitHub {
    @Step("Open Github")
    public StepsGitHub openGitHub() {
        open("https://github.com");
        return this;
    }

    @Step("Search by {repo}")
    public StepsGitHub searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
        return this;
    }

    @Step("Click on the link {repo}")
    public StepsGitHub clickRepoLink(String repo) {
        $(linkText(repo)).click();
        return this;
    }

    @Step("Opoen tab Issues")
    public StepsGitHub openIssuesTab() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Checking for Issue with number {issue}")
    public StepsGitHub checkingForIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }
}
