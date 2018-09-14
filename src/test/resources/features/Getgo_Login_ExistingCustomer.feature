

# ================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to be able to login using my credentials so that I may be able to see my virtual card details.
# ================================================================================================================

@ExistingAccountUserLogin
Feature: Existing Customer Login Feature

  Background: Open Getgo mobile application
    Given I'm on Getgo landing page
@retry
  Scenario Outline: As a tester, I want to be able to login using my credentials so that I may be able to see my virtual card details.
    Given I'm on Getgo login page
    When Enter "<email>"
    And Enter virtual/physical "<account_type>" card details - "<card_number>","<cvv>", "<expirary>"
  And Nominate "<new_password>" and "<confirm_password>" & click Next
    Then User will see dashboard page

    Examples: 
      |email                            |card_number     |cvv|expirary|new_password|confirm_password|account_type|
   #  |bren.aviador@whitecloak.com     |6019990220015059|052|01/25   |test@123     |test@123       |Virtual      |
      |jameson.candava@whitecloak.com|6019990220010167|399|01/25   |test@123     |test@123       |peso        |





    
    
    