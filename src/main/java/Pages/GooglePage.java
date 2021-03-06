package Pages;

import Factory.DriverFactory;
import Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {
    private static GooglePage googlePage;
    private Utils utils;

    private By GoogleLogo = By.cssSelector("img.lnXdpd");
    private By SearchArea = By.name("q");
    private By SearchListResult = By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']");

    public GooglePage(WebDriver driver) {
        this.utils = Utils.getUtilsInstance(driver);
    }

    public static GooglePage getGooglePageInstance(WebDriver driver){
        if (googlePage == null)
            return new GooglePage(driver);
        return googlePage;
    }

    public String getGooglePageTitle(){ return DriverFactory.getDriver().getTitle(); }

    public void verifyGoogleLogoIsDisplayedOngooglePage(){
        utils.isDisplay(GoogleLogo);

    }

    public GooglePage searchForText(String searchText) throws Exception {
        utils.type(SearchArea,searchText);
        return this;
    }

    public SearchPage clickSearchResult(String clickedText) {
        List<WebElement> list = DriverFactory.getDriver().findElements(SearchListResult);
        System.out.println("----- list size is : " + list.size());
        for (WebElement webElement : list) {
            if (webElement.getText().contains(clickedText)) {
                webElement.click();
                break;
            }
        }
        return new SearchPage(DriverFactory.getDriver());
    }

    /* public SearchPage clickSearchResult(String clickedText) {
        List<WebElement> list = DriverFactory.getDriver().findElements(SearchListResult);
        System.out.println("----- list size is : " + list.size());
        for (int i=0; i<list.size() ; i++){
            if(list.get(i).getText().contains(clickedText)) {
                list.get(i).click();
                break;
            }
        }
        return new SearchPage(DriverFactory.getDriver());
    }*/
}
