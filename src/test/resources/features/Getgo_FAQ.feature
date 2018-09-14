
# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be see the Frequently Asked Question page of the GetoPay app so that i am able to see FAQ details
# ========================================================================================================================================

@FAQ
Feature: Frequently Asked Question

  Background: Login into account
    Given I'm on Getgo landing page
@dummy
  Scenario: As a tester, I want to be see the Frequently Asked Question page of the GetoPay app so that i am able to see FAQ details
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    When I choose More menu options from the GetGopay dashboard page
    Then More page should be displayed with the options "About the Cards", "Contact Us","Frequently Asked Questions" & "Terms & Conditions"
    When I click on "Frequently Asked Questions" option
    Then Frequently Asked Questions page should be displayed with three frequently asked questions "What's the main difference of the GetGo Virtual Prepaid vs GetGo Peso+ Card? What is best for me?","What are the requirements to get the GetGo Virtual Prepaid?" & "How much is the GetGo Virtual Prepaid?"




