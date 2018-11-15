package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.SetUp.driver;

public class GooglePage extends Page {

    @FindBy(id = "lst-ib")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@aria-label='Szczęśliwy traf']")
    private WebElement luckyShotSubmit;

    public void typeInSearchEngine(final String text) {
        searchInput.sendKeys(text);
    }

    public void clearSearchEngine() {
        searchInput.clear();
    }

    public void clickOnLuckyShot() {
        luckyShotSubmit.click();
    }

    public DoodlePage goToDoodlePage() {
        wait.until(ExpectedConditions.elementToBeClickable(luckyShotSubmit)).click();
        wait.until(driver -> driver.getCurrentUrl().equals("https://www.google.com/doodles"));
        return new DoodlePage();
    }

}
