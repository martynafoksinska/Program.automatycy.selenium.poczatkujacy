package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class E_GetText {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void getTextFromElement() {

        WebDriver driver = getDriver();

        // Poniższa linia akceptuje pobieranie ciasteczek
        // Możesz zakomentować tę część i nie godzić się na pobieranie ciasteczek, ale wtedy nie będą działały niektóre polecenia na stronie
        driver.findElement(By.id("cn-accept-cookie")).click();

//        /** Wpisz imię */
//        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
//        firstNameFieldById.sendKeys("Jan");
//        System.out.println("###########################");
//        System.out.println("Imię (getText): " + firstNameFieldById.getText());
//        System.out.println("Imię (value): " + firstNameFieldById.getAttribute("value"));
//
//        /** Wpisz nazwisko */
//        WebElement lastNameFieldByName = driver.findElement(By.name("your-lastname"));
//        lastNameFieldByName.sendKeys("Kowalski");
//        System.out.println("###########################");
//        System.out.println("Nazwisko (getText): " + lastNameFieldByName.getText());
//        System.out.println("Nazwisko (value): " + lastNameFieldByName.getAttribute("value"));
//
//        /** Wybierz opcję */
//        WebElement option3ByXpath = driver.findElement(By.xpath("//input[@value='Opcja 3']"));
//        System.out.println("###########################");
//        System.out.println("Opcja (getText): " + option3ByXpath.getText());
//        System.out.println("Opcja (value): " + option3ByXpath.getAttribute("value"));
//
//        /** Wybierz ulubiony dzień tygodnia */
//        WebElement dayDropBoxByXpath = driver.findElement(By.xpath("//*[@id='day-select']/option[2]"));
//        System.out.println("###########################");
//        System.out.println("Dzień tygodnia (getText): " + dayDropBoxByXpath.getText());
//        System.out.println("Dzień tygodnia (value): " + dayDropBoxByXpath.getAttribute("value"));
//        System.out.println("Dzień tygodnia (innerText): " + dayDropBoxByXpath.getAttribute("innerText"));
//
//        List<WebElement> daysDropBoxByXpath = driver.findElements(By.xpath("//*[@id='day-select']/option"));
//        for (WebElement day:daysDropBoxByXpath){
//            System.out.println(day.getText());
//        }
//
//        /** Wybierz przeglądarkę */
//        WebElement browserSelectOptionByXpath = driver.findElement(By.xpath("//*[@id='browser-select-multiple']/option[1]"));
//        System.out.println("###########################");
//        System.out.println("Przeglądarka (getText): " + browserSelectOptionByXpath.getText());
//        System.out.println("Przeglądarka (value): " + browserSelectOptionByXpath.getAttribute("value"));
//        System.out.println("Przeglądarka (innerText): " + browserSelectOptionByXpath.getAttribute("innerText"));
//
//        List<WebElement> browsers = driver.findElements(By.xpath("//*[@id='browser-select-multiple']/option"));
//        for (WebElement browser:browsers){
//            System.out.println(browser.getText());
//        }
//
//        /** Napisz coś */
//        WebElement descriptionTextByCss = driver.findElement(By.cssSelector("#description-text"));
//        descriptionTextByCss.sendKeys("Selenium WebDriver");
//        System.out.println("###########################");
//        System.out.println("Opis (getText): " + descriptionTextByCss.getText());
//        System.out.println("Opis (value): " + descriptionTextByCss.getAttribute("value"));
//
//        /** link - polityka prywatności */
//        WebElement linkByXpath = driver.findElement(By.xpath("//*[text()='polityka prywatności']"));
//        System.out.println("Nazwa linku (getText): " + linkByXpath.getText());
//        System.out.println("Adres linku (value): " + linkByXpath.getAttribute("href"));
//
//        /** Zgadzam się z polityką prywatności - polityka prywatności */
//        WebElement policyRadioButtonsByXpath = driver.findElement(By.xpath("//*[@id='wpcf7-f9259-p9257-o1']//input[@value='Tak']"));
//        System.out.println("###########################");
//        System.out.println("Zgoda polityki prywatności (getText): " + policyRadioButtonsByXpath.getText());
//        System.out.println("Zgoda polityki prywatności (value): " + policyRadioButtonsByXpath.getAttribute("value"));
//
//        /** Zaznacz wszystkie pola z literą "C" */
//        WebElement cLetterFirstCheckBoxById = driver.findElement(By.name("c1[]"));
//        WebElement cLetterSecondCheckBoxById = driver.findElement(By.name("c2[]"));
//        System.out.println("###########################");
//        System.out.println("Pierwsza litera (getText): " + cLetterFirstCheckBoxById.getText());
//        System.out.println("Druga litera (value): " + cLetterSecondCheckBoxById.getAttribute("value"));
//
//        /** Wybierz grupę */
//        WebElement groupMultipleCheckBoxByXpath = driver.findElement(By.xpath("//*[@id='group-checkbox']/span[3]/input"));
//        System.out.println("###########################");
//        System.out.println("Grupa (getText): " + groupMultipleCheckBoxByXpath.getText());
//        System.out.println("Grupa (value): " + groupMultipleCheckBoxByXpath.getAttribute("value"));
//
//         /** Naciśnij przycisk - NIC NIE RÓB */
//        WebElement doNothingButtonById = driver.findElement(By.id("nothing-submit"));
//        System.out.println("###########################");
//        System.out.println("Przycisk (getText): " + doNothingButtonById.getText());
//        System.out.println("Przycisk (value): " + doNothingButtonById.getAttribute("value"));

        /**     Otwórz i zmaksymalizuj przeglądarkę Chrome
         Przejdź do strony https://programautomatycy.pl/test-page/
         Zlokalizuj opcję o wartości “Pies” w sekcji “Wybierz zwierzę” na formularzu testowym 2, dowolnym sposobem
         Pobierz i wydrukuj z wyszukanego elementu tekst “Pies” **/

        WebElement animalByXpath = driver.findElement(By.xpath("//*[@id='animal-select']/option[3]"));
        System.out.println("###########################");
        System.out.println("Zwierze (getText): " + animalByXpath.getText());
        System.out.println("Zwierze (value): " + animalByXpath.getAttribute("value"));
        System.out.println("Zwierze (innerText): " + animalByXpath.getAttribute("innerText"));

        List<WebElement> animal2ByXpath = driver.findElements(By.xpath("//*[@id='animal-select']"));
        for (WebElement animal:animal2ByXpath){
            System.out.println(animal.getText());
        }

        driver.quit();
    }
}