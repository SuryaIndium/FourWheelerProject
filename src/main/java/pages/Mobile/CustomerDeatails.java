package pages.Mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;


public class CustomerDeatails extends ApplicationKeywords {

	
	public static final String customerDetailsPage = "Customer Details Page#xpath=//android.widget.TextView[@text='Customer Details']";
	public static final String txt_PreQualifiedOffer = "Pre-Qualified Offer#id=com.bfl.isdcia.dev:id/tvOfferTitle";
	public static final String txt_PreQualifiedOfferAmount = "Pre-Qualified Amount#id=com.bfl.isdcia.dev:id/tv_customer_loan_amount";
	public static final String txt_Salutation ="Button Salutation#id=com.bfl.isdcia.dev:id/edt_salutation";
	public static final String txt_FirstNameCustomerPage="Text First Name#id=com.bfl.isdcia.dev:id/edt_firstname";
	public static final String txt_MiddleNameCustomerPage="Text First Name#id=com.bfl.isdcia.dev:id/edt_middlename";
	public static final String txt_LastNameCustomerPage="Text First Name#id=com.bfl.isdcia.dev:id/edt_lastname";
	public static final String txt_Gender="Text Gender#id=com.bfl.isdcia.dev:id/edt_gender";
	public static final String txt_DOB ="Date Of Brith#id=com.bfl.isdcia.dev:id/edt_dob";
	public static final String txt_MobileNumberCustomerPage="Mobile Number#id=com.bfl.isdcia.dev:id/edt_mobilenumber";
	public static final String txt_emailIdCustomerPage="Email Id#id=com.bfl.isdcia.dev:id/edt_emailid";
	public static final String txt_pinCodeCustomerPage="PinCode Number#id=com.bfl.isdcia.dev:id/edt_pincode";
	public static final String txt_FirmNameCustomerPage="Firm Name#id=com.bfl.isdcia.dev:id/edtFirmName";
	public static final String btn_Validate="Button Validate#id=com.bfl.isdcia.dev:id/button_validate";
	public static final String txt_ErrorMessageValue="Error Message#id=com.bfl.isdcia.dev:id/textinput_error";
	public static final String txt_PANNO_CustomerPage ="PAN Number#id=com.bfl.isdcia.dev:id/edt_panno";
	
	
	public CustomerDeatails(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}
	String firstNameValue = null;

	
	public void validateCustomerDetailsScreen(String salutationExpectedText,String firstName,String middleName,String lastName,String genderExpectedText,String dateOfBirth,String mobileNumber,String EmailId,String PinCode)
	{
		try
		{
			validatecustomerDetails(salutationExpectedText,firstName,middleName,lastName,genderExpectedText,dateOfBirth,mobileNumber,EmailId,PinCode);
			clickOn(btn_Validate);
			waitTime(10);
			clickOn("btn_Procced");
		}
	catch (Exception e) 
	{
		testStepFailed("Exception in the Method validateCustomerDetailsScreen:" + e.toString());
	}
}

	public void validatecustomerDetails(String salutationExpectedText,String firstName,String middleName,String lastName,String genderExpectedText,String dateOfBirth,String mobileNumber,String EmailId,String PinCode)
	{
		try
		{
			waitForElementToDisplay(customerDetailsPage, 10);
			if(isElementDisplayed(customerDetailsPage))
			{
				validateElementkeyAndValue(txt_PreQualifiedOffer, txt_PreQualifiedOfferAmount);
				validateDropDown(txt_Salutation,salutationExpectedText);
				enterTextBox(txt_FirstNameCustomerPage, firstName+""+randomCharacter());
				enterTextBox(txt_MiddleNameCustomerPage,middleName+""+randomCharacter());
				enterTextBox(txt_LastNameCustomerPage,lastName+""+randomCharacter());	
				validateDropDown(txt_Gender,genderExpectedText);
				scrollToElement(Constants.validate);
				validateDateOfBirth(txt_DOB,dateOfBirth);
				enterTextBox(txt_MobileNumberCustomerPage,mobileNumber);
				enterTextBox(txt_emailIdCustomerPage,EmailId);
				enterTextBox(txt_pinCodeCustomerPage,PinCode);	
			}
			else
			{
				testStepFailed("couldn't able to locate the element");;
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method validatecustomerDetails:" + e.toString());
		}
	}
	
	public void validateFirmNameCustomerScreen(String salutationExpectedText,String firstName,String middleName,String lastName,String genderExpectedText,String dateOfBirth,String mobileNumber,String EmailId,String PinCode,String FirmName)
	{
		try
		{
			validatecustomerDetails(salutationExpectedText,firstName,middleName,lastName,genderExpectedText,dateOfBirth,mobileNumber,EmailId,PinCode);
			enterTextBox(txt_FirmNameCustomerPage,FirmName);
			clickOn(btn_Validate);
			waitTime(10);
			clickOn("btn_Procced");
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the Method validateFirmNameCustomerScreen:" + e.toString());
		}
	}
	
	public void errorMessageCustomerPages(String salutationExpectedText,String firstName,String middleName,String lastName,String genderExpectedText,String dateOfBirth,String mobileNumber,String EmailId,String PinCode,String firmName )
	{
		try 
		{
			String errorMessageSalutation = retrieve("errorMessageSalutation");
			String errorMessageFirstName = retrieve("errorMessageFirstName");
			String errorMessageLastName = retrieve("errorMessageLastName");
			String errorMessageGender = retrieve("errorMessageGender");
			String errorMessageDOB = retrieve("errorMessageDOB");
			String errorMessageInValidPANNO =retrieve("errorMessagePANNO");//Enter 10 digit Pan Number
			String errorMessageValidPANNo= retrieve("errorMessageInvalidPANNO");
			String errorMessageMobile = retrieve("errorMessageMobile");
			String errorMessageEmailID = retrieve("errorMessageEmailID");
			String errorMessagePinCode = retrieve("errorMessagePinCode");
			String errorMessageFirmName = retrieve("errorMessageFirmName");//Enter Firm Name
			
			waitForElementToDisplay(customerDetailsPage, 10);
			if(isElementDisplayed(customerDetailsPage))
			{
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageSalutation);
			validateDropDown(txt_Salutation,salutationExpectedText);
		
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageFirstName);
			enterTextBox(txt_FirstNameCustomerPage, firstName+""+randomCharacter());
			
//			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageFirstName);
	    	enterTextBox(txt_MiddleNameCustomerPage,middleName+""+randomCharacter());
			
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageLastName);
			enterTextBox(txt_LastNameCustomerPage,lastName+""+randomCharacter());	
			
			waitTime(2);
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageGender);
			validateDropDown(txt_Gender,genderExpectedText);
			
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageDOB);
			validateDateOfBirth(txt_DOB,dateOfBirth);
			
			String PANNO=getText(txt_PANNO_CustomerPage);
			clearEditBox(txt_PANNO_CustomerPage);
			closeKeyBoard();
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageInValidPANNO);
			inValidPANNO(errorMessageValidPANNo);
			typeIn(txt_PANNO_CustomerPage, PANNO);
			closeKeyBoard();
			
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageMobile);
			enterInvalidMobileNumber();
			enterTextBox(txt_MobileNumberCustomerPage,mobileNumber);
			
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageEmailID);
			enterTextBox(txt_emailIdCustomerPage,EmailId);
			
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessagePinCode);
			enterTextBox(txt_pinCodeCustomerPage,PinCode);	
			
			validateErrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageFirmName);
			enterTextBox(txt_FirmNameCustomerPage,firmName);
			
			waitTime(2);
			clickOnButton(Constants.validate);
			waitTime(10);
			clickOnButton(Constants.proceed);
			}
			else
			{
				testStepFailed("couldn't able to locate the element");;
			}
		} 
		catch (Exception e) 
		{
			testStepFailed("Exception in the method errorMessageCustomerPage:"+ e.toString());
		}
	}
	
	public void inValidPANNO(String errorMessageInValidPANNO)
	{
		try 
		{
			String invalidPANNO = retrieve("InvalidPANNO");		
			enterTextBox(txt_PANNO_CustomerPage, invalidPANNO);
			validateerrorMessage(btn_Validate,txt_ErrorMessageValue,errorMessageInValidPANNO);
			clearEditBox(txt_PANNO_CustomerPage);
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
	    	 enterTextBox(txt_MobileNumberCustomerPage, Number);
	         validateerrorMessage(btn_Validate,txt_ErrorMessageValue,Message);
	         waitTime(2);
	         clearEditBox(txt_MobileNumberCustomerPage);
	         closeKeyBoard();
	    	}
	    	  catch (Exception e) 
	        {
	            testStepFailed("Exception in the Method validateErrorMessageMobNO"+e.toString());
	        }
	    }
	
	public void validateErrorMessage(String objLocatorButton,String objLocatorText,String expectedText)
	{
		try
		{
			scrollToElement(Constants.validate);
			validateerrorMessage(objLocatorButton,objLocatorText,expectedText);
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateErrorMessage:"+ e.toString());
		}
	}

	public void customerDetailsPage() {
	
		try {
			waitForElementToDisplay("customerDetailsPage", 10);
			if (isElementDisplayed("customerDetailsPage")) {
				String salutationValue = retrieve("salutation");
				enterSalutation(Constants.salutation,salutationValue);
				enterFirstName(Constants.firstName);
				enterMiddleName(Constants.middleName);
				enterLastName(Constants.lastName);
				enterGender(Constants.gender);
				enterTheDateOfBirth(Constants.dateOfBirth);
				enterMobileNumber(Constants.mobileNumber);
				enterEmailID(Constants.emailId);
				enterPinCode(Constants.pinCode);
				clickOnButton(Constants.validate);
				waitTime(10);
				clickOnButton(Constants.proceed);
				waitTime(10);
			}else {
				testStepFailed("Customer details is not present");
			}
		} catch (Exception e) {
			testStepFailed("Exception in the method customerDetailsPage"+e.toString());
		}

	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to select the
	 * salutation dropdown. number Return Value : String Purpose  : select the
	 * dropdown
	 * 
	 * @param : Passing the field name and field value
	 */
	public void enterSalutation(String fieldName, String fieldValue)
	{
		selectDropdownValue(fieldName, fieldValue);
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
		String middleNameValue = retrieve("middleName");
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
		String lastNameValue = retrieve("lastName");
		enterTextInField(Constants.lastName, lastNameValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to select the
	 * Gender dropdown. number Return Value : String Purpose  : select the dropdown
	 * 
	 * @param : Passing the field name 
	 */
	public void enterGender(String fieldName) {
		String genderValue = retrieve("gender");
		selectDropdownValue(fieldName, genderValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to Enter the date
	 * of birth number Return Value : String Purpose  : enter the date of birth
	 * 
	 * @param : Passing the field name and field value
	 */
	public void enterTheDateOfBirth(String fieldName) {
		String dateOfBirthValue = retrieve("dateOfBirth");
		enterDateOfBirth(fieldName, dateOfBirthValue);
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * mobile Number number Return Value : String Purpose  : Enter the text in the
	 * field.
	 * 
	 * @param : Passing the field name
	 */
	public void enterMobileNumber(String fieldName) {
		String mobileNumberValue = generateMobileNumber();
		enterTextInField(fieldName, "9148722066");
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * email ID number Return Value : String Purpose  : Enter the text in the field.
	 * 
	 * @param : Passing the field name
	 */
	public void enterEmailID(String fieldName) {
		String emailValue = firstNameValue + "@gmail.com";
		enterTextInField(fieldName, "bajajb458@gmail.com");
		
		
	}

	/*
	 * @author : Meghana M S
	 * 
	 * @created Date : 22-05-2023 Description : The method is used to enter the
	 * pincode number Return Value : String Purpose  : Enter the text in the field.
	 * 
	 * @param : Passing the field name 
	 */
	public void enterPinCode(String fieldName) {
          String pincodeValue = retrieve("pinCode");
		enterTextInField(fieldName, pincodeValue);
	}
//========================Negative Scenario===============================================
	
	/*
	 * @author : Surya
	 * 
	 * @created Date : 25-05-2023
	 * Description : The method is used to Customer Page error Message Validation
	 * number Return Value : 
	 * String Purpose  : Enter the text in the field.
	 *  @param : Passing the field name and value
	 */
	
	public void errorMessageCustomerPage()
	{
		try 
		{
			String errorMessageSalutation = retrieve("errorMessageSalutation");
			String errorMessageFirstName = retrieve("errorMessageFirstName");
			String errorMessageLastName = retrieve("errorMessageLastName");
			String errorMessageGender = retrieve("errorMessageGender");
			String errorMessageDOB = retrieve("errorMessageDOB");
			String errorMessageMobile = retrieve("errorMessageMobile");
			String errorMessageEmailID = retrieve("errorMessageEmailID");
			String errorMessagePinCode = retrieve("errorMessagePinCode");
			
			scrollToElement("VALIDATE");
			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessageSalutation);
			enterSalutation(Constants.salutation,"Ms.");
			
			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessageFirstName);
			enterFirstName(Constants.firstName);
			
			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessageLastName);
			enterLastName(Constants.lastName);
			
			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessageGender);
			enterGender(Constants.gender);
			
			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessageDOB);
			enterTheDateOfBirth(Constants.dateOfBirth);
		
			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessageMobile);
			enterMobileNumber (Constants.mobileNumber);

			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessageEmailID);
			enterEmailID(Constants.emailId);
			
			clickOnButton(Constants.validate);
			errorValidationOnFields(errorMessagePinCode);
			enterPinCode(Constants.pinCode);
			
			waitTime(2);
			clickOnButton(Constants.validate);
			waitTime(10);
			clickOnButton(Constants.proceed);
			
		} 
		catch (Exception e) 
		{
			testStepFailed("Exception in the method errorMessageCustomerPage:"+ e.toString());
		}
	}
}
