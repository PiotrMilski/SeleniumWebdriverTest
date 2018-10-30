package core;

import dataproviders.AppUrl;
import dataproviders.GooglePageTestData;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.GooglePage;

import static dataproviders.AppUrl.GOOGLE_URL;

public class SetUp {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private final int SECONDS = 10;


    @BeforeSuite
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, SECONDS);
        //driver.manage().window().maximize();
    }

    public GooglePage openGooglePage() {
        driver.get(GOOGLE_URL);
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo(GOOGLE_URL);
        return new GooglePage();
    }

    public void czekaj(int seconds) {
        try {
            seconds = seconds * 1000;
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
