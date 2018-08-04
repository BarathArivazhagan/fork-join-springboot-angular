Feature: To retrieve the user with user details
  Scenario: retrieve the user with user id
    Given the user saved with user name "barath" and user id 1
    When the client calls GET "/users/{userId}" with user id as 1
    Then the client receives status code of 200
    And the response contains user id 1
  Scenario: retrieve the user with user name
    When the client calls GET "/users/byName/{userName}" with user name as "barath" in uri variable
    Then the client receives status code of 200
    And the response contains user name "barath"