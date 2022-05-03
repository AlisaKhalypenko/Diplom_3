package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    //локатор кнопки Войти
    @FindBy(how = How.XPATH,using = "//button[starts-with(@class, 'button_button') and text()='Войти']")
    private SelenideElement enterButton;

    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH,using = "//a[starts-with(@class, 'Auth_link') and text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    //локатор кнопки Восстановить пароль
    @FindBy(how = How.XPATH,using = "//a[starts-with(@class, 'Auth_link') and text()='Восстановить пароль']")
    private SelenideElement recoverPasswordButton;

    //локатор поля email
    @FindBy(how = How.XPATH,using = "//input[@type = 'text' and @name = 'name']")
    private SelenideElement emailField;

    //локатор поля пароль
    @FindBy(how = How.XPATH,using = "//input[@type = 'password' and @name = 'Пароль']")
    private SelenideElement passwordField;

    //локатор заголовка Вход
    @FindBy(how = How.CLASS_NAME,using = "Auth_login__3hAey")
    private SelenideElement enterHeading;

    //локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH,using = "//p[starts-with(@class, 'AppHeader_header') and text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    //локатор кнопки Выход
    @FindBy(how = How.XPATH,using = "//button[starts-with(@class, 'Account_button') and text()='Выход']")
    private SelenideElement exitButton;

    public void clickRegistrationButton(){
        registrationButton.click();
    }

    @Step("Email input")
    public void setEmail(String email){
        emailField.shouldBe(Condition.visible).setValue(email);
    }

    @Step("Password input")
    public void setPassword(String password){
        passwordField.shouldBe(Condition.visible).setValue(password);
    }

    @Step("click Enter Button")
    public void clickEnterButton(){
        enterButton.click();
        $(byText("Оформить заказ")).shouldBe(visible);
    }

    @Step("click Recover Password Button")
    public void clickRecoverPasswordButton(){
        recoverPasswordButton.click();
    }

    @Step("click PersonalAccount Button")
    public void openPersonalAccountAfterAuthorisation(){
        personalAccountButton.click();
        $(byText("Выход")).shouldBe(visible);
    }

}
