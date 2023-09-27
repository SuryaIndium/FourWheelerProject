package pages.Mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class EligibilityCheck extends ApplicationKeywords
{
	public EligibilityCheck(RemoteWebDriver driver, BaseClass obj) 
	{
		super(driver, obj);
	}
	
	public static final String refresh_PanCheck="Refresh for PAN check#id=com.bfl.isdcia.dev:id/img_refresh_pan";
	public static final String refresh_Cibil="Refresh Icon for Cibil#id=com.bfl.isdcia.dev:id/img_refresh_cibil";
	public static final String refresh_Debupe= "Refresh Icon for Debupe#id=com.bfl.isdcia.dev:id/img_refresh_deque";
	public static final String refresh_MCP="Refresh Icon for MCP#id=com.bfl.isdcia.dev:id/img_refresh_mcp";
	public static final String refresh_Eligibility="Refresh Icon for Eligibility#id=com.bfl.isdcia.dev:id/img_refresh_eligibility";
	public static final String refresh_SPT="Refresh Icon for SPT#id=com.bfl.isdcia.dev:id/iv_spt_status";
	public static final String label_EligibilityCheck="Title for Eligibility Check#xpath=//android.widget.TextView[@text='Eligibility Check']";
	public static final String number_LANNO="Loan Application Number#id=com.bfl.isdcia.dev:id/tv_loan_application_number";
	public static final String txt_LANNO="Text Loan Application#xpath=//android.widget.TextView[@text='Loan Application Number']";
	public static final String refreshIcon = "refresh icon#xpath=//android.widget.TextView[@resource-id='com.bfl.isdcia.dev:id/menu_item_refresh']";
	
	public static final String txt_EligibilityAmount= "Eligibility Amount#xpath=//android.widget.TextView[@text='Eligibility Amount']";
	public static final String number_EligibilityAmount= "Eligibility Amount#id=com.bfl.isdcia.dev:id/tv_eligibility_amount";
	public static final String txt_GenerateSanctionLetter="Generate In-Principle Sanction Letter#id=com.bfl.isdcia.dev:id/button_generate_letter";
	public static final String EligibilityPageRefreshIcon="Eligibility Page refresh Icon#xpath=//android.widget.TextView[@content-desc='refresh']";
	public static final String Title_InPrincipleSanctionOrProccedButton="Title For InPrinciple Sanction Letter#xpath=//android.widget.TextView[@text='In-Principle Sanction Letter']|//android.widget.Button[@text='PROCEED']";
	

	//Loan EligibilityAwaitiedScreen
	
	public static final String label_LoanEligibilityAwaited = "Title Loan Eligibility Awaited#xpath=//android.view.ViewGroup[@resource-id='com.bfl.isdcia.dev:id/ncf_toolbar']/android.widget.TextView[@text='Loan Eligibility Awaited']";
	public static final String img_LoanEligibilityAwaitedRefresh =" Loan eligibility Refresh ICon#id=com.bfl.isdcia.dev:id/iv_refresh";
	
	
	
	public void validateLoanEligibilityScreen(String objLocator)
	{
		try
		{
			waitTime(10);
			waitForElementToDisplay(label_LoanEligibilityAwaited, 10);
			if(getAttributeValue(img_LoanEligibilityAwaitedRefresh, "clickable").equalsIgnoreCase("true"))
			{
				while(getAttributeValue("btn_Procced", "enabled").equalsIgnoreCase("true"))
				{
					clickOn("btn_Procced");
					waitTime(5);
				}
			}
			else
			{
				testStepFailed("couldn't able to clickable the element");
			}
		}
		catch(Exception e)
		{
			testStepFailed("Exception in the method validateEligibilityCheck" +e.toString());
		}
	}
	
	public void eligibilityCheckForUncheckSTP() {
		

		
		
		String proceedbtn ="Proceed Btn#xpath=//android.widget.Button[@resource-id='com.bfl.isdcia.dev:id/button_proceed']";
		String refreshIcon = "refresh icon#xpath=//android.widget.TextView[@resource-id='com.bfl.isdcia.dev:id/menu_item_refresh']";
		int i = 0;
      do {
    	  waitTime(30);
    	  clickOn(refreshIcon);
    	  waitTime(30);
    	  clickOn(refreshIcon);
    	  waitTime(10);
    	  clickOn(refreshIcon);
    	  i++;  
      }while(i==1 || i==0);
      waitTime(20);
      clickOn(proceedbtn);
      waitTime(10);
	}

	
	public void eligibilityCheck() {
		String GENERATEINPRINCIPLESANCTIONLETTER = "#xpath=//android.widget.Button[@text='GENERATE IN-PRINCIPLE SANCTION LETTER']";
		String popUp = "popUp#xpath=//android.widget.TextView[@text='In-Principle Sanction Letter']";
		String proceed = "proceed#id=com.bfl.isdcia.dev:id/btn_proceed";
		waitForElement(GENERATEINPRINCIPLESANCTIONLETTER, 60);
		if (isElementDisplayed(GENERATEINPRINCIPLESANCTIONLETTER)) {
			clickOn(GENERATEINPRINCIPLESANCTIONLETTER);
			testStepPassed("Clicked on Enhance Offer");
			if (isElementDisplayed(popUp)) {

				clickOn(proceed);
				testStepPassed("Verify the popup and click on Proceed");
			} else {
				testStepFailed("In Principle Sanction letter is no present");
			}

		} else {
			testStepFailed("Enhance Offer btn is not present");
		}
	}
	
	public void validateEligibilityCheck(String objLocator)
	{
		try
		{
			waitForElementToDisplay(objLocator, 10);
			if(getAttributeValue(objLocator, "clickable").equalsIgnoreCase("true"))
			{
				while(getAttributeValue(objLocator, "enabled").equalsIgnoreCase("true"))
				{
					clickOn(objLocator);
				}
			}
			else
			{
				testStepFailed("couldn't able to clickable the element");
			}
		}
		catch(Exception e)
		{
			testStepFailed("Exception in the method validateEligibilityCheck" +e.toString());
		}
	}
	
	public void validateEligibilityCheck()
	{
		try
		{
			waitTime(10);
			if(isElementDisplayed(label_EligibilityCheck))
			{
				validateElementkeyAndValue(txt_LANNO,number_LANNO);
				validateEligibilityCheck(refresh_PanCheck);
				validateEligibilityCheck(refresh_Cibil);
				validateEligibilityCheck(refresh_Debupe);
				validateEligibilityCheck(refresh_MCP);
				validateEligibilityCheck(refresh_Eligibility);
				validateSTPStatusFlow();
				waitTime(10);
				validateElementkeyAndValue(txt_EligibilityAmount,number_EligibilityAmount);
				validateEligibilityType();
				waitTime(10);
			}
			else
			{
				testStepFailed("Couldn't not able locate the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method validateEligibilityCheck" + e.toString());
		}
	}
	
	public void validateSTPStatusFlow()
	{
		try
		{
			if(elementDisplayed(txt_GenerateSanctionLetter))
			{
				clickOn(refreshIcon);
				testStepPassed("STP IS Green Flow");
			}
			else if (elementDisplayed("btn_Procced"))
			{
				clickOn(refreshIcon);
				testStepPassed("STP Is Red Flow");
			}
			else
			{
				testStepFailed("Couldn't not able locate the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method validateEligibilityCheck" + e.toString());
		}
	}
	
	public void validateSanctionLetterSuccessfullyMsg()
	{
		try
		{
			waitForElementToDisplay(Title_InPrincipleSanctionOrProccedButton, 10);
			if(isElementDisplayed(Title_InPrincipleSanctionOrProccedButton))////android.widget.TextView[@text='In Principle Sanction Letter Generated Successfully.']
			{
				clickOnButton(Constants.proceed);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the Method validateSanctionLetterSuccessfullyMsg:" + e.toString());
		}
	}
	
	public void validateEligibilityLetterSummary()
	{
		try
		{
			
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the Method validateEligibilityLetterSummary:" + e.toString());
		}
	}
	
	public void validateEligibilityType()
	{
		String screenType="";
		try
		{
			WebElement element= findWebElement(Title_InPrincipleSanctionOrProccedButton);
		 screenType =element.getText();
		
		switch (screenType) 
		{
		case "GENERATE IN-PRINCIPLE SANCTION LETTER":
			clickOn(txt_GenerateSanctionLetter);
			break;

		default:
			clickOnButton(Constants.proceed);
			break;
		}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method validateEligibilityType:" + e.toString());
		}
	}
	
}
