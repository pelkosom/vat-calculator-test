Feature: VAT Calculator

  Scenario: Basic Functionality Test
    Given I am on the VAT calculator page
    And I accept the cookie consent
    When I select "Germany" as the country
    And I choose "19%" as the VAT rate
    And I enter "100" as the Net amount
    Then the Gross amount should be "119.00"
    And the VAT amount should be "19.00"

    # TODO: Add more positive scenarios

  Scenario: Error Handling for Negative Input
    Given I am on the VAT calculator page
    And I accept the cookie consent
    And I enter "-100" as the Net amount
    Then I should see an error message
    And the error message should contain "Negative values are invalid for a pie chart."
