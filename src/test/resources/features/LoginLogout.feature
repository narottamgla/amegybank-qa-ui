Feature: Home page navigation and Login with invalid credentials to amegybank

  @smoke
  Scenario: Verify Amegybank home page navigation
    Given User open amegybank page urlin browser
    Then User should navigate to amegybank home page
    Then User should see home page title as "Personal Accounts | Amegy Bank of Texas"

  Scenario: Verify Top left and right different menus
    Then User should navigate to amegybank home page
    Then User should see different top left menu options
      | PERSONAL |
      | BUSINESS |
      | WEALTH   |
    Then User should see different top right menu options
      | About Us   |
      | Careers    |
      | Contact Us |
      | Locations  |

  Scenario Outline: Verify Login with invalid credentials for amegybank
    When User clicks on Login Button on amegybank home page
    Then User should see login page
    When User performs login with username as "<username>" and password as "<password>"
    Then User should see username validation error as "<usernamevalidatorerror>" and password validator error as "<passwordvalidatorerror>"

    Examples: 
      | username | password | usernamevalidatorerror   | passwordvalidatorerror  |
      | aa       |          |                          | Please enter a password |
      |          |          | Please enter a Login ID. |                         |

  Scenario: Finally Quit browser
    Then User quite the browser tab
