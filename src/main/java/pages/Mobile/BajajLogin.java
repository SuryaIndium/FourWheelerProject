package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class BajajLogin extends ApplicationKeywords {

	public BajajLogin(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}
	public static final String txt_menuIcon="menu Icon#xpath=//android.widget.TextView[@content-desc='menu']";
	public static final String img_closeIcon= "Image Close Icon#xpath=//android.widget.TextView[@content-desc='close']";
	public static final String txt_Logout="Text LogOut#xpath=//android.widget.LinearLayout/android.widget.TextView[@text='Click to log out of your account']";
	
public void logOut()
{
	try
	{
		waitTime(5);
		waitForElementToDisplay(txt_menuIcon, 10);
		if(elementDisplayed(txt_menuIcon))
		{
			clickOn(txt_menuIcon);
			verifyElementIsDisplayed(img_closeIcon);
			clickOn(txt_Logout);
		}
	}
	catch (Exception e) 
	{
		testStepFailed("Exception in the method logOut:"+e.toString());
	}
}
	
	
	/*
	     * @author : Meghana M S
	     * 
	     * @created Date : 18-05-2023
	     * Description : The method is used in login page
	     * number Return Value : 
	     * String Purpose  : to login to the application
	     */

	public void login() {
		try {
			waitForElementToDisplay("mobileNumber",10);
			if (isElementDisplayed("mobileNumber")) {
				enterYourMobileNumber();
				clickOnSendOTP();
				testStepPassed("Enter the mobile number and click on ");
			} 
			else
			{
				testStepFailed("couldn't able locate the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Execption in the method login"+e.toString());
		}
	}


	/*
	     * @author : Meghana M S
	     * @created Date : 25-05-2023
	     * Description : The method is used to enter the mobile number
	     * Return Value : 
	     * String Purpose  : Enter the text in the mobile number field.
	     * 
	     */
	public void enterYourMobileNumber()
	{
		String mobileNumber = retrieve("mobileNumber");
		enterTextInField(Constants.enterMobileNumber, mobileNumber);
	}

	/*
     *      * @author : Meghana M S     
     *  * @created Date : 25-05-2023      *
     * Description : The method is used to enter the mobile number      * Return
     * Value :       * String Purpose  : Enter the text in the mobile number field.
     *      *      
     */
    public void enterInvalidMobileNumber()
    {
        String[] invalidValues = { "123456", "7777777777", "987654321"};
        try 
        {
            for (int i = 0; i < invalidValues.length; i++)
            {
                enterTextInField(Constants.enterMobileNumber, invalidValues[i]);
                clickOnSendOTP();
                validateErrorMessage("Please enter valid mobile number.");
                clearTextFromFiled(invalidValues[i]);
            }
            
            String invalidNumber = "9123131311";
            enterTextInField(Constants.enterMobileNumber, invalidNumber);
            clickOnSendOTP();
            validateErrorMessage("ALERT");
            clickOnTextValue("OK");
            clearTextFromFiled(invalidNumber);
        } 
        catch (Exception e) 
        {
            testStepFailed("Error "+e);
        }
    }
    

	/*
	     * @author : Meghana M S
	     * @created Date : 25-05-2023
	     * Description : The method is used to click on send OTP
	     * Return Value : 
	     * String Purpose  : To click on Send OTP.
	     * 
	     */

	public void clickOnSendOTP()
	{
		clickOnButton(Constants.sendOTP);
	}
	

	/*
	     * @author : Meghana M S
	     * @created Date : 25-05-2023
	     * Description : The method is used to click on send OTP
	     * Return Value : 
	     * String Purpose  : To click on Send OTP.
	     * 
	     */


	//==========================================Negative Scenario===================================================
	/*
	     * @author : surya 
	     * @created Date : 25-05-2023
	     * Description : The method is used to validate login screen errorMessage
	     * Return Value : 
	     * String Purpose  : To click on Send OTP.
	     * 
	     */

	public void validateloginErrorMsg()
	{
		try
		{
			String errorMsg = retrieve("errorMessageMobileNo");
			clickOnButton(Constants.sendOTP);
			validateErrorMessage(errorMsg);
			login();
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateloginErrorMsg :" +e.toString());
		}
	}


	public void enterNumStartwithZeroToNine()
	{
		try
		{
			String errorMsg = retrieve("errorMessageMobileNo");
			String ZeroToNineNum = retrieve("EnterZeroToNineMobileNum");

			enterTextInField(Constants.enterMobileNumber, ZeroToNineNum);
			clickOnButton(Constants.sendOTP);
			validateErrorMessage(errorMsg);
			clearEditBox(ZeroToNineNum);


		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method enterNumStartwithZeroToNine:" +e.toString());
		}

	}


	public void enterTextInField(String labelName, String value) {
		try {
			String field = labelName + "#xpath=//android.widget.EditText[@text='" + labelName + "']";
			if (isElementDisplayed(field)) {
				addValuesToHtmlReport(labelName, value);
				typeIn(field, value);
				closeKeyBoard();
			} else {
				testStepFailed(labelName + " field is not present");
			}
		} catch (Exception e) {
			testStepFailed("Failed in enterTextInCustomerProcess " + e.getMessage());
		}
	}

	public void validateLoginScreen()
	{
		try
		{
			String mobileNumber = retrieve("mobileNumber");
			
			waitForElementToDisplay("mobileNumber", 10);
			if(isElementDisplayed("mobileNumber"))
			{
				enterTextBox("mobileNumber", mobileNumber);
				waitTime(2);
				clickOn("sendOTP");
			}
			else
			{
				testStepPassed("couldn't able to locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateLoginScreen:" +e.toString());
		}
	}
	

}
