package org.web.ui.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class StandardizationTest extends TestBase {

    private static final String menuButtonStandardization = "//div[contains(@class, 'header__menu-item')]/a[text()='Стандартизация']";
    private static final String input = "//input[contains(@class,'api-data-input__field')]";
    private static final String buttonCheck = "//section[contains(@class,'api-data-input')]/button";
    private static final String tabsItemFullName = ".//*[@id='demo']//span[contains(@class, 'api-tabs__item') and normalize-space(.) = 'ФИО']";
    private static final String country = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Страна:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String index = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Индекс:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String federalDistrict = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Фед. округ:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String city = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'город:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String district = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Район:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String directions = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'проезд:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String house = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'дом:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String flat = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'квартира:']/../div[contains(@class,'api-data-result-info-item__value')]";

    private static final String surname = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Фамилия:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String name = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Имя:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String patronymic = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Отчество:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String gender = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Пол:']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String nominativeCase = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Им. падеж (кто?):']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String genitiveCase = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Род. падеж (кого?):']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String dativeCase = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Дат. падеж (кому?):']/../div[contains(@class,'api-data-result-info-item__value')]";
    private static final String instrumentalCase = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Твор. падеж (кем?):']/../div[contains(@class,'api-data-result-info-item__value')]";

    @Test
    @DisplayName("Проверка стандартизации по адресу")
    void standardizationAddressTest() {
        getDriver().findElement(By.xpath(menuButtonStandardization)).click();
        getDriver().findElement(By.xpath(input)).clear();
        getDriver().findElement(By.xpath(input)).sendKeys("2-Y Donskoy Proyezd, 4 building 4, flat 64 Moskva");
        getDriver().findElement(By.xpath(buttonCheck)).click();

        Assertions.assertEquals("Россия", getDriver().findElement(By.xpath(country)).getText());
        Assertions.assertEquals("119071", getDriver().findElement(By.xpath(index)).getText());
        Assertions.assertEquals("Центральный", getDriver().findElement(By.xpath(federalDistrict)).getText());
        Assertions.assertEquals("Москва", getDriver().findElement(By.xpath(city)).getText());
        Assertions.assertEquals("Донской", getDriver().findElement(By.xpath(district)).getText());
        Assertions.assertEquals("2-й Донской", getDriver().findElement(By.xpath(directions)).getText());
        Assertions.assertEquals("4 стр 4", getDriver().findElement(By.xpath(house)).getText());
        Assertions.assertEquals("64", getDriver().findElement(By.xpath(flat)).getText());
    }

    @Test
    @DisplayName("Проверка стандартизации по ФИО")
    void standardizationFullNameTest() {
        getDriver().findElement(By.xpath(menuButtonStandardization)).click();
        getDriver().findElement(By.xpath(tabsItemFullName)).click();
        getDriver().findElement(By.xpath(input)).clear();
        getDriver().findElement(By.xpath(input)).sendKeys("Иванов иван иванович");
        getDriver().findElement(By.xpath(buttonCheck)).click();

        Assertions.assertEquals("Иванов", getDriver().findElement(By.xpath(surname)).getText());
        Assertions.assertEquals("Иван", getDriver().findElement(By.xpath(name)).getText());
        Assertions.assertEquals("Иванович", getDriver().findElement(By.xpath(patronymic)).getText());
        Assertions.assertEquals("мужской", getDriver().findElement(By.xpath(gender)).getText());
        Assertions.assertEquals("Иванов Иван Иванович", getDriver().findElement(By.xpath(nominativeCase)).getText());
        Assertions.assertEquals("Иванова Ивана Ивановича", getDriver().findElement(By.xpath(genitiveCase)).getText());
        Assertions.assertEquals("Иванову Ивану Ивановичу", getDriver().findElement(By.xpath(dativeCase)).getText());
        Assertions.assertEquals("Ивановым Иваном Ивановичем", getDriver().findElement(By.xpath(instrumentalCase)).getText());
    }
}
