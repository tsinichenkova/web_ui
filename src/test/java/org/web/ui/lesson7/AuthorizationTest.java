package org.web.ui.lesson7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AuthorizationTest extends TestBase {

    @Test
    @Epic("Authorization")
    @DisplayName("Проверка корректной авторизации")
    @Description("Корректная авторизация на сайте")
    @Link("https://dadata.ru")
    @Severity(SeverityLevel.BLOCKER)
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
    @Epic("Authorization")
    @DisplayName("Проверка неуспешной авторизации")
    @Description("Ошибка авторизации на сайте")
    @Link("https://dadata.ru")
    @Severity(SeverityLevel.CRITICAL)
    void incorrectAuthorizationTest() throws IOException {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginIn("mail-alexmailformusic@yandex.ru", "qwerty2");

        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='login-form']//div[contains(@class, 'form-errors')]"), "Введите правильные почту и пароль"));
        Assertions.assertEquals("Введите правильные почту и пароль", loginPage.getFormErrors().getText());
        File file = MyUtils.makeScreenshot(getDriver(),"org.web.ui.lesson7.AuthorizationTest.incorrectAuthorizationTest" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
