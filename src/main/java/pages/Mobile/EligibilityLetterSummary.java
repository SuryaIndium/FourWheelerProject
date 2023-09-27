package pages.Mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;

public class EligibilityLetterSummary extends ApplicationKeywords{
	public EligibilityLetterSummary(RemoteWebDriver driver, BaseClass obj) 
	{
		super(driver, obj);
	}
	
	public static final String label_SanctionSummary="Title Sancation Letter Summary#xpath=//android.view.ViewGroup/android.widget.TextView[@text='In-Principle Sanction Letter Summary']";
	public static final String txt_LANNO="Text Loan Application#xpath=//android.widget.TextView[@text='Loan Application Number']";
	public static final String txt_LANNumberValue="LAN VAlue#id=com.bfl.isdcia.dev:id/tvNcfLoanAppNumber";
	public static final String txt_ApprovedLoanAmount ="Approved Loan Amount#xpath=//android.widget.TextView[@text='Approved Loan Amount']";
	public static final String txt_ApprovedLoanAmountValue ="Approved Loan Amount value#id=com.bfl.isdcia.dev:id/tvNcfLoanAppAmount";
	public static final String txt_ApplicantName="Applicant Name#xpath=//android.widget.TextView[@text='Applicant Name']";
	public static final String txt_ApplicantNameValue="Applicant Name Value#id=com.bfl.isdcia.dev:id/tvNcfLoanAppName";
	public static final String txt_PrincipleSanction= "Principle Sanction#xpath=//android.widget.TextView[contains(@text,'In Principle Saction')]";
	public static final String txt_PrincipleSanctionValue= "Principle Sanction Value#id=com.bfl.isdcia.dev:id/tvNcfLoanAppLetterValidity";
	public static final String txt_Tenor="Tenor In Month#xpath=//android.widget.TextView[@text='Tenor (in months)']";
	public static final String txt_TenorValue="Tenor In Month Value#id=com.bfl.isdcia.dev:id/tvNcfLoanAppTenor";
	public static final String txt_StampedRate="Stamped Rate#xpath=//android.widget.TextView[@text='Stamped Rate']";
	public static final String txt_StampedRateValue="Stamped Rate Value#id=com.bfl.isdcia.dev:id/tvNcfLoanAppStampRate";
	public static final String txt_StampedLTV="Text Stamped LTV#id=//android.widget.TextView[@text='Stamped LTV']";
	
	
	public void validateLetterSummary()
	{
		try
		{
			waitForElementToDisplay(label_SanctionSummary, 10);
			if(isElementDisplayed(label_SanctionSummary))
			{
				validateElementkeyAndValue(txt_LANNO,txt_LANNumberValue);
				validateElementEditable(txt_LANNumberValue);
				validateAlphanumeric(txt_LANNumberValue);
				validateElementkeyAndValue(txt_ApprovedLoanAmount,txt_ApprovedLoanAmountValue);
				validateElementEditable(txt_ApprovedLoanAmountValue);
				validateNumeric(txt_ApprovedLoanAmountValue);
				validateElementkeyAndValue(txt_ApplicantName,txt_ApplicantNameValue);
				validateElementEditable(txt_ApplicantNameValue);
				validateAlphabetical(txt_ApplicantNameValue);
				validateElementkeyAndValue(txt_PrincipleSanction,txt_PrincipleSanctionValue);
				validateElementEditable(txt_PrincipleSanctionValue);
				validateElementkeyAndValue(txt_Tenor,txt_TenorValue);
				validateElementEditable(txt_TenorValue);
				validateTenorValue(txt_TenorValue);
				validateElementkeyAndValue(txt_StampedRate,txt_StampedRateValue);
				validateElementEditable(txt_StampedRateValue);
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateLetterSummary:"+e.toString());
		}
	}
	
	public void validateElementEditable(String objLocator)
	{
		try
		{
			if(getAttributeValue(objLocator, "clickable").equalsIgnoreCase("false"))
			{
				testStepPassed("The value is not Editable"+getText(objLocator));
			}
			else
			{
				testStepFailed("The value is Editable");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateElementEditable:"+e.toString());
		}
	}
	
	public void validateAlphanumeric(String objLocator)
	{
		try
		{
			String Alpha = "";
			String number="";
			WebElement element = findWebElement(objLocator);
			String actualText=element.getText();
			for (int i = 0; i < actualText.length(); i++) 
			{
				char textValue=actualText.charAt(i);
				if(Character.isUpperCase(textValue))
				{
					Alpha=Alpha+textValue;
				}
				else if (Character.isDigit(textValue)) {
					number=number+textValue;
				}
				else
				{
					testStepFailed("Given text contains Alphanumeric");
				}
			}
			testStepPassed("Given text contains Alphanumeric" + Alpha+""+number);
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateAlpaNumeric:"+e.toString());
		}
	}
	
	public void validateAlphabetical(String objLocator) {
		try
		{
			String caps ="";
			String small ="";
			WebElement element = findWebElement(objLocator);
			String actualText=element.getText();
			for (int i = 0; i < actualText.length(); i++) 
			{
				char textValue=actualText.charAt(i);
				if(Character.isUpperCase(textValue))
				{
					caps=caps+textValue;
				}
				else if (Character.isLowerCase(textValue)) {
					small=small+textValue;
				}
				else
				{
					testStepFailed("Given text contains Alphabetical");
				}
			}
			testStepPassed("Given text contains Alphabetical" + caps+""+small);
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateAlpaNumeric:"+e.toString());
		}
	}
	
	
	public void validateNumeric(String objLocator) {
		try
		{
			String number="";
			String SpecialCharacter="";
			WebElement element = findWebElement(objLocator);
			String actualText=element.getText();
			for (int i = 0; i < actualText.length(); i++) 
			{
				char textValue=actualText.charAt(i);
				 if (Character.isDigit(textValue)) 
				 {
					number=number+textValue;
				}
				else
				{
					SpecialCharacter=SpecialCharacter+textValue;
					testStepPassed("Given text contains SpecialCharacter");
				
				}
			}
			testStepPassed("Given text contains Numeric"+number+""+SpecialCharacter);
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateAlpaNumeric:"+e.toString());
		}
	}
	
	public void validateTenorValue(String objLocator)
	{
		try
		{
			String number ="";
			WebElement element = findWebElement(objLocator);
			String actualText=element.getText();
			if(actualText.equalsIgnoreCase("96"))
			{
				testStepPassed(actualText +"is Tenor month is Display");
			}
			else
			{
				testStepFailed("Couldn't able locate the element");
			}
			for (int i = 0; i < actualText.length(); i++) 
			{
				char textValue=actualText.charAt(i);
				 if (Character.isDigit(textValue)) 
				 {
					number=number+textValue;
				}
				 else
				 {
					 testStepFailed("Numeric value is not displayed");
				 }
			}
			testStepPassed("Given text contains Numeric"+number);
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateTenorValue:"+e.toString());
		}
	}
}


