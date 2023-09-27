package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class Welcome extends ApplicationKeywords{
	
	public Welcome(RemoteWebDriver driver, BaseClass obj) {
		super(driver, obj);
	}
	
	
	public void validateLoginNewUser(String dropDownValue)
	{
		try
		{
				waitTime(10);
			     waitForElementToDisplay("label_welcomePage",10);
			     if(elementDisplayed("label_welcomePage"))
			     {
			    	 validateListOfValueWelcomePage();
			    	 getText("txt_listofWelcomeValues", dropDownValue);
			    	 clickOn("btn_Procced");
			     }
			     else
			     {
			    	 testStepFailed("couldn't able to navigate the Welcome screen");
			     }
			}
			catch (Exception e) 
			{
				testStepFailed("Exception in the method validateGenderDropDown "+e.toString());
			}
	}
	
	public void validateKatriaMotorPage(String dropDownValue)
	{
		try
		{
			waitTime(10);
		     waitForElementToDisplay("welcomePage",10);
			if(isElementDisplayed("welcomePage",10)) 
			{
			waitTime(5);
			clickOnTextValue(dropDownValue);
		}
		}
		catch (Exception e) 
		{
			testStepFailed("");
		}
	}
	
	public void validateListOfValueWelcomePage()
	{
		try
		{

			String listOfValues =retrieve("WelcomeScreen");
			waitTime(2);
			String[] listofvalue= listOfValues.split("##");
			for (int i = 0; i < listofvalue.length; i++) 
			{
				getText("txt_listofWelcomeValues", listofvalue[i]);
			}
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateGenderDropDown "+e.toString());
		}
	}
	
	
	
}
