package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class A_Drivers {

    /**
     * Uruchom poniższy test. Nazwa metody powinna pojawić się w górnym pasku w polu rozwijanym"
     * W odpowiedzi otrzymasz błąd, ponieważ nie masz wpisanej ścieżki do drivera
     * Wybierz w polu rozwijanym opcję "Edit Configurations..."
     * W polu "VM options:" wpisz ścieżkę do drivera, w moim przypadku jest to: -Dwebdriver.chrome.driver=D:\ProgramAutomatycy\Repozytorium\webdrivers\chromedriver.exe
     * Pamiętaj aby na początku umieścić -D tak jak jest w przykładzie. W taki sposób deklaruje się zmienne w opcjach wirtualnej maszyny (VM options)
     */

    @Test
    public void chromeDriverOnPath() {
        // Poniższa linia utworzy nową instancję sterownika ChromeDriver.
        WebDriver driver = new ChromeDriver();
        // Poniższa linia zamnknie przeglądarkę oraz sterownik.
        driver.quit();
    }

    /**
     * W poniższym teście zmień ścieżkę geckodrivera na swoją (podana jest tylko ścieżka przykładowa)
     * Uruchom poniższy test. Nazwa metody pojawiła się w górnym pasku w polu rozwijanym"
     * Przeglądarka firefox powinna się otworzyć, a następnie zamknąć bez błędów (pod warunkiem, że ścieżka do sterownika jest prawidłowa)
     */

    @Test
    public void chromeDriverUsingSystemProperty() {
        //Podmień ścieżkę sterownika w poniższej linii bazując na przykładzie
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

    /**
     * Zachowanie pozostałych przeglądarek będzie identyczne
     * Wykonaj te same czynności dla reszty przeglądarek wymienionych poniżej
     */

    @Test
    public void firefoxGeckoDriverOnPath() {
        WebDriver driver = new FirefoxDriver();
        driver.quit();
    }

    @Test
    public void firefoxGeckoDriverUsingSystemProperty() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.quit();
    }

    @Test
    public void edgeMsedgeDriverOnPath() {
        WebDriver driver = new EdgeDriver();
        driver.quit();
    }

    @Test
    public void edgeMsedgeDriverUsingSystemProperty() {
        System.setProperty("webdriver.edge.driver", "D:/ProgramAutomatycy/Repozytorium/webdrivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.quit();
    }

    @Test
    public void ieDriverServerOnPath() {
        WebDriver driver = new InternetExplorerDriver();
        driver.quit();
    }

    @Test
    public void ieDriverServerUsingSystemProperty() {
        System.setProperty("webdriver.ie.driver", "D:/ProgramAutomatycy/Repozytorium/webdrivers/IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.quit();
    }

    /**
     * Przeglądarka Safari jest wspierana tylko na komputerach MAC z systemem Mac OS
     * Jeśli pracujesz na komputerze MAC, wtedy nie jest potrzebny sterownik do Safari
     * Sterownik jest już przygotowany w systemie, trzeba wykonać tylko kilka czynności, żeby można było go użyć
     * Strona z instrukcją: https://developer.apple.com/documentation/webkit/testing_with_webdriver_in_safari
     */

    public void safariDriver() {
        WebDriver driver = new SafariDriver();
        driver.quit();
    }

    /**
     * Istnieje biblioteka o nazwie WebDriverManager, której możesz użyć, która wykona za Ciebie wszystkie funkcje setProperty.
     * Znajdziesz ją tutaj - https://github.com/bonigarcia/webdrivermanager
     * Ale ważne jest, aby zrozumieć jak to działa, żeby nie polegać tylko na bibliotekach.
     */
}