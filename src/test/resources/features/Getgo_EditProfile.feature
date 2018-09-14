# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be able to change my personal profile so that my details are updated.
# ========================================================================================================================================

@EditProfile
Feature: Edit Profile

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a tester, I want to be able to change my personal profile so that my details are updated - Edit Mobile number
    Given I'm on "Dashboard" page of GetGo pay with valid "edit_username" and "edit_password"
    When  I choose Settings option from the menu
    Then  I should see "Settings" page
    When  I choose "Profile" option from settings page
    Then  I should see "Manage Profile" page with "PERSONAL DETAILS" , "ADDRESS" and "OTHER DETAILS" sections
    When  I click on edit link in the "Mobile Number" section
    Then  "Update Mobile Number" page should be displayed with a edit mobile textbox, "SAVE" and "NEXT" button
    When  I enter new mobile number
    And   click next button
    And   Enter OTP details
    Then  Mobile number should be updated and verified in "Manage Profile" page
@two
  Scenario: As a tester, I want to be able to change my personal profile so that my details are updated - Edit Address
    Given I'm on "Dashboard" page of GetGo pay with valid "edit_username" and "edit_password"
    When  I choose Settings option from the menu
    Then  I should see "Settings" page
    When  I choose "Profile" option from settings page
    Then  I should see "Manage Profile" page with "PERSONAL DETAILS" , "ADDRESS" and "OTHER DETAILS" sections
    When  I click on edit link in the "Address" section
    Then  "Update Address" page should be displayed with Country,State,City Combo Boxes,Edit House/Street textbox and "SAVE" button
    When  I click on SAVE button with updated address details
    Then  Address details should be updated and verified in "Manage Profile" page

@three
  Scenario: As a tester, I want to be able to change my personal profile so that my details are updated - Edit Other details
    Given I'm on "Dashboard" page of GetGo pay with valid "edit_username" and "edit_password"
    When  I choose Settings option from the menu
    Then  I should see "Settings" page
    When  I choose "Profile" option from settings page
    Then  I should see "Manage Profile" page with "PERSONAL DETAILS" , "ADDRESS" and "OTHER DETAILS" sections
    When  I click on edit link in the "Other details" section
    Then  "Update Other Details" page should be displayed
    When  I click on SAVE button with updated other details
    Then  Other details should be updated and verified in "Manage Profile" page
