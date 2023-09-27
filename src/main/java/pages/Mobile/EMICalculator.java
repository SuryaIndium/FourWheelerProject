package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class EMICalculator extends ApplicationKeywords
{
	public EMICalculator(RemoteWebDriver driver, BaseClass obj) 
	{
		super(driver, obj);
	}
	
	public static final String txt_LoanEMIAmount ="Loan EMI Amount#id=com.bfl.isdcia.dev:id/tv_ncf_loan_emi";

	public void validateEMICaliculator()
	{
		try
		{
			scrollToElement(Constants.proceed);
			validateSeekBar("dropDownLoanAmount",100);
			validateSeekBar("dropDownLoanTenor",0.9);
			validateSeekBar("dropDownROI",0.6);
			getText(txt_LoanEMIAmount);
			clickOnButton(Constants.proceed);
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateEMICaliculator:"+e.toString());
		}
	}
}
