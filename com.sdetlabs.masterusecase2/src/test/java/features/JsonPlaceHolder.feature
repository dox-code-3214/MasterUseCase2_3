Feature: JsonPlaceHolder

  Scenario Outline: Verify Status Codes of Rest Assured Requests to Json Place Holder site.
    Given Json Place Holder site
    When Rest Assured Request is "<RequestType>"
    Then the status code should be <code>

    Examples: 
      | RequestType | code |
      | Get         |  200 |
      | Put         |  200 |
      | Post        |  201 |
      | Patch       |  200 |
      | Delete      |  200 |
