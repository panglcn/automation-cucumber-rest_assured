package steps_definition;

import cucumber.api.CucumberOptions;

/**
 * Created by XuyenTran on 7/28/18.
 */
@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty", "json:target/cucumber-report.json"},
        tags = { "~@ignore"}
)
public class RunCukesTest1 {
}
