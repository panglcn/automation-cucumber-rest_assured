package pages_object;

import helpers.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.CommonActions.clickByJS;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class HomePage extends GenericPage{

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "login")
    private WebElement signInBtn;

    @Override
    public void waitForPageIsDisplayed() {
        WaitUtils.waitForElementPresent(driver,signInBtn);
    }

    public void clickOnSignIn(){
        clickByJS(driver,signInBtn);
    }


}
