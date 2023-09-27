package pages.Mobile;


import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class AssetDetails extends ApplicationKeywords 
{
	public AssetDetails(RemoteWebDriver driver, BaseClass obj) 
	{
		super(driver, obj);
	}

	public static final String txt_ExshowRoomPrice="Amount ExShowRoomPrice#id=com.bfl.isdcia.dev:id/etExShowRoomPrice";
	public static final String txt_OnRoadPrice="Amount ExShowRoomPrice#id=com.bfl.isdcia.dev:id/etExShowRoomPrice";
	public static final String txt_Downpayment="Enter the DownPayment Amount#id=com.bfl.isdcia.dev:id/etDownPayment";
	
	
	
	public void validateAssetDetailsScreen(String makeValue,String fuelTypeValue,String modelValue,String variantValue,String insuranceTypeValue,String registrationTypeValue)
	{
		try
		{
			waitTime(10);
			waitForElementToDisplay("label_AssetDetails", 20);
			if(isElementDisplayed("label_AssetDetails"))
			{
				ScrollTovalidateDropDown("btn_Make",makeValue);
				validateDropDown("btn_FuelType",fuelTypeValue);
				validateDropDown("btn_Model",modelValue);
				validateDropDown("btn_Variant",variantValue);
				validateDropDown("btn_InsuranceType",insuranceTypeValue);
				validateDropDown("btn_RegistrationType",registrationTypeValue);
			
				scrollToElement(Constants.proceed);
				waitTime(2);
				validateInvoiceSummary(txt_ExshowRoomPrice,txt_OnRoadPrice);
				clickOnButtonValue("btn_Procced");
				waitTime(20);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateAssetDetailsScreen:"+e.toString());
		}
	}
	

	public void validateAssetDetails()
	{
		try
		{
			String makeValue = retrieve("Make");//Tata
			String fuelTypeValue = retrieve("FuelType");
			String modelValue = retrieve("Model");
			String variantValue = retrieve("Variant");
			String insuranceTypeValue = retrieve("InsuranceType");
			String registrationTypeValue = retrieve("RegistrationType");

			waitTime(10);
			waitForElementToDisplay("label_AssetDetails", 20);
			if(isElementDisplayed("label_AssetDetails"))
			{
				validateChangeValueDropDown(makeValue,"btn_Make",0);
				validateChangeValueDropDown(fuelTypeValue,"btn_FuelType",0);
				validateChangeValueDropDown(modelValue,"btn_Model",0);
				validateChangeValueDropDown(variantValue,"btn_Variant",0);
				validateChangeValueDropDown(insuranceTypeValue,"btn_InsuranceType",0);
				validateChangeValueDropDown(registrationTypeValue,"btn_RegistrationType",0);
				
				ScrollTovalidateChangeValueDropDown(makeValue,"btn_Make",1);
				validateChangeValueDropDown(fuelTypeValue,"btn_FuelType",1);
				validateChangeValueDropDown(modelValue,"btn_Model",1);
				validateChangeValueDropDown(variantValue,"btn_Variant",1);
				validateChangeValueDropDown(insuranceTypeValue,"btn_InsuranceType",1);
				validateChangeValueDropDown(registrationTypeValue,"btn_RegistrationType",1);
			
				scrollToElement(Constants.proceed);
				waitTime(2);
				validateInvoiceSummary(txt_ExshowRoomPrice,txt_OnRoadPrice);
				clickOnButton(Constants.proceed);
				waitTime(20);
			}
			else
			{
				testStepFailed("Couldn't not able locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateDetails:"+e.toString());
		}
	}

	public void validateInvoiceSummary(String ExShowPrice,String OnRoadPrice)
	{
		try
		{

			String ExShowRoomPrice = findWebElement(ExShowPrice).getText();
			String OnRoad = findWebElement(OnRoadPrice).getText();
			if(ExShowRoomPrice.equals(OnRoad))
			{
				testStepPassed("Ex Showroom price is equal to On road price");
				typeIn(txt_Downpayment, "100000");
				closeKeyBoard();
				testStepPassed(getText(txt_Downpayment));
			}
			else
			{
				testStepFailed("Ex Showroom price is Not equal to On road price");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateInvoiceSummary:"+e.toString());
		}
	}


	public void validateErrorMessageAssetDetails()
	{
		try
		{
			String makeValue = retrieve("Make");
			String fuelTypeValue = retrieve("FuelType");
			String modelValue = retrieve("Model");
			String variantValue = retrieve("Variant");
			String insuranceTypeValue = retrieve("InsuranceType");
			String registrationTypeValue = retrieve("RegistrationType");

			String errormessageMake = retrieve("ErrorMessageSelectMake");
			String errorMessageFuel = retrieve("ErrorMessageSelectFuelType");
			String errorMessageModel = retrieve("ErrorMessageSelectModel");
			String errorMessageVariant = retrieve("ErrorMessageSelectVariant");
			String errorMessageInsurance = retrieve("ErrorMessageInsuranceType");
			String errorMessageRegistration = retrieve("errormessageRegistrationType");

			waitTime(10);
			waitForElementToDisplay("label_AssetDetails", 10);
			if(isElementDisplayed("label_AssetDetails"))
			{

				validateMandatoryField(Constants.proceed,errormessageMake);
				ScrollTovalidateChangeValueDropDown(makeValue,"btn_Make",1);//Select Make

				validateMandatoryField(Constants.proceed,errorMessageFuel);
				validateChangeValueDropDown(fuelTypeValue,"btn_FuelType",1);//Select Fual type

				validateMandatoryField(Constants.proceed,errorMessageModel);//Select Model
				validateChangeValueDropDown(modelValue,"btn_Model",1);

				validateMandatoryField(Constants.proceed,errorMessageVariant);//Select Variant
				validateChangeValueDropDown(variantValue,"btn_Variant",1);
	

				clickOnButton(Constants.proceed);
				errorValidationOnFields(errorMessageInsurance);//Insurance Type
				validateChangeValueDropDown(insuranceTypeValue,"btn_InsuranceType",1);

				clickOnButton(Constants.proceed);
				errorValidationOnFields(errorMessageRegistration);//Registration Type
				validateChangeValueDropDown(registrationTypeValue,"btn_RegistrationType",1);
				
				scrollToElement(Constants.proceed);
				clickOnButton(Constants.proceed);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateInvoiceSummary:"+e.toString());
		}
	}

	public void validateMandatoryField(String objLocator,String errorMessage)
	{
		try
		{
			scrollToElement(objLocator);
			clickOnButton(objLocator);
			scrollToElement(errorMessage);
			errorValidationOnFields(errorMessage);
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateErrorMessageAssetDetails:"+e.toString());
		}
	}

	
	public void ScrollTovalidateDropDown(String objLocatorButton,String expectedText)
	{
		try
		{
			waitTime(2);
			clickOn(objLocatorButton);
			scrollToElement(expectedText);
			getElementAndClick("dropDownValue", expectedText);
			getText(objLocatorButton, expectedText);
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateDropDown:"+e.toString());
		}
	}

	public void validateChangeValueDropDown(String DataValues,String objLocatorButton,int postion)
	{
		try
		{
			String[] DataValue= DataValues.split("##");
			for (int i = 0; i < DataValue.length; ) 
			{
				validateDropDown(objLocatorButton,DataValue[postion]);
				break;
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateChangeValueDropDown:"+e.toString());
		}
	}
	
	public void ScrollTovalidateChangeValueDropDown(String DataValues,String objLocatorButton,int postion)
	{
		try
		{
			String[] DataValue= DataValues.split("##");
			for (int i = 0; i < DataValue.length;) 
			{
				ScrollTovalidateDropDown(objLocatorButton,DataValue[postion]);
				break;
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateChangeValueDropDown:"+e.toString());
		}
	}



}
