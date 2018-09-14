
# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be see the Terms and Conditions page of the GetoPay app so that i am aware about the TERMS & CONDITIONS and PRIVACY POLICY details
# ========================================================================================================================================

@TermsandConditions
Feature: TermsandConditions

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want to be see the Terms and Conditions page of the GetoPay app so that i am aware about the TERMS & CONDITIONS and PRIVACY POLICY details
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    When I choose More menu options from the GetGopay dashboard page
    Then More page should be displayed with the options "About the Cards", "Contact Us","Frequently Asked Questions" & "Terms & Conditions"
    When I click on "Terms & Conditions" option
    Then Terms & Conditions page should be displayed with two sections "TERMS & CONDITIONS" and "PRIVACY POLICY" & verify the contents




