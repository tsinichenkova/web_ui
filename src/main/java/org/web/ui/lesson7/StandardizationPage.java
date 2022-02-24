package org.web.ui.lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StandardizationPage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@class,'api-data-input__field')]")
    private WebElement input;

    @FindBy(xpath = "//section[contains(@class,'api-data-input')]/button")
    private WebElement buttonCheck;

    @FindBy(xpath = ".//*[@id='demo']//span[contains(@class, 'api-tabs__item') and normalize-space(.) = 'ФИО']")
    private WebElement tabsItemFullName;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Страна:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement country;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Индекс:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement index;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Фед. округ:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement federalDistrict;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'город:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement city;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Район:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement district;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'проезд:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement directions;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'дом:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement house;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'квартира:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement flat;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Фамилия:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement surname;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Имя:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement name;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Отчество:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement patronymic;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Пол:']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement gender;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Им. падеж (кто?):']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement nominativeCase;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Род. падеж (кого?):']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement genitiveCase;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Дат. падеж (кому?):']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement dativeCase;

    @FindBy(xpath = "//section[contains(@class, 'api-data-result')]//div[contains(@class,'api-data-result-info-item')]/p[normalize-space(.) = 'Твор. падеж (кем?):']/../div[contains(@class,'api-data-result-info-item__value')]")
    private WebElement instrumentalCase;

    public WebElement getCountry() {
        return country;
    }

    public WebElement getIndex() {
        return index;
    }

    public WebElement getFederalDistrict() {
        return federalDistrict;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getDistrict() {
        return district;
    }

    public WebElement getDirections() {
        return directions;
    }

    public WebElement getHouse() {
        return house;
    }

    public WebElement getFlat() {
        return flat;
    }

    public WebElement getSurname() {
        return surname;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPatronymic() {
        return patronymic;
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getNominativeCase() {
        return nominativeCase;
    }

    public WebElement getGenitiveCase() {
        return genitiveCase;
    }

    public WebElement getDativeCase() {
        return dativeCase;
    }

    public WebElement getInstrumentalCase() {
        return instrumentalCase;
    }

    public StandardizationPage(WebDriver driver) {
        super(driver);
    }

    public void fill(String text) {
        this.input.clear();
        this.input.sendKeys(text);
        this.buttonCheck.click();
    }

    public void fillFullName(String fullName) {
        this.tabsItemFullName.click();
        fill(fullName);
    }
}
