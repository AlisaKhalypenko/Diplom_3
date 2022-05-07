import pageobject.ConstantPage;
import pageobject.LoginPage;
import pageobject.PersonalAccountPage;
import pageobject.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class ExitTest {
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
    }

    @Test
    @DisplayName("exit From Account")
    public void exitFromAccount() {
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
}
