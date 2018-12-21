@full-regression @reporting
Feature: Reporting - Save Reports feature

  As a reporting user
  I want to be able to save reports
  So that I can customize reports to meet my needs

  Background:
    Given ~Navigate~ I navigate to the "Default" instance

  @smoke
  Scenario: Saving an "Account Template" report with added fields is successful
      And ~Login~ I log in as a "SYSTEM_ADMIN"
      And ~Home~ I navigate to "Products" then "Reporting"
      And ~Reporting~ I select the "BlackLine Reports" tab
      And ~Reporting~ I copy the report "Account Template" to "My Reports"
      And ~Reporting~ I select the "My Reports" tab
      And ~Reporting~ I select Edit on the report I copied
      And ~ReportingEdit~ I add the field "Account" to the "FIELDS" section
      And ~ReportingEdit~ I add the field "Team" to the "FIELDS" section
    When ~ReportingEdit~ I save the report
      And ~Home~ I navigate to "Products" then "Reporting"
      And ~Reporting~ I select Edit on the report I copied
    Then ~ReportingEdit~ I verify the field "Account" is added to the "FIELDS" section
      And ~ReportingEdit~ I verify the field "Team" is added to the "FIELDS" section