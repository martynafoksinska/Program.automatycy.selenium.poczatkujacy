package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class G_SelectClass_SingleOption {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void selectSingleOptionByText() {

        WebDriver driver = getDriver();

        /** Wybierz ulubiony dzień tygodnia */
        // Tworzymy nowy obiekt Select o nazwie dayDropBoxByXpath
        // Musimy przekazać WebElement czyli: driver.findElement(By.xpath("//*[@id='day-select']")) jako parametr.
        Select dayDropBoxByXpath = new Select(driver.findElement(By.xpath("//*[@id='day-select']")));
        // Wybierz opcję za pomocą tekstu
        dayDropBoxByXpath.selectByVisibleText("Wtorek");
        // Wyświetl pierwszą widoczną opcję
        System.out.println(dayDropBoxByXpath.getFirstSelectedOption().getText());

        driver.quit();
    }

    @Test
    public void selectSingleOptionByValue() {

        WebDriver driver = getDriver();

        /** Wybierz ulubiony dzień tygodnia */
        Select dayDropBoxByXpath = new Select(driver.findElement(By.xpath("//*[@id='day-select']")));
        dayDropBoxByXpath.selectByValue("Wtorek");
        System.out.println(dayDropBoxByXpath.getFirstSelectedOption().getText());

        driver.quit();
    }

    @Test
    public void selectSingleOptionByIndex() {

        WebDriver driver = getDriver();

        /** Wybierz ulubiony dzień tygodnia */
        Select dayDropBoxByXpath = new Select(driver.findElement(By.xpath("//*[@id='day-select']")));
        dayDropBoxByXpath.selectByIndex(2);
        System.out.println(dayDropBoxByXpath.getFirstSelectedOption().getText());

        driver.quit();
    }
}