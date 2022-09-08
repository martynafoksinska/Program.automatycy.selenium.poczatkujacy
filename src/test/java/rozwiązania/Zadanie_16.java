package rozwiązania;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadanie_16 {

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
        Select dayDropBoxByXpath = new Select(driver.findElement(By.xpath("//*[@id='colour-select-multiple']")));

        // Ad 4
        dayDropBoxByXpath.selectByValue("Czarny");

        // Ad 5
        System.out.println(dayDropBoxByXpath.getFirstSelectedOption().getText());

        // Ad 6
        driver.quit();
    }
}
