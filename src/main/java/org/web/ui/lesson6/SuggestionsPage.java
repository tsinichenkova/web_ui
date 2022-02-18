package org.web.ui.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuggestionsPage extends AbstractPage{

    @FindBy(id = "address-input")
    private WebElement addressInput;

    @FindBy(xpath = "//div[contains(@class, 'suggestions-suggestions')]//span//strong")
    private WebElement suggestion;

    @FindBy(id = "fullname-input")
    private WebElement fullNameInput;

    @FindBy(xpath = "//ul[contains(@class, 'plaintabs__header')]//li[contains(@class, 'plaintabs__item')]/a[normalize-space(.) = 'ФИО']")
    private WebElement tabsItemFullName;

    @FindBy(xpath = "//input[@data-ref='postal_code']")
    private WebElement index;

    @FindBy(xpath = "//input[@data-ref='region']")
    private WebElement region;

    @FindBy(xpath = "//input[@data-ref='street']")
    private WebElement street;

    @FindBy(xpath = "//input[@data-ref='house']")
    private WebElement house;

    @FindBy(xpath = "//input[@data-ref='surname']")
    private WebElement surname;

    @FindBy(xpath = "//input[@data-ref='name']")
    private WebElement name;

    @FindBy(xpath = "//input[@data-ref='patronymic']")
    private WebElement patronymic;

    @FindBy(xpath = "//input[@data-ref='gender']")
    private WebElement gender;

    public WebElement getIndex() {
        return index;
    }

    public WebElement getRegion() {
        return region;
    }

    public WebElement getStreet() {
        return street;
    }

    public WebElement getHouse() {
        return house;
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

    public SuggestionsPage(WebDriver driver) {
        super(driver);
    }

    public void fillAddress(String address) {
        this.addressInput.sendKeys(address);
        this.suggestion.click();
    }

    public void fillFullName(String fullName) {
        this.tabsItemFullName.click();
        this.fullNameInput.sendKeys(fullName);
        this.suggestion.click();
    }
}
