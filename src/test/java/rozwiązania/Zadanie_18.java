package rozwiązania;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Zadanie_18 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void elementExists() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        List<WebElement> textField = driver.findElements(By.cssSelector("#text-text"));

        // Ad 4
        Assert.assertTrue(textField.size() > 0);

        // Ad 5
        Select colourSelect = new Select(driver.findElement(By.xpath("//*[@id='colour-select-multiple']")));

        // Ad 6
        colourSelect.selectByValue("Czarny");

        // Ad 7
        Assert.assertEquals("Czarny", colourSelect.getFirstSelectedOption().getText());

        // Ad 8
        WebElement number3 = driver.findElement(By.xpath("//span[@id='number-radio']")).findElement(By.xpath("//*[@value='3']"));

        // Ad 9
        number3.click();

        // Ad 10
        Assert.assertTrue(number3.isSelected());

        // Ad 11
        driver.quit();
    }
}
