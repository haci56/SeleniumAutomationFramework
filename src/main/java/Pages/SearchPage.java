package Pages;

import Utils.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private static SearchPage searchPage;
    private CommonFunctions cf;

    private By Tumu = By.cssSelector("div.hdtb-mitem.hdtb-msel");
    private By SearchGoogleLogo = By.cssSelector("a[title*='Google Anasayfası']");
    private By BottomGoogleOnSearch = By.cssSelector("tr[jsname='TeSSVd']");

    public SearchPage(WebDriver driver) {
        this.cf = CommonFunctions.getInstance(driver);
        //super(driver);
    }

    public static SearchPage getSearchPageInstance(WebDriver driver){
        if (searchPage == null)
            return new SearchPage(driver);
        return searchPage;
    }

    public SearchPage verifyTumuIsVısıble (String expectedText){
       String actualText = cf.getElementText(Tumu) ;
        Assert.assertTrue(actualText.contains(expectedText));
       return this;
    }

    public SearchPage verifyGoogleLogoIsDisplayedOnSearchPage (){
        cf.isDisplay(SearchGoogleLogo);
        return this;
    }

    public SearchPage scrollToXY (int x,int y){
        cf.scrollToCoordinate(x,y);
        return this;
    }

    public SearchPage scrollToBottomGoogleLogo (){
        cf.scrollToElement(BottomGoogleOnSearch);
        return this;
    }

    public void sleep(int seconds){
        cf.sleep(seconds);
    }
}
