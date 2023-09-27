package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class KYC extends ApplicationKeywords {
	public KYC(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}

	public static final String kycPage = "kyc page#xpath=//android.widget.TextView[@text='KYC']";
	public static final String physical = "physical#xpath=//android.widget.Button[@resource-id='com.bfl.isdcia.dev:id/button_physical']";
	public static final String digilocker = "digilocker#xpath=//android.widget.TextView[@text='Digilocker']";
	
	public void validatekYCScreen()
	{
		try
		{
			waitTime(10);
			 waitForElementToDisplay(kycPage, 10);
				if (isElementDisplayed(kycPage))
				{
					waitTime(10);
					waitForElementToDisplay(digilocker, 10);
					verifyElementIsDisplayed(digilocker);
					clickOnButtonValue(digilocker);
					waitTime(10);
					validatePhysicalKYC();
				}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validatekYCScreen:"+e.toString());
		}
	}
	public void kyc_Page() {

		
		try {
			 waitForElementToDisplay(kycPage, 10);
			if (isElementDisplayed(kycPage))
			{
				waitForElementToDisplay(digilocker, 10);
				verifyElementIsDisplayed(digilocker);
				clickOnTextValue(digilocker);
				waitTime(10);
//				waitForElementToDisplay(physical,10);
//				waitTime(8);
//				clickOnButton(Constants.physicalKYC);
				validatePhysicalKYC();
			} else {
				testStepFailed("KYC page is not present");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validatePhysicalKYC()
	{
		try
		{
			waitForElementToDisplay(physical, 10);
			if(isElementDisplayed(physical))
			{
				getAttributeValue(physical,"enabled").equalsIgnoreCase("true");
				waitTime(10);
				clickOnButtonValue(physical);
				waitTime(10);
			}
			else
			{
				testStepFailed("couldn't able to clickable the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method validatePhysicalKYC" + e.toString());
		}
	}
}
