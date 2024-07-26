package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class LambdaGitHubTest {

    private final static String REPO = "selenide/selenide";
    private final static Integer ISSUE = 2780;
    @Test
    public void gitHubIssueLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open GitHub", () -> {
            open("https://github.com");
        });

        step("Search by" + REPO, () ->{
            $(".search-input").click();
            $("#query-builder-test").sendKeys("selenide/selenide");
            $("#query-builder-test").submit();
        });

        step("Click on the link" + REPO, () ->{
            $(linkText(REPO)).click();
        });

        step("Open tab issue", () ->{
            $("#issues-tab").click();
        });
        step("Checking for Issue with number {issue}", ()->{
            $(withText("#" + ISSUE)).shouldBe(Condition.exist);
        });
    }
}
