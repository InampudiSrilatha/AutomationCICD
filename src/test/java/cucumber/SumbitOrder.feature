@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given i have landed on the Ecommerce page
  
  @Regression
  Scenario Outline: Positive test for submittimg the order
    Given Logged in with username <username> and password <password>
    When I add productname <ProductName> to the cart
    And Checkout <ProductName>
    Then "THANKYOU FOR THE ORDER." is displayed on the conformation page

    Examples: 
      | username             | password | Product Name|
      | srilatha.i@gmail.com | Fjot&023 | ZARA COAT 3|
      
