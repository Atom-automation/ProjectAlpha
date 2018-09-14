

# ================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a tester, I want to login into the GetGo app and Logout so that Login-Logout process verification is successfull
# ================================================================================================================

@Logout
Feature: Logout Feature

  Background: Open Getgo mobile application
    Given I'm on Getgo landing page

  Scenario Outline: As a tester, I want to login into the GetGo app and Logout so that Login-Logout process verification is successfull
    Given I'm on Getgo login page
    When  I enter a "<username>" & click next
    And   I enter password "<password>"
    And   I click login
    Then  I should see my "<accountType>" account dashboard with my profile picture & my full name
    When I choose logout option from the menu
    Then I should see a "Logout?" popup window prompting you to logout from the current session
    When I click yes
    Then I should be logged out from the current session & redirected to signin page with logged "<username>"

    Examples: 
      | username         | password         | accountType |
 #     | Virtual_Username | Virtual_Password | Virtual     |
      | Peso_Username    | Peso_Password    | Peso        |



    