package steps.Mobile;

import common.PageObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Eligibility extends PageObjects
{
	
	@Given("User able to login the application")
	public void user_able_to_login_the_application() 
	{
		//bajajlogin.login();
		bajajlogin.validateLoginScreen();

//		eligibilitycheck.validateEligibilityCheck();
//		eligibilityLetterSummary.validateLetterSummary();
	}

	@When("User able navigate the Khataria Motror{string}")
	public void user_able_navigate_the_Khataria_Motror(String DropdownValue) 
	{
		welcome.validateKatriaMotorPage(DropdownValue);
		myLoanApplication.validateLoanUserSalesLogin();
     	kyc.validatekYCScreen();
	}

	@Then("User able to Fill the all details Permantent Screen")
	public void user_able_to_Fill_the_all_details_Permantent_Screen() 
	{
		permanentaddress.permanent_Address();
	
	}

	@Then("User able to Fill the all Details in RC Details Screen and validate {string}")
	public void user_able_to_Fill_the_all_Details_in_RC_Details_Screen_and_validate(String coApplicantValue) 
	{
		rcdeliveryaddress.rcDeliveryAddress(coApplicantValue);
	}

	@Then("User able to Fill the all Details in CoApplicant Screen")
	public void user_able_to_Fill_the_all_Details_in_CoApplicant_Screen()
	{
		coApplicant.validateCoApplicant();
	}

	@Then("User able to Fill the all Details Additional Details Screen")
	public void user_able_to_Fill_the_all_Details_Additional_Details_Screen() 
	{
		additionalDeatails.additionalDeatails();
	}
	
	@Then("User able to Fill the All Details in Asset Details Screen.")
	public void user_able_to_Fill_the_All_Details_in_Asset_Details_Screen() 
	{
		
		myLoanApplication.validateLoanUserPostApprovalSales();
		assetDetails.validateAssetDetails();
	}

	@Then("User able to Fill All Details in Review Loan Details Screen and Loan Details Screen.")
	public void user_able_to_Fill_All_Details_in_Review_Loan_Details_Screen_and_Loan_Details_Screen() 
	{
		reviewLoanDetails.validateReviewLoanDetails();
		loanDetails.validateLoanDetailsScreen();
		
	}

	@Then("User able to validate the All Details Banking Details Screen and IMPS Screen.")
	public void user_able_to_validate_the_All_Details_Banking_Details_Screen_and_IMPS_Screen()
	{
		bankDetails.validateRePaymentBankingDetails();
		bankDetails.validateBankingDetailsScreenTwo();
	
	}

	@Then("User able to validate the E-Mandate Awaited Screen.")
	public void user_able_to_validate_the_E_Mandate_Awaited_Screen()
	{
		iMPS.validateIMPSScreen();
	}


}
