package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class SelectYourProfession  extends ApplicationKeywords{
	
	public SelectYourProfession(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}
	
	
	public static final String btn_search = "search#xpath=//android.widget.Button[@text='SEARCH']";
	public static final String label_selectYourProfession ="Select your profession#xpath=//android.widget.TextView[@text='Select your profession']";
	public static final String btn_OptionValue="Text Option Value#xpath=//android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView";
	public static final String txt_InvalidErrorMessage ="Error Message#xpath=//android.widget.LinearLayout/android.widget.TextView";
	public static final String txt_ProfessionMobileNumber ="MobileNumber#id=com.bfl.isdcia.dev:id/etMobileNumberNcf";
	public static final String txt_ProfessionPANNumber="PAN Number#id=com.bfl.isdcia.dev:id/etPanCardNumberNcf";
	
	
	public void validateSalaryFlow(String salariedText,String vehicleFinanceText,String UsageTypeText)
	{
		try
		{
			if(isElementDisplayed(label_selectYourProfession))
			{
				getElementAndClick(btn_OptionValue, salariedText);
				getElementAndClick(btn_OptionValue, vehicleFinanceText);
				getElementAndClick(btn_OptionValue, UsageTypeText);
				enterTextBox(txt_ProfessionPANNumber,generatePanNumber());
				clickOn(btn_search);
			}
			else
			{
				testStepFailed("couldn't able to locate the select your Profression screen");
			}
		}
		catch (Exception e)
		{	
			testStepFailed("Exception in the Method validateSalaryFlow:" + e.toString());
		}
	}
	
	public void validateSelfEmployed(String selfEmployedText,String vehicleFinanceText,String UsageTypeText,String vechicleNameText)
	{
		try
		{
			waitForElementToDisplay(label_selectYourProfession, 10);
			if(isElementDisplayed(label_selectYourProfession))
			{
				getElementAndClick(btn_OptionValue, selfEmployedText);
				getElementAndClick(btn_OptionValue, vehicleFinanceText);
				getElementAndClick(btn_OptionValue, UsageTypeText);
				getElementAndClick(btn_OptionValue, vechicleNameText);
				enterTextBox(txt_ProfessionPANNumber,generatePanNumber());
				clickOn(btn_search);
			}
			else
			{
				testStepFailed("couldn't able to locate the select your Profression screen");
			}
		}
		catch (Exception e)
		{	
			testStepFailed("Exception in the Method validateSelfEmpolyedFlow:" + e.toString());
		}
	}
	
	

	
	
	//==================================Negative Scenario========================================
	
	/*
	 * @author :Surya
	 * 
	 * @created Date : 25-05-2023 Description : The method is used to Select your Professionpage error Message
	 * select your profession page Return Value :
	 * 
	 */
	
	public void validateSelfEmployedErrorMsg(String selfEmployedText,String vehicleFinanceText,String UsageTypeText,String vechicleNameText,String mobileNumber)
	{
		try
		{
			
			String errorMessageVechileFin = retrieve("errorMessageVechileFin");
			String errorMessageUsageType = retrieve("errorMessageUsageType");
			String errorMessageVechileName =retrieve("errorMessageVechileName");//Please select vehicle in name of.

			String errorMessagePANorMob = retrieve("errorMessagePANOrMob");
			String errorMessageInValidPANNO =retrieve("errorMessagePANNO");//Enter 10 digit Pan Number
			String errorMessageEitherPANAndMobile = retrieve("errorMessageEitherPANAndMobile");//Please enter either Pan number or Mobile number.
			
			waitForElementToDisplay(label_selectYourProfession, 10);
			if(isElementDisplayed(label_selectYourProfession))
			{
				getElementAndClick(btn_OptionValue, selfEmployedText);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageVechileFin);
				
				getElementAndClick(btn_OptionValue, vehicleFinanceText);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageUsageType);
				
				getElementAndClick(btn_OptionValue, UsageTypeText);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageVechileName);
				
				getElementAndClick(btn_OptionValue, vechicleNameText);
				
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessagePANorMob);
				
				enterInvalidMobileNumber();
				inValidPANNO(errorMessageInValidPANNO);
				
				enterTextBox(txt_ProfessionPANNumber,generatePanNumber());
				
				enterTextBox(txt_ProfessionMobileNumber, mobileNumber);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageEitherPANAndMobile);
				clearEditBox(txt_ProfessionMobileNumber);
				closeKeyBoard();
				
				clickOn(btn_search);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateSelfEmployedErrorMsg:"+ e.toString());
		}
	}
	
	public void vaildateErrorMsgProfessionPage(String selfEmployedText,String vehicleFinanceText,String UsageTypeText,String mobileNumber)
	{
		try
		{
			
			String errorMessageVechileFin = retrieve("errorMessageVechileFin");
			String errorMessageUsageType = retrieve("errorMessageUsageType");

			String errorMessagePANorMob = retrieve("errorMessagePANOrMob");
			String errorMessageInValidPANNO =retrieve("errorMessagePANNO");//Enter 10 digit Pan Number
			String errorMessageEitherPANAndMobile = retrieve("errorMessageEitherPANAndMobile");//Please enter either Pan number or Mobile number.
			
			waitForElementToDisplay(label_selectYourProfession, 10);
			if(isElementDisplayed(label_selectYourProfession))
			{
				getElementAndClick(btn_OptionValue, selfEmployedText);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageVechileFin);
				
				getElementAndClick(btn_OptionValue, vehicleFinanceText);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageUsageType);
				
				getElementAndClick(btn_OptionValue, UsageTypeText);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessagePANorMob);
				
				enterInvalidMobileNumber();
				inValidPANNO(errorMessageInValidPANNO);
				
				enterTextBox(txt_ProfessionPANNumber,generatePanNumber());
				
				enterTextBox(txt_ProfessionMobileNumber, mobileNumber);
				validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageEitherPANAndMobile);
				clearEditBox(txt_ProfessionMobileNumber);
				closeKeyBoard();
				
				clickOn(btn_search);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method vaildateErrorMsgProfessionPage:"+ e.toString());
		}
	}
	
	public void inValidPANNO(String errorMessageInValidPANNO)
	{
		try 
		{
			String invalidPANNO = retrieve("InvalidPANNO");		
			enterTextBox(txt_ProfessionPANNumber, invalidPANNO);
			validateerrorMessage(btn_search,txt_InvalidErrorMessage,errorMessageInValidPANNO);
			clearEditBox(txt_ProfessionPANNumber);
			closeKeyBoard();
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method inValidPANNO:"+ e.toString());
		}
	}
	
	
    public void enterInvalidMobileNumber()
    {
        String InvalidMobNO = retrieve("InvalidMobileNumber");
        String errorMessageValidate = retrieve("errorMessageInvalidMob");
        
        String[] InvalidsMobNO = InvalidMobNO.split("##");
        String[] errorMessage = errorMessageValidate.split("##");
        
        try 
        {
            for (int i = 0; i < errorMessage.length; i++)
            {
            	validateErrorMessageMobNO(InvalidsMobNO[i], errorMessage[i]);
            }
        } 
        catch (Exception e) 
        {
            testStepFailed("Exception in the Method enterInvalidMobileNumber"+e.toString());
        }
    }
    
    public void validateErrorMessageMobNO(String Number, String Message)
    {
    	try
    	{
    	 enterTextBox(txt_ProfessionMobileNumber, Number);
         validateerrorMessage(btn_search,txt_InvalidErrorMessage,Message);
         waitTime(2);
         clearEditBox(txt_ProfessionMobileNumber);
         closeKeyBoard();
    	}
    	  catch (Exception e) 
        {
            testStepFailed("Exception in the Method validateErrorMessageMobNO"+e.toString());
        }
    }
	
   
	}
	
