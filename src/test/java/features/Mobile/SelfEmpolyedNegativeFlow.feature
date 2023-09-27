Feature: User able to check selfEmpolyee Flow for Invalid Data

@selfEmployedNegative
 Scenario Outline: User able to login the application with SelfEmployed Flow Invalid Data
    Given User able to login the application valid Mobile Number
    When user able to navigate the Welcome khataria Motors "<Select Login New File>"
    Then User able to navigate the Select your page Check with Invalid Data "<Tell Us about profession>" "<Type of vehicle Finance>" "<Usage Type>" "<vehicle in the name>"
    Then User able to navigate the Customer Details Enter the option Invalid Data "<Salutation>" "<Firstname>" "<Middlename>" "<LastName>" "<Select Gender>" "<DOB>" "<Mobile Number>" "<EmailID>" "<PinCode>" "<Firm Name>"
    Then User able to navigate the Frist Eligibility Screen.
		Then User able to navigate the KYC screen
		
    Examples: 
      | Select Login New File | Tell Us about profession | Type of vehicle Finance | Usage Type | vehicle in the name | Salutation | Firstname | Middlename | LastName | Select Gender | DOB        | Mobile Number | EmailID               | PinCode | Firm Name  |
      | Login a New File      | Self Employed            | Single                  | Personal   | Individual          | Mr.        | Jack      | User       | One      | Male          | 2000-08-01 |    9873653423 | jackuserone@gmail.com |  411014 | Henry User |
@selfEmployedNegative
  Scenario Outline: User able to navigate second Eligibility Screen
    Given User able to Enter All Details Invalid Data Permanent Screen "<MotherFirstName>" "<MotherMiddleName>" "<MotherLastName>" "<AddressLineOne>" "<AddressLineTwo>" "<AddressLineThree>" "<ZipCode>" "<City>" "<State>" "<AddressDocumentType>" "<AddressDocumentNumber>" "<IdentityDocumentType>" "<MaritalStatus>" "<GrossAnnualIncome>" "<NatureofBusiness>"
    Then User able to Enter All Details Invalid Data Rc Delivery Address "<AddressType>" "<AddressLineOne>" "<AddressLineTwo>" "<AddressLineThree>" "<ZipCode>" "<City>" "<State>" "<AddressDocumentType>" "<AddressDocumentNumber>"
    Then User able to Enter All Details Invalid Data Customer Details Add Firm as Applicant "<AddressType>" "<AddressLineOne>" "<AddressLineTwo>" "<AddressLineThree>" "<ZipCode>" "<City>" "<State>" "<AddressDocumentType>" "<AddressDocumentNumber>"
    Then User able to Enter All Details Invalid Data Co-Applicant Screen "<ApplicantType>" "<FirstName>" "<MiddleName>" "<LastName>" "<Select Gender>" "<DOB>" "<AddressLineOne>" "<AddressLineTwo>" "<AddressLineThree>" "<ZipCode>" "<City>" "<State>" "<AddressDocumentType>" "<AddressDocumentNumber>" "<IdentityDocumentType>"
    Then User able to Enter All Details Invalid Data Additional Details Screen "<BusinessVintage>" "<DateOfIncorportion>" "<RequiredLoanAmount>"
    Then User able to Navigate the Second Eligibility Screen

    Examples: 
      | MotherFirstName | MotherMiddleName | MotherLastName | AddressLineOne | AddressLineTwo | AddressLineThree | ZipCode | City | State       | AddressDocumentType | AddressDocumentNumber | IdentityDocumentType | MaritalStatus | GrossAnnualIncome | NatureofBusiness | AddressType       | ApplicantType             | FirstName | MiddleName | LastName | Select Gender | DOB        | BusinessVintage | DateOfIncorportion | RequiredLoanAmount |
      | Noah            | User             | One            | #Pune          | Middle East    | East Coast Road  |  411014 | Pune | Maharashtra | OVD-Driving Licence |                989387 | Trust Deed           | Single        | 10 to 25 Lakhs    | Services         | Current Residence | Non Financial CoApplicant | Jack      | Sparrow    | User     | Male          | 1999-05-10 | 1000000          | 2000-08-01         |             500000 |
      