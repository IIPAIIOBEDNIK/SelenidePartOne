package drug_and_drop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.*;

public class DrugAndDrop {

    @BeforeAll
    static void setup(){
        baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        startMaximized = true;
    }

    @Test
    void checkDrugAndDrop(){
        //Открываем
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Переносим квадрат А на квадрат В
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверяем, что они поменялись местами
        $("#column-a header").shouldHave(text("B"));
    }
}
