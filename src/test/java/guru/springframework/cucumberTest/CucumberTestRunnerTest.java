package guru.springframework.cucumberTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/springBoot"})
public class CucumberTestRunnerTest extends AbstractTestNGCucumberTests {

}
