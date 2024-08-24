import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {


    @Step("Открыть главную страницу")
    public WebSteps openPage(){
        open("https://github.com");
        return this;
    }

    @Step("Выполнить поиск репозитория {repository}")
    public WebSteps findRepository(String repository){
        $("div.search-input-container").click();
        $("input#query-builder-test").sendKeys(repository);
        $("input#query-builder-test").pressEnter();
        return this;
    }

    @Step("Выбрать репозиторий {webLink}")
    public WebSteps selectRepository(String webLink){
        $(byLinkText((webLink))).click();
        return this;
    }

    @Step("Перейти на вкладку Issues")
    public WebSteps followWebLink(){
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверить наличие темы № {number}")
    public WebSteps checkForIssue(int number){
        $(withText("#" + number)).should(Condition.exist);
        return this;
    }
}