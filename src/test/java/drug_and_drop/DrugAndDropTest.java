package drug_and_drop;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.*;

public class DrugAndDropTest {

    @BeforeAll
    static void setup(){
        baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        startMaximized = true;
    }

    @Test
    void checkDrugAndDropTest(){
        //Открываем
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Переносим квадрат А на квадрат В
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверяем, что они поменялись местами
        $("#column-a").shouldHave(text("B"));
    }
}
