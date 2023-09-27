package steps.Mobile;

import common.PageObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SelfEmpolyedFlow extends PageObjects
{
	
	@Given("User able to login the application valid Mobile Number")
	public void user_able_to_login_the_application_valid_Mobile_Number() 
	{
		bajajlogin.validateLoginScreen();
	}
	
	@When("user able to navigate the Welcome khataria Motors {string}")
	public void user_able_to_navigate_the_Welcome_khataria_Motors(String DropdownValue) 
	{
		welcome.validateLoginNewUser(DropdownValue);
	}

	@Then("User able to navigate the Select your page select the option {string} {string} {string} {string}")
	public void user_able_to_navigate_the_Select_your_page_select_the_option(String selfEmployedText, String vehicleFinanceText, String UsageTypeText, String vechicleNameText) 
	{
		selectyourprofession.validateSelfEmployed(selfEmployedText,vehicleFinanceText,UsageTypeText,vechicleNameText);
	
	}

	@Then("User able to navigate the Customer Details Enter the option {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_navigate_the_Customer_Details_Enter_the_option(String salutationExpectedText, String genderExpectedText, String firstName, String middleName, String lastName, String dateOfBirth, String mobileNumber, String EmailId, String PinCode, String FirmName) 
	{
		customerdeatails.validateFirmNameCustomerScreen(salutationExpectedText,genderExpectedText,firstName,middleName,lastName,dateOfBirth, mobileNumber, EmailId, PinCode, FirmName);
		
	}
	
	//Salaried Flow
	@Then("User able to navigate the select the Profression Screen {string} {string} {string}")
	public void user_able_to_navigate_the_select_the_Profression_Screen(String salariedText, String vehicleFinanceText, String UsageTypeText) 
	{
		selectyourprofession.validateSalaryFlow(salariedText,vehicleFinanceText,UsageTypeText);
	}
	//Salaried Flow
	@Then("User able to navigate the Customer Details Screen {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_navigate_the_Customer_Details_Screen(String salutationExpectedText, String firstName, String middleName, String lastName, String genderExpectedText, String dateOfBirth, String mobileNumber, String EmailId, String PinCode) 
	{
		customerdeatails.validateCustomerDetailsScreen(salutationExpectedText,firstName,middleName,lastName,genderExpectedText,dateOfBirth,mobileNumber,EmailId,PinCode);
	}
	
	@Then("User able to navigate the Frist Eligibility Screen.")
	public void user_able_to_navigate_the_Frist_Eligibility_Screen() 
	{
		eligibilitycheck.validateEligibilityCheck();
	}
	
	@Then("User able to navigate the KYC screen")
	public void user_able_to_navigate_the_KYC_screen()
	{
		kyc.validatekYCScreen();
	}
	
	@Then("User able to navigate the Select your page Check with Invalid Data {string} {string} {string} {string}")
	public void user_able_to_navigate_the_Select_your_page_Check_with_Invalid_Data(String selfEmployedText, String vehicleFinanceText, String UsageTypeText, String vechicleNameText) 
	{
		selectyourprofession.validateSelfEmployedErrorMsg(selfEmployedText,vehicleFinanceText,UsageTypeText,vechicleNameText,"9972093453");
	}

	@Then("User able to navigate the Customer Details Enter the option Invalid Data {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_navigate_the_Customer_Details_Enter_the_option_Invalid_Data(String salutationExpectedText, String genderExpectedText, String firstName, String middleName, String lastName, String dateOfBirth, String mobileNumber, String EmailId, String PinCode, String FirmName) 
	{
		customerdeatails.errorMessageCustomerPages(salutationExpectedText,genderExpectedText,firstName,middleName,lastName, dateOfBirth, mobileNumber, EmailId, PinCode,FirmName);
	}
	
	@Given("User able to Enter All Details In Permanent Screen {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_In_Permanent_Screen(String motherFirstName, String motherMiddletName, String motherLastName, String addressLineOne, String addressLineTwo, String addressLineThree, String zipCode, String CityName, String StateName, String DocumentTypeExpectedText, String DocumentNumber, String IdentityTypeExpectedText, String martialStatusExpectedText, String GrossAnnualIncomeExpectedText, String NatureOfBusinessExpectedText) 
	{
//		bajajlogin.validateLoginScreen();
//		welcome.validateKatriaMotorPage("My Loan Application");
//		myLoanApplication.validateLoanUserSalesLogin();
//     	kyc.validatekYCScreen();
		permanentaddress.validatePermentantAddressScreen(motherFirstName,motherMiddletName, motherLastName,addressLineOne, addressLineTwo, addressLineThree,
				 zipCode, CityName, StateName, DocumentTypeExpectedText, DocumentNumber, IdentityTypeExpectedText, martialStatusExpectedText, GrossAnnualIncomeExpectedText, NatureOfBusinessExpectedText);
	}

	@Then("User able to Enter All Details In Rc Delivery Address {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_In_Rc_Delivery_Address(String AddressTypeExpectedText, String addressLineOne, String addressLineTwo, String addressLineThree, String zipCode, String CityName, String StateName, String DocumentTypeExpectedText,String DocumentNumebrExpectedText) 
	{
		rcdeliveryaddress.validateRCDeliveryAddress(AddressTypeExpectedText, addressLineOne, addressLineTwo, addressLineThree, zipCode, CityName, StateName, DocumentTypeExpectedText,DocumentNumebrExpectedText);
	}

	@Then("User able to Enter All Details In Customer Details Add Firm as Applicant {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_In_Customer_Details_Add_Firm_as_Applicant(String addressType, String addressLineOne, String addressLineTwo, String addressLineThree, String zipCode, String cityName, String stateName, String DocumentTypeExpectedText, String DocumentNumebrExpectedText) 
	{
	   addFrimAsApplicantCustomerDetails.validateAddFirmAsApplicant(addressType, addressLineOne, addressLineTwo, addressLineThree, zipCode, cityName, stateName, DocumentTypeExpectedText,  DocumentNumebrExpectedText);
	}
	
	@Then("User able to Enter All Details In Co-Applicant Screen {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_In_Co_Applicant_Screen(String applicantType, String firstName, String middleName, String lastName, String gender, String dateOfBirth, String addressLineOne, String addressLineTwo, String addressLinethree, String pincode, String cityName, String state, String addressDocumentType, String addressDocumentNumber, String identityDocumentType) 
	{
		coApplicant.validateCoApplicatScreen(applicantType, firstName,  middleName,  lastName,  gender, dateOfBirth, addressLineOne, addressLineTwo, addressLinethree, pincode, cityName, state,addressDocumentType, addressDocumentNumber, identityDocumentType);
	}

	
	@Then("User able to Enter All Details In Additional Details Screen {string} {string} {string}")
	public void user_able_to_Enter_All_Details_In_Additional_Details_Screen(String businessVintage, String dateOfBirth, String loanAmount) 
	{
		additionalDeatails.validateAdditionDetailsSeftEmployedFlow(businessVintage,dateOfBirth,loanAmount);
	}

	@Then("User able to Navigate the Second Eligibility Screen")
	public void user_able_to_Navigate_the_Second_Eligibility_Screen() 
	{
		eligibilitycheck.validateEligibilityCheck();
	}
	
	@Given("User able to Fill All the Details in Asset Details Screen {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Fill_All_the_Details_in_Asset_Details_Screen(String makeValue, String fuelTypeValue, String modelValue, String variantValue, String insuranceTypeValue, String registrationTypeValue) 
	{
		assetDetails.validateAssetDetailsScreen(makeValue,fuelTypeValue,modelValue,variantValue,insuranceTypeValue,registrationTypeValue);
	}

	@Then("User Navigate to Review Loan Screen {string}")
	public void user_Navigate_to_Review_Loan_Screen(String loanAmount) 
	{
		reviewLoanDetails.validateReviewLoanScreens(loanAmount);
	}

	@Then("User able to Navigate Loan Details")
	public void user_able_to_Navigate_Loan_Details() 
	{
		loanDetails.validateLoanDetailsScreen();
	}

	@Then("User able to Navigate the banking Details Screen and Enter the {string} and {string}")
	public void user_able_to_Navigate_the_banking_Details_Screen_and_Enter_the_and(String string, String string2) 
	{
		
	}
	
	//Nagtive
	@Given("User able to Enter All Details Invalid Data Permanent Screen {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_Invalid_Data_Permanent_Screen(String motherFirstName, String motherMiddletName, String motherLastName, String addressLineOne, String addressLineTwo, String addressLineThree, String zipCode, String CityName, String StateName, String DocumentTypeExpectedText, String DocumentNumber, String IdentityTypeExpectedText, String martialStatusExpectedText, String GrossAnnualIncomeExpectedText, String NatureOfBusinessExpectedText) 
	{
//		bajajlogin.validateLoginScreen();
//		welcome.validateKatriaMotorPage("My Loan Application");
//		myLoanApplication.validateLoanUserSalesLogin();
//     	kyc.validatekYCScreen();
		permanentaddress.validateErrorMessagePermanentScreen(motherFirstName,motherMiddletName, motherLastName,addressLineOne, addressLineTwo, addressLineThree,
				 zipCode, CityName, StateName, DocumentTypeExpectedText, DocumentNumber, IdentityTypeExpectedText, martialStatusExpectedText, GrossAnnualIncomeExpectedText, NatureOfBusinessExpectedText);
	}

	@Then("User able to Enter All Details Invalid Data Rc Delivery Address {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_Invalid_Data_Rc_Delivery_Address(String AddressTypeExpectedText, String addressLineOne, String addressLineTwo, String addressLineThree, String zipCode, String CityName, String StateName, String DocumentTypeExpectedText,String DocumentNumebrExpectedText)
	{
		rcdeliveryaddress.validateErrorMessageRCDeliveryScreen(AddressTypeExpectedText, addressLineOne, addressLineTwo, addressLineThree, zipCode, CityName, StateName, DocumentTypeExpectedText,DocumentNumebrExpectedText);
	}

	@Then("User able to Enter All Details Invalid Data Customer Details Add Firm as Applicant {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_Invalid_Data_Customer_Details_Add_Firm_as_Applicant(String addressType, String addressLineOne, String addressLineTwo, String addressLineThree, String zipCode, String cityName, String stateName, String DocumentTypeExpectedText, String DocumentNumebrExpectedText) 
	{
		addFrimAsApplicantCustomerDetails.validateErrorMesageAddFirmAsApplicant(addressType, addressLineOne, addressLineTwo, addressLineThree, zipCode, cityName, stateName, DocumentTypeExpectedText,  DocumentNumebrExpectedText);
	}

	@Then("User able to Enter All Details Invalid Data Co-Applicant Screen {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_Enter_All_Details_Invalid_Data_Co_Applicant_Screen(String applicantType, String firstName, String middleName, String lastName, String gender, String dateOfBirth, String addressLineOne, String addressLineTwo, String addressLinethree, String pincode, String cityName, String state, String addressDocumentType, String addressDocumentNumber, String identityDocumentType) 
	{
		coApplicant.validateErrorMessageCoApplicantScreen(applicantType, firstName,  middleName,  lastName,  gender, dateOfBirth, addressLineOne, addressLineTwo, addressLinethree, pincode, cityName, state,addressDocumentType, addressDocumentNumber, identityDocumentType);
	}

	@Then("User able to Enter All Details Invalid Data Additional Details Screen {string} {string} {string}")
	public void user_able_to_Enter_All_Details_Invalid_Data_Additional_Details_Screen(String businessVintage, String dateOfBirth, String loanAmount) 
	{
		additionalDeatails.validateErrorMessageAdditionDetailsSeftEmployedFlow(businessVintage,dateOfBirth,loanAmount);
	}
}
