Feature: User able to login to the application

  @salaried
  Scenario Outline: User able to Navigate Salaried Flow in Eligiblity Screen.
    Given User able to login the application valid Mobile Number
    When user able to navigate the Welcome khataria Motors "<Select Login New File>"
    Then User able to navigate the select the Profression Screen "<Tell Us about profession>" "<Type of vehicle Finance>" "<Usage Type>"
    Then User able to navigate the Customer Details Screen "<Salutation>" "<Firstname>" "<Middlename>" "<LastName>" "<Select Gender>" "<DOB>" "<Mobile Number>" "<EmailID>" "<PinCode>"
    Then User able to navigate the Frist Eligibility Screen.
    Then User able to navigate the KYC screen
    
    Examples: 
      | Select Login New File | Tell Us about profession | Type of vehicle Finance | Usage Type | Salutation | Firstname | Middlename | LastName | Select Gender | DOB        | Mobile Number | EmailID               | PinCode |
      | Login a New File      | Self Employed            | Single                  | Personal   | Mr.        | Jack      | User       | One      | Male          | 2000-08-01 |    9873653423 | jackuserone@gmail.com |  411014 |
