package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class MyLoanApplication extends ApplicationKeywords
{
	public MyLoanApplication(RemoteWebDriver driver, BaseClass obj) 
	{
		super(driver, obj);
	}
	public static final String label_MyLoanApplication="Title My loan Application#xpath=//android.widget.TextView[@text='My Loan Application']";
	public static final String SearcgIcon=" Search Icon#id=com.bfl.isdcia.dev:id/et_search";
	public static final String btn_SalesLogin="Sales Login#xpath=//android.widget.TextView[@text='Sales Login']";
	

	public void validateLoanUserSalesLogin()
	{
		try
		{
			String firstName = retrieve("FirstName");
			String lastName = retrieve("LastName");
			
			String name = firstName + " " + lastName;
			
			waitTime(10);
			waitForElementToDisplay(label_MyLoanApplication, 10);
			if(isElementDisplayed(label_MyLoanApplication))
			{
				waitTime(5);
				enterTextInField(Constants.search_Icon,name);
				clickOnTextValue(Constants.salesLogin);
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	public void validateLoanUserPostApprovalSales()
	{
		try
		{
			String firstName = retrieve("FirstName");
			String lastName = retrieve("LastName");
			
			String name = firstName + " " + lastName;
			
			waitTime(10);
			waitForElementToDisplay(label_MyLoanApplication, 10);
			if(isElementDisplayed(label_MyLoanApplication))
			{
				waitTime(5);
				enterTextInField(Constants.search_Icon,name);
				clickOnTextValue("Post Approval Sales");
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
}
