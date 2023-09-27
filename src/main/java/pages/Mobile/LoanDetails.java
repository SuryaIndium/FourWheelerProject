package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class LoanDetails extends ApplicationKeywords
{
	public LoanDetails(RemoteWebDriver driver, BaseClass obj)
	{
		super(driver, obj);
	}
	
	public static final String Title_LoanDetails = "Loan Details Title#xpath=//android.widget.TextView[@text='Loan Details']";
	public static final String rateApprovalStatus="Rate Approval Status#id=com.bfl.isdcia.dev:id/tvNcfRateApproval";
	public static final String refreshIconRateApproval ="Refresh Icon Rate Approval#id=com.bfl.isdcia.dev:id/ivNcfRateApprovalRefresh";
	public static final String txt_netDisbursable="Net Disbursable#xpath=//android.widget.TextView[@text='Net Disbursable Amount*']";
	public static final String txt_netDisbursableAmount ="Net Disbursable Amount#id=com.bfl.isdcia.dev:id/tvNcfNetDisbursalAmt";
	public static final String img_FileLoanDetails="Image File Icon#id=com.bfl.isdcia.dev:id/img_attachment";
	public static final String img_CameraLoanDetails="Image Camera Icon#id=com.bfl.isdcia.dev:id/img_camera";
	public static final String upLoadIconLoanDetails="Upload Icon#xpath=//android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_dealerMemo']";
	public static final String txt_LANNO="Text Loan Application#xpath=//android.widget.TextView[@text='Loan Application Number']";
	public static final String txt_LANNumberValue="LAN VAlue#id=com.bfl.isdcia.dev:id/tvNcfLoanAppNumber";
	
	
	public void validateLoanDetailsScreen()
	{
		try
		{
			String exceptedPendingStatus = retrieve("LoanDetailsPendingStatus");
			String exceptedPassedStatus = retrieve("LoanDetailsPassedStatus");
			
			waitForElementToDisplay(Title_LoanDetails, 10);
			if(isElementDisplayed(Title_LoanDetails))
			{
				validateElementkeyAndValue(txt_LANNO,txt_LANNumberValue);
				scrollToElement(Constants.rateApproval);
				if(elementDisplayed(refreshIconRateApproval))
				{
					getText(rateApprovalStatus, exceptedPendingStatus);//Pending
					if(getAttributeValue(refreshIconRateApproval, "clickable").equalsIgnoreCase("true"))
					{
						while(elementDisplayed(refreshIconRateApproval))
						{
							getAttributeValue(refreshIconRateApproval, "enabled").equalsIgnoreCase("true");
							clickOn(refreshIconRateApproval);
							waitTime(10);
						}
					}
					else
					{
						testStepFailed("couldn't able to locate the element");
					}
				}
				else
				{
					testStepPassed("Rate Approval Status"+getText(rateApprovalStatus));
				}
				getText(rateApprovalStatus, exceptedPassedStatus);//Passed
				scrollToEnd();
				validateElementkeyAndValue(txt_netDisbursable,txt_netDisbursableAmount);
				validatePhysicalDeatlerMemo();
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateLoanDetailsScreen:"+e.toString());
		}
	}
	
	public void validatePhysicalDeatlerMemo()
	{
		try
		{
			waitForElementToDisplay(Title_LoanDetails, 10);
			if(isElementDisplayed(img_FileLoanDetails) && isElementDisplayed(img_CameraLoanDetails))
			{
				navigateTOImageFile(img_FileLoanDetails,upLoadIconLoanDetails);
				clickOnButton(Constants.proceed);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validatePhysicalDeatlerMemo:"+e.toString());
		}
	}
	
}
