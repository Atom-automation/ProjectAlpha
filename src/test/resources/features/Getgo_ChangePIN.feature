# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be able to be able to change my PIN real-time so I can keep my account secure.
# ========================================================================================================================================

@ChangePIN
Feature: Change PIN

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want to be able to be able to change my PIN real-time so I can keep my account secure
    Given I'm on "Dashboard" page of GetGo pay with valid "changePIN_username" and "changePIN_password"
    When  I choose Settings option from the menu
    Then  I should see "Settings" page
    When  I choose "Card PIN" option from settings page
    Then  I should see "Update Card PIN" page with "Current PIN" , "New PIN" and "Confirm PIN" textboxes, close and Save buttons
    When  I Enter Current PIN, New PIN and Confirm PIN details
    And   click submit button in the update card PIN page
    Then  I should see One Time Password page
    When  I Enter OTP details
    Then  PIN should be updated successfully


