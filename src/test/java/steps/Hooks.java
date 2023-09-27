package steps;

import common.ApplicationKeywords;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends ApplicationKeywords {

	@After("@hook")
	public void logoutWithHook(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[] screenshot = takeScreenshot();
			scenario.embed(screenshot, "image/png");
		}
		driver.close();
	}
	
	@Before
    public void setUpScenario(Scenario scenario) {
		System.out.println(scenario);
        scenarioStep = scenario;
        putScenario(scenario);
        
    }

	
	
	
	
	
}
