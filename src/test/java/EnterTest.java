import PageObject.LoginPage;
import PageObject.RegistrationPage;
import PageObject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class EnterTest {

    @Test
    @DisplayName("enter To Account From Main Page By 'Enter To Accout' Button")
    public void enterToAccountFromMainPageByEnterToAccoutButton(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickEnterToAccountButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    @DisplayName("enter To Account From Main Page By Personal Account Button")
    public void enterToAccountFromMainPageByPersonalAccountButton() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickPersonalAccountButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    @DisplayName("enter To Account From Registration Page By Enter Button")
    public void enterToAccountFromRegistrationPageByEnterButton() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.clickEnterButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    @DisplayName("enter To Account From Login Page By Recover Password Button")
    public void enterToAccountFromLoginPageByRecoverPasswordButton() {
        LoginPage loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickRecoverPasswordButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/forgot-password");
    }
}
