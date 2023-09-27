package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class BankingDetails extends ApplicationKeywords
{
	public BankingDetails(RemoteWebDriver driver, BaseClass obj)
	{
		super(driver, obj);
	}
	
	public static final String label_BankingDetailsScreen="Title Banking Details#xpath=//android.widget.TextView[@text='Banking Details']";
	public static final String txt_RepaymentBank="Text Repayment Bank#xpath=//android.widget.TextView[@text='Bank Details(Repayment Bank)']";
	public static final String txt_RepaymentAccountNumber="Text Repayment Account Number#id=com.bfl.isdcia.dev:id/edt_repayment_bank_account_number";
	public static final String txt_RepaymentIFSCCode="Text Repayment IFSC Code#id=com.bfl.isdcia.dev:id/edt_repayment_bank_ifsc_code";
	public static final String txt_CustomerName="Customer Name#id=com.bfl.isdcia.dev:id/tv_name_title";
	
	public void validateBankingscreenOne(String AccountNumber,String IFSCCode)
	{
		try
		{
			waitForElementToDisplay(label_BankingDetailsScreen, 10);
			if(isElementDisplayed(label_BankingDetailsScreen))
			{
				verifyElementIsDisplayed(txt_RepaymentBank);
				verifyElementIsDisplayed(txt_RepaymentAccountNumber);
				typeIn(txt_RepaymentAccountNumber, AccountNumber);
				closeKeyBoard();
				verifyElementIsDisplayed(txt_RepaymentIFSCCode);
				typeIn(txt_RepaymentIFSCCode, IFSCCode);
				closeKeyBoard();
				clickOnButton(Constants.save);
			}
			else
			{
				testStepFailed("Couldn't able to locate element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateRePaymentBankingDetails:"+e.toString());
		}
	}
	
	public void validateRePaymentBankingDetails()
	{
		try
		{
			String AccountNumber = retrieve("AccountNumber");
			String IFSCCode = retrieve("IFSCCode");
			String errorMessageRePaymentBank = retrieve("ErrorMessageRePaymentBankAccount");//Enter Re-Payment Bank Account Number
			String errorMessageRePaymentIFSCCode= retrieve("ErrorMessageRepaymentBankIFSC");//Enter Re-Payment Bank IFSC Code


			waitForElementToDisplay(label_BankingDetailsScreen, 10);
			if(isElementDisplayed(label_BankingDetailsScreen))
			{
				verifyElementIsDisplayed(txt_RepaymentBank);
				verifyElementIsDisplayed(txt_RepaymentAccountNumber);
				validateErrorMessage(errorMessageRePaymentBank);
				typeIn(txt_RepaymentAccountNumber, AccountNumber);
				closeKeyBoard();
				verifyElementIsDisplayed(txt_RepaymentIFSCCode);
				validateErrorMessage(errorMessageRePaymentIFSCCode);
				typeIn(txt_RepaymentIFSCCode, IFSCCode);
				closeKeyBoard();
				clickOnButton(Constants.save);
			}
			else
			{
				testStepFailed("Couldn't able to locate element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateRePaymentBankingDetails:"+e.toString());
		}
	}
	
	public void validateBankingDetailsScreenTwo()
	{
		try
		{
			waitForElementToDisplay(label_BankingDetailsScreen, 10);
			if(isElementDisplayed(label_BankingDetailsScreen))
			{
				verifyElementIsDisplayed(txt_CustomerName);
				testStepPassed(getText(txt_CustomerName));
				clickOnButton(Constants.proceed);
			}
			else
			{
				testStepFailed("Couldn't able to locate element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateRePaymentBankingDetails:"+e.toString());
		}
	}
}
