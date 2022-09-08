package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Zadanie_17 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void selectSingleOptionByValue() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        Select colourSelect = new Select(driver.findElement(By.xpath("//*[@id='colour-select-multiple']")));

        // Ad 4
        colourSelect.selectByValue("Czarny");

        // Ad 5
        colourSelect.selectByVisibleText("Zielony");

        // Ad 6
        colourSelect.selectByIndex(1);

        // Ad 7
        List<WebElement> colours = colourSelect.getAllSelectedOptions();
        for (WebElement colour : colours) {
            System.out.println(colour.getText());
        }

        // Ad 8
        driver.quit();
    }
}
