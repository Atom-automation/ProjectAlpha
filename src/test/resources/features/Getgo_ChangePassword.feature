# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be able to be able to change my password real-time so I can keep my account secure.
# ========================================================================================================================================

@ChangePassword
Feature: Change Password

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want to be able to be able to change my password real-time so that I can keep my account secure.
    Given I'm on "Dashboard" page of GetGo pay with valid "change_username" and "change_password"
    When  I choose Settings option from the menu
    Then  I should see "Settings" page
    When  I choose "Password" option from settings page
    Then  I should see "Update Password" page with "Enter Old password","Enter New password","Confirm New password" and  "SUBMIT" button
    When  I Enter old password, Nominate and confirm new password
    And   click submit button
    And   I should see One Time Password page
    And   Enter OTP details
    Then  Password should be updated
    When  I logout and login with updated password
    Then  Login should be successfull and Dashboard page should be displayed


