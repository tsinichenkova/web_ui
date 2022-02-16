package org.web.ui.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SuggestionsTest extends TestBase{
    private static final String menuButtonSuggestions = "//div[contains(@class, 'header__menu-item')]/a[text()='Подсказки']";
    private static final String addressInput = "address-input";
    private static final String suggestion = "//div[contains(@class, 'suggestions-suggestions')]//span//strong";
    private static final String fullNameInput = "fullname-input";
    private static final String tabsItemFullName = "//ul[contains(@class, 'plaintabs__header')]//li[contains(@class, 'plaintabs__item')]/a[normalize-space(.) = 'ФИО']";
    private static final String index = "//input[@data-ref='postal_code']";
    private static final String region = "//input[@data-ref='region']";
    private static final String street = "//input[@data-ref='street']";
    private static final String house = "//input[@data-ref='house']";

    private static final String surname = "//input[@data-ref='surname']";
    private static final String name = "//input[@data-ref='name']";
    private static final String patronymic = "//input[@data-ref='patronymic']";
    private static final String gender = "//input[@data-ref='gender']";

    @Test
    @DisplayName("Проверка подсказок по адресу")
    void suggestionsAddressTest() {
        getDriver().findElement(By.xpath(menuButtonSuggestions)).click();
        getDriver().findElement(By.id(addressInput)).sendKeys("г Москва, ул Арбат, д 50");
        getDriver().findElement(By.xpath(suggestion)).click();

        Assertions.assertEquals("119002", getDriver().findElement(By.xpath(index)).getAttribute("value"));
        Assertions.assertEquals("г Москва", getDriver().findElement(By.xpath(region)).getAttribute("value"));
        Assertions.assertEquals("ул Арбат", getDriver().findElement(By.xpath(street)).getAttribute("value"));
        Assertions.assertEquals("д 50", getDriver().findElement(By.xpath(house)).getAttribute("value"));
    }

    @Test
    @DisplayName("Проверка подсказок по ФИО")
    void standardizationFullNameTest() {
        getDriver().findElement(By.xpath(menuButtonSuggestions)).click();
        getDriver().findElement(By.xpath(tabsItemFullName)).click();
        getDriver().findElement(By.id(fullNameInput)).sendKeys("иванов иван иванович");
        getDriver().findElement(By.xpath(suggestion)).click();

        Assertions.assertEquals("Иванов", getDriver().findElement(By.xpath(surname)).getAttribute("value"));
        Assertions.assertEquals("Иван", getDriver().findElement(By.xpath(name)).getAttribute("value"));
        Assertions.assertEquals("Иванович", getDriver().findElement(By.xpath(patronymic)).getAttribute("value"));
        Assertions.assertEquals("♂ мужской", getDriver().findElement(By.xpath(gender)).getAttribute("value"));
    }
}
