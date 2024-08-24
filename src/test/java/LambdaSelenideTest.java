import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class LambdaSelenideTest extends TestBase {
    @DisplayName("Поиск заданной темы в репозитории")
    @Test
    public void nameOfIssueMustMatchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу",()->{
            open("");
        });

        step("Выполнить поиск",()->{
            $("div.search-input-container").click();
            $("input#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("input#query-builder-test").pressEnter();
        });

        step("Перейти на первую найденную страницу",()->{
            $(byLinkText(("eroshenkoam/allure-example"))).click();
        });

        step("Перейти на вкладку Issues",()->{
            $("#issues-tab").click();
        });

        step("Проверить наличие Issue",()->{
            $(withText("#90")).should(Condition.exist);
        });
    }
}
