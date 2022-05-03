import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoToTheSectionTest {

    @Test
    @DisplayName("go To The Sause Section")
    public void goToTheSauseSection(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickSauceButton();
        $(byText("Соус Spicy-X")).shouldBe(visible);
    }

    @Test
    @DisplayName("go To The Filling Section")
    public void goToTheFillingSection(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickFillingButton();
        $(byText("Мясо бессмертных моллюсков Protostomia")).shouldBe(visible);
    }

    @Test
    @DisplayName("go To The Bun Section")
    public void goToTheBunSection(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        $(byText("Флюоресцентная булка R2-D3")).shouldBe(visible);
    }
}
