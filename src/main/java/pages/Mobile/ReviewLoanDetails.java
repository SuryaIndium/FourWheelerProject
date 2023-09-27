package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class ReviewLoanDetails extends ApplicationKeywords
{

	public ReviewLoanDetails(RemoteWebDriver driver, BaseClass obj) 
	{
		super(driver, obj);
	}
	
	public static final String label_ReviewLoanDetails = "Title Review Loan Details#xpath=//android.widget.TextView[@text='Review Loan Details']";
	public static final String txt_LAN="Text Loan Application Number#xpath=//android.widget.TextView[@text='Loan Application Number']";
	public static final String txt_LANNO="Loan Application Number#xpath=//android.widget.TextView[@resource-id='com.bfl.isdcia.dev:id/tvLoanAppNumber']";
	public static final String txt_EditLoanAmount ="Loan Amount#id=com.bfl.isdcia.dev:id/etAmount";
	public static final String txt_Charges= "Text of Charges#xpath=//android.widget.TextView[@text='Charges']";
	public static final String txt_ChargesTitle = "Title charges Key#id=com.bfl.isdcia.dev:id/tvChargesTitle";
	public static final String txt_ChargesValue = "Title charges Key#id=com.bfl.isdcia.dev:id/tvChargesValue";
	
		
	public void validateReviewLoanScreens(String loanAmount)
	{
		try
		{
			validateReviewLoanDetailsScreenOne(loanAmount);
			validateReviewLoanDetailsSecondScreen();
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateReviewLoanScreens:"+e.toString());
		}
	}
	
		public void validateReviewLoanDetails()
		{
			try
			{
				validateReviewLoanDetailsFirstScreen();
				validateReviewLoanDetailsSecondScreen();
			}
			catch (Exception e)
			{
				testStepFailed("Exception in the method validateReviewLoanDetails:"+e.toString());
			}
		}
		
		public void validateReviewLoanDetailsScreenOne(String loanAmount)
		{
			try
			{
				waitForElementToDisplay(label_ReviewLoanDetails, 10);
				if(isElementDisplayed(label_ReviewLoanDetails,10))
				{
					validateElementkeyAndValue(txt_LAN,txt_LANNO);
					waitTime(5);
					typeIn(txt_EditLoanAmount, loanAmount);
					closeKeyBoard();
					clickOnButtonValue("btn_Procced");
					waitTime(20);
				}
				else
				{
					testStepFailed("couldn't able to locate the element");
				}
			}
			catch (Exception e)
			{
				testStepFailed("Exception in the method validateReviewLoanDetails:"+e.toString());
			}
		}
	
	public void validateReviewLoanDetailsFirstScreen()
	{
		try
		{
			waitForElementToDisplay(label_ReviewLoanDetails, 10);
			if(isElementDisplayed(label_ReviewLoanDetails,10))
			{
				validateElementkeyAndValue(txt_LAN,txt_LANNO);
				String actualAmount=getText(txt_EditLoanAmount);
				testStepPassed(actualAmount+"amount is Displayed");
				clearEditBox(txt_EditLoanAmount);
				typeIn(txt_EditLoanAmount, actualAmount);
				closeKeyBoard();
				clickOnButtonValue("btn_Procced");
				waitTime(20);
			}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateReviewLoanDetails:"+e.toString());
		}
	}
	
	public void validateReviewLoanDetailsSecondScreen()
	{
		try
		{
			waitForElementToDisplay(label_ReviewLoanDetails, 10);
			if(isElementDisplayed(label_ReviewLoanDetails,10))
			{
				validateElementkeyAndValue(txt_LAN,txt_LANNO);
				if(isElementDisplayed(txt_Charges))
				{
					validateElementkeyAndValue(txt_ChargesTitle,txt_ChargesValue);
					clickOnButtonValue("btn_Procced");
					waitTime(20);
				}
				else
				{
					testStepFailed("couldn't able to locate the element");
				}
			
				}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateReviewLoanDetails:"+e.toString());
		}
	}
	
}
