package Utils;

import org.openqa.selenium.*;

public class Utils {

    private static Utils lazy;

    private WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public static Utils getUtilsInstance(WebDriver driver){
        if (lazy == null)
            return new Utils(driver);
        return lazy;
    }

    public void sleep(int seconds) {
        System.out.println("-----------------user is going to wait for : " + seconds + " seconds ----------------");
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------user waited for : " + seconds + " seconds ----------------");
    }

    public <T> void click(T p)  {
        WebElement el = null;
        if (p instanceof By)
            el = driver.findElement((By) p);
        else if (p instanceof WebElement)
            el = ((WebElement) p);
        else if (p instanceof String)
            el = (WebElement) ((JavascriptExecutor)driver).executeScript("return "+(p));
        assert el != null;
        el.click();
    }

    public <P, T> void type(P p, T t) throws Exception {
        if ((p == null))
            throw new Exception(p + "is null");
        else if (!(p instanceof WebElement) && !(p instanceof By))
            throw new Exception(p + "parameter type not supported by tap function");
        WebElement el;
        if (p instanceof By) {
            el = driver.findElement((By) p);
        } else {
            el = ((WebElement) p);
        }
        if (t instanceof String) {
            el.clear();
            el.sendKeys(((String) t));
        } else if (t instanceof Keys) {
            el.sendKeys(((Keys) t));
        }
    }
    public <T> String getElementText(T p){
        String text;
        if (p instanceof By) {
            text = driver.findElement((By) p).getText();
        } else {
            text =  ((WebElement) p).getText();
        }
        return text;
    }


    public <T> void isDisplay(T p)  {
       if(p instanceof By){
         boolean b =  driver.findElement((By) p).isDisplayed();
        }else{
          boolean b = ((WebElement) p).isDisplayed();
       }
    }

    public void scrollToCoordinate(int x, int y){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+","+y+")");
    }

    public <T> void scrollToElement(T p) {
        WebElement el;
        if (p instanceof By) {
            el = driver.findElement((By) p);
        } else {
            el = ((WebElement) p);
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
    }

}
