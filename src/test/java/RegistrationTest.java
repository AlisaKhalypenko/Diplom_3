import PageObject.LoginPage;
import PageObject.PersonalAccountPage;
import PageObject.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    String email = RandomStringUtils.randomAlphabetic(10)+"@gmail.com";

    @Test
    @DisplayName("registration With Correct Password")
    public void registrationWithCorrectPassword(){
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.setName("Germiona");
        registrationPage.setEmail(email);
        registrationPage.setPassword("123456");
        registrationPage.clickRegistrationButton();
        $(byText("Вход")).shouldBe(visible);
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.setEmail(email);
        loginPage.setPassword("123456");
        loginPage.clickEnterButton();
        String url1 = url();

        assertEquals(url1, "https://stellarburgers.nomoreparties.site/");

        PersonalAccountPage personalAccountPage = open("https://stellarburgers.nomoreparties.site", PersonalAccountPage.class);
        loginPage.openPersonalAccountAfterAuthorisation();
        personalAccountPage.clickExitButton();
        $(byText("Вход")).shouldBe(visible);
    }

    @Test
    @DisplayName("Incorrect Password input")
    public void registrationWithIncorrectPassword(){
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.setPassword("12345");
        registrationPage.clickRegistrationButton();
        registrationPage.formError();
    }
}
