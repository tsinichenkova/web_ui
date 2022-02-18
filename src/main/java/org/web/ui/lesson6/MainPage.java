package org.web.ui.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{

    @FindBy(id = "signin")
    private WebElement signIn;

    @FindBy(id = "show-user-menu")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@id='user-menu']//ul//li//a[contains(@class,'header__user-menu-item')]/span[contains(@class,'header__profile')]")
    private WebElement profile;

    @FindBy(xpath = "//div[contains(@class, 'header__menu-item')]/a[text()='Стандартизация']")
    private WebElement standardization;

    @FindBy(xpath = "//div[contains(@class, 'header__menu-item')]/a[text()='Подсказки']")
    private WebElement suggestions;


    public WebElement getProfile() {
        return profile;
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage(){
        signIn.click();
    }

    public void clickUserMenu(){
        userMenu.click();
    }

    public void goToProfilePage(){
        profile.click();
    }

    public void goToStandardizationPage(){
        standardization.click();
    }

    public void goToSuggestionsPage(){
        suggestions.click();
    }

}
