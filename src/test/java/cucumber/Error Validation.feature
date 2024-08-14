
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given i have landed on the Ecommerce page
    When Logged in with username <username> and password <password>
    Then "Incorrect email or password." error message is displayed

    
      Examples: 
      | username             | password |
      | srilatha.i@gmail.com | Fjot&024 | 
