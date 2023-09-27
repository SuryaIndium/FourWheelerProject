package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class AdditionalDeatails extends ApplicationKeywords{

	public AdditionalDeatails(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}
	public static final String label_AdditionalDetails="Title Additional Details Screen#xpath=//android.widget.TextView[@text='Additional Details']";
	public static final String txt_BusinessVintage= "Business Vintage#id=com.bfl.isdcia.dev:id/businessVintage";
	public static final String txt_DateOfIncorporation ="Date Of Incorporation#id=com.bfl.isdcia.dev:id/et_date_of_incorporation";
	public static final String txt_LoanAmount="Required Loan Amount#id=com.bfl.isdcia.dev:id/et_req_loan_amt";
	public static final String btn_Confirm ="Button Confirm#id=com.bfl.isdcia.dev:id/button_confirm";
	public static final String txt_ErrorMessageValue="Error Message#id=com.bfl.isdcia.dev:id/textinput_error";
	
	public void validateAdditionDetailsSeftEmployedFlow(String businessVintage,String dateOfBirth,String loanAmount)
	{
		try
		{
			waitTime(2);
			waitForElementToDisplay(label_AdditionalDetails, 10);
			if(isElementDisplayed(label_AdditionalDetails))
			{
				enterTextBox(txt_BusinessVintage,businessVintage);
				validateDateOfBirth(txt_DateOfIncorporation,dateOfBirth);
				enterTextBox(txt_LoanAmount,loanAmount);
				clickOnButtonValue(btn_Confirm);
				waitTime(10);
			}
			else
			{
				testStepFailed("coildn't able to locate the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateAdditionDetailsSeftEmployedFlow:"+ e.toString());		
		}
	}
	
	public void validateErrorMessageAdditionDetailsSeftEmployedFlow(String businessVintage,String dateOfBirth,String loanAmount)
	{
		try
		{
			String errorMessageBusinessVintage = retrieve("ErrorMessageBusinessVintage");
			String errorMessageDateOfInCorporation = retrieve("ErrorMessageDateOfInCorporation");
			String errorMessageLoanAmount = retrieve("ErrorMessageLoanAmount");
			
			waitForElementToDisplay(label_AdditionalDetails, 10);
			if(isElementDisplayed(label_AdditionalDetails))
			{
				validateerrorMessage(btn_Confirm,txt_ErrorMessageValue,errorMessageBusinessVintage);
				enterTextBox(txt_BusinessVintage,businessVintage);
				validateerrorMessage(btn_Confirm,txt_ErrorMessageValue,errorMessageDateOfInCorporation);
				validateDateOfBirth(txt_DateOfIncorporation,dateOfBirth);
				clearEditBox(txt_LoanAmount);
				validateerrorMessage(btn_Confirm,txt_ErrorMessageValue,errorMessageLoanAmount);
				enterTextBox(txt_LoanAmount,loanAmount);
				clickOn(btn_Confirm);
			}
			else
			{
				testStepFailed("coildn't able to locate the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateErrorMessageAdditionDetailsSeftEmployedFlow:"+ e.toString());		
		}
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

	public void additionalDeatails() {
		String officemailID = generateName()+"@gmail.com";
		try {
			waitTime(10);
			if(isElementDisplayed("enterYourAdditionalDeatailPage")) {
				enterTextInField(Constants.empName, Constants.officeName);
				clickOn("search");
				clickOn("selectBajaj");

				enterTextInField(Constants.officeMailId, officemailID);
				String loanAmountValue = retrieve("loanAmount");
				enterTextInField(Constants.requires,loanAmountValue);
				String vintageCompanyValue = retrieve("vintageValue");
				enterTextInField(Constants.vintage,vintageCompanyValue);			
				clickOnButton(Constants.validate);
				waitTime(10);
				//clickOnButton(Constants.proceed);
				waitTime(5);
				manualScreenshot();
			}
			else
			{
				testStepFailed("Additional deatils in not present");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method additionalDeatails:"+ e.toString());		
		}
	}
	//==========================================Negative Scenario============================================================

	public void validateErrorMsgAdditionDetails()
	{
		try
		{
			String officemailID = generateName()+"@gmail.com";
			String errorMessageEmailID = retrieve("errorMessageEmailID");
			String errorMessageLoanAmount = retrieve("errorMessageLoanAmount");
			String errorMessageVintage = retrieve("errorMessageVintage");
			String loanAmountValue = retrieve("loanAmount");
			String vintageCompanyValue = retrieve("vintageValue");
			String InvaildWithoutDomain = retrieve("InvaildWithoutDomain");
			String InvalidEmailIDspecialCharacter = retrieve("InvalidEmailIDspecialCharacter");
			String newDomainMail = retrieve("NewDomainEmailID");

			waitTime(10);
			if(isElementDisplayed("enterYourAdditionalDeatailPage")) 
			{
				enterTextInField(Constants.empName, Constants.officeName);
				clickOn("search");
				clickOn("selectBajaj");

				clickOnButton(Constants.validate);
				errorValidationOnFields(errorMessageEmailID);

				validateEmailMissingCharacter( InvaildWithoutDomain,  errorMessageEmailID);//testing@gmail
				validateEmailMissingCharacter( InvalidEmailIDspecialCharacter,  errorMessageEmailID);//testing+gamil.com

				enterTextInField(Constants.officeMailId, newDomainMail);//admin@testing.com
				waitTime(3);
				clearTextFromFiled(newDomainMail);

				enterTextInField(Constants.officeMailId, officemailID);//
				if((officemailID.contains("@"))&&officemailID.contains(".")&&officemailID.contains(".com"))
				{
					testStepPassed("Email contains all special characters"+officemailID);
				}
				else
				{
					testStepFailed("couldn't able to locate Special character");
				}

				clickOnButton(Constants.validate);
				errorValidationOnFields(errorMessageLoanAmount);
				enterTextInField(Constants.requires,loanAmountValue);
				getText("requiredLoanAmounr");

				clickOnButton(Constants.validate);
				errorValidationOnFields(errorMessageVintage);
				enterTextInField(Constants.vintage,vintageCompanyValue);
				getText("vintageInCurrentCompany");

				clickOnButton(Constants.validate);
				waitTime(10);
			//	clickOnButton(Constants.proceed);
				waitTime(5);
				manualScreenshot();
			}
			else 
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateErrorMsgAdditionDetails:"+ e.toString());		
		}
	}

	public void validateEmailMissingCharacter(String invalidEmailID, String errorMessageEmailID)
	{
		try
		{
			enterTextInField(Constants.officeMailId, invalidEmailID);
			errorValidationOnFields(errorMessageEmailID);
			clearTextFromFiled(invalidEmailID);
		}
		catch (Exception e) {
			testStepFailed("Exception in the method validateEmailMissingCharacter:"+ e.toString());		
		}
	}

}
