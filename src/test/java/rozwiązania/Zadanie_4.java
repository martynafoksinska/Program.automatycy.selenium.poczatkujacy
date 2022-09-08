package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie_4 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl");
        return driver;
    }

    @Test
    public void findElementByTagName() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        WebElement footer = driver.findElement(By.tagName("footer"));

        // Ad 4
        driver.quit();
    }
}
