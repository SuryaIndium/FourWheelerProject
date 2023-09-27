package pages.Mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class RCDeliveryAddress extends ApplicationKeywords {

	public RCDeliveryAddress(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}
	
	public static final String txt_labelRCDeliveryAddress="Title RC Delivery address Screen#xpath=//android.widget.TextView[@text='RC Delivery Address']";
	public static final String txt_AddressTypeRCDelivery="Address Type#id=com.bfl.isdcia.dev:id/et_address_type";
	public static final String txt_AddressTypeOneRC="Address Type One RC Delivery#id=com.bfl.isdcia.dev:id/et_address1";
	public static final String txt_AddressTypeTwoRC="Address Type Two RC Delivery#id=com.bfl.isdcia.dev:id/et_address2";
	public static final String txt_AddressTypeThreeRC="Address Type three RC Delivery#id=com.bfl.isdcia.dev:id/et_address3";
	public static final String txt_PinCodeRCDelivery="PinCode Rc Delivery#id=com.bfl.isdcia.dev:id/et_pincode";
	public static final String txt_CityRCDelivery="City Rc Delivery Address#id=com.bfl.isdcia.dev:id/et_city";
	public static final String txt_StateRCDelivery="State RC Delivery#id=com.bfl.isdcia.dev:id/et_state";
	public static final String txt_DocumentTypeRCDelivery="Document Type RC Delivery#id=com.bfl.isdcia.dev:id/et_kyc_doc_type";
	public static final String txt_DocumentNumberRCDelivery="Document Number RC Delivery#id=com.bfl.isdcia.dev:id/et_doc_num";
	public static final String txt_DocumentExpiryRCdelivery="Document Expiry RC Delivery#id=com.bfl.isdcia.dev:id/et_doc_exp";
	public static final String btn_Submit="Submit Button#id=com.bfl.isdcia.dev:id/button_submit";
	public static final String txt_ErrorMessageValue="Error Message#id=com.bfl.isdcia.dev:id/textinput_error";
	
	public void validateRCDeliveryAddress(String AddressTypeExpectedText,String addressLineOne,String addressLineTwo,String addressLineThree,String zipCode,String CityName,String StateName,String DocumentTypeExpectedText,String DocumentNumebrExpectedText)
	{
		try
		{
			waitTime(10);
			waitForElementToDisplay(txt_labelRCDeliveryAddress, 10);
			if(isElementDisplayed(txt_labelRCDeliveryAddress))
			{
				validateDropDown(txt_AddressTypeRCDelivery,AddressTypeExpectedText);
				enterTextBox(txt_AddressTypeOneRC, addressLineOne);
				enterTextBox(txt_AddressTypeTwoRC, addressLineTwo);
				enterTextBox(txt_AddressTypeThreeRC, addressLineThree);
				enterTextBox(txt_PinCodeRCDelivery, zipCode);
				enterTextBox(txt_CityRCDelivery, CityName);
				enterTextBox(txt_StateRCDelivery, StateName);
				validateDropDown(txt_DocumentTypeRCDelivery,DocumentTypeExpectedText);
				enterTextBox(txt_DocumentNumberRCDelivery, DocumentNumebrExpectedText);
				validateExpiryDate(txt_DocumentExpiryRCdelivery,ExpiryDate());
				navigateTOImageFile("addressUpload","uploadbtn");
				clickOnButtonValue(btn_Submit);
				waitTime(10);
			}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateRCDeliveryAddress:" + e.toString());
		}
	}
	
	public void validateErrorMessageRCDeliveryScreen(String AddressTypeExpectedText,String addressLineOne,String addressLineTwo,String addressLineThree,String zipCode,String CityName,String StateName,String DocumentTypeExpectedText,String DocumentNumebrExpectedText)
	{
		try
		{
			String errorMessageAddressType = retrieve("errorMessageAddressType");
			String errorMessageAddress1 = retrieve("errorMessageAddress1");
			String errorMessageAddress2 = retrieve("errorMessageAddress2");
			String errorMessageAddress3 = retrieve("errorMessageAddress3");
			String errorMessagePinCode = retrieve("errorMessagePinCode");
			String errorMessageCityRC = retrieve("errorMessageCityRC");
			String errorMessageStateRC = retrieve("errorMessageStateRC");
			
			String errorMessageDocumentType = retrieve("errorMessageDocumentType");
			String errorMessageDocumentNumber = retrieve("errorMessageDocumentNumber");
			String errorMessageDocumentExpiry = retrieve("errorMessageDocumentExpiry");
			
			waitTime(10);
			waitForElementToDisplay(txt_labelRCDeliveryAddress, 10);
			if(isElementDisplayed(txt_labelRCDeliveryAddress))
			{
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageAddressType);
				validateDropDown(txt_AddressTypeRCDelivery,AddressTypeExpectedText);
				
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageAddress1);
				enterTextBox(txt_AddressTypeOneRC, addressLineOne);
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageAddress2);
				enterTextBox(txt_AddressTypeTwoRC, addressLineTwo);
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageAddress3);
				enterTextBox(txt_AddressTypeThreeRC, addressLineThree);
				
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageCityRC);
				enterTextBox(txt_CityRCDelivery, CityName);
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageStateRC);
				enterTextBox(txt_StateRCDelivery, StateName);
				
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessagePinCode);
				enterTextBox(txt_PinCodeRCDelivery, zipCode);
				
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageDocumentType);
				validateDropDown(txt_DocumentTypeRCDelivery,DocumentTypeExpectedText);
				
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageDocumentNumber);
				enterTextBox(txt_DocumentNumberRCDelivery, DocumentNumebrExpectedText);
				
				validateerrorMessage(btn_Submit, txt_ErrorMessageValue, errorMessageDocumentExpiry);
				validateExpiryDate(txt_DocumentExpiryRCdelivery,ExpiryDate());
				
				navigateTOImageFile("addressUpload","uploadbtn");
				clickOnButtonValue(btn_Submit);
				waitTime(10);
			}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateErrorMessageRCDeliveryScreen:" + e.toString());
		}
	}
	
	 public void validateerrorMessage(String objLocatorButton,String objLocatorText,String expectedText)
	    {
	    	try
	    	{
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

	public void rcDeliveryAddress(String coApplicantValue) {
		String address1Value = retrieve("address1");
		String address2Value = retrieve("address2");
		String address3Value = retrieve("address3");
		String pincodeValue = retrieve("pinCode");
		String cityValue = retrieve("city");
		String stateValue = retrieve("state");
		String documentTypeValue = retrieve("documentype");

		selectDropdownValue(Constants.addressType, "Office");
		enterTextInField(Constants.addressline1, address1Value);
		enterTextInField(Constants.addressline2, address2Value);
		enterTextInField(Constants.addressline3, address3Value);
		enterTextInField(Constants.PINCode, pincodeValue);
		enterTextInField(Constants.city, cityValue);
		enterTextInField(Constants.state, stateValue);
		selectDropdownValue(Constants.documentType, documentTypeValue);
		enterTextInField(Constants.documentNumber, gen_Five_Digit());
		expiryDate(Constants.documentExpiry);
	//	uploadDocument();
		
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to upload the
	 * identity proof Return Value : String Purpose  :
	 * 
	 * @param :
	 */

	public void uploadDocument() {

		if (isElementDisplayed("addressUpload")) {
			clickOn("addressUpload");
			toSelectTheImage();
			clickOn("uploadbtn");
			waitTime(7);
			manualScreenshot();
			testStepPassed("Upload Document updated succefully");
		} else {
			testStepFailed("Address proof not upadted ");
		}
	}

	// ==========================================Negative
	// Scenario============================================================

	public void RCDeliveryAddressErrorMsg(String coApplicantValue) {
		try {
			String errorMessageAddressType = retrieve("errorMessageAddressType");
			String errorMessageAddress1 = retrieve("errorMessageAddress1");
			String errorMessageAddress2 = retrieve("errorMessageAddress2");
			String errorMessageAddress3 = retrieve("errorMessageAddress3");
			String errorMessageCityRC = retrieve("errorMessageCityRC");
			String errorMessageStateRC = retrieve("errorMessageStateRC");
			String errorMessagePinCode = retrieve("errorMessagePinCode");
			String errorMessageDocumentType = retrieve("errorMessageDocumentType");
			String errorMessageDocumentNumber = retrieve("errorMessageDocumentNumber");
			String errorMessageDocumentExpiry = retrieve("errorMessageDocumentExpiry");

			String address1Value = retrieve("address1");
			String address2Value = retrieve("address2");
			String address3Value = retrieve("address3");
			String pincodeValue = retrieve("pinCode");
			String invalidPinCode = retrieve("InvalidPinCode");
			String cityValue = retrieve("city");
			String stateValue = retrieve("state");
			String documentTypeValue = retrieve("documentype");

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			scrollToElement(errorMessageAddressType);
			errorValidationOnFields(errorMessageAddressType);// Select Address Type
			selectDropdownValue(Constants.addressType, "Office");
			scrollToEnd();

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			scrollToElement(errorMessageAddress1);
			errorValidationOnFields(errorMessageAddress1);
			enterTextInField(Constants.addressline1, address1Value);// Enter Address1
			 scrollToEnd();

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			scrollToElement(errorMessageAddress2);
			errorValidationOnFields(errorMessageAddress2);
			enterTextInField(Constants.addressline2, address2Value);// Enter Address2
			 scrollToEnd();

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			scrollToElement(errorMessageAddress3);
			errorValidationOnFields(errorMessageAddress3);
			enterTextInField(Constants.addressline3, address3Value);// Enter Address3
			 scrollToEnd();

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			scrollToElement(errorMessageCityRC);
			errorValidationOnFields(errorMessageCityRC);// Enter Area
			enterTextInField(Constants.city, cityValue);
			 scrollToEnd();

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			scrollToElement(errorMessageStateRC);
			errorValidationOnFields(errorMessageStateRC);// Enter Landmark
			enterTextInField(Constants.state, stateValue);
			 scrollToEnd();

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			errorValidationOnFields(errorMessagePinCode);// Enter 6 Digit PinCode
			enterTextInField(Constants.PINCode, invalidPinCode);
			validateErrorMessagePinCode();
			enterTextInField(Constants.PINCode, pincodeValue);
			 scrollToEnd();

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			errorValidationOnFields(errorMessageDocumentType);// Select KYC document Type
			selectDropdownValue(Constants.documentType, documentTypeValue);

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			errorValidationOnFields(errorMessageDocumentNumber);// Enter Document number
			enterTextInField(Constants.documentNumber, gen_Five_Digit());

			scrollToElement("SUBMIT");
			clickOnButton(Constants.submit);
			errorValidationOnFields(errorMessageDocumentExpiry);// Enter Document number
			SelectYear();
			//	 expiryDate(Constants.documentExpiry);


			//	clickOnButton(Constants.submit);
			//			validateErrorMessagePinCode();
			//			enterTextInField(Constants.PINCode, pincodeValue);

			//			uploadDocumentMoreThan3MB();
			//			uploadDocument();

			//addressProofMoreThanThreeMB();
			navigateTOImageFile("addressUpload","uploadbtn");
			clickOnButton(Constants.submit);
			waitTime(10);
			add_Applicant(coApplicantValue);

		} catch (Exception e) {
			testStepFailed("Exception in the method RCDeliveryAddressErrorMsg:" + e.toString());
		}
	}
	
	public void validateFieldErrorMessage(String text,String errorMessage)
	{
		try
		{
			scrollToElement(text);
			clickOnButton(text);
			scrollToElement(errorMessage);
			errorValidationOnFields(errorMessage);// Select Address Type
			//selectDropdownValue(Constants.addressType, "Office");
			scrollToEnd();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

	public void validateErrorMessagePinCode() {

		String pincodeValue = retrieve("InvalidPinCode");
		String pincodeErrorMessage = retrieve("errorMessagePinCode");
		errorValidationOnFields(pincodeErrorMessage);
		clearTextFromFiled(pincodeValue);
		//clickOn("city");

	}

	public void SelectYear() {

		// String dateOfBirthValue = retrieve("dateOfBirth");
		String yearValue = "2026";
		clickOn("ExpiryDocumentDate");
		//clickOnTextValue(Constants.documentExpiry);
		if (isElementDisplayed("year")) {
			clickOn("year");
			clickOnTextValue(yearValue);
			String value = getText("year");
			verifyTwoValues(yearValue, value);
			selectMonthandDate();

		} else {
			testStepFailed("Year is not present");
		}

	}

	public void selectMonthandDate() {

		clickOn("date");
		clickOnButton("OK");

	}

	public void uploadDocumentMoreThan3MB() {

		try {
			if (isElementDisplayed("addressUpload")) {
				clickOn("addressUpload");
				waitTime(3);
				//	driver.findElement(By.xpath("//android.widget.CompoundButton[@text='Images']")).click();
				waitTime(3);
				driver.findElement(By.xpath("//android.widget.TextView[@text='Upload.pdf']")).click();
				validateErrorMessage("File size exceed 3MB");
			} else {
				testStepFailed("More than 3MB file Updated ");
			}
		} catch (Exception e) {
			testStepFailed("error in the RC deatils upload the file more then 3 mb "+e);
		}
	}
}
