package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie_8 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void enterTextIntoTheElement() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        WebElement bookTitle = driver.findElement(By.id("book-text"));

        // Ad 4
        bookTitle.sendKeys("Wiedźmin");

        // Ad 5
        WebElement movieTitle = driver.findElement(By.name("your-movie"));

        // Ad 6
        movieTitle.sendKeys("Nietykalni");

        // Ad 7 test page
    }
}
