package Pages;

import Utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private static SearchPage searchPage;
    private Utils utils;

    private By Tumu = By.cssSelector("div.hdtb-mitem.hdtb-msel");
    private By SearchGoogleLogo = By.cssSelector("a[title*='Google Anasayfası']");
    private By BottomGoogleOnSearch = By.cssSelector("tr[jsname='TeSSVd']");

    public SearchPage(WebDriver driver) {
        this.utils = Utils.getUtilsInstance(driver);
    }

    public static SearchPage getSearchPageInstance(WebDriver driver){
        if (searchPage == null)
            return new SearchPage(driver);
        return searchPage;
    }

    public SearchPage verifyTumuIsVısıble (String expectedText){
       String actualText = utils.getElementText(Tumu) ;
        Assert.assertTrue(actualText.contains(expectedText));
       return this;
    }

    public SearchPage verifyGoogleLogoIsDisplayedOnSearchPage (){
        utils.isDisplay(SearchGoogleLogo);
        return this;
    }

    public SearchPage scrollToXY (int x,int y){
        utils.scrollToCoordinate(x,y);
        return this;
    }

    public SearchPage scrollToBottomGoogleLogo (){
        utils.scrollToElement(BottomGoogleOnSearch);
        return this;
    }

    public void sleep(int seconds){
        utils.sleep(seconds);
    }
}
