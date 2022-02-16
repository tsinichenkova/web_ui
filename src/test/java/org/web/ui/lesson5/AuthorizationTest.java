package org.web.ui.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationTest extends TestBase {

    private static final String signIn = "signin";
    private static final String showUserMenu = "show-user-menu";
    private static final String emailInput = "//div[contains(@class, 'authorization_popup__row')]//input[@name='login-email']";
    private static final String passwordInput = "//div[contains(@class, 'authorization_popup__row')]//input[@name='login-password']";
    private static final String submitButton = "//div[contains(@class, 'authorization_popup__row')]//input[@value='Войти в систему']";
    private static final String headerProfile = "//*[@id='user-menu']//ul//li//a[contains(@class,'header__user-menu-item')]/span[contains(@class,'header__profile')]";
    private static final String formErrors = "//*[@id='login-form']//div[contains(@class, 'form-errors')]";

    @Test
    @DisplayName("Проверка корректной авторизации")
    void correctAuthorizationTest() {
        getDriver().findElement(By.id(signIn)).click();
        loginIn("mail-alexmailformusic@yandex.ru", "qwerty");

        getDriver().findElement(By.id(showUserMenu)).click();
        Assertions.assertEquals("ЛИЧНЫЙ КАБИНЕТ", getDriver().findElement(By.xpath(headerProfile)).getText());
        getDriver().findElement(By.xpath(headerProfile)).click();
        Assertions.assertEquals("Личный кабинет", getDriver().getTitle(), "Вход в личный кабинет неудачный");
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации")
    void incorrectAuthorizationTest() {
        getDriver().findElement(By.id(signIn)).click();
        loginIn("mail-alexmailformusic@yandex.ru", "qwerty123");

        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(formErrors), "Введите правильные почту и пароль"));
        Assertions.assertEquals("Введите правильные почту и пароль", getDriver().findElement(By.xpath(formErrors)).getText());
    }

    private void loginIn(String email, String password) {
        Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(getDriver().findElement(By.xpath(emailInput)), email)
                .click(getDriver().findElement(By.xpath(passwordInput)))
                .sendKeys(password)
                .click(getDriver().findElement(By.xpath(submitButton)))
                .build()
                .perform();
    }
}
