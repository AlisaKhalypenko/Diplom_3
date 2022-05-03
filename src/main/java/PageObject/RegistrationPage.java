package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    //локатор кнопки Зарегистрироваться
    @FindBy(how = How.XPATH,using = "//button[starts-with(@class, 'button_button') and text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    //локатор кнопки Войти
    @FindBy(how = How.XPATH,using = "//a[starts-with(@class, 'Auth_link__1fOlj') and text()='Войти']")
    private SelenideElement enterButton;

    //локатор поля email
    @FindBy(how = How.XPATH,using = "//label[text() ='Email']//following::input[1]")
    private SelenideElement emailField;

    //локатор поля пароль
    @FindBy(how = How.XPATH,using = "//input[@class='text input__textfield text_type_main-default' and @type='password']")
    private SelenideElement passwordField;

    //локатор поля Имя
    @FindBy(how = How.XPATH,using = "//input[@type = 'text' and @name = 'name']")
    private SelenideElement nameField;

    //локатор ошибки Некорректный пароль
    @FindBy(how = How.XPATH,using = "//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']")
    private SelenideElement wrongPasswordField;

    public void setName(String name){
        nameField.shouldBe(Condition.visible).setValue(name);
    }

    public void setEmail(String email){
        emailField.click();
        emailField.shouldBe(Condition.visible).setValue(email);
    }

    public void setPassword(String password){
        passwordField.shouldBe(Condition.visible).setValue(password);
    }

    public void clickRegistrationButton(){
        registrationButton.click();
    }

    public void clickEnterButton(){
        enterButton.click();
    }

    public void formError(){
        wrongPasswordField.shouldBe(Condition.visible);
        wrongPasswordField.shouldHave(Condition.exactText("Некорректный пароль"));
    }
}
