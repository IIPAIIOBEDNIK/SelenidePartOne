package github;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FindSelenideTest {

    @BeforeAll
    static void setup() {
        baseUrl = "https://github.com";
        startMaximized = true;
    }

    @Test
    void shouldFindSelenideRepository() {
        //Открыть страницу гитхаб
        open("https://github.com");
        //Вводим selenide в строку поиска
        $("[name=q]").setValue("drag_and_drop").pressEnter();
        $$(".repo-list").first().$("a").click();
        //Переходим в Wiki
        $("[data-content = Wiki").click();
        //Раскрываем
        $(".js-wiki-more-pages-link").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"))
                .$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
