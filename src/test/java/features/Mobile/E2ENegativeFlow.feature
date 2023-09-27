Feature: Validate the ErrorMessage for All Field

   @E2ENegativeFlow
  Scenario: User able validate the errorMessage in all field
    Given User validate errorMesssage in login Page
    When User naviagte to Welcome Khataria Motors
    Then User validate errorMessage in select the profession page
    Then User validate errorMessage in customerDetail Page

  #And User able Navigate and click on the proceed button on the eligibility page
  #When User able Navigate to KYC page

  Scenario Outline: User able View Awaiting Loan Apporval Page
    Given User validate errorMesssage in login Page
    When User naviagte to Welcome Khataria Motors "<Select Loan Application>"
    Then Enter the Name in My Loan Application page and validate KYC Page
    Then User able validate the errorMessgae in permantant Address Page Screen
    Then User able validate the errorMessage in RC Delivery Address Page Screen and Validate "<coApplicantValue>"
    Then User able to validate the errorMessage in Additional Details Page screen

    Examples: 
      | Select Loan Application | coApplicantValue |
      | My Loan Application     | YES              |
