package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_Navigation {

    @Test
    public void navigation() {

        WebDriver driver = new ChromeDriver();

        //Poniższa linia zmaksymalizuje okno przeglądarki. Odpowiada za to manage(), który omówimy sobie w dalszej części kursu
        driver.manage().window().maximize();

        //Przejdź do strony https://www.programautomatycy.pl
        driver.navigate().to("https://www.programautomatycy.pl");

        //Po uruchomieniu przeglądarki powinniśmy poczekać na konkretny obiekt, albo aż strona się w pełni załaduje
        //W poniższym przykładzie nie będziemy czekać, zajmiemy się tym później

        //Przejdź do innego adresu
        driver.navigate().to("https://programautomatycy.pl/contact/");

        //Wykonaj polecenie "wstecz" na przeglądarce
        driver.navigate().back();

        //Wykonaj polecenie "dalej" na przeglądarce
        driver.navigate().forward();

        //Odśwież bieżącą stronę
        driver.navigate().refresh();

        //Zamknij przeglądarkę
        driver.quit();
    }
}