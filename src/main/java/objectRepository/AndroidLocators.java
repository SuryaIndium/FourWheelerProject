package objectRepository;

public class AndroidLocators {

	public static final String orName = "Andoid OR";

	public static String panNumber = "";
	public static String Mobile = "";

	public static final String mobileNumber = "Mobile Number#xpath=//android.widget.EditText[@resource-id='com.bfl.isdcia.dev:id/et_mobile_no']";
	public static final String sendOTP = "Send otp#xpath=//android.widget.Button[@text='SEND OTP']";
	
	//Welcome screen
	public static final String label_welcomePage = "Title Welcome Page#xpath=//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='com.bfl.isdcia.dev:id/header_card']";
	public static final String txt_listofWelcomeValues="Welcome page value#xpath=//android.widget.LinearLayout/android.widget.TextView";

	public static final String welcomePage = "Welcome Page#xpath=//androidx.appcompat.widget.LinearLayoutCompat[@resource-id='com.bfl.isdcia.dev:id/header_card']";

	public static final String select_Your_Profession ="Select your profession#xpath=//android.widget.TextView[@text='Select your profession']";
	
	public static final String Salaried ="Salaried#xpath=//android.widget.TextView[@text='Salaried']";
    public static final String single ="Salaried#xpath=//android.widget.TextView[@text='Single']";
    public static final String personal ="personal#xpath=//android.widget.TextView[@text='Personal']";
    public static final String pan ="pan#xpath=//android.widget.EditText[@text='PAN']";
    public static final String mobile ="mobile#xpath=//android.widget.EditText[@text='Mobile']]";
    
    public static final String customerDetailsPage = "Customer Details Page#xpath=//android.widget.TextView[@text='Customer Details']";
	
    public static final String kycPage = "kyc page#xpath=//android.widget.TextView[@text='KYC']";
	public static final String digilocker = "digilocker#xpath=//android.widget.TextView[@text='Digilocker']";
	
	
	public static final String errorMessage ="ErrorMessage#id=com.bfl.isdcia.dev:id/textinput_error";
	public static final String motherFirstName = "Mother Fisrt Name#xpath=//android.widget.EditText[@resource-id='com.bfl.isdcia.dev:id/et_mother_first_name']";
	public static final String mothermiddleName = "Mother middle Name#xpath=//android.widget.EditText[@resource-id='com.bfl.isdcia.dev:id/et_mother_middle_name']";
	public static final String motherlastName = "Mother last Name#xpath=//android.widget.EditText[@resource-id='com.bfl.isdcia.dev:id/et_mother_last_name']";

	public static final String proceedbtn ="Proceed Btn#xpath=//android.widget.Button[@resource-id='com.bfl.isdcia.dev:id/button_proceed']";
	public static final String refreshIcon = "refresh icon#xpath=//android.widget.TextView[@resource-id='com.bfl.isdcia.dev:id/menu_item_refresh']";
	
	public static final String enterYourAdditionalDeatailPage = "Enter Your Additional Deatail#xpath=//android.widget.TextView[@text='Enter your Additional Details']";
	public static final String employerName = "Employer Name#id=com.bfl.isdcia.dev:id/ed_employer_name";
	public static final String search = "Employer Search Field#id=com.bfl.isdcia.dev:id/text_input_end_icon";
	public static final String selectBajaj = "BAJAJ#id=com.bfl.isdcia.dev:id/tv_modelType";
	public static final String officeMailID = "OfficemailID#id=com.bfl.isdcia.dev:id/et_employer_email";
	
	
	public static final String requiredLoanAmounr = "RequiredLoanAmount#id=com.bfl.isdcia.dev:id/et_req_loan_amt";
	public static final String vintageInCurrentCompany = "vintageincurrentcompany#id=com.bfl.isdcia.dev:id/et_vintage";
	public static final String validate = "validate#id=com.bfl.isdcia.dev:id/button_validate";
	
	public static final String addressUpload = "upload#xpath=//android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_ncf_attach']";
    public static final String addressuploadbtn = "upload icon#xpath=//android.widget.TextView[@text='Address Proof']/following::android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_addressproof']";

    public static final String identityUpload = "upload#xpath=//android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_ncf_attach2']";
    public static final String identityUploadbtn = "upload icon#xpath=//android.widget.TextView[@text='Identity Proof']/following::android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_identityproof']";
	
    public static final String uploadbtn = "upload document#xpath=//android.widget.TextView[@text='Upload Document']/following::android.widget.ImageView[@resource-id='com.bfl.isdcia.dev:id/ic_upload_document']";
    
	//AssetDetails Screen
    
    public static final String label_AssetDetails="Title Asset Detail#xpath=//android.widget.TextView[@text='Asset Details']";
    
    
    //Permantent Address
    public static final String btn_CloseIcon="DropDown Close Icon#id=com.bfl.isdcia.dev:id/iv_close";
    public static final String txt_firstName="FirstName#id=com.bfl.isdcia.dev:id/et_first_name";
    
    public static final String txt_MiddleName="MiddleName#id=com.bfl.isdcia.dev:id/et_middle_name";
    public static final String txt_LastName="LastName#id=com.bfl.isdcia.dev:id/et_last_name";
    public static final String txt_DOB="DOB#id=com.bfl.isdcia.dev:id/edt_dob";
    public static final String txt_Address1="AddressLine1#id=com.bfl.isdcia.dev:id/et_address1";
    public static final String txt_Address2="AddressLine2#id=com.bfl.isdcia.dev:id/et_address2";
    public static final String txt_Address3="AddressLine3#id=com.bfl.isdcia.dev:id/et_address3";
    public static final String CheckBox_RCDelivery="CeckBox RC Delivery Address#id=com.bfl.isdcia.dev:id/chkRCDeliveryAddress";
    public static final String year = "year#id=android:id/date_picker_header_year";
    public static final String date = "Date#xpath=//android.view.View[@text='6']";
    

	public static final String Title_PermanentScreen="Title Permanent Scree#xpath=//android.widget.TextView[@text='Permanent Address']";
	public static final String btn_Gender="Button Gender#id=com.bfl.isdcia.dev:id/et_gender";
	public static final String btn_DocumentType="Button Document Type#id=com.bfl.isdcia.dev:id/et_kyc_doc_type";
		
	public static final String btn_IdentityDocumentType="Button Gender#id=com.bfl.isdcia.dev:id/et_identy_doc_type";
	public static final String btn_MaritalStatus="Button Marital Status#id=com.bfl.isdcia.dev:id/et_marital_status";
	public static final String btn_GrossIncome="Button GrossIncome#id=com.bfl.isdcia.dev:id/et_gross_income";
	public static final String btn_NatureofBusiness="Button Nature Of Business#id=com.bfl.isdcia.dev:id/et_nature_of_business";

    
    //RC Details
    public static final String ExpiryDocumentDate ="ExpiryDocument#id=com.bfl.isdcia.dev:id/et_doc_exp";
    
 public static final String menuButton="Side menu button#xpath=//android.widget.ImageButton[@content-desc='Show roots']";
 public static final String txt_Downloads= "Download#xpath=//android.widget.ListView[@resource-id='com.google.android.documentsui:id/roots_list']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='Downloads']";
public static final String txt_Image="Image#xpath=//android.widget.ListView[@resource-id='com.google.android.documentsui:id/roots_list']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[@text='Images']";
 public static final String Search_Icon="Uploading search Icon#xpath=//android.widget.TextView[@content-desc='Search']";
 public static final String txt_search ="Search text#id=com.google.android.documentsui:id/search_src_text";
 public static final String select_Document="click on the document#id=com.google.android.documentsui:id/icon_thumb";
 public static final String txt_ScreenShot ="Screenshot#xpath=//android.widget.TextView[@text='Screenshots']";
 public static final String txt_Crop ="Crop#xpath=//android.widget.TextView[@text='CROP']";
 
 public static final String PermantentScreen_dateOFBirth=  "Date Of Birth#id=com.bfl.isdcia.dev:id/edt_dob";
 public static final String CoApplicantScreen_DateOfBirth="Date Of Birth#id=com.bfl.isdcia.dev:id/edtDateOfBirth";
 
 public static final String CoApplicant_AdddressLine1="AddressLine1#id=com.bfl.isdcia.dev:id/ncfCoAppAddress_1";
 public static final String CoApplicant_AddressLine2="AddressLine2#id=com.bfl.isdcia.dev:id/ncfCoAppAddress_2";
 public static final String CoApplicant_AddressLine3="AddressLine3#id=com.bfl.isdcia.dev:id/ncfCoAppAddress_3";
 
 public static final String CoApplicant_AddressUpload="CoApplicant Address Upload#id=com.bfl.isdcia.dev:id/ic_address_proof_attachment";
 public static final String CoApplicant_AddressUploadbtn="CoApplicant Address Upload Button#id=com.bfl.isdcia.dev:id/icAddressDocStatus";
 public static final String CoApplicant_IdentityUpload ="CoApplicant Identity Upload#id=com.bfl.isdcia.dev:id/ic_identity_attachment";
 public static final String CoApplicant_IdentityUploadbtn="CoApplicant Identity Upload Button#id=com.bfl.isdcia.dev:id/icIdentityDocStatus";
public static final String txt_AddressProof="Address proof#xpath=//android.widget.TextView[@text='Address Proof']";
public static final String txt_IdentityProof="IdentityProof#xpath=//android.widget.TextView[@text='Identity Proof']";

//Asset Details

public static final String btn_Make="Button for Make#id=com.bfl.isdcia.dev:id/edt_assest_make";
public static final String btn_FuelType = "Button for FuelType#id=com.bfl.isdcia.dev:id/edt_assest_fuel_type";
public static final String btn_Model = "Button for Model#xpath=//android.widget.LinearLayout[@resource-id='com.bfl.isdcia.dev:id/ti_ncf_model']";
public static final String btn_Variant ="Button for Variant#id=com.bfl.isdcia.dev:id/edtAssetvariant";
public static final String btn_InsuranceType ="Button for InsuranceType#id=com.bfl.isdcia.dev:id/tv_insurance_type";
public static final String btn_RegistrationType ="Button for RegistrationType#id=com.bfl.isdcia.dev:id/etRegistrationType";

public static final String dropDownValue="Select the DropDown Value#xpath=//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView";


public static final String dropDownLoanAmount ="LoanAmount#id=com.bfl.isdcia.dev:id/slider_loan_amt";
public static final String dropDownLoanTenor = "LoanTenor#id=com.bfl.isdcia.dev:id/slider_loan_tenor";
public static final String dropDownROI="Drop Down ROI#id=com.bfl.isdcia.dev:id/slider_roi";

public static final String btn_Procced=" Procced Button#xpath=//android.widget.Button[@text='PROCEED']";


	
}
