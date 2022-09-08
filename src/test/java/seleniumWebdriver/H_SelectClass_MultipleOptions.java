package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class H_SelectClass_MultipleOptions {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void isMultiple() {

        WebDriver driver = getDriver();

        /** Wybierz ulubiony dzień tygodnia */
        Select dayDropBoxByXpath = new Select(driver.findElement(By.xpath("//*[@id='day-select']")));
        // Sprawdzamy czy pole wyboru dnia tygodnia jest wielokrotnego wyboru
        // Zobaczymy tutaj false
        System.out.println("Dzień tygodnia - pole wielokrotnego wyboru: " + dayDropBoxByXpath.isMultiple());

        /** Wybierz przeglądarkę */
        Select browserSelectOptionByXpath = new Select(driver.findElement(By.xpath("//*[@id='browser-select-multiple']")));
        // Sprawdzamy czy pole wyboru przeglądarek jest wielokrotnego wyboru
        // Zobaczymy tutaj true
        System.out.println("Przeglądarka - pole wielokrotnego wyboru: " + browserSelectOptionByXpath.isMultiple());

        driver.quit();
    }

    @Test
    public void selectMultipleOptions() {

        WebDriver driver = getDriver();

        Select browserMultipleField = new Select(driver.findElement(By.id("browser-select-multiple")));

        // Wybieramy dwie opcje
        browserMultipleField.selectByVisibleText("Google Chrome");
        browserMultipleField.selectByVisibleText("Mozilla Firefox");

        // Pobieramy wszystkie zaznaczone przeglądarki
        List<WebElement> browsers = browserMultipleField.getAllSelectedOptions();

        // Wyświetl w pętli wybrane przeglądarki
        for (WebElement browser : browsers) {
            System.out.println(browser.getText());
        }

        driver.quit();
    }

    @Test
    public void selectMultipleOptionsAndDeselectSome() {

        WebDriver driver = getDriver();

        Select browserMultipleField = new Select(driver.findElement(By.id("browser-select-multiple")));

        // Wybierz opcję, używając widocznego tekstu
        browserMultipleField.selectByVisibleText("Google Chrome");
        browserMultipleField.selectByVisibleText("Microsoft Edge");

        // Wybierz opcję, używając jej wartości
        browserMultipleField.selectByValue("Opera");
        browserMultipleField.selectByValue("Internet Explorer");

        // Wyświetl w pętli wybrane przeglądarki
        List<WebElement> browsers = browserMultipleField.getAllSelectedOptions();
        for (WebElement browser : browsers) {
            System.out.println(browser.getText());
        }

        System.out.println("####################");

        // Odznacz opcję, używając widocznego tekstu
        browserMultipleField.deselectByVisibleText("Opera");
        // Odznacz opcję, używając wartości
        browserMultipleField.deselectByValue("Google Chrome");

        // Wyświetl w pętli pozostałe przeglądarki
        browsers = browserMultipleField.getAllSelectedOptions();
        for (WebElement browser : browsers) {
            System.out.println(browser.getText());
        }

        driver.quit();
    }
}