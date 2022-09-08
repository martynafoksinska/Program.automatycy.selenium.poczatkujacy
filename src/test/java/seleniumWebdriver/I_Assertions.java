package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;

public class I_Assertions {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void assertOptionsPassed() {

        WebDriver driver = getDriver();

        /** Wpisz imię */
        // Potwierdź, że wpisane imie zgadza się z wyświetlanym tekstem
        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
        firstNameFieldById.sendKeys("Jan");
        Assert.assertEquals("Jan", firstNameFieldById.getAttribute("value"));

        /** Wpisz nazwisko */
        // Potwierdź, że pole z nazwiskiem jest edytowalne
        WebElement lastNameFieldByName = driver.findElement(By.name("your-lastname"));
        Assert.assertTrue(lastNameFieldByName.isEnabled());

        /** Przycisk pojawiający się z opóźnieniem: 2 sekundy */
        // Potwierdź, że przycisk pojawiający się z opóźnieniem jest niewidoczny na stronie
        WebElement delayButtonById = driver.findElement(By.id("delay-button"));
        Assert.assertFalse(delayButtonById.isDisplayed());

        /** Nieedytowalny checkbox */
        // Potwierdź, że atrybut "disabled" w obiekcie disabledCheckBoxById nie jest nulem
        WebElement disabledCheckBoxById = driver.findElement(By.id("disabled-checkbox"));
        Assert.assertNotNull(disabledCheckBoxById.getAttribute("disabled"));

        //driver.quit();
    }

    @Test
    public void assertOptionsFailed() {

        WebDriver driver = getDriver();

        /** Wpisz imię */
        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
        firstNameFieldById.sendKeys("Jan");
        Assert.assertEquals("John", firstNameFieldById.getAttribute("value"));

        driver.quit();
    }
}