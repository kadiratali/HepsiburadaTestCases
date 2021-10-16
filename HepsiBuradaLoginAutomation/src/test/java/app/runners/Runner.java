package app.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report","app.step_definitions.customReportListener"},
        features="src/test/resources/features",
        glue="app/step_definitions",
        dryRun=false
)
public class Runner extends AbstractTestNGCucumberTests {

}