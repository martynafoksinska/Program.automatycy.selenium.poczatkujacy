package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie_9 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void clickOnElement() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        WebElement number3 = driver.findElement(By.xpath("//span[@id='number-radio']")).findElement(By.xpath("//*[@value='3']"));

        // Ad 4
        number3.click();

        // Ad 5
        WebElement greenColour = driver.findElement(By.xpath("//select[@id='colour-select-multiple']")).findElement(By.xpath("//*[@value='Zielony']"));

        // Ad 6
        greenColour.click();

        // Ad 7 test page
    }
}
