package org.web.ui.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.web.ui.lesson5.TestBase;

public class AuthorizationTest extends TestBase {

    @Test
    @DisplayName("Проверка корректной авторизации")
    void correctAuthorizationTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.goToLoginPage();
        new LoginPage(getDriver()).loginIn("mail-alexmailformusic@yandex.ru", "qwerty");
        mainPage.clickUserMenu();
        Assertions.assertEquals("ЛИЧНЫЙ КАБИНЕТ", mainPage.getProfile().getText());
        mainPage.goToProfilePage();
        Assertions.assertEquals("Личный кабинет", getDriver().getTitle(), "Вход в личный кабинет неудачный");
    }

    @Test
    @DisplayName("Проверка неуспешной авторизации")
    void incorrectAuthorizationTest() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginIn("mail-alexmailformusic@yandex.ru", "qwerty2");

        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='login-form']//div[contains(@class, 'form-errors')]"), "Введите правильные почту и пароль"));
        Assertions.assertEquals("Введите правильные почту и пароль", loginPage.getFormErrors().getText());
    }
}
