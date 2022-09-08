package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class J_Screenshots {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void takeAScreenshot() throws IOException, InterruptedException {

        WebDriver driver = getDriver();

        Thread.sleep(3000);

        // Zaczynamy od stworzenia obiektu File. Jest to obiekt z biblioteki Java. Zasadniczo reprezentacja klasy pliku na dysku
        // Następnie „przesyłamy” nasz sterownik do „interfejsu” TakesScreenshot, który daje naszemu sterownikowi dostęp do metody getScreenshotAs()
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Plik został utworzony na naszym dysku, ale jeszcze nie znamy jego lokalizacji
        // Zrobimy kopię tego pliku i umieścimy go do wybranego folderu, wraz z nazwą kontekstową.
        // Podając ścieżkę musimy zastąpić pojedynczy \ na podwójny \\
        FileUtils.copyFile(scrFile, new File("D:\\ProgramAutomatycy\\Repozytorium\\program.automatycy.selenium.poczatkujacy\\screenshots\\screenshot.jpg"));

        // Tworzenie unikalnej nazwy dla zrzutu ekranu

        // Pobranie nazwy aktualnego testu/metody
        String testName = new Throwable() {}
                .getStackTrace()[0]
                .getMethodName();

        // Pobranie systemowej daty i godziny
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        Date date = new Date();
        String dateTime = dateFormat.format(date);

        // Poniżej metoda, która odwołuje się bezpośrednio do ścieżki naszego projektu i przypisuje unikalną nazwę
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + dateTime + "-" + testName + ".jpg"));

        driver.quit();
    }
}