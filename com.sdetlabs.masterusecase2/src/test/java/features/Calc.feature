Feature: Calculator

  Scenario Outline: Verify Status Codes of Soap Requests to Calculator site.
    Given Calculator site
    When Soap Request is "<RequestType>"
    Then the status code should be <code>

    Examples: 
      | RequestType | code |
      | Get         |  200 |
      | Post        |  500 |
