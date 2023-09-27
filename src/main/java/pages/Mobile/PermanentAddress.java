package pages.Mobile;


import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class PermanentAddress extends ApplicationKeywords {

	public PermanentAddress(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}

	String firstNameValue = null;

	public static final String txt_MotherFirstName="Mother First Name#id=com.bfl.isdcia.dev:id/et_mother_first_name";
	public static final String txt_MotherMiddleName="Mother Middle Name#id=com.bfl.isdcia.dev:id/et_mother_middle_name";
	public static final String txt_MotherLastName="Mother Last Name#id=com.bfl.isdcia.dev:id/et_mother_last_name";
	public static final String txt_GenderPermanentAddress="Gender Permanent Address#id=com.bfl.isdcia.dev:id/et_gender";
	public static final String txt_DOBPermanentAddress="Date of Brith#id=com.bfl.isdcia.dev:id/edt_dob";
	public static final String txt_PermanentAddressLineOne="Address Line One#id=com.bfl.isdcia.dev:id/et_address1";
	public static final String txt_PermanentAddressLineTwo="Address Line Two#id=com.bfl.isdcia.dev:id/et_address2";
	public static final String txt_PermanentAddressLineThree="Address Line Three#id=com.bfl.isdcia.dev:id/et_address3";
	public static final String txt_PermanentAddressZIPCode="Zip Code#id=com.bfl.isdcia.dev:id/et_zipcode";
	public static final String txt_PermanentAddressCity="City Field#id=com.bfl.isdcia.dev:id/et_city";
	public static final String txt_PermanentAddressState="State Field#id=com.bfl.isdcia.dev:id/et_state";
	public static final String txt_PermanentAddressDocumentType="Address Document Type#id=com.bfl.isdcia.dev:id/et_kyc_doc_type";
	public static final String txt_PermanentAddressDocumentNumber="Address Document Number#id=com.bfl.isdcia.dev:id/et_doc_num";
	public static final String txt_PermanentAddressDocumentExpiry="Address document Expiry#id=com.bfl.isdcia.dev:id/et_doc_exp";
	public static final String txt_IdentityDocumentType="Identity Document Type#id=com.bfl.isdcia.dev:id/et_identy_doc_type";
	public static final String txt_IdentityDocumentExpiry="Identity Document Expiry#id=com.bfl.isdcia.dev:id/et_identity_doc_exp";
	public static final String txt_MartialStatus="Marital Status#id=com.bfl.isdcia.dev:id/et_marital_status";
	public static final String txt_GrossAnnualIncome="Gross Annual Income#id=com.bfl.isdcia.dev:id/et_gross_income";
	public static final String txt_NatureOfBusiness="Nature Of Business#id=com.bfl.isdcia.dev:id/et_nature_of_business";
	public static final String btn_RCDeliveryAddress="Button RC Delivery Address#id=com.bfl.isdcia.dev:id/ncf_btn_rc_delivery";
	public static final String txt_ErrorMessageValue="Error Message#id=com.bfl.isdcia.dev:id/textinput_error";



	
	public void validatePermentantAddressScreen(String motherFirstName,String motherMiddletName,String motherLastName,String addressLineOne,String addressLineTwo,String addressLineThree,
			String zipCode,String CityName,String StateName,String DocumentTypeExpectedText,String DocumentNumber,String IdentityTypeExpectedText,String martialStatusExpectedText,String GrossAnnualIncomeExpectedText,String NatureOfBusinessExpectedText)
	{
		try
		{
			waitTime(10);
			waitForElementToDisplay("Title_PermanentScreen", 10);
			if(isElementDisplayed("Title_PermanentScreen"))
			{
			//	validateDefaultValue();
				enterTextBox(txt_MotherFirstName, motherFirstName);
				enterTextBox(txt_MotherMiddleName, motherMiddletName);
				enterTextBox(txt_MotherLastName, motherLastName);
				validateGenderDropDown();
				waitTime(2);
//				SelectYear("PermantentScreen_dateOFBirth");
//				changeTheDate("PermantentScreen_dateOFBirth");
				enterTextBox(txt_PermanentAddressLineOne, addressLineOne);
				enterTextBox(txt_PermanentAddressLineTwo, addressLineTwo);
				enterTextBox(txt_PermanentAddressLineThree, addressLineThree);
				enterTextBox(txt_PermanentAddressZIPCode, zipCode);
				enterTextBox(txt_PermanentAddressCity, CityName);
				enterTextBox(txt_PermanentAddressState, StateName);
				validateDropDown(txt_PermanentAddressDocumentType,DocumentTypeExpectedText);//OVD-Driving Licence
				enterTextBox(txt_PermanentAddressDocumentNumber, DocumentNumber);
				validateExpiryDate(txt_PermanentAddressDocumentExpiry,ExpiryDate());
				validateDropDown(txt_IdentityDocumentType,IdentityTypeExpectedText);//Partnership Deed
				validateDropDown(txt_MartialStatus,martialStatusExpectedText);//Single
				validateDropDown(txt_GrossAnnualIncome,GrossAnnualIncomeExpectedText);//Less than 5 Lakhs
				validateDropDown(txt_NatureOfBusiness,NatureOfBusinessExpectedText);//Services
				
				scrollToElement("RC DELIVERY ADDRESS");
				navigateTOImageFile("addressUpload","addressuploadbtn");
				navigateTOImageFile("identityUpload","identityUploadbtn");
				
				clickOnButtonValue(btn_RCDeliveryAddress);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateDetails:"+e.toString());
		}
	}
	
	public void validateErrorMessagePermanentScreen(String motherFirstName,String motherMiddletName,String motherLastName,String addressLineOne,String addressLineTwo,String addressLineThree,
			String zipCode,String CityName,String StateName,String DocumentTypeExpectedText,String DocumentNumber,String IdentityTypeExpectedText,String martialStatusExpectedText,String GrossAnnualIncomeExpectedText,String NatureOfBusinessExpectedText)
	{
		try
		{
			waitTime(10);
			String errorMessageMotherFirstName = retrieve("errorMessageMotherFirstName");
			String errorMessageMotherLastName = retrieve("errorMessageMotherLastName");
			String errorMessageAddress1 = retrieve("errorMessageAddress1");
			String errorMessageAddress2 = retrieve("errorMessageAddress2");
			String errorMessageAddress3 = retrieve("errorMessageAddress3");

			String errorMessagePinCode = retrieve("errorMessagePinCode");
			String errorMessageCity = retrieve("errorMessageCity");
			String errorMessageState = retrieve("errorMessageState");
			
			String errorMessageDocumentType = retrieve("errorMessageDocumentType");
			String errorMessageDocumentNumber = retrieve("errorMessageDocumentNumber");
			String errorMessageDocumentExpiry = retrieve("errorMessageDocumentExpiry");
			String errorMessageIdentityDocumentType = retrieve("errorMessageIdentityDocumentType");
			String errorMessageMaritalStatus = retrieve("errorMessageMaritalStatus");
			String errorMessageGrossIncome = retrieve("errorMessageGrossIncome");
			String errorMessageNatureBusiness = retrieve("errorMessageNatureBusiness");
			
			waitForElementToDisplay("Title_PermanentScreen", 10);
			if(isElementDisplayed("Title_PermanentScreen"))
			{
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageMotherFirstName);
				enterTextBox(txt_MotherFirstName, motherFirstName);
				enterTextBox(txt_MotherMiddleName, motherMiddletName);
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageMotherLastName);
				enterTextBox(txt_MotherLastName, motherLastName);
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageAddress1);
				enterTextBox(txt_PermanentAddressLineOne, addressLineOne);
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageAddress2);
				enterTextBox(txt_PermanentAddressLineTwo, addressLineTwo);
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageAddress3);
				enterTextBox(txt_PermanentAddressLineThree, addressLineThree);
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessagePinCode);
				enterTextBox(txt_PermanentAddressZIPCode, zipCode);
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageCity);
				enterTextBox(txt_PermanentAddressCity, CityName);
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageState);
				enterTextBox(txt_PermanentAddressState, StateName);
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageDocumentType);
				validateDropDown(txt_PermanentAddressDocumentType,DocumentTypeExpectedText);//OVD-Driving Licence
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageDocumentNumber);
				//scrollToElement(StateName);
				enterTextBox(txt_PermanentAddressDocumentNumber, DocumentNumber);
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageDocumentExpiry);
			//	scrollToElement(StateName);
				validateExpiryDate(txt_PermanentAddressDocumentExpiry,ExpiryDate());
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageIdentityDocumentType);
				validateDropDown(txt_IdentityDocumentType,IdentityTypeExpectedText);//Partnership Deed
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageMaritalStatus);
				validateDropDown(txt_MartialStatus,martialStatusExpectedText);//Single
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageGrossIncome);
				validateDropDown(txt_GrossAnnualIncome,GrossAnnualIncomeExpectedText);//Less than 5 Lakhs
				
				validateErrorMessageTextField(btn_RCDeliveryAddress,txt_ErrorMessageValue,errorMessageNatureBusiness);
				validateDropDown(txt_NatureOfBusiness,NatureOfBusinessExpectedText);//Services
				
				clickOn("CheckBox_RCDelivery");
				ValidateFieldEnableAndDisableStatus(Constants.proceedWithEKYC,"true");
				ValidateFieldEnableAndDisableStatus(Constants.rcDeliveryAddress,"false");
				clickOn("CheckBox_RCDelivery");
				ValidateFieldEnableAndDisableStatus(Constants.rcDeliveryAddress,"true");
				ValidateFieldEnableAndDisableStatus(Constants.proceedWithEKYC,"false");
				addressProofMoreThanThreeMB();
				waitTime(3);
				identityProofMoreThanThreeMB();
				clickOnButtonValue(btn_RCDeliveryAddress);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateErrorMessagePermanentScreen:"+e.toString());
		}
	}
	
	public void validateErrorMessage(String objLocatorButton,String objLocatorText,String expectedText)
	{
		try
		{
			
			validateerrorMessage(objLocatorButton,objLocatorText,expectedText);
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateErrorMessage:"+ e.toString());
		}
	}
	
	public void validateErrorMessageTextField(String objLocatorButton, String objLocatorText ,String expectedText)
	{
		try
		{
		scrollToEnd();
		scrollToElement("RC DELIVERY ADDRESS");
		clickOnButtonValue(objLocatorButton);
		scrollToUp();
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
			testStepFailed("Exception in the method validateErrorMessageTextField:"+ e.toString());
		}
	}



	public void permanent_Address() 
	{
		try
		{

			String address1 = "Pune";
			String zipCode = "411014";
			String addressDocumentTypeValue = retrieve("documentype");
			String identityDocumentTypeValue = retrieve("identitytype");
			String maritalValue = retrieve("maritalstatus");
			String grossAnnualIncomeValue = retrieve("grossAnnualIncome");
			String natureOfBusinessValue = retrieve("natureOfBusiness");

			waitTime(5);
			waitForElementToDisplay("Title_PermanentScreen", 10);
			if(isElementDisplayed("Title_PermanentScreen"))

			{
				enterMotherFirstName();
				enterMotherMiddleName();
				enterMotherLastName();  
				enterAddress1(Constants.addressline1);
				enterAddress2(Constants.addressline2);
				enterAddress3(Constants.addressline3);

				enterTextInField(Constants.zipcode, zipCode);
				enterTextInField(Constants.city, address1);
				enterTextInField(Constants.state,address1);
//
//				validateDropDown("btn_DocumentType", "dropDownValue", addressDocumentTypeValue);
//				enterTextInField(Constants.addressDocumentNumber, gen_Five_Digit());
//				expiryDate(Constants.addressDocumentExpiry);
//
//				validateDropDown("btn_IdentityDocumentType", "dropDownValue", identityDocumentTypeValue);
//
//				scrollToElement(Constants.maritalStatus);
//				validateDropDown("btn_MaritalStatus", "dropDownValue", maritalValue);
//
//				scrollToElement(Constants.grossAnnualIncome);
//				validateDropDown("btn_GrossIncome", "dropDownValue", grossAnnualIncomeValue);
//
//				scrollToElement(Constants.natureOfBusiness);
//				validateDropDown("btn_NatureofBusiness", "dropDownValue", natureOfBusinessValue);

				scrollToElement("RC DELIVERY ADDRESS");

				navigateTOImageFile("addressUpload","addressuploadbtn");
				navigateTOImageFile("identityUpload","identityUploadbtn");

				clickOnButton(Constants.rcDeliveryAddress);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateDetails:"+e.toString());
		}
	}




	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * first name number Return Value : String Purpose  : Enter the text in the
	 * field.
	 * 
	 * @param : Passing the field name
	 */

	public void enterFirstName(String fieldName) {
		firstNameValue = generateName();
		enterTextInField(fieldName, firstNameValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * middle name number Return Value : String Purpose  : Enter the text in the
	 * field.
	 * 
	 * @param : Passing the field name
	 */
	public void enterMiddleName(String fieldName) {
		String middleNameValue = "lolo";
		enterTextInField(Constants.middleName, middleNameValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the last
	 * name number Return Value : String Purpose  : Enter the text in the field.
	 * 
	 * @param : Passing the field name
	 */
	public void enterLastName(String fieldName) {
		String lastNameValue = "Bhachan";
		enterTextInField(Constants.lastName, lastNameValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * Mother first name number Return Value : String Purpose  : Enter the text in
	 * the field.
	 * 
	 * @param :
	 */

	public void enterMotherFirstName() 
	{
		String montherName = generateName();
		typeIn("motherFirstName", montherName);
		closeKeyBoard();
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * mother middle name number Return Value : String Purpose  : Enter the text in
	 * the field.
	 * 
	 * @param :
	 */
	public void enterMotherMiddleName() {
		String motherMiddleNameValue = "lolo";
		typeIn("mothermiddleName", motherMiddleNameValue);
		closeKeyBoard();
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * Mother last name number Return Value : String Purpose  : Enter the text in
	 * the field.
	 * 
	 * @param :
	 */
	public void enterMotherLastName() {
		String lastNameValue = "Bhachan";
		typeIn("motherlastName", lastNameValue);
		closeKeyBoard();
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to Enter the date
	 * of birth number Return Value : String Purpose  : enter the date of birth
	 * 
	 * @param : Passing the field name and field value
	 */

	public void enterDateOfBirth(String fieldName, String fieldValue) {
		enterDateOfBirth(fieldName, fieldValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to select the
	 * Gender dropdown. number Return Value : String Purpose  : select the dropdown
	 * 
	 * @param : Passing the field name and field value
	 */
	public void enterGender(String fieldName, String fieldValue) {
		selectDropdownValue(fieldName, fieldValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the Address1
	 *  Return Value : 
	 *  String Purpose  : Enter the text in the
	 * field.
	 * 
	 * @param : Passing the field name
	 */


	public void enterAddress1(String fieldName) {
		scrollToElement(fieldName);
		String address1 = retrieve("address1");
		enterTextInField(fieldName, address1);

	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023
	 * Description : The method is used to enter the address2
	 *  Return Value : String Purpose  : Enter the text in the
	 * field.
	 * 
	 * @param : Passing the field name
	 */
	public void enterAddress2(String fieldName) {
		String address2 = retrieve("address2");
		enterTextInField(fieldName, address2);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023
	 *  Description : The method is used to enter the address3
	 *Return Value : 
	 *String Purpose  : Enter the text in the field.
	 * @param : Passing the field name
	 */
	public void enterAddress3(String fieldName) {
		String address3 = retrieve("address3");
		enterTextInField(fieldName, address3);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023
	 *  Description : The method is used to upload the address proof
	 *Return Value : 
	 *String Purpose  : 
	 * @param : 
	 */
	public void addressProof() {

		if (isElementDisplayed("addressUpload")) {
			clickOn("addressUpload");
			waitTime(3);
			toSelectTheImage();
			clickOn("addressuploadbtn");
			waitTime(7);
			manualScreenshot();
			addValuesToHtmlReport("Address proof ", "Updated");
		} else {
			testStepFailed("Address proof not upadted ");
		}

	}
	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023
	 *  Description : The method is used to upload the identity proof
	 *Return Value : 
	 *String Purpose  : 
	 * @param : 
	 */
	public void identityProof() {

		if (isElementDisplayed("identityUpload")) 
		{
			clickOn("identityUpload");
			waitTime(3);
			toSelectTheImage();
			clickOn("identityUploadbtn");
			waitTime(7);
			manualScreenshot();
			addValuesToHtmlReport("Identity Proof ", "Updated");
		} else {
			testStepFailed("Identity Proof not upadted ");
		}
	}
	
	public void validateTextDefaultValue(String objLocator)
	{
		try
		{
			waitForElementToDisplay(objLocator, 10);
			if(isElementDisplayed(objLocator))
			{
				verifyElementIsDisplayed(objLocator);
				String value= getText(objLocator);
				clearTextFromFiled(value);
				typeIn(objLocator, value);
				closeKeyBoard();
				addValuesToHtmlReport("Default Value Is", value);
			}
			
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateDefaultValue "+e.toString());
		}
	}

	public void validateDefaultValue()
	{
		try
		{
			validateTextDefaultValue("txt_firstName");
			validateTextDefaultValue("txt_MiddleName");
			validateTextDefaultValue("txt_LastName");

				verifyElementIsDisplayed("txt_Address1");
				getText("txt_Address1");
				verifyElementIsDisplayed("txt_Address2");
				getText("txt_Address2");
				verifyElementIsDisplayed("txt_Address3");
				getText("txt_Address3");

			
			
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateDefaultValue "+e.toString());
		}
	}



	//==========================================Negative Scenario============================================================

	public void ErrorMsgPermanentPage()
	{
		try
		{
			String address1 = "Pune";
			String zipCode = "411014";

			String addressDocumentTypeValue = retrieve("documentype");
			String identityDocumentTypeValue = retrieve("identitytype");
			String maritalValue = retrieve("maritalstatus");
			String grossAnnualIncomeValue = retrieve("grossAnnualIncome");
			String natureOfBusinessValue = retrieve("natureOfBusiness");

			String errorMessageMotherFirstName = retrieve("errorMessageMotherFirstName");
			String errorMessageMotherLastName = retrieve("errorMessageMotherLastName");

			String errorMessageAddress1 = retrieve("errorMessageAddress1");
			String errorMessageAddress2 = retrieve("errorMessageAddress2");
			String errorMessageAddress3 = retrieve("errorMessageAddress3");

			String InvalidZipCode = retrieve("InvalidZipCode");
			String errorMessagePinCode = retrieve("errorMessagePinCode");
			String errorMessageCity = retrieve("errorMessageCity");
			String errorMessageState = retrieve("errorMessageState");
			String errorMessageDocumentType = retrieve("errorMessageDocumentType");
			String errorMessageDocumentNumber = retrieve("errorMessageDocumentNumber");
			String errorMessageDocumentExpiry = retrieve("errorMessageDocumentExpiry");
			String errorMessageIdentityDocumentType = retrieve("errorMessageIdentityDocumentType");
			String errorMessageMaritalStatus = retrieve("errorMessageMaritalStatus");
			String errorMessageGrossIncome = retrieve("errorMessageGrossIncome");
			String errorMessageNatureBusiness = retrieve("errorMessageNatureBusiness");

			waitTime(10);
			validateDefaultValue();

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);//Enter Mother's First Name
			scrollToElement(errorMessageMotherFirstName);
			validateErrorMessages("errorMessage",errorMessageMotherFirstName);
			enterMotherFirstName();

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress); 
			scrollToElement(errorMessageMotherLastName);
			validateErrorMessages("errorMessage",errorMessageMotherLastName); //Enter Mother's Last Name
			enterMotherLastName();

			validateGenderDropDown();
			waitTime(2);
			SelectYear("PermantentScreen_dateOFBirth");
			changeTheDate("PermantentScreen_dateOFBirth");

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress); 
			scrollToElement(errorMessageAddress1);
			errorValidationOnFields(errorMessageAddress1);//Enter Address1
			enterAddress1(Constants.addressline1);

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);        
			errorValidationOnFields(errorMessageAddress2);//Enter Address2
			enterAddress2(Constants.addressline2);

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);        
			errorValidationOnFields(errorMessageAddress3);//Enter Address3
			enterAddress3(Constants.addressline3);

			scrollToElement(Constants.zipcode);
			enterTextInField(Constants.zipcode, InvalidZipCode);
			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);
			scrollToElement(errorMessagePinCode);
			errorValidationOnFields(errorMessagePinCode); //Enter 6 Digit PinCode
			clearTextFromFiled(InvalidZipCode);
			scrollToEnd();

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);
			scrollToElement(errorMessagePinCode);
			errorValidationOnFields(errorMessagePinCode); //Enter 6 Digit PinCode
			waitTime(2);
			enterTextInField(Constants.zipcode, zipCode);
			scrollToEnd();

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress); 
			scrollToElement(errorMessageCity);
			errorValidationOnFields(errorMessageCity); //Enter City Name
			enterTextInField(Constants.city, address1); 
			scrollToEnd();

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress); 
			scrollToElement(errorMessageState);
			errorValidationOnFields(errorMessageState); 
			enterTextInField(Constants.state,address1);//Enter State Name
			scrollToEnd();

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);
			scrollToElement(errorMessageDocumentType);
			errorValidationOnFields(errorMessageDocumentType);// Select KYC document Type
			selectDropdownValue(Constants.addressDocumentType,addressDocumentTypeValue);

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);
			scrollToElement(errorMessageDocumentNumber);
			errorValidationOnFields(errorMessageDocumentNumber);//Enter Document number
			enterTextInField(Constants.addressDocumentNumber, gen_Five_Digit());

			scrollToEnd();
			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);
			scrollToElement(addressDocumentTypeValue);
			errorValidationOnFields(errorMessageDocumentExpiry);//Enter Document number
			expiryDate(Constants.addressDocumentExpiry);

			scrollToElement("RC DELIVERY ADDRESS");
			clickOnButton(Constants.rcDeliveryAddress);
			scrollToElement(errorMessageIdentityDocumentType);
			errorValidationOnFields(errorMessageIdentityDocumentType);//Select KYC document Type
			selectDropdownValue("Identity Document Type", identityDocumentTypeValue);

			validateMaritalDropDown();

			clickOnButton(Constants.rcDeliveryAddress);
			errorValidationOnFields(errorMessageMaritalStatus);//Select marital status
			selectDropdownValue(Constants.maritalStatus,maritalValue);

			clickOnButton(Constants.rcDeliveryAddress);
			errorValidationOnFields(errorMessageGrossIncome);//Select Gross Income
			selectDropdownValue(Constants.grossAnnualIncome,grossAnnualIncomeValue);

			clickOnButton(Constants.rcDeliveryAddress);
			errorValidationOnFields(errorMessageNatureBusiness);//Select Nature of Business.
			selectDropdownValue(Constants.natureOfBusiness,natureOfBusinessValue);

			clickOn("CheckBox_RCDelivery");
			ValidateFieldEnableAndDisableStatus(Constants.proceedWithEKYC,"true");
			ValidateFieldEnableAndDisableStatus(Constants.rcDeliveryAddress,"false");
			clickOn("CheckBox_RCDelivery");
			ValidateFieldEnableAndDisableStatus(Constants.rcDeliveryAddress,"true");
			ValidateFieldEnableAndDisableStatus(Constants.proceedWithEKYC,"false");

			//			addressProof();
			//			identityProof();
			addressProofMoreThanThreeMB();
			waitTime(3);
			identityProofMoreThanThreeMB();
			clickOnButton(Constants.rcDeliveryAddress);
		}
		catch (Exception e) {
			testStepFailed("Exception in the method ErrorMsgPermanentPage:"+ e.toString());		
		}
	}

	public void clickOnText(String value)
	{
		try {
			String button = value + "#xpath=//android.widget.EditText[@text='" + value + "']";
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


	public void validateGenderDropDown()
	{
		try
		{
			String listOfValues =retrieve("genderDropDown");
			clickOn(txt_GenderPermanentAddress);
			String[] listofvalue= listOfValues.split("##");
			for (int i = 0; i < listofvalue.length; i++) 
			{
				getText("dropDownValue", listofvalue[i]);
			}
			clickOn("btn_CloseIcon");
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateGenderDropDown "+e.toString());
		}
	}

	public void validateMaritalDropDown()
	{
		String button ="Button dropDown#id=com.bfl.isdcia.dev:id/et_marital_status";
		String value = "list of dropdownValue#xpath=//android.widget.TextView";
		try
		{
			String listOfValues =retrieve("MaritalDropDown");
			clickOn(button);			
			String[] listofvalue= listOfValues.split("##");
			for (int i = 0; i < listofvalue.length; i++) 
			{
				getText(value, listofvalue[i]);
			}
			clickOn("btn_CloseIcon");
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateMaritalDropDown "+e.toString());
		}
	}

	public void ValidateFieldEnableAndDisableStatus(String field,String status)
	{
		try
		{
			String fieldValue = field + "#xpath=//android.widget.Button[@text='" + field + "']";
			getAttributeValue(fieldValue, "enabled").equalsIgnoreCase(status);
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method ValidateFieldEnableAndDisableStatus "+e.toString());
		}
	}



}
