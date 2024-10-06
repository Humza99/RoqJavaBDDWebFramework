Feature: SwagLabs

  Web Application Testing with SwagLabs Website

  Background:

    Given I am on the SwagLabs Website

  Scenario: A happy path scenario of a customer purchasing an item
    Given I log in with valid credentials
    When I add a product to basket
    And I go to the basket
    And I complete the checkout process
    Then I have completed my purchase

  Scenario: Verify product prices on website with a csv file containing prices
    Given I log in with valid credentials
    Then I check website prices and iterate over each product in the csv and me sure it matches

  @fail
  Scenario: Expecting to successfully login
    When I enter invalid credentials to login
    Then I am logged in successfully

  Scenario: A unhappy path scenario of entering incorrect login credentials
    When I enter invalid credentials to login
    Then A error message is outputted on the screen