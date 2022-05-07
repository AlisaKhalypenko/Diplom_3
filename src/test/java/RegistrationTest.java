import pageobject.ConstantPage;
import pageobject.LoginPage;
import pageobject.PersonalAccountPage;
import pageobject.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    String email = RandomStringUtils.randomAlphabetic(10)+"@gmail.com";
    String name = RandomStringUtils.randomAlphabetic(10);
    String password = RandomStringUtils.randomAlphabetic(10);

    @Test
    @DisplayName("registration With Correct Password")
    public void registrationWithCorrectPassword(){
        RegistrationPage registrationPage = open(ConstantPage.BASE_URL_REGISTER, RegistrationPage.class);
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickRegistrationButton();
        registrationPage.waitForLoadRoute();
        String url = url();
        assertEquals(url, "https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = open(ConstantPage.BASE_URL_LOGIN, LoginPage.class);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickEnterButton();
        String url1 = url();

        assertEquals(url1, "https://stellarburgers.nomoreparties.site/");

        PersonalAccountPage personalAccountPage = open("https://stellarburgers.nomoreparties.site", PersonalAccountPage.class);
        loginPage.openPersonalAccountAfterAuthorisation();
        personalAccountPage.clickExitButton();
    }

    @Test
    @DisplayName("Incorrect Password input")
    public void registrationWithIncorrectPassword(){
        RegistrationPage registrationPage = open(ConstantPage.BASE_URL_REGISTER, RegistrationPage.class);
        registrationPage.setPassword("12345");
        registrationPage.clickRegistrationButton();
        registrationPage.formError();
    }
}
