import pageobject.ConstantPage;
import pageobject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class GoToTheSectionTest {

    @Test
    @DisplayName("go To The Sause Section")
    public void goToTheSauseSection(){
        MainPage mainPage = open(ConstantPage.BASE_URL, MainPage.class);
        mainPage.clickSauceButton();
    }

    @Test
    @DisplayName("go To The Filling Section")
    public void goToTheFillingSection(){
        MainPage mainPage = open(ConstantPage.BASE_URL, MainPage.class);
        mainPage.clickFillingButton();
    }

    @Test
    @DisplayName("go To The Bun Section")
    public void goToTheBunSection(){
        MainPage mainPage = open(ConstantPage.BASE_URL, MainPage.class);
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
    }
}
