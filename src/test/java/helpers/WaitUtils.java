package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class WaitUtils {

    static int timeOutSecond = Integer.parseInt(new ReadDataFile().readJsonFile("/Config.json","Constant","time_out_second"));


    public static void waitForElementPresent(WebDriver aDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(aDriver, timeOutSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementClickable(WebDriver aDriver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(aDriver,timeOutSecond);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitForElementIsVisible(WebDriver driver, int second, By by) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(visibilityOfElementLocated(by));
    }

    public static void waitForElementIsInvisible(WebDriver driver, int second, By by) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(invisibilityOfElementLocated(by));
    }
}
