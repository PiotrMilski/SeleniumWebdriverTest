package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.SetUp.driver;

public abstract class Page {

    protected WebDriverWait wait;
    private final int SECONDS = 10;

    protected Page() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, SECONDS);
    }
}
