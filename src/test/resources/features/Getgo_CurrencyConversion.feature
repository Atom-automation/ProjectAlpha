
# ========================================================================================================================================
# Author: Balabharathi Jayaraman
# Functionality : As a tester, I want to be able to complete a currency conversion transaction so that I can transact in another currency.
# ========================================================================================================================================

@CurrencyConversion
Feature: Currency Conversion

  Background: Login into account
    Given I'm on Getgo landing page

  Scenario Outline: As a tester, I want to be able to complete a currency conversion transaction so that I can transact in another currency.
    Given I'm login into my "Peso" account with my "Peso_Username" and "Peso_Password"
    Given I'm on Currency conversion screen after noting down the balance of "<to>" currency
    When  I choose "<from>" currency and "<to>" currency
    And   I enter the conversion amount "<conversion_amount>"
    Then  Conversion amount will be automatically populated under To Amount field
    When  I review conversion details and submit
    Then  Amount should be converted & displayed in the dashboard

    Examples:
      | from  | to    | conversion_amount |
     | PHP   | AUD   | 10                |
      | PHP   | CAD   | 10                |

