@WebApplication
Feature: SwagLabs

  Web Application Testing with SwagLabs Website

  Background:

    Given I am on the SwagLabs Website

  Scenario: A happy path scenario of a customer purchasing an item
    Given I log in with valid credentials
    When I add a product to basket
    And I proceed to the basket
    And I proceed to checkout
    And I enter my credentials
    And I continue to the overview page
    And I confirm my order
    Then I have completed my purchase

  Scenario: Verify product prices on website with a csv file containing prices
    Given I log in with valid credentials
    Then I check website prices and iterate over each product in the csv and me sure it matches

  Scenario: A unhappy path scenario of entering incorrect login credentials
    Given I enter invalid credentials to login
    Then A error message is outputted on the screen