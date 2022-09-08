package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class D_Interactions {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void enterTextIntoTheElement() {

        WebDriver driver = getDriver();

        /** Wpisz imię */
        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
        firstNameFieldById.sendKeys("Jan");
        WebElement secondNameFieldById = driver.findElement(By.id("secondname-text"));
        secondNameFieldById.sendKeys("Piotr");

        driver.findElement(By.id("firstname-text")).clear();
        driver.findElement(By.id("firstname-text")).sendKeys("Wojtek");

        /** Wpisz nazwisko */
        WebElement lastNameFieldByName = driver.findElement(By.name("your-lastname"));
        lastNameFieldByName.sendKeys("Kowalski");

        /** Napisz coś */
        WebElement descriptionTextByCss = driver.findElement(By.cssSelector("#description-text"));
        descriptionTextByCss.sendKeys("Selenium WebDriver Java dla początkujących");

        //driver.quit();
    }

    @Test
    public void clickOnElement() {

        WebDriver driver = getDriver();

        // Poniższa linia akceptuje pobieranie ciasteczek
        // Możesz zakomentować tę część i nie godzić się na pobieranie ciasteczek, ale wtedy nie będą działały niektóre polecenia na stronie
        driver.findElement(By.id("cn-accept-cookie")).click();

        /** Wybierz opcję */
        WebElement optionByXpath = driver.findElement(By.xpath("//input[@value='Opcja 3']"));
        optionByXpath.click();

        /** Wybierz ulubiony dzień tygodnia */
        WebElement dayDropBoxByXpath = driver.findElement(By.xpath("//*[@id='day-select']")).findElement(By.xpath("//*[@value='Poniedziałek']"));
        dayDropBoxByXpath.click();

        /** Wybierz przeglądarkę */
        WebElement browserSelectOptionByXpath = driver.findElement(By.xpath("//*[@id='browser-select-multiple']")).findElement(By.xpath("//*[@value='Google Chrome']"));
        browserSelectOptionByXpath.click();

        /** link - polityka prywatności */
        WebElement linkByXpath = driver.findElement(By.xpath("//*[text()='polityka prywatności']"));
        linkByXpath.click();

        // Wróc do poprzedniej strony
        driver.navigate().back();

        /** Zgadzam się z polityką prywatności - polityka prywatności */
        WebElement policyRadioButtonsByXpath = driver.findElement(By.xpath("//*[@id='wpcf7-f9259-p9257-o1']//input[@value='Tak']"));
        policyRadioButtonsByXpath.click();

        /** Zaznacz wszystkie pola z literą "C" */
//        WebElement cLetterFirstCheckBoxById = driver.findElement(By.name("c1[]"));
//        cLetterFirstCheckBoxById.click();
//        WebElement cLetterSecondCheckBoxById = driver.findElement(By.name("c2[]"));
//        cLetterSecondCheckBoxById.click();

        /** Zaznacz wszystkie pola z literą "C" - Zastosowanie masowego szukania elementów oraz zaznaczenie elementów w pętli */
        List<WebElement> cLettersCheckBoxByXpath = driver.findElements(By.xpath("//input[@type='checkbox' and @value='C']"));
        for (WebElement cLetter:cLettersCheckBoxByXpath){
            cLetter.click();
        }
//        for (int i = 0; i < cLettersCheckBoxByXpath.size(); i++){
//            cLettersCheckBoxByXpath.get(i).click();
//        }

        /** Wybierz grupę */
        WebElement groupMultipleCheckBoxByXpath = driver.findElement(By.xpath("//*[@id='group-checkbox']/span[3]/input"));
        groupMultipleCheckBoxByXpath.click();

        /** Naciśnij przycisk - NIC NIE RÓB */
        WebElement doNothingButtonById = driver.findElement(By.id("nothing-submit"));
        doNothingButtonById.click();

        //driver.quit();
    }

    /**
     * WebDriver obsługuje i pobiera informacje bezpośrednio z przeglądarki
     * Poniżej kilka przykładów jak można korzystać z dodatkowych opcji
     */

    @Test
    public void driverInteractions() {

        WebDriver driver = getDriver();

        System.out.println("###########################");

        // Pobierz i wyświetl adres URL strony.
        System.out.println(driver.getCurrentUrl());

        System.out.println("###########################");

        // Pobierz i wyświetl tytuł strony / tytuł karty
        System.out.println(driver.getTitle());

        System.out.println("###########################");

        // Pobierz i wyświetl źródło kodu całej strony
        System.out.println(driver.getPageSource());

        driver.quit();
    }

}
