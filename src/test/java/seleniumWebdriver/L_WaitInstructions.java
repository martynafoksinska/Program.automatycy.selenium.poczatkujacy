package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class L_WaitInstructions {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    /**
     * Poniżej znajduje się czekanie (uśpienie WebDrivera) przez określony czas
     * Nie powinno się tego używać w projektach
     * Ma to tylko zastosowanie, jeśli chcemy na szybko coś sprawdzić i na jakiś czas zatrzymać test, potem powinno się to usunąć lub zastąpić inną metodą
     */
    @Test
    public void sleepWait() throws InterruptedException {

        WebDriver driver = getDriver();

        // Poniżej proste czekanie 5000 milisekund, czyli 5 sekund
        // To właśnie przez poniższą linię kodu trzeba dodać wyjątek "InterruptedException" przy nazwie naszej metody
        Thread.sleep(5000);

        // Kliknij na przycisk pojawiający się z opóźnieniem: 2 sekundy
        driver.findElement(By.id("delay-button")).click();

        //driver.quit();
    }

    /**
     * Lepszym rozwiązaniem, ale jeszcze nie idealnym jest ustawienie nadrzędnego czekania na element
     * Można ustawić w sterowniku ile czasu ma czekać za każdym razem, gdy chcemy odwołać się do jakiegoś elementu
     * Najlepiej nie przekraczać wartości 10 sekund
     */
    @Test
    public void implicitlyWaitTimeout() {

        WebDriver driver = getDriver();

        // W poniższym przykładzie zadeklarowano 5 sekund oczekiwania na element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Kliknij na przycisk pojawiający się z opóźnieniem: 2 sekundy
        driver.findElement(By.id("delay-button")).click();

        // Próba odszukania elementu który nie istnieje na stronie
        // Po 5 sekundach powinien pojawić się błąd
        driver.findElement(By.id("Element"));

        //driver.quit();
    }

    /**
     * Najlepszym rozwiązanie są oczekiwania jawne, czyli takie które jawnie określają, ile czasu mają czekać na konkretny element
     * Dodatkowo można także określić częstotliwość prób wyszukiwania danego elementu
     */
    @Test
    public void webDriverWaitTimeout() {

        WebDriver driver = getDriver();

        // Deklarujemy obiekt o nazwie wait za pomocą klasy WebDriverWait przypisując 5 sekund oczekiwania
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));

        // Możemy ustawić, jak często chcemy, aby WebDriver sprawdzał, czy nasz warunek jest spełniony
        wait.pollingEvery(Duration.ofMillis(250));

        // Do operowania na elemencie posłużymy się klasą ExpectedConditions, która jest bogata w różne metody
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("delay-button")))).click();

        // Czekamy na WebElement i dodatkowo możemy wykonać interakcję w postaci kliknięcia
        WebElement dayDropBoxByXpath = driver.findElement(By.xpath("//*[@id='day-select']/option[2]"));
        wait.until(ExpectedConditions.visibilityOf(dayDropBoxByXpath)).click();

        // Przykład czekania, dany element nie jest widoczny na stronie
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("password")));

        //driver.quit();
    }
}
