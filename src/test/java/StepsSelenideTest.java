import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsSelenideTest extends TestBase{

    @DisplayName("Поиск заданной темы в репозитории")
    @Test
    public void nameOfIssueMustMatchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps ws = new WebSteps();

        ws.openPage()
                .findRepository("eroshenkoam/allure-example")
                .selectRepository("eroshenkoam/allure-example")
                .followWebLink()
                .checkForIssue(90);
    }
}
