package common;

import com.automation.qa.isafe.driver.DriverManager;

import pages.Mobile.*;

import org.openqa.selenium.remote.RemoteWebDriver;

public class PageObjects extends ApplicationKeywords {

	public RemoteWebDriver driver;
	public ApplicationKeywords applicationKeywords;

	
	public BajajLogin bajajlogin;
	public EligibilityCheck eligibilitycheck;
	public KYC kyc;
	public PermanentAddress permanentaddress;
	public AdditionalDeatails additionaldeatails;
	public RCDeliveryAddress rcdeliveryaddress;
	public Welcome welcome;
	public CustomerDeatails customerdeatails;
    public SelectYourProfession selectyourprofession;
    public AdditionalDeatails additionalDeatails;
    public MyLoanApplication myLoanApplication;
    public CoApplicant coApplicant;
    public AssetDetails assetDetails;
    public ReviewLoanDetails reviewLoanDetails;
    public EligibilityLetterSummary eligibilityLetterSummary;
    public LoanDetails loanDetails;
    public BankingDetails bankDetails;
    public IMPS iMPS;
    public AddFrimAsApplicantCustomerDetails addFrimAsApplicantCustomerDetails;
    
	public PageObjects() {

		super(DriverManager.getDriver(), BaseClass.obj.get());

		driver = DriverManager.getDriver();
		applicationKeywords = new ApplicationKeywords(driver);

	
		welcome = new Welcome(driver, BaseClass.obj.get());
		bajajlogin = new BajajLogin(driver, BaseClass.obj.get());
		customerdeatails= new CustomerDeatails(driver, BaseClass.obj.get());
		selectyourprofession = new SelectYourProfession(driver, BaseClass.obj.get());
		eligibilitycheck = new EligibilityCheck(driver, BaseClass.obj.get());
		kyc = new KYC(driver, BaseClass.obj.get());
		permanentaddress =  new PermanentAddress(driver, BaseClass.obj.get());
		additionaldeatails = new AdditionalDeatails(driver, BaseClass.obj.get());
		rcdeliveryaddress =  new RCDeliveryAddress(driver, BaseClass.obj.get());
		additionalDeatails = new AdditionalDeatails(driver, BaseClass.obj.get());
		myLoanApplication = new MyLoanApplication(driver,BaseClass.obj.get());
		coApplicant = new CoApplicant(driver,BaseClass.obj.get());
		assetDetails= new AssetDetails(driver,BaseClass.obj.get());
		reviewLoanDetails = new ReviewLoanDetails(driver,BaseClass.obj.get());
		eligibilityLetterSummary = new EligibilityLetterSummary(driver,BaseClass.obj.get());
		loanDetails= new LoanDetails(driver,BaseClass.obj.get());
		bankDetails = new BankingDetails(driver,BaseClass.obj.get());
		iMPS= new IMPS(driver,BaseClass.obj.get());
		addFrimAsApplicantCustomerDetails = new AddFrimAsApplicantCustomerDetails(driver,BaseClass.obj.get());
		}
}
