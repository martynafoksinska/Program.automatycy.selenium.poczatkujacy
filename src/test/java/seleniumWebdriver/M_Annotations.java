package seleniumWebdriver;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class M_Annotations {

    public WebDriver driver;
    public String testName;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Ta metoda będzie wywołana raz, przed wszystkimi testami");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Ta metoda będzie wywołana raz, po wszystkich testach");
    }

    @Before
    public void setUp() {
        System.out.println("Ta metoda będzie wywołana przed każdym testem");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://programautomatycy.pl/test-page/");
    }

    @After
    public void tearDown() throws IOException {
        System.out.println("Ta metoda będzie wywołana po każdym teście");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        Date date = new Date();
        String dateTime = dateFormat.format(date);

        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + testName + "\\" + dateTime + ".jpg"));

        driver.quit();
    }

    @Test
    public void someTest() {

        testName = new Throwable() {}
        .getStackTrace()[0]
        .getMethodName();

        System.out.println("Ta metoda wykona się po metodzie z adnotacją @Before i przed @After, w tym przypadku będzie w samym środku");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname-text"))).sendKeys("Jan");
    }
}