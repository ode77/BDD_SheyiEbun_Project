@UKBA1
Feature: Check Visa Eligibility

  Background:
    Given I am on UKba Website
    When I click on Accept additional cookies
    Then the Check if you need a UK visa page is displayed
    And I click on StartNow button

  Scenario Outline: Country and Study
#    Given I am on UKba Website
#    When I click on Accept additional cookies
#    Then the Check if you need a UK visa page is displayed
#    And I click on StartNow button
    When I provide nationality of "<CountryName>"
    And I click on Continue button
    And I select reason as "Study"
    And I click on Continue button
    And I state I intend to stay for more than 6 months
    And I click on Continue button
    Then I should get a respond "<Message>" as coming to UK
    Examples:
      | CountryName | Message                               |
      | Japan       | You’ll need a visa to study in the UK |
      | Cuba        | You’ll need a visa to study in the UK |
      | USA         | You’ll need a visa to study in the UK |
      | Canada      | You’ll need a visa to study in the UK |



#  @UKBA2
  Scenario Outline: Nationalities and Tourism
#    Given I am on UKba Website
#    When I click on Accept additional cookies
#    Then the Check if you need a UK visa page is displayed
#    And I click on StartNow button
    When I provide nationality of "<CountryName>"
    And I click on Continue button
    And I select the reason as "Tourism"
    And I click on Continue button
    And I select "Yes" button for travelling with or visiting partner or family member
    And I click on Continue button
    Then I should get a "<Message>" as coming to UK
    Examples:
      | CountryName |Message|
      | Russia      |You’ll usually need a visa to come to the UK|
      |Cuba         |You’ll usually need a visa to come to the UK|
      |Belarus      |You’ll usually need a visa to come to the UK|
      |Albania      |You’ll usually need a visa to come to the UK|
