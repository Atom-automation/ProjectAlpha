
# ===============================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to complete a funds transfer transaction so that I can pass on funds to another cardholder.
# ===============================================================================================================================

@ManageRecipient
Feature: Manage Recipients Feature

  Background: Open Getgo mobile application
  	Given I'm on Getgo landing page

  @AndroidOnly
  Scenario Outline: As a tester, I want to add new recipients and tag some of them as favorites so that I can keep a list of recipients (From Card transfer page)
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page
    When  I Choose Manage Recipients option
    And   Add a recipient and tag it as a favorite
    When  I Choose Manage Recipients option again
    Then  Recipient should be displayed in my favourites

  Examples:
    | accountType | username         | password         |
 #  | Virtual     | Virtual_Username | Virtual_Password |
    | Peso        | Peso_Username    | Peso_Password    |


  Scenario Outline: As a tester, I want to add new recipients and tag some of them as favorites so that I can keep a list of recipients (From Beneficiaries page)
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Beneficiaries page
    When  I add a recipient and tag it as a favorite
    When  I open Beneficiaries page again
    Then  Recipient should be displayed in my favourites

  Examples:
    | accountType | username         | password         |
  #  | Virtual     | Virtual_Username | Virtual_Password |
    | Peso        | Peso_Username    | Peso_Password    |