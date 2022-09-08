package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie_11 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void getText() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        WebElement dog = driver.findElement(By.id("animal-select")).findElement(By.xpath("//option[@value='Pies']"));

        // Ad 4
        System.out.println(dog.getText());

        // Ad 5
        driver.quit();
    }
}
