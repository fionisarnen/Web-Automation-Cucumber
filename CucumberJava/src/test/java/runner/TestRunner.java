package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinition"},
monochrome=true,
plugin= {"pretty","junit:target/JUnitReports/report.xml", "html:target/HtmlReports"})
public class TestRunner {

}