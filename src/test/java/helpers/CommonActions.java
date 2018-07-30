package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import steps_definition.Hooks;

import static helpers.WaitUtils.waitForElementClickable;
import static helpers.WaitUtils.waitForElementPresent;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class CommonActions extends Hooks{

    public static void setText(WebElement element, String key) {
        waitForElementPresent(driver,element);
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                element.clear();
                element.sendKeys(key);
            } else {
                Log.info("Unable to set text on field");
            }
        } catch (StaleElementReferenceException e) {
            Log.info("#Unable to set text on field: Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            Log.info("#Unable to set text on field: Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            Log.info("Unable to set text on field " + e.getStackTrace());
        }
    }

    public static String getValue(WebElement element) {
        String jQuerySelector = "arguments[0]";
        return ((JavascriptExecutor) driver).executeScript("return $(" + jQuerySelector + ").val();", element)
                .toString();
    }

    public static String getText(WebDriver driver, WebElement element) {
        waitForElementPresent(driver, element);
        return element.getText();
    }

    public static void clickByJS(WebDriver driver, WebElement element) {
        waitForElementClickable(driver,element);
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page DOCUMENT " + e.getStackTrace());
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }
    }

    public static boolean isElementDisplayed(WebElement element, boolean expected) {
        try {
            if(expected){
                waitForElementPresent(driver, element);
            }
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isRadioButtonChecked(WebDriver driver, WebElement element) {
        waitForElementPresent(driver,element);
        String jQuerySelector = "arguments[0]";
        String check = ((JavascriptExecutor) driver)
                .executeScript("return $(" + jQuerySelector + ").is(':checked')", element).toString();
        if (check.equals("false")) {
            return false;
        }
        return true;
    }

    public static void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public static void click(WebDriver driver, WebElement element){
        waitForElementClickable(driver,element);
        scrollToElement(element);
        element.click();
    }

    public static void scrollToElement(WebElement el) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", el);
        }
    }

    public static boolean isEnableElement(WebDriver driver, WebElement element, boolean expected){
        if(expected){
            waitForElementClickable(driver,element);
        }
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public static void scrollToTop(WebDriver driver){
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,-900)", "");
    }

    public static void scrollToMidde(WebDriver driver){
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,500)", "");
    }


    public static void scrollToDown(WebDriver driver){
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,990)", "");
    }

    public static void uploadFile(WebDriver driver, String filePath, By by) throws Throwable {
        System.out.println("Upload file.....");
        WebElement el = driver.findElement(by);
        ((RemoteWebElement) el).setFileDetector(new LocalFileDetector());
        el.sendKeys(" " + filePath);
    }

    public static String getCurrentOperation(){
        return System.getProperty("os.name");
    }

    public static boolean isExistElementBy(WebDriver driver, By by){
        try{
            return driver.findElement(by).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public static void enterValueForDateField(WebElement element ,String value){
        waitForElementPresent(driver,element);
        element.click();
        setText(element,value);
        element.sendKeys(Keys.ESCAPE);
    }

    public static String getAttribute( WebElement element, String attribute){
        return element.getAttribute(attribute);
    }


    public static boolean isEnableElementBy(WebDriver driver, By by, boolean expected){
        if(expected){
            waitForElementClickable(driver,driver.findElement(by));
        }
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
