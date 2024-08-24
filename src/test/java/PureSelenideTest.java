import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PureSelenideTest extends TestBase {
    @DisplayName("Поиск заданной темы в репозитории")
    @Test
    public void nameOfIssueMustMatchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");
        $("div.search-input-container").click();
        $("input#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("input#query-builder-test").pressEnter();
        $(byLinkText(("eroshenkoam/allure-example"))).click();
        $("#issues-tab").click();
        $(withText("#90")).should(Condition.exist);
    }

}
