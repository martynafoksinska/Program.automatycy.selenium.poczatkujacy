package seleniumWebdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class F_CheckElements {

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
        return driver;
    }

    @Test
    public void elementIsEnabled() {

        WebDriver driver = getDriver();

//        /** Wpisz imię */
//        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
//        System.out.println("Czy pierwsze imię jest edytowalne?: " + firstNameFieldById.isEnabled());
//
//        /** Wpisz imię */
//        WebElement secondNameFieldById = driver.findElement(By.id("secondname-text"));
//        System.out.println("Czy drugie imię jest edytowalne?: " + secondNameFieldById.isEnabled());
//
//        /** Nieedytowalny checkbox */
//        WebElement disabledCheckBoxById = driver.findElement(By.id("disabled-checkbox"));
//        System.out.println("Czy checkbox jest edytowalny?: " + disabledCheckBoxById.isEnabled());
//
//        /** Nieedytowalne pole tekstowe */
//        WebElement disabledTextFieldById = driver.findElement(By.id("disabled-text"));
//        System.out.println("Czy pole tekstowe jest edytowalne?: " + disabledTextFieldById.isEnabled());
//
//        System.out.println("#################################################");
//
//        /** Wpisz imię */
//        WebElement firstNameFieldByIdGetAttribute = driver.findElement(By.id("firstname-text"));
//        System.out.println("Pierwsze imię jest edytowalne: " + firstNameFieldByIdGetAttribute.getAttribute("disabled"));
//
//        /** Wpisz imię */
//        WebElement secondNameFieldByIdGetAttribute = driver.findElement(By.id("secondname-text"));
//        System.out.println("Drugie imię jest edytowalne: " + secondNameFieldByIdGetAttribute.getAttribute("disabled"));
//
//        /** Nieedytowalny checkbox */
//        WebElement disabledCheckBoxByIdGetAttribute = driver.findElement(By.id("disabled-checkbox"));
//        System.out.println("Checkbox jest edytowalny: " + disabledCheckBoxByIdGetAttribute.getAttribute("disabled"));
//
//        /** Nieedytowalne pole tekstowe */
//        WebElement disabledTextFieldByIdGetAttribute = driver.findElement(By.id("disabled-text"));
//        System.out.println("Pole tekstowe jest edytowalne: " + disabledTextFieldByIdGetAttribute.getAttribute("disabled"));

        WebElement bookTitleById = driver.findElement(By.id("book-text"));
        System.out.println("Czy pole tytuł książki jest edytowalne?: " + bookTitleById.isEnabled());

        driver.quit();
    }

    @Test
    public void elementIsDisplayed() {

        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200, 1));
//        /** Wpisz imię */
//        WebElement firstNameFieldById = driver.findElement(By.id("firstname-text"));
//        System.out.println("Imię jest wyświetlone na stronie: " + firstNameFieldById.isDisplayed());
//
//
//        /** Wpisz nazwisko */
//        WebElement lastNameFieldByName = driver.findElement(By.name("your-lastname"));
//        System.out.println("Nazwisko jest wyświetlone na stronie: " + lastNameFieldByName.isDisplayed());

        WebElement movieTitleFieldById = driver.findElement(By.id("movie-text"));
        System.out.println("Pole tytuł filmu jest wyświetlone na stronie: " + movieTitleFieldById.isDisplayed());

        driver.quit();
    }

    @Test
    public void elementIsSelected() {

        WebDriver driver = getDriver();

        // Poniższa linia akceptuje pobieranie ciasteczek
        // Możesz zakomentować tę część i nie godzić się na pobieranie ciasteczek, ale wtedy nie będą działały niektóre polecenia na stronie
        driver.findElement(By.id("cn-accept-cookie")).click();

        /** Wybierz opcję */
        WebElement optionRadioButtonsByClassName = driver.findElement(By.id("option-radio"));
        WebElement option1ByXpath = optionRadioButtonsByClassName.findElement(By.xpath("//input[@value='Opcja 1']"));
        option1ByXpath.click();
        System.out.println("###########################");

        System.out.println("Czy Opcja 1 jest wybrana?: " + option1ByXpath.isSelected());

        WebElement option2ByXpath = optionRadioButtonsByClassName.findElement(By.xpath("//input[@value='Opcja 2']"));
        System.out.println("Czy Opcja 2 jest wybrana?: " + option2ByXpath.isSelected());

        WebElement option3ByXpath = optionRadioButtonsByClassName.findElement(By.xpath("//input[@value='Opcja 3']"));
        System.out.println("Czy Opcja 3 jest wybrana?: " + option3ByXpath.isSelected());

        System.out.println("########################### - Pętla");
        List<WebElement> optionsRadioButtonsByClassName = driver.findElements(By.xpath("//*[@id='option-radio']//input"));

        for (WebElement option : optionsRadioButtonsByClassName) {
            System.out.println("Czy " + option.getAttribute("value") + " jest wybrana?: " + option.isSelected());
        }

        /** Wybierz ulubiony dzień tygodnia */
        WebElement dayDropBoxByXpath = driver.findElement(By.xpath("//*[@id='day-select']/option[2]"));
        dayDropBoxByXpath.click();
        System.out.println("###########################");
        System.out.println("Czy wybrany jest poniedziałek?: " + dayDropBoxByXpath.isSelected());

        /** Wybierz przeglądarkę */
        WebElement browserSelectOptionByXpath = driver.findElement(By.xpath("//*[@id='browser-select-multiple']/option[1]"));
        browserSelectOptionByXpath.click();
        System.out.println("###########################");
        System.out.println("Czy wybrany jest Google Chrome?: " + browserSelectOptionByXpath.isSelected());

        /** Zgadzam się z polityką prywatności - polityka prywatności */
        WebElement policyRadioButtonsByXpath = driver.findElement(By.xpath("//*[@id='wpcf7-f9259-p9257-o1']//input[@value='Tak']"));
        policyRadioButtonsByXpath.click();
        System.out.println("###########################");
        System.out.println("Czy wybrana jest odpowiedź 'Tak'?: " + policyRadioButtonsByXpath.isSelected());

        /** Zaznacz wszystkie pola z literą "C" */
        WebElement cLetterFirstCheckBoxById = driver.findElement(By.name("c1[]"));
        cLetterFirstCheckBoxById.click();
        WebElement cLetterSecondCheckBoxById = driver.findElement(By.name("c2[]"));
        cLetterSecondCheckBoxById.click();
        System.out.println("###########################");
        System.out.println("Czy pierwsza litera C jest zaznaczona?: " + cLetterFirstCheckBoxById.isSelected());
        System.out.println("Czy druga litera C jest zaznaczona?: " + cLetterSecondCheckBoxById.isSelected());

        /** Wybierz grupę */
        WebElement groupCheckboxByXpath = driver.findElement(By.xpath("//*[@id='group-checkbox']//*[@value='Grupa 2']"));
        groupCheckboxByXpath.click();
        System.out.println("###########################");
        System.out.println("Czy zaznaczona jest Grupa 2?: " + groupCheckboxByXpath.isSelected());

        //driver.quit();
    }

    @Test
    public void elementExists() {

        WebDriver driver = getDriver();

        /** Napisz coś */
        List<WebElement> descriptionTextByCss = driver.findElements(By.cssSelector("#description-text"));
        if (descriptionTextByCss.size() > 0) {
            System.out.println("Pole tekstowe istnieje");
        } else {
            System.out.println("Pole tekstowe nie istnieje");
        }

        // Nie istniejący element na stronie
        List<WebElement> fakeElementById = driver.findElements(By.id("nieznane"));
        if (fakeElementById.size() > 0) {
            System.out.println("Element istnieje");
        } else {
            System.out.println("Element nie istnieje");
        }

        driver.quit();
    }
}