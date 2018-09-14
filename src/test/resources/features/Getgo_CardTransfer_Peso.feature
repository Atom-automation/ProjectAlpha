


# ===============================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to complete a funds transfer transaction so that I can pass on funds to another cardholder.
# ===============================================================================================================================

@FundTransferphysical
Feature: Fund Transfer from Peso+ card to another card

  Background: Open Getgo mobile application
  	Given I'm on Getgo landing page

  Scenario Outline: As a tester, I want to complete a funds transfer transaction from my Peso card account so that I can pass on funds to another cardholder (Add recipient from saved list).
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message - Add recipient from saved list by clicking on add button
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page

  Examples:
    | accountType | username      | password      |
    | Peso        | Peso_Username | Peso_Password |

  Scenario Outline: As a tester, I want to complete a funds transfer transaction from my Peso card account so that I can pass on funds to another cardholder.
    Given I'm login into my "<accountType>" account with my "<username>" and "<password>"
    Given I'm on Getgo Fund transfer page of my "<accountType>" card account
    When  I Enter card number, recipient name, amount, system date, frequency, and message
    And   I review transfer instruction and click submit
    Then  I should see the confirmation page

  Examples:
    | accountType | username      | password      |
    | Peso        | Peso_Username | Peso_Password |
