package steps_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pages_object.AuthenticationPage;
import pages_object.HomePage;
import pages_object.MyAccountPage;

/**
 * Created by XuyenTran on 7/27/18.
 */
public class LoginSteps {

    HomePage homePage = new HomePage();
    AuthenticationPage authenticationPage = new AuthenticationPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    SoftAssertions softAssertions = new SoftAssertions();


    @Given("^user is on the authentication page$")
    public void userIsOnTheAuthenticationPage() throws Throwable {
        homePage.clickOnSignIn();
        authenticationPage.waitForPageIsDisplayed();
    }

    @When("^user enters with \"([^\"]*)\" and \"([^\"]*)\" as email and password$")
    public void userEntersWithAndAsEmailAndPassword(String email, String password) throws Throwable {
        authenticationPage.enterEmailAndPassword(email,password);
    }

    @And("^user click on sign in button$")
    public void userClickOnSignInButton() throws Throwable {
        authenticationPage.clickOnLogin();
    }

    @Then("^user should be redirected to my account page$")
    public void userShouldBeRedirectedToMyAccountPage() throws Throwable {
       myAccountPage.waitForPageIsDisplayed();
    }

    @Then("^user should see \"([^\"]*)\" as error message$")
    public void userShouldSeeAsErrorMessage(String error) throws Throwable {
        softAssertions.assertThat(authenticationPage.getErrorMessage().compareToIgnoreCase(error));
        softAssertions.assertAll();
    }

}
