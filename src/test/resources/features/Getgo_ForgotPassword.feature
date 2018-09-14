

# ================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to reset the password details through forgot password functionality so that I can login into the account successfully while I am not remembering my password
# ================================================================================================================

@ForgotPassword
Feature: Forgot Password Feature

  Background: Open Getgo mobile application
    Given I'm on Getgo landing page
@dummy1
  Scenario Outline: As a tester, I want to reset the password details through forgot password functionality so that I can login into the account successfully while I am not remembering my password
    Given I'm on Getgo login page
    When  I enter a "<username>" detail & click next
    Then  A page should be displayed with password textbox, NEXT button and "Forgot your password?" link
    When I click on Forgot your password link
    And Enter email address & click submit
    Then I should see a message We have sent you an email to reset your password in the Forgot your password page
    When I reset the password details through the Password Reset email & click submit
    Then I see an message as Your password has been successfully changed
    When I login with reset password details
    Then Login should be successfull and I should see Dashboard page


    Examples: 
      | username         |
      | forgotpassword_username |



    
    