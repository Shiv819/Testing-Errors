@All
Feature: Navigate to website
  @RegressionTesting
  Scenario: Website Navigation
    Given Navigate to website and assert
    Then Navigate to Login screen
  @SmokeTesting
  Scenario: Website
    Given Navigate to website and assert
    Then Navigate to Login screen