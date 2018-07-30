package steps_definition;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

/**
 * Created by XuyenTran on 7/28/18.
 */
public class APISteps {

    private SoftAssertions softAssertions = new SoftAssertions();
    private Response response;
    private RequestSpecification request;


    @Given("^user has the api to check the weather conditions as \"([^\"]*)\"$")
    public void userHasTheApiToCheckTheWeatherConditionsAs(String url) throws Throwable {
        request = RestAssured.with();
        request.given()
                .contentType(ContentType.JSON)
                .baseUri(url);
    }

    @When("^user send request for city \"([^\"]*)\"$")
    public void userSendRequestForCity(String city) throws Throwable {
        response = request.get(city);
    }

    @Then("^user should get response status code is (\\d+)$")
    public void userShouldGetResponseStatusCodeIs(int status) throws Throwable {
        softAssertions.assertThat(response.getStatusCode()).isEqualTo(status);
        softAssertions.assertAll();
    }

    @And("^user should see city as \"([^\"]*)\"$")
    public void userShouldSeeCityAs(String city) throws Throwable {
        softAssertions.assertThat(response.body().jsonPath().get("City")).isEqualTo(city);
        softAssertions.assertAll();
    }

    @And("^user should see error message is \"([^\"]*)\"$")
    public void userShouldSeeErrorMessageIs(String msg) throws Throwable {
        softAssertions.assertThat(response.body().jsonPath().get("fault")).isEqualTo(msg);
        softAssertions.assertAll();
    }
}
