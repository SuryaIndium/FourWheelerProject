package runners;

import com.automation.qa.isafe.cucumber.util.Constant;
import com.automation.qa.isafe.cucumber.util.CustomAbstractTestNGCucumberTests;
import com.automation.qa.isafe.driver.DriverFactory;
import com.automation.qa.isafe.driver.DriverManager;
import com.automation.qa.isafe.utilities.OutputAndLog;

import common.ApplicationKeywords;
import common.BaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@CucumberOptions(dryRun = false, // Skip execution of glue code.
		strict = true, // Treat undefined and pending steps as errors.
		features = { "src/test/java/features/Mobile" }, glue = { "steps" }, plugin = {
				"json:target/jsonReports/ChromeTestResults.json" }, monochrome = false, tags = { "" })

@Test
public class CommonRunner extends CustomAbstractTestNGCucumberTests {

	private static final Logger LOGGER = Logger.getLogger(String.valueOf(CommonRunner.class));

	// @BeforeSuite
	public void initOutputDir() {
		ApplicationKeywords.setCSSProperties(OutputAndLog.createOutputDirectory());
	}

	@Parameters({ "cucumber.tags" })
	@BeforeClass(alwaysRun = true)
	public void setUpTest(String tags) throws Exception {
		Class<?> testClass = this.getClass();
		changeCucumberAnnotation(testClass, "tags", new String[] { tags });
		testNGCucumberRunner = new TestNGCucumberRunner(testClass);
	}

	private static void changeCucumberAnnotation(Class<?> clazz, String key, Object newValue)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Annotation options = clazz.getAnnotation(CucumberOptions.class);
		InvocationHandler proxyHandler = Proxy.getInvocationHandler(options);
		Field f = proxyHandler.getClass().getDeclaredField("memberValues");
		f.setAccessible(true);
		Map<String, Object> memberValues = (Map<String, Object>) f.get(proxyHandler);
		memberValues.remove(key);
		memberValues.put(key, newValue);
	}

	@Parameters({ "or" })
	@BeforeClass
	public void setUpBrowser(String orName) {

		LOGGER.info("Execution Browser set as: " + Constant.BROWSER_NAME);
		LOGGER.info("Execution Browser Version set as: " + Constant.BROWSER_VERSION);
		LOGGER.info("Execution Platform set as: " + Constant.PLATFORM);

		DriverFactory.createInstance(Constant.BROWSER_NAME, Constant.BROWSER_VERSION, Constant.PLATFORM);
		LOGGER.info("Done! Created " + Constant.BROWSER_NAME + " driver!");

		BaseClass obj = new BaseClass();
		BaseClass.obj.set(obj);
		obj.setOR(orName);
	}

	@AfterClass
	public void tearDownBrowser() {
		DriverManager.getDriver().quit();
	}
}