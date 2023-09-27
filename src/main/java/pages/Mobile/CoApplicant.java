package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class CoApplicant extends ApplicationKeywords
{
	public CoApplicant(RemoteWebDriver driver, BaseClass obj)
	{
		super(driver, obj);
	}

	public static final String label_coApplicant="Title co-Applicant Screen#xpath=//android.widget.TextView[@text='Customer Details (Co-Applicant)']";
	public static final String txt_CoApplicantType="Co-Applicant Type#id=com.bfl.isdcia.dev:id/ncfCoAppApplicantType";
	public static final String txt_CoApplicantFirstName="Co-Applicant FirstName#id=com.bfl.isdcia.dev:id/ncfCoAppFirstName";
	public static final String txt_CoApplicantMiddleName="Co-Applicant MiddleName#id=com.bfl.isdcia.dev:id/ncfCoAppMiddleName";
	public static final String txt_CoApplicantLastName="Co-Applicant LastName#id=com.bfl.isdcia.dev:id/ncfCoAppLastName";
	public static final String txt_CoApplicantGender="Co-Applicant Gender#id=com.bfl.isdcia.dev:id/ncfCoAppGender";
	public static final String txt_CoApplicantDOB="Co-Applicant Date Of Brith#id=com.bfl.isdcia.dev:id/edtDateOfBirth";
	public static final String txt_CoApplicantAddressOne="Co-Applicant AddressLine One#id=com.bfl.isdcia.dev:id/ncfCoAppAddress_1";
	public static final String txt_CoApplicantAddressTwo="Co-Applicant AddressLine Two#id=com.bfl.isdcia.dev:id/ncfCoAppAddress_2";
	public static final String txt_CoApplicantAddressThree="Co-Applicant AddressLine Three#id=com.bfl.isdcia.dev:id/ncfCoAppAddress_3";
	public static final String txt_CoApplicantPinCodeNO="Co_Applicant PinCode no#id=com.bfl.isdcia.dev:id/ncfCoAppPinCode";
	public static final String txt_CoApplicantCity="Co-Applicant City Name#id=com.bfl.isdcia.dev:id/ncfCoAppCity";
	public static final String txt_CoApplicantPANNO="CoApplicant PAN Number#id=com.bfl.isdcia.dev:id/ncfCoAppPan";
	public static final String txt_CoApplicantState="CoApplicant State#id=com.bfl.isdcia.dev:id/ncfCoAppState";
	public static final String txt_CoApplicantAddressDocumentType="C0-Applicant Address Document Type#id=com.bfl.isdcia.dev:id/ncfCoAppAddressProofType";
	public static final String txt_CoApplicantAddressDocumentNumber="Co-Applicant Address Document Number#id=com.bfl.isdcia.dev:id/ncfCoAppAddressProofDocNum";
	public static final String txt_CoApplicantAddressDocumentExpiry="Co-Applicant Address Document Expiry#xpath=//android.widget.EditText[@resource-id='com.bfl.isdcia.dev:id/ncfCoAppAddressProofDocExpiry']";
	public static final String txt_CoApplicantIdentityDocumentType="Co-Applicant Identity Document type#id=com.bfl.isdcia.dev:id/ncfCoAppIdentityDocType";
	public static final String btn_Save="Button Save#xpath=//android.widget.Button[@text='SAVE']";
	public static final String btn_SaveAndContinue="Button Save and continue#xpath=//android.widget.Button[@text='SAVE AND CONTINUE']";
	public static final String txt_ErrorMessageValue="Error Message#id=com.bfl.isdcia.dev:id/textinput_error";


	public void validateCoApplicatScreen(String applicantType,String firstName, String middleName, String lastName, String gender,String dateOfBirth,String addressLineOne,String addressLineTwo,String addressLinethree,String pincode,String cityName,String state,
			String addressDocumentType,String addressDocumentNumber,String identityDocumentType)
	{
		try
		{
			waitTime(10);
			waitForElementToDisplay(label_coApplicant, 20);
			if(isElementDisplayed(label_coApplicant))
			{
				waitTime(2);
				validateDropDown(txt_CoApplicantType,applicantType);
				enterTextBox(txt_CoApplicantFirstName, firstName);
				enterTextBox(txt_CoApplicantMiddleName, middleName);
				enterTextBox(txt_CoApplicantLastName, lastName);
				validateDropDown(txt_CoApplicantGender,gender);
				validateDateOfBirth(txt_CoApplicantDOB,dateOfBirth);
				enterTextBox(txt_CoApplicantAddressOne, addressLineOne);
				enterTextBox(txt_CoApplicantAddressTwo, addressLineTwo);
				enterTextBox(txt_CoApplicantAddressThree,addressLinethree);
				enterTextBox(txt_CoApplicantPinCodeNO, pincode);
				enterTextBox(txt_CoApplicantCity, cityName);
				enterTextBox(txt_CoApplicantPANNO,generatePanNumber());
				enterTextBox(txt_CoApplicantState,state);
				validateDropDown(txt_CoApplicantAddressDocumentType,addressDocumentType);
				enterTextBox(txt_CoApplicantAddressDocumentNumber,addressDocumentNumber);
				validateExpiryDate(txt_CoApplicantAddressDocumentExpiry,ExpiryDate());
				waitTime(2);
				validateDropDown(txt_CoApplicantIdentityDocumentType,identityDocumentType);
				clickOnButtonValue(btn_Save);
				waitTime(10);
				scrollToElement(Constants.SaveAndContinue);
				navigateTOImageFile("CoApplicant_AddressUpload","CoApplicant_AddressUploadbtn");
				waitTime(5);
				navigateTOImageFile("CoApplicant_IdentityUpload","CoApplicant_IdentityUploadbtn");
				clickOnButtonValue(btn_SaveAndContinue);
				waitTime(10);
				add_Applicant("NO");
			}
			else
			{
				testStepFailed("couldn't able to locate the screen");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateCoApplicatScreen:"+e.toString());
		}
	}
	
	public void validateErrorMessageCoApplicantScreen(String applicantType,String firstName, String middleName, String lastName, String gender,String dateOfBirth,String addressLineOne,String addressLineTwo,String addressLinethree,String pincode,String cityName,String state,
			String addressDocumentType,String addressDocumentNumber,String identityDocumentType)
	{
		try
		{
			

			String errorMessageApplicantType = retrieve("errorMessageApplicantType");
			String errorMessageFirstName = retrieve("errorMessageFirstName");
			String errorMessageLastName = retrieve("errorMessageLastName");
			String errorMessageGender = retrieve("errorMessageGender");
			String errorMessageDOB = retrieve("errorMessageDOB");
			String errorMessageAddress1 = retrieve("errorMessageAddress1");
			String errorMessageAddress2 = retrieve("errorMessageAddress2");
			String errorMessageAddress3 = retrieve("errorMessageAddress3");
			String errorMessagePinCode = retrieve("errorMessagePinCode");
			String errorMessageCity = retrieve("errorMessageCity");
			String errorMessageState = retrieve("errorMessageState");
			String errorMessageAddressDocumentType= retrieve("errorMessageAddressDocumentType");
			String ErrorMessageAddressProofNumber = retrieve("ErrorMessageAddressProofNumber");
			String ErrorMessageIdentityDocumentType = retrieve("ErrorMessageIdentityDocumentType");
			String errorMessagePANNO = retrieve("errorMessagePANNO");
			String errorMessageInvalidPANNO =retrieve("errorMessageInvalidPANNO");
			
			String InvalidPANNO = retrieve("InvalidPANNO");
			
			waitTime(10);
			waitForElementToDisplay(label_coApplicant, 20);
			if(isElementDisplayed(label_coApplicant))
			{
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageApplicantType);
				validateDropDown(txt_CoApplicantType,applicantType);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageFirstName);
				enterTextBox(txt_CoApplicantFirstName, firstName);
				enterTextBox(txt_CoApplicantMiddleName, middleName);
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageLastName);
				enterTextBox(txt_CoApplicantLastName, lastName);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageGender);
				validateDropDown(txt_CoApplicantGender,gender);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageDOB);
				validateDateOfBirth(txt_CoApplicantDOB,dateOfBirth);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageAddress1);
				enterTextBox(txt_CoApplicantAddressOne, addressLineOne);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageAddress2);
				enterTextBox(txt_CoApplicantAddressTwo, addressLineTwo);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageAddress3);
				enterTextBox(txt_CoApplicantAddressThree,addressLinethree);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessagePinCode);
				enterTextBox(txt_CoApplicantPinCodeNO, pincode);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageCity);
				enterTextBox(txt_CoApplicantCity, cityName);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageState);
				enterTextBox(txt_CoApplicantState,state);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageAddressDocumentType);
				validateDropDown(txt_CoApplicantAddressDocumentType,addressDocumentType);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,ErrorMessageAddressProofNumber);
				enterTextBox(txt_CoApplicantAddressDocumentNumber,addressDocumentNumber);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageAddressDocumentType);
				validateExpiryDate(txt_CoApplicantAddressDocumentExpiry,ExpiryDate());
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,ErrorMessageIdentityDocumentType);
				validateDropDown(txt_CoApplicantIdentityDocumentType,identityDocumentType);
				
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessagePANNO);
				
				enterTextBox(txt_CoApplicantPANNO, InvalidPANNO);
				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessageInvalidPANNO);
				clearEditBox(txt_CoApplicantPANNO);
				closeKeyBoard();
				enterTextBox(txt_CoApplicantPANNO, generatePanNumber());
				
//				validateerrorMessage(btn_Save,txt_ErrorMessageValue,errorMessagePinCode);
//				enterTextBox(txt_CoApplicantPANNO,generatePanNumber());
				
				clickOnButtonValue(btn_Save);
				scrollToElement(Constants.SaveAndContinue);
				navigateTOImageFile("CoApplicant_AddressUpload","CoApplicant_AddressUploadbtn");
				waitTime(5);
				navigateTOImageFile("CoApplicant_IdentityUpload","CoApplicant_IdentityUploadbtn");
				clickOnButtonValue(btn_SaveAndContinue);
				waitTime(10);
				add_Applicant("NO");
			}
			else
			{
				testStepFailed("couldn't able to locate the screen");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateCoApplicatScreen:"+e.toString());
		}
	}
	
	 public void validateerrorMessage(String objLocatorButton,String objLocatorText,String expectedText)
	    {
	    	try
	    	{
	    		scrollToEnd();
	    		//scrollToElement("SAVE");
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
	
	
	public void validateCoApplicant()
	{
		try
		{
			String applicantTypeValue=retrieve("ApplicantTypeValue");
			String firstNameValue = retrieve("firstName")+randomCharacter();
			String middleNameValue = retrieve("middleName")+randomCharacter();
			String lastNameValue = retrieve("lastName")+randomCharacter();
			String genderValue = retrieve("gender");
			String dateOfBirthValue = retrieve("dateOfBirth");
			String address1 = retrieve("address1");
			String address2 = retrieve("address1");
			String address3 = retrieve("address1");
			String pinCode = retrieve("pinCode");
			String addressDocumentTypeValue = retrieve("documentype");
			String identityDocumentTypeValue = retrieve("identitytype");

		
			selectDropdownValue(Constants.applicantType,applicantTypeValue);//Primary Financial CoApplicant

			enterTextInField(Constants.firstName, firstNameValue);
			enterTextInField(Constants.middleName, middleNameValue);
			enterTextInField(Constants.lastName, lastNameValue);
			selectDropdownValue(Constants.gender, genderValue);
			enterDateOfBirth(Constants.dateOfBirth, dateOfBirthValue);
			enterTextInField(Constants.addressline1, address1);
			enterTextInField(Constants.addressline2, address2);
			enterTextInField(Constants.addressline3, address3);
			enterTextInField(Constants.coapplicant_pinCode, pinCode);
			enterTextInField(Constants.city, address1);
			enterTextInField(Constants.PANNumber, generatePanNumber());
			enterTextInField(Constants.state,address1);
			selectDropdownValue(Constants.addressDocumentType,addressDocumentTypeValue);
			enterTextInField(Constants.addressDocumentNumber, gen_Five_Digit());
			expiryDate(Constants.addressDocumentExpiry);
			selectDropdownValue("Identity Document Type", identityDocumentTypeValue);
			clickOnButton(Constants.save);
			waitTime(10);
			scrollToElement(Constants.SaveAndContinue);
			navigateTOImageFile("CoApplicant_AddressUpload","CoApplicant_AddressUploadbtn");
			waitTime(5);
			navigateTOImageFile("CoApplicant_IdentityUpload","CoApplicant_IdentityUploadbtn");
			clickOnButton(Constants.SaveAndContinue);
			waitTime(10);
			add_Applicant("NO");
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateCoApplicant"+e.toString());
		}
	}

	public void inValidateDataeCoApplicant()
	{
		try
		{
			String applicantTypeValue=retrieve("ApplicantTypeValue");
			String firstNameValue = retrieve("firstName")+randomCharacter();
			String middleNameValue = retrieve("middleName")+randomCharacter();
			String lastNameValue = retrieve("lastName")+randomCharacter();
			String genderValue = retrieve("gender");
			String dateOfBirthValue = retrieve("dateOfBirth");
			String address1 = retrieve("address1");
			String address2 = retrieve("address1");
			String address3 = retrieve("address1");
			String pinCode = retrieve("pinCode");
			String addressDocumentTypeValue = retrieve("documentype");
			String identityDocumentTypeValue = retrieve("identitytype");

			String errorMessageApplicantType = retrieve("errorMessageApplicantType");
			String errorMessageFirstName = retrieve("errorMessageFirstName");
			String errorMessageLastName = retrieve("errorMessageLastName");
			String errorMessageGender = retrieve("errorMessageGender");
			String errorMessageDOB = retrieve("errorMessageDOB");
			String errorMessageAddress1 = retrieve("errorMessageAddress1");
			String errorMessageAddress2 = retrieve("errorMessageAddress2");
			String errorMessageAddress3 = retrieve("errorMessageAddress3");
			String errorMessagePinCode = retrieve("errorMessagePinCode");
			String InvalidZipCode = retrieve("InvalidZipCode");
			String errorMessageCity = retrieve("errorMessageCity");
			String errorMessageState = retrieve("errorMessageState");
			String errorMessageAddressDocumentType= retrieve("errorMessageAddressDocumentType");
			String ErrorMessageAddressProofNumber = retrieve("ErrorMessageAddressProofNumber");
			String ErrorMessageIdentityDocumentType = retrieve("ErrorMessageIdentityDocumentType");
			String errorMessagePANNO = retrieve("errorMessagePANNO");
			String InvalidPANNO = retrieve("InvalidPANNO");
			String errorMessageInvalidPANNO =retrieve("errorMessageInvalidPANNO");

		
			validateErrorMesssage(Constants.save,errorMessageApplicantType);
			selectDropdownValue(Constants.applicantType,applicantTypeValue);//Primary Financial CoApplicant

			validateErrorMesssage(Constants.save,errorMessageFirstName);
			enterTextInField(Constants.firstName, firstNameValue);
			enterTextInField(Constants.middleName, middleNameValue);

			validateErrorMesssage(Constants.save,errorMessageLastName);
			enterTextInField(Constants.lastName, lastNameValue);

			validateErrorMesssage(Constants.save,errorMessageGender);
			selectDropdownValue(Constants.gender, genderValue);

			validateErrorMesssage(Constants.save,errorMessageDOB);
			enterDateOfBirth(Constants.dateOfBirth, dateOfBirthValue);

			SelectYear("CoApplicantScreen_DateOfBirth");
			changeTheDate("CoApplicantScreen_DateOfBirth");

			verifyElementIsDisplayed("CoApplicant_AdddressLine1");
			getText("CoApplicant_AdddressLine1");
			verifyElementIsDisplayed("CoApplicant_AddressLine2");
			getText("CoApplicant_AddressLine2");
			verifyElementIsDisplayed("CoApplicant_AddressLine3");
			getText("CoApplicant_AddressLine3");

			validateErrorMesssage(Constants.save,errorMessageAddress1);
			enterTextInField(Constants.addressline1, address1);
			validateErrorMesssage(Constants.save,errorMessageAddress2);
			enterTextInField(Constants.addressline2, address2);
			validateErrorMesssage(Constants.save,errorMessageAddress3);
			enterTextInField(Constants.addressline3, address3);

			validateErrorMesssage(Constants.save,errorMessagePinCode);
			enterTextInField(Constants.coapplicant_pinCode, InvalidZipCode);

			validateErrorMesssage(Constants.save,errorMessagePinCode);
			clearTextFromFiled(InvalidZipCode);
			enterTextInField(Constants.coapplicant_pinCode, pinCode);

			validateErrorMesssage(Constants.save,errorMessageCity);
			enterTextInField(Constants.city, address1);

			validateErrorMesssage(Constants.save,errorMessageState);
			enterTextInField(Constants.state,address1);

			validateErrorMesssage(Constants.save,errorMessageAddressDocumentType);
			selectDropdownValue(Constants.addressDocumentType,addressDocumentTypeValue);

			validateErrorMesssage(Constants.save,ErrorMessageAddressProofNumber);
			enterTextInField(Constants.addressDocumentNumber, gen_Five_Digit());

			validateErrorMesssage(Constants.save,errorMessageAddressDocumentType);
			expiryDate(Constants.addressDocumentExpiry);

			validateErrorMesssage(Constants.save,ErrorMessageIdentityDocumentType);
			selectDropdownValue("Identity Document Type", identityDocumentTypeValue);

			validatePANNO(Constants.PANNumber);
			clickOnButton(Constants.save);
			validateErrorMesssage(Constants.save,errorMessagePANNO);//InvalidPANNO
			enterTextInField(Constants.PANNumber, InvalidPANNO);
			clickOnButton(Constants.save);
			errorValidationOnFields(errorMessageInvalidPANNO);
			clearTextFromFiled(InvalidPANNO);
			enterTextInField(Constants.PANNumber, generatePanNumber());
			clickOnButton(Constants.save);
			
			waitTime(30);
			scrollToEnd();
			scrollToElement(Constants.SaveAndContinue);
			validateDocumentProof();
			navigateTOImageFile("CoApplicant_AddressUpload","CoApplicant_AddressUploadbtn");
			navigateTOImageFile("CoApplicant_IdentityUpload","CoApplicant_IdentityUploadbtn");
			waitTime(10);
			scrollToEnd();
			clickOnButton(Constants.SaveAndContinue);
			add_Applicant("NO");
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateCoApplicant"+e.toString());
		}
	}

	public void validateErrorMesssage(String element,String errorMessage)
	{
		try
		{
			scrollToElement(element);
			clickOnButton(element); 
			scrollToElement(errorMessage);
			errorValidationOnFields(errorMessage);
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateErrorMesssage"+e.toString());
		}
	}

	public void validatePANNO(String labelName)
	{
		try
		{
			String field = labelName + "#xpath=//android.widget.EditText[@text='" + labelName + "']";
			verifyElementIsDisplayed(field);
			testStepPassed("Label value is Displayed"+getText(field));
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validatePANNO"+e.toString());
		}
	}
	
	public void validateDocumentProof()
	{
		try
		{
			waitForElementToDisplay("txt_AddressProof", 10);
			if(isElementDisplayed("txt_AddressProof")&&isElementDisplayed("txt_IdentityProof"))
			{
				testStepPassed(getText("txt_AddressProof")+"is Display"+getText("txt_IdentityProof")+ "is Display");
			}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateDocumentProof "+e.toString());
		}
	}

}
