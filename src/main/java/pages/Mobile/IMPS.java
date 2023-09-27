package pages.Mobile;

import org.openqa.selenium.remote.RemoteWebDriver;

import common.ApplicationKeywords;
import common.BaseClass;
import common.Constants;

public class IMPS extends ApplicationKeywords
{
	public IMPS(RemoteWebDriver driver, BaseClass obj)
	{
		super(driver, obj);
	}
	
	public static final String label_IMPS = "Title IMPS#xpath=//android.widget.TextView[@text='IMPS']";
	public static final String txt_IMPSAwaitingStatus ="IMPS Awaiting Status#id=com.bfl.isdcia.dev:id/tv_ncf_mandate_status";
	public static final String btn_REInitiate="Button Re-Initiate#xpath=//android.widget.Button[@text='RE-INITIATE']";
	public static final String img_IMPSUpload="File Upload icon#id=com.bfl.isdcia.dev:id/tv_upload_doc";
	public static final String img_IMPSFileAttach="File Attach#id=com.bfl.isdcia.dev:id/img_ncf_attach";
	public static final String btn_Proceed = "Proceed Button#xpath=//android.widget.Button[@text='PROCEED']";
	
	//EMandateScreen
	public static final String label_EMAndateScreen= "Title EMandate Screen#xpath=//android.widget.TextView[@text='E-MANDATE']";
	public static final String txt_EmandatesuccessMsg=" Text E-Mandate Success Message#xpath=//android.widget.TextView[@text='E-Mandate Success']";
	
	public static final String label_EApplication= "Title E-Application and E-Agreement#xpath=//android.view.ViewGroup[@resource-id='com.bfl.isdcia.dev:id/ncf_toolbar']/android.widget.TextView[@text='E-Application and E-Agreement']";
	public static final String img_EApplicationFileAttach ="File Attach#id=com.bfl.isdcia.dev:id/ic_application_attachment";
	public static final String img_EApplicationUpload ="File Upload Icon#id=com.bfl.isdcia.dev:id/ic_upload_application";
	
	public static final String label_NCFEAgreement="Title NCF EAgreement EApplication#xpath=//android.widget.TextView[@text='NCFEAgreementEApplicationSSuccessFragment']";
	public static final String txt_EAgreementSuccess="Text EAgreement status#xpath=//android.widget.TextView[@text='E-Agreement Success']";
	
	
	//E-Mandate Failed
	public static final String label_EMandateFailed= "Title EMandate Failed#xpath=//android.view.ViewGroup[@resource-id='com.bfl.isdcia.dev:id/ncf_toolbar']/android.widget.TextView[@text='E-Mandate Failed']";
	public static final String SelectApplicantType="Select Applicant#id=com.bfl.isdcia.dev:id/edt_repaybank_applicant";
	public static final String SelectApplicantTAccountType="Select Account Type#id=com.bfl.isdcia.dev:id/edt_repaybank_account_type";
	public static final String txt_AccountNumber ="Account number#id=com.bfl.isdcia.dev:id/edt_repaybank_account_number";
	public static final String txt_AccountHolderName="Account Holder Name#id=com.bfl.isdcia.dev:id/txtInputLayoutAccountName";
	public static final String txt_BankName="Bank Name#id=com.bfl.isdcia.dev:id/edt_repaybank_name";
	public static final String txt_IFSCCode="Bank ISFC Code#id=com.bfl.isdcia.dev:id/edt_repaybank_ifsc_code";
	public static final String txt_OpenECSFacility=" Open ECS Facility#id=com.bfl.isdcia.dev:id/edt_repaybank_open_ecs";
	public static final String txt_ECSAmount = "ECS Amount#id=com.bfl.isdcia.dev:id/edt_repaybank_ecs_amount";
	public static final String txt_StartDate="ECS Start Date#id=com.bfl.isdcia.dev:id/edt_repaybank_ecs_start_date";
	public static final String txt_EndDate="ECS End Date#id=com.bfl.isdcia.dev:id/edt_repaybank_ecs_end_date";
	public static final String txt_BarCode="Enter BarCode#id=com.bfl.isdcia.dev:id/edt_repaybank_barcode";
	public static final String txt_OpenECSValidity="Date for Open ECS validity#id=com.bfl.isdcia.dev:id/edt_repaybank_ecs_validity";
	public static final String img_EmandateFailedFiledAttach ="File Attach#id=com.bfl.isdcia.dev:id/imgattachment";
	public static final String img_EmandateFailedFileUpload="File upload#id=com.bfl.isdcia.dev:id/ncf_doc_title";
	
	//E-Mandate Awaited
	public static final String label_EMandateAwaitedScreen ="Label-EMandate Awaited Screen#xpath=//android.view.ViewGroup[@resource-id='com.bfl.isdcia.dev:id/ncf_toolbar']/android.widget.TextView";
	public static final String btn_Re_Initiate="Button Re-Initiate#xpath=//android.widget.Button[@text='RE-INITIATE']";
	
	//Document CheckList
	public static final String proofOfAddress ="Proof Of Address#id=com.bfl.isdcia.dev:id/img_proof_of_address";
	public static final String img_UploadDoucument ="Upload Document#id=com.bfl.isdcia.dev:id/img_ncf_attachment";
	public static final String confirmationPopup="Confirmation Popup#classname=androidx.appcompat.widget.LinearLayoutCompat";
	public static final String txt_YesUploadDocument="Text For Yes#xpath=//android.widget.Button[@resource-id='com.bfl.isdcia.dev:id/button_yes']";
	public void validateIMPSScreen()
	{
		try
		{
			validateIMPSAwaiting();
			//validateEMandateScreen();
			validateEMandateAwaitedScreen();
			validateEMandateFailedScreen();
			validateEApplicationScreen();
			validateNCFAgreementScreen();
			
		}
		catch (Exception e) 
		{
			testStepFailed("Exception in the method validateIMPSScreen:"+e.toString());
		}
	}
	
	public void validateIMPSAwaiting()
	{
		try
		{
			waitForElementToDisplay(label_IMPS, 10);
			if (elementDisplayed(txt_IMPSAwaitingStatus)) 
			{
				waitTime(3);
				verifyElementIsDisplayed(img_IMPSFileAttach);
				clickOn(img_IMPSFileAttach);
				navigateTODownloadFile();
				navigateTOImageFile(img_IMPSFileAttach,img_IMPSUpload);
				if(getAttributeValue(btn_Proceed, "enabled").equalsIgnoreCase("true"))
				{
					clickOn(btn_Proceed);
				}
				else
				{
					testStepFailed("couldn't enable the procced button");
				}
			}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateIMPSAwaiting:"+e.toString());
		}
	}
	
	
	public void validateEMandateFailedScreen()
	{
		try
		{
			String AccountType= retrieve("AccountType");//Savings
			String barCode =retrieve("BarCode");
			
			waitTime(10);
			waitForElementToDisplay(label_EMandateFailed, 10);
			if(isElementDisplayed(label_EMandateFailed))
			{
				validategetText(SelectApplicantType);
				clickOn(SelectApplicantTAccountType);
				getElementAndClick("dropDownValue", AccountType);
				getText(SelectApplicantTAccountType,AccountType);
				validategetText(txt_AccountNumber);
				scrollToId("com.bfl.isdcia.dev:id/edt_repaybank_ecs_amount");
				validategetText(txt_AccountHolderName);
				validategetText(txt_BankName);
				validategetText(txt_IFSCCode);
				validategetText(txt_OpenECSFacility);
				waitTime(3);
				
				scrollToElement(Constants.proceed);
				validategetText(txt_ECSAmount);
				validategetText(txt_StartDate);
				validategetText(txt_EndDate);
				typeIn(txt_BarCode,barCode);//5467756445
				closeKeyBoard();
				getText(txt_OpenECSValidity);
				waitTime(3);
				verifyElementIsDisplayed(img_EmandateFailedFiledAttach);
				clickOn(img_EmandateFailedFiledAttach);
				navigateTODownloadFile();
				navigateTOImageFile(img_EmandateFailedFiledAttach,img_EmandateFailedFileUpload);
				clickOn(btn_Proceed);
				waitTime(10);
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateEMandateFailedScreen:"+e.toString());
		}
	}
	
	public void validategetText(String objLocator)
	{
		try
		{
			waitForElementToDisplay(objLocator, 10);
			if(isElementDisplayed(objLocator))
			{
			getText(objLocator);
			}
			else
			{
				testStepFailed("couldn't able to locate getText element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validategetText:"+e.toString());
		}
	}
	
	public void validateEMandateScreen()
	{
		try
		{
			waitForElementToDisplay(label_EMAndateScreen, 10);
			if(isElementPresent(label_EMAndateScreen))
			{
				getText(txt_EmandatesuccessMsg);
				clickOn(btn_Proceed);
			}
			else
			{
				testStepFailed("couldn't able to locate element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateEMandateScreen:"+e.toString());
		}
	}
	
	public void validateEApplicationScreen()
	{
		try
		{
			waitForElementToDisplay(label_EApplication, 10);
			if(isElementDisplayed(label_EApplication))
			{
				verifyElementIsDisplayed(img_EApplicationFileAttach);
				clickOn(img_EApplicationFileAttach);
				navigateTODownloadFile();
				navigateTOImageFile(img_EApplicationFileAttach,img_EApplicationUpload);
				waitTime(10);
				while (elementDisplayed(label_EApplication))
				{
					waitTime(10);
					clickOn(btn_Proceed);
				}
			}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
			
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateEApplicationScreen:"+e.toString());
		}
	}
	
	public void validateNCFAgreementScreen()
	{
		try
		{
			waitForElementToDisplay(label_NCFEAgreement, 10);
			if (elementDisplayed(label_NCFEAgreement))
			{
				verifyElementIsDisplayed(txt_EAgreementSuccess);
				testStepPassed(getText(txt_EAgreementSuccess));
				clickOn(btn_Proceed);
			}
			else
			{
				testStepFailed("couldn't able to locate the element");
			}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateNCFAgreementScreen:"+e.toString());
		}
	}
	
	public void validateEMandateAwaitedScreen()
	{
		try
		{
			waitForElementToDisplay(label_EMandateAwaitedScreen, 10);
				while (elementDisplayed(label_EMandateAwaitedScreen)) 
				{
					waitTime(10);
					clickOn(btn_Re_Initiate);
				}
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateEMandateAwaitedScreen:"+e.toString());
		}
	}
	
	public void validateDocumentheckList()
	{
		try
		{
			
		}
		catch (Exception e)
		{
			testStepFailed("Exception in the method validateDocumentheckList:"+e.toString());
		}
	}
	
//	public void validateUploadFile()
//	{
//		try
//		{
//			clickOnButtonValue(proofOfAddress);
//			waitForElementToDisplay(proofOfAddress, 10);
//			if(elementDisplayed(proofOfAddress))
//			{
//				waitTime(10);
//				   waitForElementToDisplay(objLocator,10);//addressUpload
//				   clickOn(objLocator);
//				   waitTime(3);
//				   if(isElementDisplayed("menuButton"))
//				   {
//					   waitTime(3);
//					   clickOn("menuButton");
//					   verifyElementIsDisplayed("txt_Image");
//					   clickOn("txt_Image");
//					   waitTime(3);
//					   clickOn("txt_ScreenShot");
//					   if(isElementDisplayed("Search_Icon"))
//					   {
//						   clickOn("Search_Icon");
//						   typeIn("txt_search", "Image.jpg");
//						   closeKeyBoard();
//						   clickOn("select_Document");
//						   waitTime(3);
//						   clickOn("txt_Crop");
//			}
//		}
//		catch (Exception e)
//		{
//			testStepFailed("Exception in the method validateUploadFile:"+e.toString());
//		}
//	}
			
			public void validateConfirmationPopUp()
			{
				try
				{
					waitForElementToDisplay(confirmationPopup, 10);
					if(elementDisplayed(confirmationPopup))
					{
						clickOnButtonValue(txt_YesUploadDocument);
					}
				}
				catch (Exception e)
				{
					testStepFailed("Exception in the method validateConfirmationPopUp:"+e.toString());
				}
			}
	
}
