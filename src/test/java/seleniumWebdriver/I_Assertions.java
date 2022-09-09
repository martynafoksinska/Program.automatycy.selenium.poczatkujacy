package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

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
        driver.findElement(By.id("cn-accept-cookie")).click();

        WebElement someFieldByXpath = driver.findElement(By.xpath("//*[@id='text-text']"));
        Assert.assertTrue(someFieldByXpath.isDisplayed());

        Select multipleFieldColour = new Select(driver.findElement(By.id("colour-select-multiple")));
        multipleFieldColour.selectByValue("Czarny");
        Assert.assertEquals("Czarny", multipleFieldColour.getFirstSelectedOption().getText());

        WebElement number3 = driver.findElement(By.xpath("//span[@id='number-radio']")).findElement(By.xpath("//*[@value='3']"));

        number3.click();

        Assert.assertTrue(number3.isSelected());



//        /** Wpisz imię */
//        // Potwierdź, że wpisane imie zgadza się z wyświetlanym tekstem
//        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
//        firstNameFieldById.sendKeys("Jan");
//        Assert.assertEquals("Jan", firstNameFieldById.getAttribute("value"));
//
//        /** Wpisz nazwisko */
//        // Potwierdź, że pole z nazwiskiem jest edytowalne
//        WebElement lastNameFieldByName = driver.findElement(By.name("your-lastname"));
//        Assert.assertTrue(lastNameFieldByName.isEnabled());
//
//        /** Przycisk pojawiający się z opóźnieniem: 2 sekundy */
//        // Potwierdź, że przycisk pojawiający się z opóźnieniem jest niewidoczny na stronie
//        WebElement delayButtonById = driver.findElement(By.id("delay-button"));
//        Assert.assertFalse(delayButtonById.isDisplayed());
//
//        /** Nieedytowalny checkbox */
//        // Potwierdź, że atrybut "disabled" w obiekcie disabledCheckBoxById nie jest nulem
//        WebElement disabledCheckBoxById = driver.findElement(By.id("disabled-checkbox"));
//        Assert.assertNotNull(disabledCheckBoxById.getAttribute("disabled"));
//
//        //driver.quit();
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