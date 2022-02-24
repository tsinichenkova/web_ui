package org.web.ui.lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'authorization_popup__row')]//input[@name='login-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[contains(@class, 'authorization_popup__row')]//input[@name='login-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[contains(@class, 'authorization_popup__row')]//input[@value='Войти в систему']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='login-form']//div[contains(@class, 'form-errors')]")
    private WebElement formErrors;

    public WebElement getFormErrors() {
        return formErrors;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginIn(String email, String password){
        Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(this.emailInput, email)
                .click(this.passwordInput)
                .sendKeys(password)
                .click(this.submitButton)
                .build()
                .perform();
    }

}
