package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {
    //локатор кнопки Выход
    @FindBy(how = How.XPATH,using = "//button[starts-with(@class, 'Account_button') and text()='Выход']")
    private SelenideElement exitButton;

    //локатор кнопки Конструктор
    @FindBy(how = How.XPATH,using = "//p[starts-with(@class, 'AppHeader_header') and text()='Конструктор']")
    private SelenideElement designButton;

    //локатор логотипа
    @FindBy(how = How.XPATH,using = "//div[@class = 'AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    @Step("click DesignButton")
    public void clickDesignButton(){
        designButton.click();
        $(byText("Оформить заказ")).shouldBe(visible);
    }

    @Step("click ExitButton")
    public void clickExitButton(){
        exitButton.shouldBe(Condition.visible).click();
    }

    @Step("click LogoButton")
    public void clickLogoButton(){
        logoButton.click();
        $(byText("Оформить заказ")).shouldBe(visible);
    }

}
