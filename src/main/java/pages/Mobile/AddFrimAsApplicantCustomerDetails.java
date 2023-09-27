package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;

public class AddFrimAsApplicantCustomerDetails extends ApplicationKeywords
{

	public AddFrimAsApplicantCustomerDetails(RemoteWebDriver driver, BaseClass obj) 
	{
		super(driver, obj);
	}

	public static final String customerDetailsPage = "Customer Details Page#xpath=//android.widget.TextView[@text='Customer Details']";
	public static final String txt_AddFirmAsApplicant="Add Firm As Applicant#xpath=//android.widget.TextView[@text='Add Firm as Applicant']";
	public static final String txt_AddFirmApplicantType="Applicant Type#id=com.bfl.isdcia.dev:id/tv_ncfApplicantType";
	public static final String txt_AddFirmAddressType="AddressType#id=com.bfl.isdcia.dev:id/tv_ncfaddressType";
	public static final String txt_AddFirmEntireName="Address Line One#id=com.bfl.isdcia.dev:id/et_entity_name";
	public static final String txt_AddFirmAddressLineOne="Address Line One#id=com.bfl.isdcia.dev:id/tv_address_line1";
	public static final String txt_AddFirmAddressLineTwo="Address Line Two#id=com.bfl.isdcia.dev:id/tv_address_line2";
	public static final String txt_AddFirmAddressLineThree="Address Line Three#id=com.bfl.isdcia.dev:id/tv_address_line3";
	public static final String txt_AddFirmPicode="PinCode Number#id=com.bfl.isdcia.dev:id/edt_zipcode";
	public static final String txt_AddFirmCity="City Name#id=com.bfl.isdcia.dev:id/tv_city";
	public static final String txt_AddFirmState="State Name#id=com.bfl.isdcia.dev:id/tv_state";
	public static final String txt_AddFirmDocumentType="Document Type#id=com.bfl.isdcia.dev:id/tv_document_type";
	public static final String txt_AddFirmDocumentExpiry="Document Expiry Date#xpath=//android.widget.EditText[@resource-id='com.bfl.isdcia.dev:id/et_expiry_date']";
	public static final String txt_AddFirmDocumentNumber="Document Number#id=com.bfl.isdcia.dev:id/tv_document_number";
	public static final String img_AddFirmFileAttach="File Attach#id=com.bfl.isdcia.dev:id/img_ncf_attach";
	public static final String img_AddFirmFileUpload="File upload#id=com.bfl.isdcia.dev:id/tv_upload_doc";
	public static final String btn_Submit="Submit Button#id=com.bfl.isdcia.dev:id/button_submit";
	public static final String txt_ErrorMessageValue="Error Message#id=com.bfl.isdcia.dev:id/textinput_error";



	
	public void validateAddFirmAsApplicant(String addressType,String addressLineOne, String addressLineTwo,String addressLineThree,String zipCode,String cityName,String stateName,String DocumentTypeExpectedText, String DocumentNumebrExpectedText)
	{
		try
		{
			waitTime(10);
			
			waitForElementToDisplay(customerDetailsPage, 10);
			if(isElementDisplayed(customerDetailsPage))
			{
//				validateDefaultValue(txt_AddFirmApplicantType);
//				validateDefaultValue(txt_AddFirmAddressType);
//				validateDefaultValue(txt_AddFirmEntireName);
//				validateDefaultValue(txt_AddFirmAddressLineOne);
//				validateDefaultValue(txt_AddFirmAddressLineTwo);
//				validateDefaultValue(txt_AddFirmAddressLineThree);
//				validateDefaultValue(txt_AddFirmPicode);
//				validateDefaultValue(txt_AddFirmCity);
//				validateDefaultValue(txt_AddFirmState);
//				validateDefaultValue(txt_AddFirmDocumentType);
//				validateDefaultValue(txt_AddFirmDocumentExpiry);
//				validateDefaultValue(txt_AddFirmDocumentNumber);
//				navigateTOImageFile(img_AddFirmFileAttach,img_AddFirmFileUpload);
//				clickOnButtonValue(btn_Submit);
				
				validateDropDown(txt_AddFirmAddressType,addressType);
				getText(txt_AddFirmEntireName);
				enterTextBox(txt_AddFirmAddressLineOne, addressLineOne);
				enterTextBox(txt_AddFirmAddressLineTwo, addressLineTwo);
				enterTextBox(txt_AddFirmAddressLineThree,addressLineThree);
				enterTextBox(txt_AddFirmPicode, zipCode);
				enterTextBox(txt_AddFirmCity, cityName);
				enterTextBox(txt_AddFirmState, stateName);
				validateDropDown(txt_AddFirmDocumentType,DocumentTypeExpectedText);
				validateExpiryDate(txt_AddFirmDocumentExpiry,ExpiryDate());
				enterTextBox(txt_AddFirmDocumentNumber, DocumentNumebrExpectedText);
				navigateTOImageFile(img_AddFirmFileAttach,img_AddFirmFileUpload);
				clickOnButtonValue(btn_Submit);
				add_Applicant("YES");
			}
		}
		catch (Exception e) {
			testStepFailed("Exception in the method validateRCDeliveryAddress:" + e.toString());
		}
	}
	
	public void validateErrorMesageAddFirmAsApplicant(String addressType,String addressLineOne, String addressLineTwo,String addressLineThree,String zipCode,String cityName,String stateName,String DocumentTypeExpectedText, String DocumentNumebrExpectedText)
	{
		try
		{
			String errorMessageAddressTypeValue = retrieve("ErrorMessageAddressTypeValue");//Select Address Type
			String errorMessageAddress1 = retrieve("errorMessageAddress1");
			String errorMessageAddress2 = retrieve("errorMessageAddress2");
			String errorMessageAddress3 = retrieve("errorMessageAddress3");
		//	String errorMessagePinCode = retrieve("errorMessagePinCode");
			String errorMessageCity = retrieve("errorMessageCity");
			String errorMessageState = retrieve("errorMessageState");
			String errorMessageDocumentTypeAddFirm = retrieve("ErrorMessageDocumentType");
			String errorMessageDocumentNumber = retrieve("errorMessageDocumentNumber");
			
			waitTime(10);
			waitForElementToDisplay(customerDetailsPage, 10);
			if(isElementDisplayed(customerDetailsPage))
			{
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageAddressTypeValue);
				validateDropDown(txt_AddFirmAddressType,addressType);
				
				getText(txt_AddFirmEntireName);
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageAddress1);
				enterTextBox(txt_AddFirmAddressLineOne, addressLineOne);
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageAddress2);
				enterTextBox(txt_AddFirmAddressLineTwo, addressLineTwo);
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageAddress3);
				enterTextBox(txt_AddFirmAddressLineThree,addressLineThree);
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageCity);
				enterTextBox(txt_AddFirmPicode, zipCode);
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageCity);
				enterTextBox(txt_AddFirmCity, cityName);
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageState);
				enterTextBox(txt_AddFirmState, stateName);
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageDocumentTypeAddFirm);
				validateDropDown(txt_AddFirmDocumentType,DocumentTypeExpectedText);
				validateExpiryDate(txt_AddFirmDocumentExpiry,ExpiryDate());
				validateerrorMessage(btn_Submit,txt_ErrorMessageValue,errorMessageDocumentNumber);
				enterTextBox(txt_AddFirmDocumentNumber, DocumentNumebrExpectedText);
				navigateTOImageFile(img_AddFirmFileAttach,img_AddFirmFileUpload);
				clickOnButtonValue(btn_Submit);
				add_Applicant("YES");
			}
		}
		catch (Exception e) {
			testStepFailed("Exception in the method validateRCDeliveryAddress:" + e.toString());
		}
	}
	
	 public void validateerrorMessage(String objLocatorButton,String objLocatorText,String expectedText)
	    {
	    	try
	    	{
	    		scrollToEnd();
	    		scrollToElement("SUBMIT");
	    		clickOnButtonValue(objLocatorButton);
	    		scrollToElement(expectedText);
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
	
	public void validateDefaultValue(String objLocator)
	{
		try
		{
			waitForElementToDisplay(objLocator, 10);
			if(isElementDisplayed(objLocator))
			{
				String defaultValue=getText(objLocator);
				addValuesToHtmlReport("Default Value Present in", defaultValue);
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateDefaultValue:" + e.toString());
		}
	}
}
