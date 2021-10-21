package Parallel;

import Factory.DriverFactory;
import Utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {
    private final DriverFactory driverFactory;
    private WebDriver driver;
    private static Properties properties = null;

    public ApplicationHooks() {
        this.driverFactory = new DriverFactory();
        ApplicationHooks.properties = new ConfigReader().initialize_properties();
    }

    public static Properties getPropertiesInstance(){
        return properties;
    }

    @Before(order = 1 )
    public void launchBrowser(){
        //driverFactory = new DriverFactory();
        driver = driverFactory.init_driver();
    }

    @After( order = 0)
    public void quitBrowser(){
       driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
