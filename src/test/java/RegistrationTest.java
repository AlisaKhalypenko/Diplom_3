import api.User;
import api.UserClient;
import api.UserCredentials;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
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
    UserClient userClient;
    User user;
    String accessToken;
    String email = RandomStringUtils.randomAlphabetic(10)+"@gmail.com";
    String name = RandomStringUtils.randomAlphabetic(10);
    String password = RandomStringUtils.randomAlphabetic(10);
    String incorrectPassword =RandomStringUtils.randomAlphabetic(5);

    @Before
    public void userRegistration() {
        userClient = new UserClient();
        user = new User(email, password, name, accessToken);
    }

    @After
    public void tearDown(){
        if( accessToken != null){
            userClient.delete(user);
        }
    }

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
        assertEquals(url, ConstantPage.BASE_URL_LOGIN);

        LoginPage loginPage = open(ConstantPage.BASE_URL_LOGIN, LoginPage.class);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickEnterButton();

        String url1 = url();
        assertEquals(url1, ConstantPage.BASE_URL);
        ValidatableResponse loginResponse = userClient.login(new UserCredentials(email, password));
        String accessTokenExtract = loginResponse.extract().path("accessToken");
        accessToken = accessTokenExtract.replace("Bearer ", "");
        user.setAccessToken(accessToken);

        PersonalAccountPage personalAccountPage = open(ConstantPage.BASE_URL, PersonalAccountPage.class);
        loginPage.openPersonalAccountAfterAuthorisation();
        personalAccountPage.clickExitButton();
    }

    @Test
    @DisplayName("Incorrect Password input")
    public void registrationWithIncorrectPassword(){
        RegistrationPage registrationPage = open(ConstantPage.BASE_URL_REGISTER, RegistrationPage.class);
        registrationPage.setPassword(incorrectPassword);
        registrationPage.clickRegistrationButton();
        registrationPage.formError();
        ValidatableResponse loginResponse = userClient.login(new UserCredentials(email, incorrectPassword));
        int statusCode = loginResponse.extract().statusCode();
        if(statusCode == 200){
            String accessTokenExtract = loginResponse.extract().path("accessToken");
            accessToken = accessTokenExtract.replace("Bearer ", "");
            user.setAccessToken(accessToken);
        }
    }
}
