
Feature: User able navigate to Eligibility Screen
@STPGreen
  Scenario Outline: User able check STP Green Status Eligibility Status
    Given User able to login the application
    When User able navigate the Khataria Motror"<Select Loan Application>"
    Then User able to Fill the all details Permantent Screen
    Then User able to Fill the all Details in RC Details Screen and validate "<coApplicantValue>"
    Then User able to Fill the all Details in CoApplicant Screen
    Then User able to Fill the all Details Additional Details Screen

    Examples: 
      | Select Loan Application | coApplicantValue |
      | My Loan Application     | YES              |
