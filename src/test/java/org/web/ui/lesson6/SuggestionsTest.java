package org.web.ui.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.web.ui.lesson5.TestBase;

public class SuggestionsTest extends TestBase {

    @Test
    @DisplayName("Проверка подсказок по адресу")
    void suggestionsAddressTest() {
        new MainPage(getDriver()).goToSuggestionsPage();
        SuggestionsPage suggestions = new SuggestionsPage(getDriver());
        suggestions.fillAddress("г Москва, ул Арбат, д 50");

        Assertions.assertEquals("119002", suggestions.getIndex().getAttribute("value"));
        Assertions.assertEquals("г Москва", suggestions.getRegion().getAttribute("value"));
        Assertions.assertEquals("ул Арбат", suggestions.getStreet().getAttribute("value"));
        Assertions.assertEquals("д 50", suggestions.getHouse().getAttribute("value"));
    }

    @Test
    @DisplayName("Проверка подсказок по ФИО")
    void suggestionsFullNameTest() {
        new MainPage(getDriver()).goToSuggestionsPage();
        SuggestionsPage suggestions = new SuggestionsPage(getDriver());
        suggestions.fillFullName("иванов иван иванович");

        Assertions.assertEquals("Иванов", suggestions.getSurname().getAttribute("value"));
        Assertions.assertEquals("Иван", suggestions.getName().getAttribute("value"));
        Assertions.assertEquals("Иванович", suggestions.getPatronymic().getAttribute("value"));
        Assertions.assertEquals("♂ мужской", suggestions.getGender().getAttribute("value"));
    }
}
