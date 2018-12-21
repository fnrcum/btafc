#Example of mvn command to run and specify tags
#-U clean test -Dselenium.browser=remotechrome -Dfeature.tags="(@1test or @2test) and (not @nonetest)" -P parallel
@examples
Feature: Example

  Background:
    Given ~Navigate~ I navigate to the "Default" instance

  @loginExample @1test
  Scenario: Login as Preparer
    When ~Login~ I log in as a "AUTOMATED_PREPARER"
    Then ~Home~ I verify the home page title is displayed successfully

  @loginExample @2test
  Scenario: Login as Approver
    When ~Login~ I log in as a "AUTOMATED_APPROVER"
    Then ~Home~ I verify the home page title is displayed successfully

  @loginExample @2test
  Scenario: Login as Reviewer
    When ~Login~ I log in as a "AUTOMATED_REVIEWER"
    Then ~Home~ I verify the home page title is displayed successfully

  @loginExample @scenarioOutline
  Scenario Outline: Login as <Role>
    When ~Login~ I log in as a "<Role>"
    Then ~Home~ I verify the home page title is displayed successfully

    Examples:
      | Role               |
      | AUTOMATED_APPROVER |
      | AUTOMATED_PREPARER |
      | AUTOMATED_REVIEWER |
      | SYSTEM_ADMIN       |