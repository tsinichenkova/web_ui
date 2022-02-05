package org.web.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class App4
{
    private static WebDriver driver;
    private static final String menuButtonSuggestions = "//div[contains(@class, 'header__menu-item')]/a[text()='Подсказки']";
    private static final String input = ".//*[@id='fullname-input']";
    private static final String suggestion = "//div[@id='name-vue-app']//div[contains(@class, 'suggestions-suggestions')]//span//strong";
    private static final String tabsItemFullName = ".//ul[contains(@class, 'plaintabs__header')]//li[contains(@class, 'plaintabs__item')]/a[normalize-space(.) = 'ФИО']";

    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://dadata.ru");

        driver.findElement(By.xpath(menuButtonSuggestions)).click();
        driver.findElement(By.xpath(tabsItemFullName)).click();
        driver.findElement(By.xpath(input)).sendKeys("иванов иван иванович");
        driver.findElement(By.xpath(suggestion)).click();
        driver.quit();
    }


}
