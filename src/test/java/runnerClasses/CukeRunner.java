package runnerClasses;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"html:target/cucumberHtmlReport",
		}, 
		features = {
				"src/test/resources/Features"
		},
		glue = {
				"glueCode"
		},
		tags = {
				"@API_Test"
		})
public class CukeRunner {}