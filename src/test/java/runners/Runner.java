package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "target/test-classes/features",
        glue = "steps",
        tags = "@Test1"
)

public class Runner {
}
