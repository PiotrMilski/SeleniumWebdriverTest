package tests;

import core.SetUp;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GooglePage;

public class GooglePageTest extends SetUp {

    private GooglePage googlePage;

    @BeforeClass
    private void runTest() {
        googlePage = openGooglePage();
    }

    @Test
    private void shouldTypeInGoogle() {
        googlePage.typeInSearchEngine("Co nowego u Morawieckiego?");
        czekaj(2);
        googlePage.clearSearchEngine();
        czekaj(2);
    }
    /*
    @Test (dependsOnMethods = "shouldTypeInGoogle")
    private void shouldSubmitLuckyShot() {
        googlePage.clickOnLuckyShot();
        czekaj(2);
    }
    */
    @Test (dependsOnMethods = "shouldTypeInGoogle")
    private void shouldLoadLuckyShot() {
        googlePage.goToDoodlePage();
    }


}
