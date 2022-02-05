package org.web.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class App2
{
    private static WebDriver driver;
    private static final String menuButtonStandardization = "//div[contains(@class, 'header__menu-item')]/a[text()='Стандартизация']";
    private static final String input = "//input[@class='api-data-input__field']";
    private static final String buttonCheck = "//section[@class='api-data-input']/button";
    private static final String tabsItemFullName = ".//*[@id='demo']//span[contains(@class, 'api-tabs__item') and normalize-space(.) = 'ФИО']";

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

        driver.findElement(By.xpath(menuButtonStandardization)).click();
        driver.findElement(By.xpath(tabsItemFullName)).click();
        driver.findElement(By.xpath(input)).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        driver.findElement(By.xpath(input)).sendKeys("Иванов иван иванович");
        driver.findElement(By.xpath(buttonCheck)).click();
        driver.quit();
    }


}
