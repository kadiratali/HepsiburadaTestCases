@LoginProfile
Feature: Login Scenarios

  Background: User navigates to hepsiburada home page
    Given I am on the "hepsiburada home" page on URL "www.hepsiburada.com"
    Then I should see "Kampanyalar" message

  Scenario: Successful login
    When I fill in "Email" with "kadir_atalii@hotmail.com"
    And I fill in "Password" with "Kadir5159."
    And I click on the "Log In" button
    Then I am on the "HomePage" page on URL "www.hepsiburada.com"
    And I should see the "Hesabım" button

  Scenario Outline: Failed login using wrong credentials
    When I fill in "email" with "<email>"
    And I fill in "Password" with "<password>"
    And I click on the "Login" button
    And I should see "<warning>" message
    Examples:
      | email               | password                       | warning                                                        |
      | Test@hotmail.com    | !23                            | Bilgileriniz eksik veya hatalı.                                |
      | Tset                | 123                            | Geçerli bir e-posta adresi girmelisiniz.                       |
      | Tset                | !23                            | Bilgileriniz eksik veya hatalı.                                |
      | Test@hotmail.com    |                                | Şifrenizi girmelisiniz.                                        |
      |                     | 123                            | E-posta adresinizi girmelisiniz.                               |
      |                     |                                | E-posta adresinizi girmelisiniz. Şifrenizi girmelisiniz.       |