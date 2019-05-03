Feature: Basket

  Scenario: Add a single product to the basket from the home page
    Given I am on the homepage
    When I click add to cart button
    Then pop up menu appears saying product has been added to basket

    Scenario: Go to Basket page after a product confirmed to have been added
      Given I have the pop up menu opened
      When I click proceed to checkout button
      Then I am on the Basket Page

  Scenario: Increase Quantity of a product in the Basket
    Given I can see the product in the basket
    When I click on the plus button
    Then I see the quantity has been increased by 1

  Scenario: Decrease quantity of a product in the basket
    Given i can see the product in the basket
    When i click on the minus button
    Then i see the quantity has been decreased by 1

  Scenario: Specify quantity of a product in the basket
    Given i can see the product in the basket
    When i input a quantity of 5
    Then i see the quantity has been changed to 5

  Scenario: Proceed to checkout
    Given i have a populated basket
    When i click proceed to checkout
    Then i am on checkout

  Scenario: Add multiple different products to the basket from the home page
    Given i am on the home page
    When i click add to cart button for a product
    And pop up menu appears saying product has been added to the basket
    When I click continue shopping button
    And I click add to cart button for a different product
    Then pop up menu appears saying product has been added to the basket

  Scenario: Remove a single product from Basket
    Given I am on the basket page
    When I click on the delete icon
    Then product is not displayed in basket



#    Scenario: Add a product to the basket from the products page
#      Given i am on the home page
#      When i click on the More button
#      Then i can