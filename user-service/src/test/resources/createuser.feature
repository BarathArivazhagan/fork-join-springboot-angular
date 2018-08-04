Feature: To create a new user
  Scenario: client makes HTTP POST call to  /users/new
    Given the user with user details
    """
     {
      "userId": 1L,
      "userName": "barath",
      "userAge": 26,
      "userGender": MALE
     }
    """
    When the client calls "/users/new" with the given details
    Then the client receives status code of 200
    And the response contains user details
    """
    {
      "userId": 1L,
      "userName": "barath",
      "userAge": 26,
      "userGender": MALE
    }
    """