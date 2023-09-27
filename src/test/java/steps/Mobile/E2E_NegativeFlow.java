package steps.Mobile;

import common.PageObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class E2E_NegativeFlow extends PageObjects{

	@Given("User validate errorMesssage in login Page")
	public void user_validate_errorMesssage_in_login_Page()
	{
		bajajlogin.validateloginErrorMsg();
		//bajajlogin.enterNumStartwithZeroToNine();
	}

	@When("User naviagte to Welcome Khataria Motors")
	public void user_naviagte_to_Welcome_Khataria_Motors()
	{
		//welcome.verify_The_Welcome_Page_ClickOn_Proceed();
	}

	@Then("User validate errorMessage in select the profession page")
	public void user_validate_errorMessage_in_select_the_profession_page() 
	{
		//selectyourprofession.vaildateErrorMsgProfessionPage(selfEmployedText,vehicleFinanceText,UsageTypeText,mobileNumber);
	}

	@Then("User validate errorMessage in customerDetail Page")
	public void user_validate_errorMessage_in_customerDetail_Page() 
	{
		customerdeatails.errorMessageCustomerPage();
		bajajlogin.logOut();
	}

	@Then("User able Navigate and click on the proceed button on the eligibility page")
	public void user_able_Navigate_and_click_on_the_proceed_button_on_the_eligibility_page()
	{
		eligibilitycheck.eligibilityCheckForUncheckSTP();
		
	}

	@When("User able Navigate to KYC page")
	public void user_able_Navigate_to_KYC_page()
	{
		kyc.kyc_Page();
	}
	
	@When("User naviagte to Welcome Khataria Motors {string}")
	public void user_naviagte_to_Welcome_Khataria_Motors(String DropdownValue) 
	{
		welcome.validateKatriaMotorPage(DropdownValue);
		
	}

	@Then("Enter the Name in My Loan Application page and validate KYC Page")
	public void enter_the_Name_in_My_Loan_Application_page_and_validate_KYC_Page() 
	{
		myLoanApplication.validateLoanUserSalesLogin();
     	kyc.kyc_Page();
	}

	@Then("User able validate the errorMessgae in permantant Address Page Screen")
	public void user_able_validate_the_errorMessgae_in_permantant_Address_Page_Screen()
	{
		permanentaddress.ErrorMsgPermanentPage();
	
	}

	@Then("User able validate the errorMessage in RC Delivery Address Page Screen and Validate {string}")
	public void user_able_validate_the_errorMessage_in_RC_Delivery_Address_Page_Screen_and_Validate(String coApplicantValue) 
	{
		
		rcdeliveryaddress.RCDeliveryAddressErrorMsg(coApplicantValue);
		coApplicant.inValidateDataeCoApplicant();
	}

	@Then("User able to validate the errorMessage in Additional Details Page screen")
	public void user_able_to_validate_the_errorMessage_in_Additional_Details_Page_screen() 
	{
		additionalDeatails.validateErrorMsgAdditionDetails();
	}

	
}
