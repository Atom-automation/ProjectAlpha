# ========================================================================================================================================
# Author: Gopinath Rajaram
# Functionality : As a User, I want to view the transaction history details of my account in the GetGopay so that i am aware of my transaction details
# ========================================================================================================================================

@TransactionHistory
Feature: Transaction History/Activities

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario: As a User, I want to view the transaction history details of my account in the GetGopay so that i am aware of my transaction details - Activities from Dashboard page
    Given I'm on "Dashboard" page of GetGo pay with valid "Peso_Username" and "Peso_Password"
    When I click on the Availabel Balance Amount field in the Dasboard page
    Then Transaction History/Activities for the logged user should be displayed
    When I verify all the details present in the Transaction History/Activities page
    And  Click any one transaction list
    Then I should see the Transaction History/Activities details page with Reference No,Transaction Date,Description,Transaction Amount & Ending Balance

  Scenario: As a User, I want to view the transaction history details of my account in the GetGopay so that i am aware of my transaction details - Activities from Fund Transfer page
    Given I'm on "Fund Transfer" page of GetGo pay with valid "Peso_Username" and "Peso_Password" details
    When I click on the Activities option from the bottom of the fund transfer page
    Then Transaction History/Activities for the logged user should be displayed
    When I verify all the details present in the Transaction History/Activities page
    And  Click any one transaction list
    Then I should see the Transaction History/Activities details page with Reference No,Transaction Date,Description,Transaction Amount and Ending Balance


