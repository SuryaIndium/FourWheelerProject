package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.qa.isafe.cucumber.util.Constant;
import com.automation.qa.isafe.cucumber.util.FrameworkProperties;
import com.automation.qa.isafe.keywords.GUIKeywords;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;
import objectRepository.AndroidLocators;

import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApplicationKeywords extends GUIKeywords {
	public static WebDriverWait wait;

	final static Logger logger = Logger.getLogger(ApplicationKeywords.class);

	public ApplicationKeywords(RemoteWebDriver driver) {
		super(driver);
	}

	public ApplicationKeywords(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}

	public ApplicationKeywords() {

	}

	private static Properties properties;
	public static String outputDirectory = null;

	public static String getConfigProperty(String key) {
		String value = null;
		try {
			FrameworkProperties loadProperties = new FrameworkProperties();
			URL congfigFile = null;
			congfigFile = Constant.class.getClassLoader().getResource("config/Configuation.properties");
			properties = loadProperties.readProjEnvConfig(congfigFile.getPath());
			value = properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void hidekeyboard() {
		try {
			AndroidDriver<MobileElement> androidDriver = (AndroidDriver) driver;
			androidDriver.hideKeyboard();
		} catch (Exception e) {
			writeToLogFile("ERROR", e.toString());
		}
	}

	public void getKeyboard() {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
		} catch (Exception e) {
			writeToLogFile("ERROR", e.toString());
		}
	}

	public void hitBackspace() {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.BACK_SPACE).perform();
		} catch (Exception e) {
			writeToLogFile("ERROR", e.toString());
		}
	}

	public void scrollDown() {
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.60);
		int endy = (int) (size.getHeight() * 0.10);
		//((AndroidDriver<?>) driver).swipe(x, starty, x, endy, 2000);
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
		action.press(point(x, starty));
		action.waitAction(waitOptions(ofSeconds(2)));
		action.moveTo(point(x, endy));
		action.release().perform();
	}

	public String getRandomNumber(int stringLength) {
		String randomNumber = null;
		Random random = new Random();
		String Number = "0123456789";
		try {
			StringBuilder buffer = new StringBuilder(stringLength);
			for (int i = 0; i < stringLength; i++) {
				int index = (int) (random.nextFloat() * Number.length());
				buffer.append(Number.charAt(index));
			}
			randomNumber = buffer.toString();
		} catch (Exception e) {
			testStepFailed("[-] FAIL :: '" + e.getClass() + "' thrown  | check log file");
			writeToLogFile("ERROR", "[E] :: Exception thrown: " + e);
		}
		return randomNumber;
	}

	public String getRandomString(int stringLength) {
		String randomString = null;
		Random random = new Random();
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		try {
			StringBuilder buffer = new StringBuilder(stringLength);
			for (int i = 0; i < stringLength; i++) {
				int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
				buffer.append((char) randomLimitedInt);
			}
			randomString = buffer.toString();
		} catch (Exception e) {
			testStepFailed("[-] FAIL :: '" + e.getClass() + "' thrown  | check log file");
			writeToLogFile("ERROR", "[E] :: Exception thrown: " + e);
		}
		return randomString;
	}

	public static boolean setCSSProperties(String outputDitrectory) {
		try {
			final Properties prop = new Properties();
			prop.setProperty("outputDitrectory", outputDitrectory.replace("\\", "/"));
			prop.setProperty("height", "25");
			prop.setProperty("width", "25");
			FileWriter myWriter = new FileWriter("css.properties");
			myWriter.write(getPropertyAsString(prop));
			myWriter.close();
			return true;
		} catch (Exception ex) {
			System.out.println("Exception in setCSSProperties Method: " + ex);
		}
		return false;
	}

	public static String getPropertyAsString(Properties prop) {
		String properties = "";
		for (java.util.Map.Entry<Object, Object> e : prop.entrySet()) {
			properties += e.getKey() + ":" + e.getValue() + "\n";
		}
		return properties;
	}

	public void scroll() {
		AndroidDriver<MobileElement> androidDriver = (AndroidDriver) driver;
		try {
			Dimension dimensions = androidDriver.manage().window().getSize();
			int pressX = dimensions.width / 2;
			int Startpoint = (int) (dimensions.height * 0.60);
			int scrollEnd = (int) (dimensions.height * 0.40);

			new TouchAction(androidDriver).press(PointOption.point(pressX, Startpoint))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
					.moveTo(PointOption.point(pressX, scrollEnd)).release().perform();

		} catch (Exception e) {
			testStepFailed("ERROR", "Exception :" + e);
		}
	}

	
	public String generatePanNumber() {
		String panNumber = null;
		try {
			String First_char = "ABCDE";
			String middle_number = "9358";
			String last_char = "R";
			StringBuilder sb = new StringBuilder();
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			Random rnd = new Random();
			while (sb.length() < 3) { // length of the random string.
				int index = (int) (rnd.nextFloat() * First_char.length());
				sb.append(First_char.charAt(index));
			}
			while (sb1.length() < 1) { // length of the random string.
				int index = (int) (rnd.nextFloat() * First_char.length());
				sb1.append(First_char.charAt(index));
			}

			while (sb2.length() < 4) { // length of the random string.
				int index = (int) (rnd.nextFloat() * middle_number.length());
				sb2.append(middle_number.charAt(index));
			}

			String rndomStr = sb.toString();
			String rndomStr1 = sb1.toString();
			String rndomStr2 = sb2.toString();
			AndroidLocators.panNumber = "" + rndomStr + "P" + rndomStr1 + "" + rndomStr2 + "" + last_char + "";
			panNumber = "" + rndomStr + "P" + rndomStr1 + "" + rndomStr2 + "" + last_char + "";

		} catch (Exception e) {
			testStepFailed("Generate Pan Number Exception: " + e.getClass());
		}
		return panNumber;
	}

	public String generateMobileNumber() {
		String mobileNumber = null;
		try {
			int num2, num3;
			int set1, set2, set3;
			Random generator = new Random();
			set1 = 6;
			num2 = generator.nextInt(8);
			num3 = generator.nextInt(8);
			set2 = generator.nextInt(643) + 100;
			set3 = generator.nextInt(8999) + 1000;
			AndroidLocators.Mobile = set1 + "" + num2 + num3 + set2 + set3;
			mobileNumber = AndroidLocators.Mobile;
		} catch (Exception e) {
			testStepFailed("Generate Mobile Number Exception: " + e.getClass());
		}
		return mobileNumber;
	}
	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 16-05-2023 Description : Method is used generate the dynamic
	 * names
	 * 
	 * 
	 */

	public static String generateName() {
		String lead = RandomStringUtils.random(6, true, false).replace("0", "5");
		lead = "Automation" + lead;
		return lead;
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 16-05-2023 Description : Method is used to click on button
	 * 
	 * @param : Passing the field name
	 * 
	 */
	public void clickOnIfDisplayed(String locator) {
		try {
			if (isElementDisplayed(locator)) {
				clickOn(locator);
				testStepPassed(locator.split("#")[0] + " is Displayed and Clicked Successfully");
			} else {
				testStepFailed(locator.split("#")[0] + " is Not Displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			testStepFailed("Click On If Displayed Failed. Exception: " + e.getClass());
		}
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 16-05-2023 Description : Method is used to click on button
	 * 
	 * @param : Passing the field name
	 * 
	 */

	public void clickOnButton(String value)
	{
		try {
			String button = value + "#xpath=//android.widget.Button[@text='" + value + "']";
			waitForElementToDisplay(button, 10);
			if (isElementDisplayed(button)) 
			{
				clickOn(button);
				addValuesToHtmlReport("clicked on: ", value);
			}
			else 
			{
				testStepFailed(value + " is not present.");
			}
		} catch (Exception e) {
			testStepFailed("Failed to clickOnButton " + value);
		}
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 17-05-2023 Description : Method is used to enter the value in
	 * the field
	 * 
	 * @param : Passing the field name and value
	 * 
	 */
	public void enterTextInField(String labelName, String value) {
		try 
		{
			String field = labelName + "#xpath=//android.widget.EditText[@text='" + labelName + "']";
			if (isElementDisplayed(field)) 
			{
				addValuesToHtmlReport(labelName, value);
				typeIn(field, value);
				closeKeyBoard();
			}
			else 
			{
				testStepFailed(labelName + " field is not present");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Failed in enterTextInCustomerProcess " + e.getMessage());
		}
	}
	
	public void navigateNextTab(String labelName) {
		try {
			String field = labelName + "#xpath=//android.widget.EditText[@text='" + labelName + "']";
			
			WebElement element = findWebElement(field);
			element.sendKeys(Keys.TAB);
				closeKeyBoard();
			
		} catch (Exception e) {
			testStepFailed("Failed in enterTextInCustomerProcess " + e.getMessage());
		}
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 17-05-2023 Description : Method is used to enter the value in
	 * drop down
	 * 
	 * @param : Passing the field name and value
	 * 
	 */

	public void selectDropdownValue(String field, String value) {

		String dropDwon = field + "#xpath=//android.widget.EditText[@text='" + field + "']";
		String dropdownValue = value + "#xpath=//android.widget.TextView[@text='" + value + "']";
		waitForElementToDisplay(dropDwon, 10);
		if (isElementDisplayed(dropDwon)) 
		{
			clickOn(dropDwon);
			waitTime(2);
			if (isElementDisplayed(dropdownValue)) 
			{
				addValuesToHtmlReport(field, value);
				clickOn(dropdownValue);
				testStepPassed(value + " selected the value");
			}
		} 
		else 
		{
			testStepFailed(field + " dropdown field is not present");
		}
	}

	public static void addValuesToHtmlReport(String key, String value) {

		try {

			getScenario().write("" + key + ": " + value);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 16-05-2023 Description : Method is to enter the date for any
	 * field
	 * 
	 * @param : Passing the field name
	 * 
	 */
	public void enterDateOfBirth(String field, String date) {
		String dob = "Date of birth#xpath=//android.widget.EditText[@text='" + field + "']";
		try {
			if (isElementDisplayed(dob)) {
				MobileElement dobField = (MobileElement) findWebElement(dob);
				dobField.sendKeys(date);
				addValuesToHtmlReport(field, date);
			} else {
				testStepFailed(field + " is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void expiryDate(String field) {
		String dob = field + "#xpath=//android.widget.EditText[@text='" + field + "']";
		try {
			if (isElementDisplayed(dob)) {
				//MobileElement dobField = (MobileElement) findWebElement(dob);
			WebElement dobField = findWebElement(dob);
				dobField.sendKeys("2026-08-01");
				addValuesToHtmlReport(field, "2026-08-01");
			} else {
				testStepFailed(field + " is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeKeyBoard() {
		waitTime(2);

		((AndroidDriver<?>) driver).hideKeyboard();

		testStepPassed("The Android KeyBoard is closed");
	}

	public void addressProof() {
		String upload = "upload#xpath=//android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_ncf_attach']";
		String image = "image#xpath=//android.widget.CompoundButton[@text='Images']";
		String topOnImage = "Select the Image#xpath=//android.widget.TextView[@text='Image.jpg']";
		String cropBtn = "crop#xpath=//android.widget.TextView[@text='CROP']";
		String uploadbtn = "upload icon#xpath=//android.widget.TextView[@text='Address Proof']/following::android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_addressproof']";
		if (isElementDisplayed(upload)) {
			clickOn(upload);
			waitTime(5);

			// waitForElement(image);
			driver.findElement(By.xpath("//android.widget.CompoundButton[@text='Images']")).click();
			waitTime(5);
			// clickOnButton(image);
			// waitForElement(topOnImage);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Image.jpg']")).click();
			waitTime(5);
			// clickOnButton(topOnImage);
			// waitForElement(cropBtn);
			driver.findElement(By.xpath("//android.widget.TextView[@text='CROP']")).click();
			waitTime(5);
			// clickOnButton(cropBtn);
			// waitForElement(uploadbtn);
			clickOnButton(uploadbtn);
			manualScreenshot();
			addValuesToHtmlReport("Address proof ", "Updated");
		} else {
			testStepFailed("Address proof not upadted ");
		}

	}

	public void identityProof() {
		String upload = "upload#xpath=//android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_ncf_attach']";
		String image = "image#xpath=//android.widget.CompoundButton[@text='Images']";
		String topOnImage = "Select the Image#xpath=//android.widget.TextView[@text='Image.jpg']";
		String cropBtn = "crop#xpath=//android.widget.TextView[@text='CROP']";
		String uploadbtn = "upload icon#xpath=//android.widget.TextView[@text='Identity Proof']/following::android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_identityproof']";
		if (isElementDisplayed(upload)) {
			clickOn(upload);
			clickOnButton(image);
			clickOnButton(topOnImage);
			clickOnButton(cropBtn);
			clickOnButton(uploadbtn);
			addValuesToHtmlReport("Identity Proof ", "Updated");
		} else {
			testStepFailed("Identity Proof not upadted ");
		}

	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 18-05-2023 Description : Method is used to create 5 digit
	 * number Return Value : String Purpose  : Need to enter the 5-digit number for
	 * the address number field
	 */
	public String gen_Five_Digit() {
		Random r = new Random(System.currentTimeMillis());
		int nu = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		return Integer.toString(nu);
	}
	
	
	/*
	     * @author : Meghana M S
	     * 
	     * @created Date : 26-05-2023
	     *  Description : Method is used to select the image and click on crop
	     * 
	     * @param: passing the field text
	     */
	public void toSelectTheImage() {

	waitTime(3);
	driver.findElement(By.xpath("//android.widget.CompoundButton[@text='Images']")).click();
	waitTime(3);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Image.jpg']")).click();
	 waitTime(3);
	driver.findElement(By.xpath("//android.widget.TextView[@text='CROP']")).click();
	waitTime(3);
	}
	

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 18-05-2023 Description : Method is used in the add applicant
	 * popup number Return Value : Purpose  : This popup will appear after the RC
	 * Delivery Address to handle that popup
	 */
	public void add_Applicant(String value) {
		String addApplicatPage = "addApplicant#id=com.bfl.isdcia.dev:id/text_title";
		String addOrNo = "#xpath=//android.widget.Button[@text='" + value + "']";
		try {
			waitForElementToDisplay(addApplicatPage, 10);
			if (isElementDisplayed(addApplicatPage)) {
				clickOn(addOrNo);
				testStepPassed("Add Applicat option select as " + value);
			} else {
				testStepInfo("Add applicant popup not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void manualScreenshot() {
		final byte[] screenshot = takeScreenshot();
		getScenario().embed(screenshot, "image/png");
	}

	public void errorValidationOnFields(String errorValue) 
	{
		String error = "errorpopUp#xpath=//android.widget.FrameLayout/android.widget.TextView[@text='"+errorValue+"']";
		String errorMsg = "";
		if (isElementDisplayed(error))
		{
			manualScreenshot();
			errorMsg = getText(error);
			addValuesToHtmlReport("ErrorMessage is Displayed: ", errorMsg);
			testStepPassed(errorMsg + " field validation error message is displayed");
		} 
		else 
		{
			testStepFailed(errorMsg + " field validation error message is  not displayed");
		}
	}
	/*
	 * @author :  Surya
	 * 
	 * @created Date : 25-05-2023 Description : Method is used to errorvalue validation
	 * from the json file Return Value : String Purpose  :
	 */
	
	public void validateErrorMessage(String errorValue)
	{
		String errorPopup="errorpopup#xpath=//android.widget.TextView[@text='"+errorValue+"']";
		try
		{
			if(isElementPresent(errorPopup))
					{
				manualScreenshot();
				String error=getText(errorPopup);
				addValuesToHtmlReport("ErrorMessage is Displayed: ", error);
					}
		}
		catch (Exception e) {
			testStepFailed("Exception");
		}
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 23-05-2023 Description : Method is used to retrieve value
	 * from the json file Return Value : String Purpose  :
	 */
	public String retrieve(String Key) {
		String value = null;
		try {
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(new FileReader("./src/main/java/data/data.json"));
			value = data.get(Key).toString();
			
		} catch (Exception e) {
			testStepFailed("Failed in retrieve");
		}
		return value;
	}
	
	public void scrollToElement(String visibleText)
	{
		try
		{
			waitTime(2);
			((AndroidDriver<?>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
			testStepPassed("Scrolled to element containing " +visibleText);
		}
		catch(Exception e)
		{
			testStepFailed("Exception in the method scrollToElement " +e.toString());
		}
	}
	
	public  void scrollToId(String id) {
		((AndroidDriver<?>) driver).findElementByAndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("+ "new UiSelector().resourceIdMatches(\"" + id + "\"));");
	}
	
	
	/*
	     * @author : Meghana M S
	     * 
	     * @created Date : 18/05/2022 Description : Method to fine whether the element
	     * display
	     * 
	     * @param : objectLocator is element want to find
	     * 
	     * @param : timeOut is value of till wait time
	     * 
	     * @return : flag return true if the element is present
	     */


	public boolean isElementDisplayed(String objectLocator, int timeOut) {
	 driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	 boolean flag = false;
	try {
	   parseidentifyByAndlocator(objectLocator);
	  flag = driver.findElement(By.xpath(locator)).isDisplayed();
	   return flag;
	}
	catch (NoSuchElementException e) 
	{
writeToLogFile("ERROR", objectLocator + " is not found.");
	 return flag;
	} catch (Exception e) {
	writeToLogFile("ERROR", objectLocator + " is not found.");
	return flag;
	}
	}
	
	/*
     * @author : Meghana M S
     * 
     * @created Date : 29-05-2023 Description : Method is used to Compare the two
     * value
     * 
     * @param: passing the 2 values
     */

 

    public boolean verifyTwoValues(String actualValue, String expectedValue) {

 

        boolean flag = false;
        try {
            if (actualValue.equalsIgnoreCase(expectedValue)) {
                testStepInfo(
                        "Actual value - [ " + actualValue + " ] is same as expected value - [ " + expectedValue + " ]");
                flag = true;
            } else {
                testStepFailed(
                        "Actual value - " + actualValue + " is not as same as expected value - " + expectedValue);
            }
        } catch (Exception e) {
            testStepFailed(e.getMessage());
        }
        return flag;
    }
    
    public void scrollToUp()
    {
    	try
		{
			driver.findElement(MobileBy.AndroidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(3)"));
		}
		catch (Exception e) {
		testStepPassed("Scroll to element Sucessfully");
		}
    }

	public void scrollToEnd()
	{
		try
		{
			driver.findElement(MobileBy.AndroidUIAutomator(
		            "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(3)"));
		}
		catch (Exception e) {
		testStepPassed("Scroll to element Sucessfully");
		}
	}
	
	public void clickOnTextValue(String value)
	{
		try {
			String button = value + "#xpath=//android.widget.TextView[@text='" + value + "']";
			waitForElementToDisplay(button, 10);
			if (isElementDisplayed(button)) 
			{
				clickOn(button);
				addValuesToHtmlReport("clicked on: ", value);
			}
			else 
			{
				testStepFailed(value + " is not present.");
			}
		} catch (Exception e) {
			testStepFailed("Failed to clickOnButton " + value);
		}
	}

	public void clearTextFromFiled(String labelName) {
        try {
            String field = labelName + "#xpath=//android.widget.EditText[@text='" + labelName + "']";
            if (isElementDisplayed(field)) {
                clearEditBox(field);
                closeKeyBoard();
            } else {
                testStepFailed(labelName + " field is not present");
            }
        } catch (Exception e) {
            testStepFailed("Failed in enterTextInCustomerProcess " + e.getMessage());
        }
    }
	
	public void enterTextBox(String objLocator,String value)
	{
		try
		{
			waitTime(2);
			waitForElementToDisplay(objLocator, 10);
			if(isElementDisplayed(objLocator))
			{
				typeIn(objLocator, value);
				closeKeyBoard();
				addValuesToHtmlReport("Type In The Text Box", value);
			}
			else
			{
				testStepFailed("could able locate the textBox Field");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method enterTextBox:" + e.toString());
		}
	}
	
	public void clickOnButtonValue(String objLocator)
	{
		try
		{
			waitForElementToDisplay(objLocator, 10);
			if(isElementDisplayed(objLocator))
			{
				String value=getText(objLocator);
				clickOn(objLocator);
				addValuesToHtmlReport("clickOn", value);
			}
			else
			{
				testStepFailed("could able locate the clickOn Field");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method clickOnButtonValue:" + e.toString());
		}
	}
	
	public void getText(String locator, String expectedText)
	{
		boolean status = false;
		List<WebElement> elementList = findWebElements(locator);
		String actualText = "";

		for (WebElement element : elementList) 
		{
			actualText = element.getText().trim();
			if(actualText.contains(expectedText)) 
			{
				status = true;
				testStepPassed("Expected condition meets with Actual condition " +actualText);
				addValuesToHtmlReport("Text Value is ", actualText);
				
				break;
			}
		}
		if(status == false)
		{
			testStepFailed("<< Expected condition doesn't meet with Actual condition >> " +expectedText);
		}
	}
	
	public void getElementAndClick(String locator, String expectedText)
	{
		try
		{
			waitTime(2);
			List<WebElement> namelist = findWebElements(locator);
			String actualText = "";
			boolean status = false;
			for (WebElement element : namelist) 
			{
				if(element.isDisplayed())
				{
					actualText = element.getText().trim();
					if(actualText.equalsIgnoreCase(expectedText))
					{
						element.click();
						status = true;
						testStepPassed(actualText +" is validated and clicked");
						addValuesToHtmlReport("clicked on", actualText);
						break;
					}
				}
			}
			if(status == false)
			{
				testStepFailed("Expected Text " + expectedText + " does not match with Actual Text " + actualText);
			}
		}
		catch(Exception ex)
		{
			testStepFailed("Exception in the method getElementAndClick" +ex);
		}
	}
	public void validateElementkeyAndValue(String objKeyLocator,String objValueLocator)
	{
		try
		{
			HashMap <String,String> headers = new HashMap<>();
			verifyElementIsDisplayed(objKeyLocator);
			List<WebElement> time =findWebElements(objKeyLocator);
			List<WebElement> consult = findWebElements(objValueLocator);

			for (int i = 0; i < consult.size(); i++)
			{
				headers.put(consult.get(i).getText(),time.get(i).getText());
			}

			for(Map.Entry<String,String> pair : headers.entrySet())
			{
				String providerConsulation = pair.getKey();
				String providerTime = pair.getValue();
				testStepPassed(providerTime+" = "+ providerConsulation);
				addValuesToHtmlReport(providerTime,providerConsulation);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateElementkeyAndValue" + e.toString());
		}
	}
	
	public void validateErrorMessages(String objLocator,String exceptedErrorMessage)
	{
		try
		{
			String errorMessage=findWebElement(objLocator).getText();
			if(errorMessage.equalsIgnoreCase(exceptedErrorMessage))
			{
				testStepPassed("Expected condition meets with Actual condition " +errorMessage);
			}
			else
			{
				testStepFailed("Couldn't able locate the errorMessage");
			}
		}
		catch (Exception e) 
	{
            testStepFailed("Exception in the method validateErrorMessages"+e.toString());
        }
	}
	
	public char randomCharacter()
	{
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');
		return c;
	}

	public void SelectYear(String objLocator) {

	    //   String dateOfBirthValue = retrieve("dateOfBirth");
	       String yearValue =  retrieve("Year"); 
	       //String btn_DOB= "#id=com.bfl.isdcia.dev:id/edtDateOfBirth";
	       waitTime(3);
	       clickOn(objLocator);
	       //clickOnTextValue(Constants.dateOfBirth);
	       if(isElementDisplayed("year")) {
	           clickOn("year");
	           clickOnTextValue(yearValue);
	           String value = getText("year");
	           verifyTwoValues(yearValue, value);
	           selectMonthandDate();

	       }else {
	           testStepFailed("Year is not present");
	       }
	   }

	   public void selectMonthandDate() {

	       clickOn("date");
	       clickOnButton("OK");
	   }
	   
	   public void changeTheDate(String objLocator)
	   {
		 
	    //   String dateOFBirth = "Date OF Birth#id=com.bfl.isdcia.dev:id/edt_dob";
	       String beforeDateOfBirth = getText(objLocator);
	   
	     //  typeIn(dateOFBirth, "1996-05-10");
	       
	       WebElement changeDOB = findWebElement(objLocator);
	       changeDOB.sendKeys("1996-05-10");
	       
	       String afterDateOfBirth = getText(objLocator);

	       if(beforeDateOfBirth!=afterDateOfBirth) {
	           testStepPassed(beforeDateOfBirth+" changed to the "+afterDateOfBirth);
	       }else {
	           testStepFailed("date of birth is not changed");
	       }
	   }
	
	   public void addressProofMoreThanThreeMB() 
	   {
		try
		{
			if (isElementDisplayed("addressUpload")) 
			{
				clickOn("addressUpload");
				waitTime(3);
				navigateTODownloadFile();
				 navigateTOImageFile("addressUpload","addressuploadbtn");
			}
			else 
			{
				testStepFailed("Address proof not upadted ");
			}
		}
		  catch (Exception e)
		   {
			   testStepFailed("Exception in the method addressProofMoreThanThreeMB"+e.toString());
		   }
		}

	   public void navigateTODownloadFile()
	   {
		   try
		   {
			   waitTime(5);
			   if(isElementDisplayed("menuButton"))
			   {
				   clickOn("menuButton");
				   verifyElementIsDisplayed("txt_Downloads");
				   clickOn("txt_Downloads");
				   waitTime(3);
				   if(isElementDisplayed("Search_Icon"))
				   {
					   clickOn("Search_Icon");
					   typeIn("txt_search", "Upload.pdf");
					   closeKeyBoard();
					   clickOn("select_Document");
					   validateErrorMessage("File size exceed 3MB");
				   }
				   else
				   {
					   testStepFailed("couldn't able to locate element");
				   }
			   }
			   else
			   {
				   testStepFailed("couldn't able to locate menubutton");
			   }
		   }
		   catch (Exception e)
		   {
			   testStepFailed("Exception in the method navigateTODownloadFile"+e.toString());
		   }
	   }
	   

	   public void navigateTOImageFile(String objLocator,String UploadArrow)
	   {
		   try
		   {
			   waitTime(10);
			   waitForElementToDisplay(objLocator,10);//addressUpload
			   clickOn(objLocator);
			   waitTime(3);
			   if(isElementDisplayed("menuButton"))
			   {
				   waitTime(3);
				   clickOn("menuButton");
				   verifyElementIsDisplayed("txt_Image");
				   clickOn("txt_Image");
				   waitTime(3);
				   clickOn("txt_ScreenShot");
				   if(isElementDisplayed("Search_Icon"))
				   {
					   clickOn("Search_Icon");
					   typeIn("txt_search", "Image.jpg");
					   closeKeyBoard();
					   clickOn("select_Document");
					   waitTime(3);
					   clickOn("txt_Crop");
					   waitTime(5);
					   waitForElementToDisplay(UploadArrow, 10);
					   clickOn(UploadArrow);//addressuploadbtn
					   waitTime(10);
					   manualScreenshot();
					   addValuesToHtmlReport("Address proof ", "Updated");
				   }
				   else
				   {
					   testStepFailed("couldn't able to locate element");
				   }
			   }
			   else
			   {
				   testStepFailed("couldn't able to locate menubutton");
			   }

		   }
		   catch (Exception e)
		   {
			   testStepFailed("Exception in the method navigateTODownloadFile"+e.toString());
		   }
	   }
	   
	   
	   public void identityProofMoreThanThreeMB() 
	   {
		try
		{
			if (isElementDisplayed("identityUpload")) 
			{
				clickOn("identityUpload");
				waitTime(3);
				navigateTODownloadFile();
				 navigateTOImageFile("identityUpload","identityUploadbtn");
				
			} else {
				testStepFailed("Identity Proof not upadted ");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method identityProofMoreThanThreeMB "+e.toString());
		}
		}
	   
	   public void validateDropDown(String objLocator,String ExpectedText )
		{
			try
			{
				waitTime(2);
				clickOn(objLocator);
				getElementAndClick("dropDownValue", ExpectedText);
				getText(objLocator, ExpectedText);
			}
			catch (Exception e) 
			{
				testStepFailed("Exception in the Method validateDropDown:" + e.toString());
			}
		}
	   
	   public void validateDateOfBirth(String objLocator, String dateOfBirth) 
	   {
			try {
				waitForElementToDisplay(objLocator, 10);
				if (isElementDisplayed(objLocator))
				{
					WebElement dobElement = findWebElement(objLocator);
					dobElement.sendKeys(dateOfBirth);
					addValuesToHtmlReport("Enter the Date Of Birth", dateOfBirth);
				} 
				else 
				{
					testStepFailed("couldn't able to locate the DOB Option");
				}
			}
			catch (Exception e) 
			{
				testStepFailed("Exception in the Method validateCustomerDetailsScreen:" + e.toString());
			}
		}

	   
//	   public void validateDropDown(String objLocatorButton, String ObjLocatorDrowpDown,String expectedText)
//		{
//			try
//			{
//				waitTime(2);
//				clickOn(objLocatorButton);
//				getElementAndClick(ObjLocatorDrowpDown, expectedText);
//			}
//			catch (Exception e)
//			{
//				testStepFailed("Exception in the method validateDropDown:"+e.toString());
//			}
//		}
		
	   public boolean elementDisplayed(String objLocator)
		{ 
			boolean status = false;
			WebElement element;
			try {
				element = findWebElement(objLocator);
				if(element.isDisplayed())
				{
					status = true;
				}

			} catch (Exception e) {
				status = false;
			}

			return status;
		}
	   
	   public void validateerrorMessage(String objLocatorButton,String objLocatorText,String expectedText)
	    {
	    	try
	    	{
	    		clickOnButtonValue(objLocatorButton);
	    		String actualText=findWebElement(objLocatorText).getText();
	    		if(actualText.equalsIgnoreCase(expectedText))
	    		{
	    			testStepPassed("Expected condition meets with Actual condition " +actualText);
	    			addValuesToHtmlReport("ErrorMessage", actualText);
	    		}
	    		else
	    		{
	    			testStepFailed("couldn't able to locate the errorMessage");
	    		}
	    	}
	    	catch (Exception e) 
	    	{
	    		 testStepFailed("Exception in the Method validateErrorMessageMobNO"+e.toString());
			}
	    }
	   
	   public void validateSeekBar(String objLocator,double d)
	   {
		   //WebElement seekBar=driver.findElementById("io.appium.android.apis:id/seek");
		   try
		   {
			 //  double percent =percentage / 100;
		   WebElement seekBar= findWebElement(objLocator);

	        //Get start point of seekbar.
	          int startX = seekBar.getLocation().getX();
	          System.out.println(startX);

	         //Get vertical location of seekbar.
	          int startY = seekBar.getLocation().getY();
	          System.out.println(startY);

	          //Get end point of seekbar.
	          int endX = seekBar.getSize().getWidth();
	          System.out.println(endX);

	          //Set seekbar move to position.
	          //endX * 0.6 means at 60% of seek bar width.
	         //endX * 0.9 means at 100% of seek bar width.
	          int moveToXDirectionAt = (int) (endX * d);//0.99
	          System.out.println("Moving seek bar at " + moveToXDirectionAt+" In X direction.");

	          //Moving seekbar using TouchAction class.
	          TouchAction act=new TouchAction((PerformsTouchActions) driver);
	          act.press(PointOption.point(startX,startY)).moveTo(PointOption.point(moveToXDirectionAt,startY)).release().perform();
		   }
		   catch (Exception e) 
			{
				testStepFailed("Exception in the method validateSeekBar: "+e.toString());
			}
	   }
		public void validateExpiryDate(String objLocator, String dateOfExpiry)
		{
			try
			{
				validateDateOfBirth(objLocator, dateOfExpiry);
			}
			catch (Exception e)
			{
				testStepFailed("Exception in the method validateDetails:"+e.toString());
			}
		}
	   
	   public String ExpiryDate()
	   {
		   
		   LocalDate currentDate = LocalDate.now();  
		      LocalDate updatedDate = currentDate.plusMonths(6);  
		      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		     String  formattedDate = updatedDate.format(formatter);  
		      System.out.println("Updated Date: " + formattedDate);  
		      return formattedDate;
	   }
	   
}