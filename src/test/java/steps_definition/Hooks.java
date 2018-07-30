package steps_definition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.CommonActions;
import helpers.Log;
import helpers.ReadDataFile;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class Hooks {

    protected static WebDriver driver=null;
    ReadDataFile readDataFile = new ReadDataFile();
    String url = readDataFile.readJsonFile("/Config.json","Constant","url");
    String gird_hub = readDataFile.readJsonFile("/Config.json","Constant","grid_hub");
    String testType = readDataFile.readJsonFile("/Config.json","Constant","test_type");

    @Before
    public WebDriver setupDriver() {
        if(testType.equals("ui")){
            Log.info("Opening browser...");

            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setJavascriptEnabled(true);

            String browser = System.getProperty("webdriver");

            if (browser == null || browser.equalsIgnoreCase("") || browser.equalsIgnoreCase("InternetExplorer")) {
                ChromeDriverManager.getInstance().arch64().setup();
                driver = new ChromeDriver(capability);
            } else {
                // Create Remote driver
                try {
                    //capability = DesiredCapabilities.internetExplorer();
                    capability = DesiredCapabilities.chrome();
                    //capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                    driver = new RemoteWebDriver(new URL(gird_hub), capability);
                } catch (MalformedURLException e) {
                    Log.info("Cannot connect to remote driver.");
                    e.printStackTrace();
                }
            }
            openHomePage();
        }
        return driver;
    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.close();
            driver.quit();
        }
    }

    private void openHomePage() {
        driver.navigate().to(url);
        if(CommonActions.getCurrentOperation().contains("Mac")){
            driver.manage().window().fullscreen();
        }else{
            driver.manage().window().maximize();
        }
    }

}
