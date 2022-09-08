package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie_5 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void findElementByCssSelector() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        WebElement coloursFullClassName = driver.findElement(By.cssSelector("select[class='wpcf7-form-control wpcf7-select colour']"));

        // Ad 4
        WebElement coloursClassName = driver.findElement(By.cssSelector(".colour"));

        // Ad 5
        WebElement coloursId = driver.findElement(By.cssSelector("#colour-select-multiple"));

        // Ad 6
        driver.quit();
    }
}
