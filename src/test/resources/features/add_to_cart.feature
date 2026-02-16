@addToCart
Feature: Add product to cart

  Background:
    Given user is logged in as "standard_user"


  Scenario: Add a single product to the cart
    Given the user is on the product page
    When the user adds a product to the cart
    Then the product should be displayed on the cart page