

# ================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to launch the GetGo Pay application freshly so that I am able to see the product welcome feature details
# ================================================================================================================

@ProductFeature
Feature: Product Feature

  Scenario: As a tester, I want to launch the GetGo Pay application freshly so that I am able to see the product welcome feature details
    Given I'm on Getgo application with welcome page one content details,greeting image & next button
    When  I click on next button
    Then  welcome page two should be displayed with contents,greeting image & next button
    When  I click on next button
    Then  welcome page three should be displayed with contents,greeting image & next button
    When  I click on next button
    Then  welcome page four should be displayed with contents,greeting image & next button
    When  I click on next button
    Then  welcome page five should be displayed with contents,greeting image & get Started button
    And   I click on Get Started button
    Then  GetGo pay login/signup page should be displayed


    
    
    