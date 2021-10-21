package Parallel;

import Factory.DriverFactory;
import Pages.GooglePage;
import Utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Properties;

public class GoogleStepdefs {
    private Properties properties = ApplicationHooks.getPropertiesInstance();
    private static String title;

    //private GooglePage GooglePage = new GooglePage(DriverFactory.getDriver());
    private GooglePage GooglePage = Pages.GooglePage.getGooglePageInstance(DriverFactory.getDriver());

    @Given("user open url")
    public void user_opens_url(){
        String appUrl = properties.getProperty("appUrl");
        DriverFactory.getDriver().get(appUrl);
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedPageTitle) {
        title = GooglePage.getGooglePageTitle();
       Assert.assertTrue(title.contains(expectedPageTitle));
    }

    @Then("Verify Google logo is displayed On GooglePage")
    public void verifyGoogleLogoIsDisplayedOngooglePage() {
        GooglePage.verifyGoogleLogoIsDisplayedOngooglePage();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchText) throws Exception {
        GooglePage.searchForText(searchText);
    }

    @And("I clicked {string}")
    public void iClicked(String clickedText) {
        GooglePage.clickSearchResult(clickedText);
    }
}
