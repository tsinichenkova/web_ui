package org.web.ui.lesson7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StandardizationTest extends TestBase {

    @Test
    @DisplayName("Проверка стандартизации по адресу")
    @Epic("Standardization")
    @Description("Стандартизация по адресу")
    @Link("https://dadata.ru")
    @Severity(SeverityLevel.BLOCKER)
    void standardizationAddressTest() {
        new MainPage(getDriver()).goToStandardizationPage();
        StandardizationPage standardization = new StandardizationPage(getDriver());
        standardization.fill("2-Y Donskoy Proyezd, 4 building 4, flat 64 Moskva");

        Assertions.assertEquals("Россия", standardization.getCountry().getText());
        Assertions.assertEquals("119071", standardization.getIndex().getText());
        Assertions.assertEquals("Центральный", standardization.getFederalDistrict().getText());
        Assertions.assertEquals("Москва", standardization.getCity().getText());
        Assertions.assertEquals("Донской", standardization.getDistrict().getText());
        Assertions.assertEquals("2-й Донской", standardization.getDirections().getText());
        Assertions.assertEquals("4 стр 4", standardization.getHouse().getText());
        Assertions.assertEquals("64", standardization.getFlat().getText());
    }

    @Test
    @DisplayName("Проверка стандартизации по ФИО")
    @Epic("Standardization")
    @Description("Стандартизация по фио")
    @Link("https://dadata.ru")
    @Severity(SeverityLevel.BLOCKER)
    void standardizationFullNameTest() {
        new MainPage(getDriver()).goToStandardizationPage();
        StandardizationPage standardization = new StandardizationPage(getDriver());
        standardization.fillFullName("Иванов иван иванович");

        Assertions.assertEquals("Иванов", standardization.getSurname().getText());
        Assertions.assertEquals("Иван", standardization.getName().getText());
        Assertions.assertEquals("Иванович", standardization.getPatronymic().getText());
        Assertions.assertEquals("мужской", standardization.getGender().getText());
        Assertions.assertEquals("Иванов Иван Иванович", standardization.getNominativeCase().getText());
        Assertions.assertEquals("Иванова Ивана Ивановича", standardization.getGenitiveCase().getText());
        Assertions.assertEquals("Иванову Ивану Ивановичу", standardization.getDativeCase().getText());
        Assertions.assertEquals("Ивановым Иваном Ивановичем", standardization.getInstrumentalCase().getText());
    }
}
