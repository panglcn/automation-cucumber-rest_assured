package pages_object;

import helpers.CommonActions;
import helpers.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class AuthenticationPage extends GenericPage {

    public AuthenticationPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(css="#SubmitLogin>span")
    private WebElement signIn;

    @FindBy(css="div[class*='alert'] li")
    private WebElement errorMsg;

    @Override
    public void waitForPageIsDisplayed() {
        WaitUtils.waitForElementPresent(driver,email);
    }

    public void enterEmailAndPassword(String email, String password){
        CommonActions.setText(this.email,email);
        CommonActions.setText(this.password,password);
    }

    public void clickOnLogin(){
        CommonActions.clickByJS(driver,signIn);
    }

    public String getErrorMessage(){
        return CommonActions.getText(driver,errorMsg);
    }

}
