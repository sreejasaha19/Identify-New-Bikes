package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//Features/UpcomingHondaBikes.feature", ".//Features/UsedCars.feature", ".//Features/ZigWheelsLogin.feature"},
					//features= {"@target/rerun.txt"},
					//features= {".//Features/SmokeTesting.feature"},//For smoke testing
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							dryRun=false,    // checks mapping between scenario steps and step definition methods
							monochrome=true,    // to avoid junk characters in output
							publish=true,   // to publish report in cucumber server
							//tags="@sanity"  // this will execute scenarios tagged with @sanity
							//tags="@regression"
							//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
							tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
