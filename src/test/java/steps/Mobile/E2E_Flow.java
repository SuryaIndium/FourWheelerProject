package steps.Mobile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import common.PageObjects;

public class E2E_Flow extends PageObjects  {
	
	@Given("User able to launch the application")
	public void user_able_to_launch_the_application() 
	{
		bajajlogin.login();
	}
	
	@Then("User able to navigate the Select your page select the option {string} {string} {string}")
	public void user_able_to_navigate_the_Select_your_page_select_the_option(String salariedText, String vehicleFinanceText, String UsageTypeText)
	{
		selectyourprofession.validateSalaryFlow(salariedText,vehicleFinanceText,UsageTypeText);
	}
	
	@Then("User able to navigate the Customer Details {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_able_to_navigate_the_Customer_Details(String salutationExpectedText, String firstName, String middleName, String lastName, String genderExpectedText, String dateOfBirth, String mobileNumber, String EmailId, String PinCode) 
	{
		customerdeatails.validateCustomerDetailsScreen( salutationExpectedText, firstName, middleName, lastName, genderExpectedText, dateOfBirth, mobileNumber, EmailId, PinCode);
		 bajajlogin.logOut();
	}
		
	@When("User can verify and click on the proceed button on the eligibility page")
	public void user_can_verify_and_click_on_the_proceed_button_on_the_eligibility_page() 
	{
		eligibilitycheck.eligibilityCheckForUncheckSTP();
	}
	
	@When("User can go with the KYC page")
	public void user_can_go_with_the_KYC_page() 
	{
		kyc.kyc_Page();
	}

	@When("User can update the parmanent address")
	public void user_can_update_the_parmanent_address() {
		permanentaddress.permanent_Address();
		//rcdeliveryaddress.rcDeliveryAddress();
	}
}
