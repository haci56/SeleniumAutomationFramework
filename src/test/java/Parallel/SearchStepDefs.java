package Parallel;

import Factory.DriverFactory;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDefs {
    //private SearchPage SearchPage = new SearchPage(DriverFactory.getDriver());
    private SearchPage SearchPage = Pages.SearchPage.getSearchPageInstance(DriverFactory.getDriver());

    @Then("{string} is visible")
    public void isVisible(String expectedTitle) {
        SearchPage.verifyTumuIsVısıble(expectedTitle);
    }

    @Then("Verify Google logo is displayed On SearchPage")
    public void verifyGoogleLogoIsDisplayedOnSearchPage() {
        SearchPage.verifyGoogleLogoIsDisplayedOnSearchPage();
    }

    @And("Scroll to x {int} y {int}")
    public void scrollToXY(int x, int y) {
        SearchPage.scrollToXY(x,y);
    }

    @When("Scroll to Google Logo On bottom of the page")
    public void scrollToGoogleLogoOnBottomOfThePage() {
        SearchPage.scrollToBottomGoogleLogo();

    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int seconds) {
        SearchPage.sleep(seconds);
    }
}
