package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class K_iFrame {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page-in-iframe/");
        return driver;
    }

    @Test
    public void firstNameFieldInIframe() {

        WebDriver driver = getDriver();

        /** Wpisz imię */
        // Zlokalizuj formularz przy użyciu identyfikatora
        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
        firstNameFieldById.sendKeys("Jan");

//        driver.quit();
    }

    @Test
    public void lastNameFieldInIframe() {

        WebDriver driver = getDriver();

        // Należy wskazać sterownikowi, w jakim iframe znajdują się elementy strony zewnętrznej
        // W naszym przypadku będzie tylko jeden ale może być więcej. Zasada jest ta sama
        driver.switchTo().frame(0);

        /** Wpisz imię */
        // Zlokalizuj formularz przy użyciu identyfikatora
        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
        firstNameFieldById.sendKeys("Jan");

//        driver.quit();
    }
}
