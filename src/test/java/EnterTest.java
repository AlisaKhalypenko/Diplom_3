import pageobject.ConstantPage;
import pageobject.LoginPage;
import pageobject.RegistrationPage;
import pageobject.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class EnterTest {

    @Test
    @DisplayName("enter To Account From Main Page By 'Enter To Accout' Button")
    public void enterToAccountFromMainPageByEnterToAccoutButton(){
        MainPage mainPage = open(ConstantPage.BASE_URL, MainPage.class);
        mainPage.clickEnterToAccountButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    @DisplayName("enter To Account From Main Page By Personal Account Button")
    public void enterToAccountFromMainPageByPersonalAccountButton() {
        MainPage mainPage = open(ConstantPage.BASE_URL, MainPage.class);
        mainPage.clickPersonalAccountButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    @DisplayName("enter To Account From Registration Page By Enter Button")
    public void enterToAccountFromRegistrationPageByEnterButton() {
        RegistrationPage registrationPage = open(ConstantPage.BASE_URL_REGISTER, RegistrationPage.class);
        registrationPage.clickEnterButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
    }

    @Test
    @DisplayName("enter To Account From Login Page By Recover Password Button")
    public void enterToAccountFromLoginPageByRecoverPasswordButton() {
        LoginPage loginPage = open(ConstantPage.BASE_URL_LOGIN, LoginPage.class);
        loginPage.clickRecoverPasswordButton();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/forgot-password");
    }
}
