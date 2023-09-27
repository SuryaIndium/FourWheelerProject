Feature: User able to login to the application

  @E2EFlow
  Scenario Outline: E2E flow for the ISD BFL Application
    #Given User able to login the application valid Mobile Number
    #When user able to navigate the Welcome khataria Motors "<Select Login New File>"
    Then User able to navigate the Select your page select the option "<Tell Us about profession>" "<Type of vehicle Finance>" "<Usage Type>"
    Then User able to navigate the Customer Details "<Salutation>" "<Firstname>" "<Middlename>" "<LastName>" "<Select Gender>" "<DOB>" "<Mobile Number>" "<EmailID>" "<PinCode>"

    #When User can verify and click on the proceed button on the eligibility page
    #When User can go with the KYC page
    #When User can update the parmanent address
    Examples: 
      | Select Login New File | Tell Us about profession | Type of vehicle Finance | Usage Type | Salutation | Firstname | Middlename | LastName | Select Gender | DOB        | Mobile Number | EmailID               | PinCode |
      | Login a New File      | Salaried                 | Single                  | Personal   | Mr.        | Jack      | User       | One      | Male          | 2000-08-01 |    9873653423 | jackuserone@gmail.com |  411014 |
  #Scenario Outline: User able check STP Green Status Eligibility Status
    #Given User able to login the application
    #When User able navigate the Khataria Motror"<Select Loan Application>"
    #Then User able to Fill the all details Permantent Screen
    #Then User able to Fill the all Details in RC Details Screen and validate "<coApplicantValue>"
    #Then User able to Fill the all Details in CoApplicant Screen
    #Then User able to Fill the all Details Additional Details Screen
#
    #Examples: 
      #| Select Loan Application | coApplicantValue |
      #| My Loan Application     | YES              |
#
#
  #Scenario Outline: User able to navigate the Congratulations screen.
    #Given User able to login the application
    #When User able navigate the Khataria Motror"<Select Loan Application>"
    #Then User able to Fill the All Details in Asset Details Screen.
    #Then User able to Fill All Details in Review Loan Details Screen and Loan Details Screen.
    #Then User able to validate the All Details Banking Details Screen and IMPS Screen.
    #Then User able to validate the E-Mandate Awaited Screen.
#
    #Examples: 
      #| Select Loan Application |
      #| My Loan Application     |
