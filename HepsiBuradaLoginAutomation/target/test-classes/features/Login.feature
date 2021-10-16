@Kadir_Atali
Feature: Add product to cart

  Scenario:Adding a product to the cart by logging in
    Given The user visits Hepsiburada.com
    Then User login
    And After the redirect, the user login is verified on the homepage
    And The user will search for the product he wants to buy here.
    And The user can choose from the list of products displayed as a result of the Search select products.
    And For the selected product, products from two different vendors are selected and added to the cart.
    Then Verify on the My Cart page that the selected product has been added correctly

  Scenario:Add product to basket without login
    Given The user go to homepage
    Then User choice products.
    And products from two different vendors are selected and added to the cart.
    Then Verify my basket