package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie_10 {

    public WebDriver getDriver() {

        // Ad 1
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Ad 2
        driver.navigate().to("https://programautomatycy.pl/courses");
        return driver;
    }

    @Test
    public void getPageTitle() {

        // Ad 1 & 2
        WebDriver driver = getDriver();

        // Ad 3
        System.out.println(driver.getTitle());

        // Ad 4
        driver.quit();
    }
}
