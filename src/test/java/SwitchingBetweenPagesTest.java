import pageobject.ConstantPage;
import pageobject.LoginPage;
import pageobject.PersonalAccountPage;
import pageobject.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class SwitchingBetweenPagesTest {
    String email = RandomStringUtils.randomAlphabetic(10)+"@gmail.com";
    String name = RandomStringUtils.randomAlphabetic(10);
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void userRegistration() {
        RegistrationPage registrationPage = open(ConstantPage.BASE_URL_REGISTER, RegistrationPage.class);
        registrationPage.setName(name);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.clickRegistrationButton();
        registrationPage.waitForLoadRoute();
    }

    @Test
    @DisplayName("switching To Personal Account")
    public void switchingToPersonalAccount() {
        LoginPage loginPage = open(ConstantPage.BASE_URL_LOGIN, LoginPage.class);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickEnterButton();
        PersonalAccountPage personalAccountPage = open(ConstantPage.BASE_URL, PersonalAccountPage.class);
        loginPage.openPersonalAccountAfterAuthorisation();
        String url = url();

        assertEquals(url, "https://stellarburgers.nomoreparties.site/account/profile");

        personalAccountPage.clickExitButton();
    }

    @Test
    @DisplayName("switching From Personal Account To Designer By DesignerButton")
    public void switchingFromPersonalAccountToDesignerByDesignerButton() {
        LoginPage loginPage = open(ConstantPage.BASE_URL_LOGIN, LoginPage.class);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickEnterButton();
        PersonalAccountPage personalAccountPage = open(ConstantPage.BASE_URL, PersonalAccountPage.class);
        loginPage.openPersonalAccountAfterAuthorisation();
        personalAccountPage.clickDesignButton();
        String url = url();

        assertEquals(url, "https://stellarburgers.nomoreparties.site/");

        loginPage.openPersonalAccountAfterAuthorisation();
        personalAccountPage.clickExitButton();
    }

    @Test
    @DisplayName("switching From Personal Account To Designer By LogoButton")
    public void switchingFromPersonalAccountToDesignerByLogoButton() {
        LoginPage loginPage = open(ConstantPage.BASE_URL_LOGIN, LoginPage.class);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickEnterButton();
        PersonalAccountPage personalAccountPage = open(ConstantPage.BASE_URL, PersonalAccountPage.class);
        loginPage.openPersonalAccountAfterAuthorisation();
        personalAccountPage.clickLogoButton();
        String url = url();

        assertEquals(url, "https://stellarburgers.nomoreparties.site/");

        loginPage.openPersonalAccountAfterAuthorisation();
        personalAccountPage.clickExitButton();
    }

}
