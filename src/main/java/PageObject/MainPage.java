package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    //локатор кнопки Войти в аккаунт
    @FindBy(how = How.XPATH,using = "//button[starts-with(@class, 'button_button') and text()='Войти в аккаунт']")
    private SelenideElement enterToAccountButton;

    //локатор кнопки Личный кабинет
    @FindBy(how = How.XPATH,using = "//p[starts-with(@class, 'AppHeader_header') and text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    //локатор кнопки Булки
    @FindBy(how = How.XPATH,using = "//span[starts-with(@class, 'text text_type_main-default') and text()='Булки']")
    private SelenideElement bunButton;

    //локатор кнопки Соусы
    @FindBy(how = How.XPATH,using = "//span[starts-with(@class, 'text text_type_main-default') and text()='Соусы']")
    private SelenideElement sauceButton;

    //локатор кнопки Начинки
    @FindBy(how = How.XPATH,using = "//span[starts-with(@class, 'text text_type_main-default') and text()='Начинки']")
    private SelenideElement fillingButton;

    //локатор кнопки Флюоресцентная булка
    @FindBy(how = How.XPATH,using = "//p[starts-with(@class, 'BurgerIngredient_ingredient__text') and text()='Флюоресцентная булка R2-D3']")
    private SelenideElement fluorescentBunButton;

    //локатор кнопки Соус Spicy-X
    @FindBy(how = How.XPATH,using = "//p[starts-with(@class, 'BurgerIngredient_ingredient__text') and text()='Соус Spicy-X']")
    private SelenideElement sauceSpicyButton;

    //локатор кнопки Мясо бессмертных моллюсков
    @FindBy(how = How.XPATH,using = "//p[starts-with(@class, 'BurgerIngredient_ingredient__text') and text()='Мясо бессмертных моллюсков Protostomia']")
    private SelenideElement fillingMeatButton;

    //локатор кнопки Оформить заказ
    @FindBy(how = How.XPATH,using = "//button[starts-with(@class, 'button_button') and text()='Оформить заказ']")
    private SelenideElement orderButton;

    @Step("click EnterToAccountButton")
    public void clickEnterToAccountButton(){
        enterToAccountButton.click();
    }

    @Step("click PersonalAccountButton")
    public void clickPersonalAccountButton(){
        personalAccountButton.click();
    }

    @Step("click SauceButton")
    public void clickSauceButton(){
        sauceButton.click();
    }

    @Step("click FillingButton")
    public void clickFillingButton(){
        fillingButton.click();
    }

    @Step("click BunButton")
    public void clickBunButton(){
        bunButton.click();
    }
}
