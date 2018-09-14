# ===============================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to be able to register my personal details so that I can be issued a virtual card.
# ===============================================================================================================================

@VirtualRegistration
  Feature: New Virtual Card Registration

    Background: Open Getgo mobile application
      Given I'm on Getgo landing page

    @AndroidOnly
    Scenario: Register a new virtual card
      Given I'm on Getgo virtual card registration screen
      When  I enter Mobile Number, Email Address, and Nominate and Confirm password
      And   I enter one time password
      And   I fill my personal details
      And   I review & submit
      And   I click verify now
      Then  I should see the dashboard
      When  I click the verification email link from my inbox
      Then  I should see a message account is verified
      When  I login with the My Email next time
      Then  I should see my virtual card in the dashboard