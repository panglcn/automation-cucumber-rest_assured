package pages_object;

import helpers.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class MyAccountPage extends GenericPage {

    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement pageTitle;

    @Override
    public void waitForPageIsDisplayed() {
        WaitUtils.waitForElementPresent(driver,pageTitle);
    }
}
